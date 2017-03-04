/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.event.dom.client.ClickEvent
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiHandler com.google.gwt.user.client.ui.Button
 * com.google.gwt.user.client.ui.HTML
 * com.google.gwt.user.client.ui.PasswordTextBox
 * com.google.gwt.user.client.ui.SimplePanel
 * com.google.gwt.user.client.ui.TextBox com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.auth;

import org.hbgb.webcamp.client.view.AbstractView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginPopup extends AbstractView implements LoginView
{
	private static UiBinder<Widget, LoginPopup> uiBinder =  GWT
			.create( LoginPopupBinder.class);
	@UiField
	TextBox emailBox;
	@UiField
	PasswordTextBox passwordBox;
	@UiField
	Button loginButton;
	@UiField
	SimplePanel message;
	private LoginView.Presenter presenter;

	public LoginPopup()
	{
		this.initWidget(uiBinder.createAndBindUi(this));
		this.loginButton.setText("Login");
	}

	@Override
	public void setPresenter(LoginView.Presenter presenter)
	{
		this.presenter = presenter;
	}

	@UiHandler(value = { "loginButton" })
	void onSaveButtonClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		this.presenter.onLoginButtonClicked();
	}

	@Override
	public void disableLogin()
	{
		this.message.clear();
		this.loginButton.setText("Checking...");
		this.loginButton.setEnabled(false);
		this.emailBox.setEnabled(false);
		this.passwordBox.setEnabled(false);
	}

	@Override
	public void enableLogin()
	{
		this.loginButton.setText("Login");
		this.loginButton.setEnabled(true);
		this.emailBox.setEnabled(true);
		this.passwordBox.setEnabled(true);
	}

	@Override
	public void setEmailText(String email)
	{
		this.emailBox.setText(email);
	}

	@Override
	public String getEmailText()
	{
		return this.emailBox.getValue();
	}

	@Override
	public void setPasswordText(String password)
	{
		this.passwordBox.setText(password);
	}

	@Override
	public String getPasswordText()
	{
		return this.passwordBox.getValue();
	}

	@Override
	public void setMessage(String Message)
	{
		this.message.setWidget(new HTML(Message));
	}

	static interface LoginPopupBinder extends UiBinder<Widget, LoginPopup>
	{
	}

}
