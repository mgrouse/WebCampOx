/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view;

import org.hbgb.webcamp.client.presenter.ISequentialPresenter;

public interface ISequentialView
{
	public void setPresenter(ISequentialPresenter sp);

	public void addMessage(String text);

	public void setNextButtonActive(boolean b);
}
