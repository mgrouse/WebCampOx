/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.event.shared.EventHandler com.google.gwt.event.shared.GwtEvent
 * com.google.gwt.event.shared.GwtEvent$Type
 */
package org.hbgb.webcamp.client.event.application;

import com.google.gwt.event.shared.GwtEvent;

public class AddApplicationEvent extends GwtEvent<AddApplicationEventHandler>
{
	public static Type<AddApplicationEventHandler> TYPE = new Type<>();

	@Override
	public GwtEvent.Type<AddApplicationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(AddApplicationEventHandler handler)
	{
		handler.onAddApplication(this);
	}
}
