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
import org.hbgb.webcamp.client.event.user.EditUserEventHandler;

public class EditUserEvent
extends GwtEvent<EditUserEventHandler> {
    public static GwtEvent.Type<EditUserEventHandler> TYPE = new GwtEvent.Type();
    private final String key;

    public EditUserEvent(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public GwtEvent.Type<EditUserEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(EditUserEventHandler handler) {
        handler.onEditUser(this);
    }
}

