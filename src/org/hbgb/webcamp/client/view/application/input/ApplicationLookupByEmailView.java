/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.client.view.IView;

public interface ApplicationLookupByEmailView extends IView
{
	public void setPresenter(ISequentialPresenter var1);

	public void setEmailText(String var1);

	public String getEmailText();

	public void setWarningText(String var1);

	public void setNextButtonActive(boolean var1);
}
