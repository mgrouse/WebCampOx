/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view;

import org.hbgb.webcamp.client.presenter.ISequentialPresenter;

public interface ISequentialView
{
	public void setPresenter(ISequentialPresenter var1);

	public void addMessage(String var1);

	public void setNextButtonActive(boolean var1);
}
