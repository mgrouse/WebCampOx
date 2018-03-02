/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.user.client.ui.Composite
 * com.google.gwt.user.client.ui.ScrollPanel
 * com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class WorkTab extends Composite
{
	private static UiBinder<Widget, WorkTab> binder = GWT.create(WorkTabBinder.class);
	@UiField
	ScrollPanel scrollPanel;

	public WorkTab()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	ScrollPanel getScrollPanel()
	{
		return this.scrollPanel;
	}

	static interface WorkTabBinder extends UiBinder<Widget, WorkTab>
	{}

}
