/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.IPresenter;
import org.hbgb.webcamp.client.view.IView;

public interface FinishViewI extends IView
{
	public void setPresenter(IPresenter var1);

	public void setSuccessMessageVisability(Boolean var1);

	public void setFailureMessageVisability(Boolean var1);
}
