/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.resources.client.ImageResource
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiConstructor
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.user.client.ui.Composite com.google.gwt.user.client.ui.HTML
 * com.google.gwt.user.client.ui.Image com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.panel.element;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class MenuHeader extends Composite
{
	static interface MenuHeaderBinder extends UiBinder<Widget, MenuHeader>
	{}

	private static UiBinder<Widget, MenuHeader> binder = GWT.create(MenuHeaderBinder.class);

	@UiField(provided = true)
	Image image;

	@UiField(provided = true)
	HTML html;

	@UiConstructor
	public MenuHeader(String text, ImageResource imageResource)
	{
		this.image = new Image(imageResource);
		this.html = new HTML(text);
		this.initWidget(binder.createAndBindUi(this));
	}

}
