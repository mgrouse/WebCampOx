/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.event.dom.client.ClickEvent
 * com.google.gwt.event.logical.shared.CloseEvent
 * com.google.gwt.event.logical.shared.CloseHandler
 * com.google.gwt.event.logical.shared.HasCloseHandlers
 * com.google.gwt.event.shared.EventHandler com.google.gwt.event.shared.GwtEvent
 * com.google.gwt.event.shared.GwtEvent$Type
 * com.google.gwt.event.shared.HandlerRegistration
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiHandler
 * com.google.gwt.user.client.ui.Composite com.google.gwt.user.client.ui.HTML
 * com.google.gwt.user.client.ui.Image com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.panel.element;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.HasCloseHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class ClosePanel extends Composite implements HasCloseHandlers<ClosePanel>
{

	static interface ClosePanelBinder extends UiBinder<Widget, ClosePanel>
	{}

	private static UiBinder<Widget, ClosePanel> binder = GWT.create(ClosePanelBinder.class);

	@UiField
	HTML html;

	@UiField
	Image close;

	public ClosePanel()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	public void setText(String text)
	{
		this.html.setText(text);
	}

	@Override
	public HandlerRegistration addCloseHandler(CloseHandler<ClosePanel> handler)
	{
		return this.addHandler(handler, CloseEvent.getType());
	}

	@UiHandler(value = { "close" })
	void handleClick(ClickEvent event)
	{
		CloseEvent.fire(this, (this));
	}

}
