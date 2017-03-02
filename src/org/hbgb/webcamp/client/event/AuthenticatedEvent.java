/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.web.bindery.event.shared.Event
 *  com.google.web.bindery.event.shared.Event$Type
 */
package org.hbgb.webcamp.client.event;

import com.google.web.bindery.event.shared.Event;
import org.hbgb.webcamp.client.event.AuthenticatedHandler;
import org.hbgb.webcamp.shared.HbgbUser;

public class AuthenticatedEvent
extends Event<AuthenticatedHandler> {
    public static final Event.Type<AuthenticatedHandler> TYPE = new Event.Type();
    private HbgbUser user;

    public AuthenticatedEvent(HbgbUser user) {
        this.user = user;
    }

    public HbgbUser getUser() {
        return this.user;
    }

    public Event.Type<AuthenticatedHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(AuthenticatedHandler handler) {
        handler.onAuthenticated(this);
    }
}

