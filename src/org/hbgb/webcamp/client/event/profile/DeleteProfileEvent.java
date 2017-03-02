/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.event.shared.GwtEvent
 *  com.google.gwt.event.shared.GwtEvent$Type
 */
package org.hbgb.webcamp.client.event.profile;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import org.hbgb.webcamp.client.event.profile.DeleteProfileEventHandler;

public class DeleteProfileEvent
extends GwtEvent<DeleteProfileEventHandler> {
    public static GwtEvent.Type<DeleteProfileEventHandler> TYPE = new GwtEvent.Type();

    public GwtEvent.Type<DeleteProfileEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(DeleteProfileEventHandler handler) {
        handler.onDeleteProfile(this);
    }
}

