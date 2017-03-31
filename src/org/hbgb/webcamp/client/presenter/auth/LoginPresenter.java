/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.rpc.AsyncCallback
 * com.google.gwt.user.client.ui.HasWidgets
 * com.google.gwt.user.client.ui.PopupPanel com.google.gwt.user.client.ui.Widget
 * com.google.web.bindery.event.shared.Event
 */
package org.hbgb.webcamp.client.presenter.auth;

import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.async.LoginServiceAsync;
import org.hbgb.webcamp.client.event.AuthenticatedEvent;
import org.hbgb.webcamp.client.event.SingletonEventBus;
import org.hbgb.webcamp.client.presenter.IPresenter;
import org.hbgb.webcamp.client.view.auth.LoginView;
import org.hbgb.webcamp.shared.HbgbUser;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.PopupPanel;

public class LoginPresenter implements IPresenter, LoginView.Presenter
{
	private final LoginServiceAsync loginService = AsyncServiceFinder.getLoginService();
	private final LoginView view;
	PopupPanel pop;

	public LoginPresenter(LoginView v)
	{
		view = v;
		view.setPresenter(this);
	}

	public void authenticate()
	{
		loginService.authenticate(view.getEmailText(), view.getPasswordText(),
				new AsyncCallback<HbgbUser>()
				{

					@Override
					public void onFailure(Throwable caught)
					{}

					@Override
					public void onSuccess(HbgbUser user)
					{
						if (user == null)
						{
							view.setMessage("Wrong! try Email: go");
							view.enableLogin();
							return;
						}
						pop.hide();
						SingletonEventBus.get().fireEvent(new AuthenticatedEvent(user));
					}
				});
	}

	@Override
	public void onLoginButtonClicked()
	{
		view.disableLogin();
		authenticate();
	}

	@Override
	public void go()
	{
		view.enableLogin();
		pop = new PopupPanel(true);
		pop.setGlassEnabled(true);
		pop.setWidget(view.asWidget());
		pop.center();
	}

	@Override
	public void setScreen(HasWidgets container)
	{

	}

}
