/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.client.view.ISequentialView;
import org.hbgb.webcamp.client.view.IView;

public interface UploadPhotoView extends IView, ISequentialView
{
	@Override
	public void setPresenter(ISequentialPresenter var1);

	public String getImageURL();

	public void setImageURL(String var1);
}
