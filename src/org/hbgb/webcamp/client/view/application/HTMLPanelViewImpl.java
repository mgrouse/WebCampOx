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

import org.hbgb.webcamp.client.widget.LoadingPopup;

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
	{}

	private static UiBinder<Widget, HTMLPanelViewImpl> binder = GWT
			.create(HTMLPanelViewImplBinder.class);

	@UiField
	HTMLPanel panel;

	LoadingPopup loadPop;

	public HTMLPanelViewImpl()
	{
		initWidget(binder.createAndBindUi(this));
		loadPop = new LoadingPopup();
	}

	@Override
	public void setHTML(String html)
	{
		panel.clear();
		panel.add(new HTML(html));

		loadPop.stop();
	}

	@Override
	public void clear()
	{
		loadPop.go();
	}

}
