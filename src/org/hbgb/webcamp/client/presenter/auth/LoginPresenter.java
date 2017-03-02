/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.rpc.AsyncCallback
 *  com.google.gwt.user.client.ui.HasWidgets
 *  com.google.gwt.user.client.ui.PopupPanel
 *  com.google.gwt.user.client.ui.Widget
 *  com.google.web.bindery.event.shared.Event
 */
package org.hbgb.webcamp.client.presenter.auth;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.Event;
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.async.LoginServiceAsync;
import org.hbgb.webcamp.client.event.AuthenticatedEvent;
import org.hbgb.webcamp.client.event.EventBus;
import org.hbgb.webcamp.client.presenter.PresenterI;
import org.hbgb.webcamp.client.view.auth.LoginView;
import org.hbgb.webcamp.shared.HbgbUser;

public class LoginPresenter
implements PresenterI,
LoginView.Presenter {
    private final LoginServiceAsync loginService = AsyncServiceFinder.getLoginService();
    private final LoginView view;
    PopupPanel pop;

    public LoginPresenter(LoginView view) {
        this.view = view;
        view.setPresenter(this);
    }

    public void authenticate() {
        this.loginService.authenticate(this.view.getEmailText(), this.view.getPasswordText(), new AsyncCallback<HbgbUser>(){

            public void onFailure(Throwable caught) {
            }

            public void onSuccess(HbgbUser user) {
                if (user == null) {
                    LoginPresenter.this.view.setMessage("Wrong! try Email: go");
                    LoginPresenter.this.view.enableLogin();
                    return;
                }
                LoginPresenter.this.pop.hide();
                EventBus.get().fireEvent((Event)new AuthenticatedEvent(user));
            }
        });
    }

    @Override
    public void onLoginButtonClicked() {
        this.view.disableLogin();
        this.authenticate();
    }

    @Override
    public void go(HasWidgets container) {
        this.view.enableLogin();
        this.pop = new PopupPanel(true);
        this.pop.setGlassEnabled(true);
        this.pop.setWidget(this.view.asWidget());
        this.pop.center();
    }

}

