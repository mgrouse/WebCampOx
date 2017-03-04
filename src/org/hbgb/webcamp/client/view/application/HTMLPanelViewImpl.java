/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.Composite com.google.gwt.user.client.ui.HTML
 * com.google.gwt.user.client.ui.HTMLPanel com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application;

import org.hbgb.webcamp.shared.enums.SecurityRole;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class HTMLPanelViewImpl extends Composite implements HTMLPanelView
{
	@UiTemplate(value = "HTMLPanelView.ui.xml")
	static interface HTMLPanelViewImplBinder extends UiBinder<Widget, HTMLPanelViewImpl>
	{
	}

	private static UiBinder<Widget, HTMLPanelViewImpl> binder =  GWT
			.create( HTMLPanelViewImplBinder.class);

	@UiField
	HTMLPanel panel;

	public HTMLPanelViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	@Override
	public void setHTML(String html)
	{
		this.panel.clear();
		this.panel.add(new HTML(html));
	}

	@Override
	public void clear()
	{
	}

	@Override
	public void setVisibility(SecurityRole role)
	{
	}

}
