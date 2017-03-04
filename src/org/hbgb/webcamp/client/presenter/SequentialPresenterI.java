/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.presenter;

import org.hbgb.webcamp.client.presenter.KeyPresenterI;

@Deprecated
public interface SequentialPresenterI extends KeyPresenterI
{
	public void setNextPresenter(KeyPresenterI var1);

	public void onNextButtonClicked();
}
