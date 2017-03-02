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
import org.hbgb.webcamp.client.event.application.ListApplicationEventHandler;

public class ListApplicationEvent
extends GwtEvent<ListApplicationEventHandler> {
    public static GwtEvent.Type<ListApplicationEventHandler> TYPE = new GwtEvent.Type();

    public GwtEvent.Type<ListApplicationEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(ListApplicationEventHandler handler) {
        handler.onListApplication(this);
    }
}

