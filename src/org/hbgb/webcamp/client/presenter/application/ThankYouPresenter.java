/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.ui.HasWidgets com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.application;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import org.hbgb.webcamp.client.presenter.KeyPresenterI;
import org.hbgb.webcamp.client.view.application.ThankYouView;
import org.hbgb.webcamp.client.view.application.ThankYouViewImpl;

public class ThankYouPresenter implements KeyPresenterI
{
	private ThankYouView view = new ThankYouViewImpl();
	private HasWidgets screen;

	@Override
	public void go(HasWidgets container)
	{
		this.screen = container;
		this.screen.clear();
		this.screen.add(this.view.asWidget());
	}

	@Override
	public void setKey(String key)
	{}
}
