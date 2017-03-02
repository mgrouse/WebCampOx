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
import org.hbgb.webcamp.client.view.application.input.InputLogisticsInfoView;
import org.hbgb.webcamp.shared.LogisticsInfoBlock;
import org.hbgb.webcamp.shared.enums.DayOfEvent;
import org.hbgb.webcamp.shared.enums.PlayaTime;
import org.hbgb.webcamp.shared.enums.SecurityRole;
import org.hbgb.webcamp.shared.enums.Transportation;

public class InputLogisticsInfoPresenter
implements SequentialPresenterI {
    private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
    private final InputLogisticsInfoView view;
    private String key;
    private LogisticsInfoBlock logisticsInfoBlock;
    private HasWidgets screen;
    private KeyPresenterI nextPresenter;

    public InputLogisticsInfoPresenter(String key) {
        this.key = key;
        this.view = ViewFinder.getLogisticsInfoView();
        this.view.setVisibility(SecurityRole.USER);
        this.view.setPresenter(this);
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    private void setView() {
        this.view.setWantsEarlyTeam(this.logisticsInfoBlock.getWantsEarlyTeam());
        this.view.setIsAssignedEarlyTeam(this.logisticsInfoBlock.getIsAssignedEarlyTeam());
        this.view.setWantsStrikeTeam(this.logisticsInfoBlock.getWantsStrikeTeam());
        this.view.setTransportation(this.logisticsInfoBlock.getTransType());
        this.view.setArrivalDate(this.logisticsInfoBlock.getArrivalDoE());
        this.view.setArrivalTime(this.logisticsInfoBlock.getArrivalTime());
        this.view.setDepartureDate(this.logisticsInfoBlock.getDepartureDoE());
        this.view.setDepartureTime(this.logisticsInfoBlock.getDepartureTime());
    }

    private void setModel() {
        this.logisticsInfoBlock.setWantsEarlyTeam(this.view.getWantsEarlyTeam());
        this.logisticsInfoBlock.setIsAssignedEarlyTeam(this.view.getIsAssignedEarlyTeam());
        this.logisticsInfoBlock.setWantsStrikeTeam(this.view.getWantsStrikeTeam());
        this.logisticsInfoBlock.setTransType(this.view.getTransportation());
        this.logisticsInfoBlock.setArrivalDoE(this.view.getArrivalDate());
        this.logisticsInfoBlock.setArrivalTime(this.view.getArrivalTime());
        this.logisticsInfoBlock.setDepartureDoE(this.view.getDepartureDate());
        this.logisticsInfoBlock.setDepartureTime(this.view.getDepartureTime());
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
            this.rpcService.getApplicantsLogisticsInfoBlock(this.key, new AsyncCallback<LogisticsInfoBlock>(){

                public void onSuccess(LogisticsInfoBlock result) {
                    if (result == null) {
                        Window.alert((String)"Applicant's Payment Info reurned as null");
                        return;
                    }
                    InputLogisticsInfoPresenter.access$0(InputLogisticsInfoPresenter.this, result);
                    InputLogisticsInfoPresenter.this.setView();
                    InputLogisticsInfoPresenter.this.screen.add(InputLogisticsInfoPresenter.this.view.asWidget());
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
        this.rpcService.updateApplicantsLogisticsInfoBlock(this.logisticsInfoBlock, new AsyncCallback<Boolean>(){

            public void onSuccess(Boolean saved) {
                if (saved.booleanValue()) {
                    InputLogisticsInfoPresenter.this.screen.clear();
                    InputLogisticsInfoPresenter.this.nextPresenter.setKey(InputLogisticsInfoPresenter.this.key);
                    InputLogisticsInfoPresenter.this.nextPresenter.go(InputLogisticsInfoPresenter.this.screen);
                    return;
                }
                Window.alert((String)"DB Error saving Applicant's Shelter Info");
            }

            public void onFailure(Throwable caught) {
                Window.alert((String)"RPC Error saving Applicant's Shelter Info");
            }
        });
    }

    static /* synthetic */ void access$0(InputLogisticsInfoPresenter inputLogisticsInfoPresenter, LogisticsInfoBlock logisticsInfoBlock) {
        inputLogisticsInfoPresenter.logisticsInfoBlock = logisticsInfoBlock;
    }

}

