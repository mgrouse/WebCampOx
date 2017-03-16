/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.ui.HasWidgets com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.application;

import org.hbgb.webcamp.client.presenter.IKeyPresenter;
import org.hbgb.webcamp.client.view.application.ThankYouView;
import org.hbgb.webcamp.client.view.application.ThankYouViewImpl;

import com.google.gwt.user.client.ui.HasWidgets;

@Deprecated
public class ThankYouPresenter implements IKeyPresenter
{
	private ThankYouView view = new ThankYouViewImpl();
	private HasWidgets screen;

	@Override
	public void go()
	{
		// this.screen = container;
		this.screen.clear();
		this.screen.add(this.view.asWidget());
	}

	@Override
	public void setKey(String key)
	{}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.hbgb.webcamp.client.presenter.IPresenter#setScreen(com.google.gwt.
	 * user.client.ui.HasWidgets)
	 */
	@Override
	public void setScreen(HasWidgets var1)
	{
		// TODO Auto-generated method stub

	}
}
