/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.event.dom.client.ClickEvent
 * com.google.gwt.event.dom.client.ClickHandler
 * com.google.gwt.event.shared.HandlerRegistration
 * com.google.gwt.resources.client.ImageResource
 * com.google.gwt.safehtml.shared.SafeHtml
 * com.google.gwt.safehtml.shared.SafeHtmlBuilder
 * com.google.gwt.safehtml.shared.SafeHtmlUtils
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiConstructor
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.user.client.ui.AbstractImagePrototype
 * com.google.gwt.user.client.ui.Anchor com.google.gwt.user.client.ui.Composite
 * com.google.gwt.user.client.ui.Widget
 * com.google.web.bindery.event.shared.Event
 */
package org.hbgb.webcamp.client.panel;

import org.hbgb.webcamp.client.WebCampResource;
import org.hbgb.webcamp.client.event.SingletonEventBus;
import org.hbgb.webcamp.client.event.MenuEvent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MenuItem extends Composite
{
	WebCampResource images = WebCampResource.INSTANCE;
	private static UiBinder<Widget, MenuItem> binder = GWT.create(MenuItemBinder.class);
	@UiField
	Anchor anchor;

	@UiConstructor
	public MenuItem(String text, ImageResource imageResource, final String contentName)
	{
		this.initWidget(binder.createAndBindUi(this));
		this.anchor.setHTML(this.getHtml(imageResource, text));
		this.anchor.setName(contentName);
		this.anchor.addClickHandler(new ClickHandler()
		{

			@Override
			public void onClick(ClickEvent event)
			{
				SingletonEventBus.get().fireEvent(new MenuEvent(contentName));
			}
		});
	}

	private SafeHtml getHtml(ImageResource image, String text)
	{
		SafeHtmlBuilder sb = new SafeHtmlBuilder();
		sb.append(this.getHtml(this.images.blank()));
		sb.append(this.getHtml(image));
		sb.append(this.getHtml(this.images.blank()));
		sb.appendEscaped(" ").appendEscaped(text);
		return sb.toSafeHtml();
	}

	private SafeHtml getHtml(ImageResource image)
	{
		return SafeHtmlUtils.fromTrustedString(AbstractImagePrototype.create(image).getHTML());
	}

	static interface MenuItemBinder extends UiBinder<Widget, MenuItem>
	{}

}
