/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.shared.EventHandler
 *  com.google.gwt.event.shared.GwtEvent
 *  com.google.gwt.event.shared.GwtEvent$Type
 */
package org.hbgb.webcamp.client.event.application;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import org.hbgb.webcamp.client.event.application.DeleteApplicationEventHandler;

public class DeleteApplicationEvent
extends GwtEvent<DeleteApplicationEventHandler> {
    public static GwtEvent.Type<DeleteApplicationEventHandler> TYPE = new GwtEvent.Type();

    public GwtEvent.Type<DeleteApplicationEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(DeleteApplicationEventHandler handler) {
        handler.onDeleteApplication(this);
    }
}

