/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.view.ISequentialView;
import org.hbgb.webcamp.client.view.IView;

public interface IStartView extends ISequentialView, IView
{
	public void setEmailText(String text);

	public String getEmailText();
}
