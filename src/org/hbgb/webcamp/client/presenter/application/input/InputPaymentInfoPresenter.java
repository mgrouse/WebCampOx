/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.Window
 *  com.google.gwt.user.client.rpc.AsyncCallback
 *  com.google.gwt.user.client.ui.HasWidgets
 *  com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.application.input;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import java.util.Date;
import org.hbgb.webcamp.client.async.ApplicationServiceAsync;
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.presenter.KeyPresenterI;
import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.application.input.InputPaymentInfoView;
import org.hbgb.webcamp.shared.PaymentInfoBlock;
import org.hbgb.webcamp.shared.enums.SecurityRole;
import org.hbgb.webcamp.shared.enums.TicketType;

public class InputPaymentInfoPresenter
implements SequentialPresenterI {
    private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
    private final InputPaymentInfoView view;
    private String key;
    private PaymentInfoBlock paymentInfo;
    private HasWidgets screen;
    private KeyPresenterI nextPresenter;

    public InputPaymentInfoPresenter(String key) {
        this.key = key;
        this.view = ViewFinder.getPaymentInfoView();
        this.view.setPresenter(this);
        this.view.setVisibility(SecurityRole.USER);
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    private void setView() {
        this.view.setHasTicket(this.paymentInfo.getHasTicket());
        this.view.setTicketType(this.paymentInfo.getTicketType());
        this.view.setHasBeenInvoiced(this.paymentInfo.getHasBeenInvoiced());
        this.view.setHasPaidDues(this.paymentInfo.getHasPaidDues());
        this.view.setPaidDate(this.paymentInfo.getPaidDate());
        this.view.setWasSubsidized(this.paymentInfo.getWasHeeBeeSubsidized());
        this.view.setSubsidyAmt(this.paymentInfo.getSubsidyAmt());
        this.view.setSubsidyReason(this.paymentInfo.getSubsidyReason());
    }

    private void setModel() {
        this.paymentInfo.setHasTicket(this.view.getHasTicket());
        this.paymentInfo.setTicketType(this.view.getTicketType());
        this.paymentInfo.setHasBeenInvoiced(this.view.getHasBeenInvoiced());
        this.paymentInfo.setHasPaidDues(this.view.getHasPaidDues());
        this.paymentInfo.setPaidDate(this.view.getPaidDate());
        this.paymentInfo.setWasHeeBeeSubsidized(this.view.getWasSubsidized());
        this.paymentInfo.setSubsidyAmt(this.view.getSubsidyAmt());
        this.paymentInfo.setSubsidyReason(this.view.getSubsidyReason());
    }

    @Override
    public void go(HasWidgets container) {
        this.screen = container;
        this.fetchData();
        this.screen.clear();
    }

    @Override
    public void setNextPresenter(KeyPresenterI next) {
        this.nextPresenter = next;
    }

    public void fetchData() {
        if (this.key != null) {
            this.rpcService.getApplicantsPaymentInfoBlock(this.key, new AsyncCallback<PaymentInfoBlock>(){

                public void onSuccess(PaymentInfoBlock result) {
                    if (result == null) {
                        Window.alert((String)"Applicant's Payment Info reurned as null");
                        return;
                    }
                    InputPaymentInfoPresenter.access$0(InputPaymentInfoPresenter.this, result);
                    InputPaymentInfoPresenter.this.setView();
                    InputPaymentInfoPresenter.this.screen.add(InputPaymentInfoPresenter.this.view.asWidget());
                }

                public void onFailure(Throwable caught) {
                    Window.alert((String)"DB Error retrieving Applicant's Payment Info");
                }
            });
            return;
        }
        Window.alert((String)"Error no key for Applicant's Application!");
    }

    @Override
    public void onNextButtonClicked() {
        this.setModel();
        this.rpcService.updateApplicantsPaymentInfoBlock(this.paymentInfo, new AsyncCallback<Boolean>(){

            public void onSuccess(Boolean saved) {
                if (saved.booleanValue()) {
                    InputPaymentInfoPresenter.this.screen.clear();
                    InputPaymentInfoPresenter.this.nextPresenter.setKey(InputPaymentInfoPresenter.this.key);
                    InputPaymentInfoPresenter.this.nextPresenter.go(InputPaymentInfoPresenter.this.screen);
                    return;
                }
                Window.alert((String)"DB Error saving Applicant's Payment Info");
            }

            public void onFailure(Throwable caught) {
                Window.alert((String)"RPC Error saving Applicant's Payment Info");
            }
        });
    }

    static /* synthetic */ void access$0(InputPaymentInfoPresenter inputPaymentInfoPresenter, PaymentInfoBlock paymentInfoBlock) {
        inputPaymentInfoPresenter.paymentInfo = paymentInfoBlock;
    }

}

