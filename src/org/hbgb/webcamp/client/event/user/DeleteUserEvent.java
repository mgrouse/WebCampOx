/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.event.shared.GwtEvent
 *  com.google.gwt.event.shared.GwtEvent$Type
 */
package org.hbgb.webcamp.client.event.user;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import org.hbgb.webcamp.client.event.user.DeleteUserEventHandler;

public class DeleteUserEvent
extends GwtEvent<DeleteUserEventHandler> {
    public static GwtEvent.Type<DeleteUserEventHandler> TYPE = new GwtEvent.Type();

    public GwtEvent.Type<DeleteUserEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(DeleteUserEventHandler handler) {
        handler.onContactDeleted(this);
    }
}

