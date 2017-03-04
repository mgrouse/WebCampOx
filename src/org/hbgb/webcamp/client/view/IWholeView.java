/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.event.dom.client.ClickEvent
 * com.google.gwt.user.client.ui.HasWidgets
 */
package org.hbgb.webcamp.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.HasWidgets;
import org.hbgb.webcamp.client.presenter.IWholePresenter;

public interface IWholeView
{
	public void setPresenter(IWholePresenter var1);

	public HasWidgets getScreen();

	public void onPrevButtonClicked(ClickEvent var1);

	public void setPrevButtonEnabled(Boolean var1);

	public void onListButtonClicked(ClickEvent var1);

	public void setListButtonEnabled(Boolean var1);

	public void onNextButtonClicked(ClickEvent var1);

	public void setNextButtonEnabled(Boolean var1);
}
