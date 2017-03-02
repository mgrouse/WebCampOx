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
import org.hbgb.webcamp.client.event.user.AddUserEventHandler;

public class AddUserEvent
extends GwtEvent<AddUserEventHandler> {
    public static GwtEvent.Type<AddUserEventHandler> TYPE = new GwtEvent.Type();

    public GwtEvent.Type<AddUserEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(AddUserEventHandler handler) {
        handler.onAddUser(this);
    }
}

