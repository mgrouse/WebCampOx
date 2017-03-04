/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.user.client.ui.Composite com.google.gwt.user.client.ui.HTML
 * com.google.gwt.user.client.ui.HasText com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class StatusBar extends Composite implements HasText
{
	private static UiBinder<Widget, StatusBar> binder =  GWT
			.create( StatusBarBinder.class);
	@UiField
	HTML html;

	public StatusBar()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	@Override
	public void setText(String text)
	{
		this.html.setText(text);
	}

	@Override
	public String getText()
	{
		return this.html.getText();
	}

	static interface StatusBarBinder extends UiBinder<Widget, StatusBar>
	{
	}

}
