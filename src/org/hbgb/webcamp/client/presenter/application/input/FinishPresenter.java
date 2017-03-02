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
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.async.EmailServiceAsync;
import org.hbgb.webcamp.client.presenter.KeyPresenterI;
import org.hbgb.webcamp.client.view.application.input.FinishViewI;
import org.hbgb.webcamp.client.view.application.input.FinishViewImpl;

public class FinishPresenter
implements KeyPresenterI {
    private final EmailServiceAsync emailService = AsyncServiceFinder.getEmailService();
    private final FinishViewI view = new FinishViewImpl();
    private HasWidgets screen;
    private String key;

    public FinishPresenter() {
        this.view.setSuccessMessageVisability(false);
        this.view.setFailureMessageVisability(false);
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public void go(HasWidgets container) {
        this.screen = container;
        this.screen.clear();
        this.sendEmail();
    }

    private void sendEmail() {
        this.emailService.sendApplicationRecievedEmail(this.key, new AsyncCallback<String>(){

            public void onSuccess(String result) {
                if (result == null) return;
                if (result.equals("Success")) {
                    FinishPresenter.this.view.setSuccessMessageVisability(true);
                } else {
                    FinishPresenter.this.view.setFailureMessageVisability(true);
                }
                FinishPresenter.this.screen.add(FinishPresenter.this.view.asWidget());
            }

            public void onFailure(Throwable caught) {
                Window.alert((String)"Server Error sending application received email");
            }
        });
    }

}

