/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.event.logical.shared.CloseEvent
 * com.google.gwt.event.logical.shared.CloseHandler
 * com.google.gwt.event.shared.HandlerRegistration
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.user.client.ui.Composite
 * com.google.gwt.user.client.ui.ResizeComposite
 * com.google.gwt.user.client.ui.TabLayoutPanel
 * com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class ContentPanel extends ResizeComposite implements CloseHandler<ClosePanel>
{
	static interface ContentPanelBinder extends UiBinder<Widget, ContentPanel>
	{}

	private static UiBinder<Widget, ContentPanel> binder = GWT.create(ContentPanelBinder.class);
	@UiField
	TabLayoutPanel tab;

	public ContentPanel()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	public void addTab(String text, Composite content)
	{
		ClosePanel closePanel = new ClosePanel();
		closePanel.setText(text);
		closePanel.addCloseHandler(this);
		this.tab.add(content, closePanel);
		this.tab.selectTab(this.tab.getWidgetCount() - 1);
	}

	@Override
	public void onClose(CloseEvent<ClosePanel> event)
	{
		if (this.tab.getWidgetCount() <= 1)
			return;
		(event.getTarget()).removeFromParent();
	}

}
