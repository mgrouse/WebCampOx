/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.event.shared.EventHandler com.google.gwt.event.shared.GwtEvent
 * com.google.gwt.event.shared.GwtEvent$Type
 */
package org.hbgb.webcamp.client.event.user;

import com.google.gwt.event.shared.GwtEvent;

public class ListUserEvent extends GwtEvent<ListUserEventHandler>
{
	public static GwtEvent.Type<ListUserEventHandler> TYPE = new GwtEvent.Type<>();

	@Override
	public GwtEvent.Type<ListUserEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ListUserEventHandler handler)
	{
		handler.onListUser(this);
	}
}
