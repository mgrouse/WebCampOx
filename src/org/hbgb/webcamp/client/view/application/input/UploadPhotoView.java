/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.view.ISequentialView;
import org.hbgb.webcamp.client.view.IView;

public interface UploadPhotoView extends ISequentialView, IView
{
	public String getImageURL();

	public void setImageURL(String var1);
}
