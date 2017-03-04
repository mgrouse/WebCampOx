/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.event.shared.EventHandler com.google.gwt.event.shared.GwtEvent
 * com.google.gwt.event.shared.GwtEvent$Type
 */
package org.hbgb.webcamp.client.event.application;

import com.google.gwt.event.shared.GwtEvent;

public class DeleteApplicationEvent extends GwtEvent<DeleteApplicationEventHandler>
{
	public static Type<DeleteApplicationEventHandler> TYPE = new Type<>();

	@Override
	public Type<DeleteApplicationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(DeleteApplicationEventHandler handler)
	{
		handler.onDeleteApplication(this);
	}
}
