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
import org.hbgb.webcamp.client.async.ApplicationServiceAsync;
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.presenter.KeyPresenterI;
import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.application.input.InputCommitteeInfoView;
import org.hbgb.webcamp.shared.CommitteeInfoBlock;
import org.hbgb.webcamp.shared.enums.Committee;
import org.hbgb.webcamp.shared.enums.SecurityRole;

public class InputCommitteeInfoPresenter
implements SequentialPresenterI {
    private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
    private final InputCommitteeInfoView view;
    private String key;
    private CommitteeInfoBlock committeeInfo;
    private HasWidgets screen;
    private KeyPresenterI nextPresenter;

    public InputCommitteeInfoPresenter(String key) {
        this.key = key;
        this.view = ViewFinder.getCommitteeInfoView();
        this.view.setVisibility(SecurityRole.USER);
        this.view.setPresenter(this);
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    private void setView() {
        this.view.setReason1(this.committeeInfo.getReason1());
        this.view.setReason2(this.committeeInfo.getReason2());
        this.view.setCommittee1(this.committeeInfo.getCommittee1());
        this.view.setCommittee2(this.committeeInfo.getCommittee2());
        this.view.setAssignedCommittee(this.committeeInfo.getAssignedCommittee());
        this.view.setIsAssignedLead(this.committeeInfo.getIsAssignedLead());
    }

    private void setModel() {
        this.committeeInfo.setReason1(this.view.getReason1());
        this.committeeInfo.setReason2(this.view.getReason2());
        this.committeeInfo.setCommittee1(this.view.getCommittee1());
        this.committeeInfo.setCommittee2(this.view.getCommittee2());
        this.committeeInfo.setAssignedCommittee(this.view.getAssignedCommittee());
        this.committeeInfo.setIsAssignedLead(this.view.getIsAssignedLead());
    }

    public void fetchData() {
        if (this.key != null) {
            this.rpcService.getApplicantsCommitteeInfoBlock(this.key, new AsyncCallback<CommitteeInfoBlock>(){

                public void onSuccess(CommitteeInfoBlock result) {
                    if (result == null) {
                        Window.alert((String)"Applicant's Committee Info returned as null");
                        return;
                    }
                    InputCommitteeInfoPresenter.access$0(InputCommitteeInfoPresenter.this, result);
                    InputCommitteeInfoPresenter.this.setView();
                    InputCommitteeInfoPresenter.this.screen.add(InputCommitteeInfoPresenter.this.view.asWidget());
                }

                public void onFailure(Throwable caught) {
                    Window.alert((String)"DB Error retrieving Applicant's Committee Info");
                }
            });
            return;
        }
        Window.alert((String)"Error no key for Applicant's Application!");
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

    @Override
    public void onNextButtonClicked() {
        this.setModel();
        this.rpcService.updateApplicantsCommitteeInfoBlock(this.committeeInfo, new AsyncCallback<Boolean>(){

            public void onSuccess(Boolean saved) {
                if (saved.booleanValue()) {
                    InputCommitteeInfoPresenter.this.screen.clear();
                    InputCommitteeInfoPresenter.this.nextPresenter.setKey(InputCommitteeInfoPresenter.this.key);
                    InputCommitteeInfoPresenter.this.nextPresenter.go(InputCommitteeInfoPresenter.this.screen);
                    return;
                }
                Window.alert((String)"DB Error saving Applicant's Committee Info");
            }

            public void onFailure(Throwable caught) {
                Window.alert((String)"RPC Error saving Applicant's Committee Info");
            }
        });
    }

    static /* synthetic */ void access$0(InputCommitteeInfoPresenter inputCommitteeInfoPresenter, CommitteeInfoBlock committeeInfoBlock) {
        inputCommitteeInfoPresenter.committeeInfo = committeeInfoBlock;
    }

}

