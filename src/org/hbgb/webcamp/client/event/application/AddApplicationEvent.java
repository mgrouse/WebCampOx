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
import org.hbgb.webcamp.client.event.application.AddApplicationEventHandler;

public class AddApplicationEvent
extends GwtEvent<AddApplicationEventHandler> {
    public static GwtEvent.Type<AddApplicationEventHandler> TYPE = new GwtEvent.Type();

    public GwtEvent.Type<AddApplicationEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(AddApplicationEventHandler handler) {
        handler.onAddApplication(this);
    }
}

