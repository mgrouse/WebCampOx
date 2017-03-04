/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.event.shared.EventHandler com.google.gwt.event.shared.GwtEvent
 * com.google.gwt.event.shared.GwtEvent$Type
 */
package org.hbgb.webcamp.client.event.user;

import com.google.gwt.event.shared.GwtEvent;

public class EditUserEvent extends GwtEvent<EditUserEventHandler>
{
	public static GwtEvent.Type<EditUserEventHandler> TYPE = new GwtEvent.Type<>();
	private final String key;

	public EditUserEvent(String key)
	{
		this.key = key;
	}

	public String getKey()
	{
		return this.key;
	}

	@Override
	public GwtEvent.Type<EditUserEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(EditUserEventHandler handler)
	{
		handler.onEditUser(this);
	}
}
