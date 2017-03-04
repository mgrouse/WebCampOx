/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.web.bindery.event.shared.Event
 * com.google.web.bindery.event.shared.Event$Type
 */
package org.hbgb.webcamp.client.event;

import org.hbgb.webcamp.shared.HbgbUser;

import com.google.web.bindery.event.shared.Event;

public class AuthenticatedEvent extends Event<AuthenticatedHandler>
{
	public static final Type<AuthenticatedHandler> TYPE = new Type<>();
	private HbgbUser user;

	public AuthenticatedEvent(HbgbUser user)
	{
		this.user = user;
	}

	public HbgbUser getUser()
	{
		return this.user;
	}

	@Override
	public Event.Type<AuthenticatedHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(AuthenticatedHandler handler)
	{
		handler.onAuthenticated(this);
	}
}
