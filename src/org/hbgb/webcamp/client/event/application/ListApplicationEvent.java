/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.event.shared.EventHandler com.google.gwt.event.shared.GwtEvent
 * com.google.gwt.event.shared.GwtEvent$Type
 */
package org.hbgb.webcamp.client.event.application;

import com.google.gwt.event.shared.GwtEvent;

public class ListApplicationEvent extends GwtEvent<ListApplicationEventHandler>
{
	public static GwtEvent.Type<ListApplicationEventHandler> TYPE = new GwtEvent.Type<>();

	@Override
	public GwtEvent.Type<ListApplicationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(ListApplicationEventHandler handler)
	{
		handler.onListApplication(this);
	}
}
