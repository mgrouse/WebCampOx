/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.user.client.ui.ResizeComposite
 * com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.Widget;

public class MenuBar extends ResizeComposite
{
	static interface MenuBarBinder extends UiBinder<Widget, MenuBar>
	{
	}

	private static UiBinder<Widget, MenuBar> binder = GWT.create(MenuBarBinder.class);

	public MenuBar()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

}
