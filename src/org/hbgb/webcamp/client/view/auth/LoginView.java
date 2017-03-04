/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.auth;

import org.hbgb.webcamp.client.view.IView;

public interface LoginView extends IView
{
	public void setPresenter(Presenter var1);

	public void disableLogin();

	public void enableLogin();

	public void setEmailText(String var1);

	public String getEmailText();

	public void setPasswordText(String var1);

	public String getPasswordText();

	public void setMessage(String var1);

	public static interface Presenter
	{
		public void onLoginButtonClicked();
	}

}
