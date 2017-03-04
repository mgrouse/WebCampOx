/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.web.bindery.event.shared.Event
 * com.google.web.bindery.event.shared.Event$Type
 */
package org.hbgb.webcamp.client.event;

import com.google.web.bindery.event.shared.Event;

public class MenuEvent extends Event<MenuHandler>
{
	public static final Type<MenuHandler> TYPE = new Type<>();
	private String menu;

	public MenuEvent(String menu)
	{
		this.menu = menu;
	}

	public String getMenu()
	{
		return this.menu;
	}

	@Override
	public Event.Type<MenuHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(MenuHandler handler)
	{
		handler.onMenuSelection(this);
	}
}
