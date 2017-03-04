/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.web.bindery.event.shared.Event
 * com.google.web.bindery.event.shared.Event$Type
 */
package org.hbgb.webcamp.client.event;

import com.google.web.bindery.event.shared.Event;

public class StatusEvent extends Event<StatusHandler>
{
	public static final Type<StatusHandler> TYPE = new Type<>();

	private String status;

	public StatusEvent(String status)
	{
		this.status = status;
	}

	public String getStatus()
	{
		return this.status;
	}

	@Override
	public Event.Type<StatusHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(StatusHandler handler)
	{
		handler.onStatusChange(this);
	}
}
