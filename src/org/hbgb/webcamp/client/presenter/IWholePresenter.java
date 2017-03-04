/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.ui.HasWidgets
 */
package org.hbgb.webcamp.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;
import java.util.List;
import org.hbgb.webcamp.client.presenter.application.edit.AbstractInfoBlockPresenter;

public interface IWholePresenter
{
	public void setKey(String var1);

	public void setKeyList(List<String> var1);

	public void setScreen(HasWidgets var1);

	public void setParts(List<AbstractInfoBlockPresenter> var1);

	public void onPrevButtonClicked();

	public void onListButtonClicked();

	public void onNextButtonClicked();
}
