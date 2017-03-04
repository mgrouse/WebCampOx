/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.IView;

public interface StartViewI extends IView
{
	public void setPresenter(SequentialPresenterI var1);

	public void setEmailText(String var1);

	public String getEmailText();

	public void setWarningText(String var1);

	public void setNextButtonActive(boolean var1);
}
