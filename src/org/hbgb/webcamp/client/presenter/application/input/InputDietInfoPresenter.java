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
import org.hbgb.webcamp.client.view.application.input.InputDietInfoView;
import org.hbgb.webcamp.shared.DietInfoBlock;
import org.hbgb.webcamp.shared.enums.DietType;
import org.hbgb.webcamp.shared.enums.SecurityRole;

public class InputDietInfoPresenter
implements SequentialPresenterI {
    private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
    private final InputDietInfoView view;
    private String key;
    private DietInfoBlock dietInfoBlock;
    private HasWidgets screen;
    private KeyPresenterI nextPresenter;

    public InputDietInfoPresenter(String key) {
        this.key = key;
        this.view = ViewFinder.getDietInfoView();
        this.view.setVisibility(SecurityRole.USER);
        this.view.setPresenter(this);
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    private void setView() {
        this.view.setDietType(this.dietInfoBlock.getDietType());
        this.view.setIsGlutenFree(this.dietInfoBlock.getIsGlutenFree());
        this.view.setDietaryRestrictions(this.dietInfoBlock.getDietaryRestrictions());
    }

    private void setModel() {
        this.dietInfoBlock.setDietType(this.view.getDietType());
        this.dietInfoBlock.setIsGlutenFree(this.view.getIsGlutenFree());
        this.dietInfoBlock.setDietaryRestrictions(this.view.getDietaryRestrictions());
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
            this.rpcService.getApplicantsDietInfoBlock(this.key, new AsyncCallback<DietInfoBlock>(){

                public void onSuccess(DietInfoBlock result) {
                    if (result == null) {
                        Window.alert((String)"Applicant's Payment Info reurned as null");
                        return;
                    }
                    InputDietInfoPresenter.access$0(InputDietInfoPresenter.this, result);
                    InputDietInfoPresenter.this.setView();
                    InputDietInfoPresenter.this.screen.add(InputDietInfoPresenter.this.view.asWidget());
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
        this.rpcService.updateApplicantsDietInfoBlock(this.dietInfoBlock, new AsyncCallback<Boolean>(){

            public void onSuccess(Boolean saved) {
                if (saved.booleanValue()) {
                    InputDietInfoPresenter.this.screen.clear();
                    InputDietInfoPresenter.this.nextPresenter.setKey(InputDietInfoPresenter.this.key);
                    InputDietInfoPresenter.this.nextPresenter.go(InputDietInfoPresenter.this.screen);
                    return;
                }
                Window.alert((String)"DB Error saving Applicant's Payment Info");
            }

            public void onFailure(Throwable caught) {
                Window.alert((String)"RPC Error saving Applicant's Payment Info");
            }
        });
    }

    static /* synthetic */ void access$0(InputDietInfoPresenter inputDietInfoPresenter, DietInfoBlock dietInfoBlock) {
        inputDietInfoPresenter.dietInfoBlock = dietInfoBlock;
    }

}

