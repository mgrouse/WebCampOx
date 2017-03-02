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
import org.hbgb.webcamp.client.view.application.input.StartViewI;
import org.hbgb.webcamp.shared.Application;

public class StartPresenter
implements SequentialPresenterI {
    private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
    private final StartViewI view = ViewFinder.getEnterView();
    private String key = null;
    private Application application = null;
    private String email;
    private HasWidgets screen;
    private KeyPresenterI nextPresenter;

    public StartPresenter() {
        this.view.setPresenter(this);
    }

    @Override
    public void go(HasWidgets container) {
        this.screen = container;
        this.screen.clear();
        this.view.clear();
        this.screen.add(this.view.asWidget());
    }

    @Override
    public void setNextPresenter(KeyPresenterI next) {
        this.nextPresenter = next;
    }

    @Override
    public void onNextButtonClicked() {
        this.setModel();
        Boolean good = this.validateModel();
        if (good == false) return;
        this.view.setNextButtonActive(false);
        this.rpcService.findOrAddApplication(this.email, new AsyncCallback<Application>(){

            public void onSuccess(Application result) {
                if (result == null) {
                    StartPresenter.this.screen.clear();
                    StartPresenter.this.view.setWarningText(StartPresenter.this.getUsedEmailWarningText());
                    StartPresenter.this.view.setNextButtonActive(true);
                    StartPresenter.this.screen.add(StartPresenter.this.view.asWidget());
                    return;
                }
                StartPresenter.access$3(StartPresenter.this, result.getEncodedKey());
                if (StartPresenter.this.key == null) {
                    Window.alert((String)"Applicant's Info came back with null key");
                    return;
                }
                StartPresenter.this.screen.clear();
                StartPresenter.this.nextPresenter.setKey(StartPresenter.this.key);
                StartPresenter.this.nextPresenter.go(StartPresenter.this.screen);
            }

            public void onFailure(Throwable caught) {
                Window.alert((String)("RPC Error saving Applicant's Info: " + caught.getMessage()));
            }
        });
    }

    private void setModel() {
        this.email = this.view.getEmailText();
    }

    private Boolean validateModel() {
        Boolean retVal = true;
        if (this.email != null) {
            if (!this.email.isEmpty()) return retVal;
        }
        this.view.setWarningText("<p>A valid email is required to continue.</p>");
        return false;
    }

    private String getUsedEmailWarningText() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<h1>Warning!</h1>");
        stringBuilder.append("<p>The email address you have supplied has already been used to apply for this year. ");
        stringBuilder.append("Editing your application is not supported. If you feel this warning is in error, ");
        stringBuilder.append("contact Scarab at: michael.grouse@gmail.com.</p>");
        return stringBuilder.toString();
    }

    @Override
    public void setKey(String key) {
    }

    static /* synthetic */ void access$3(StartPresenter startPresenter, String string) {
        startPresenter.key = string;
    }

}

