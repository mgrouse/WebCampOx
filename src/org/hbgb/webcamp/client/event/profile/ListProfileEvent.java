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
import org.hbgb.webcamp.client.event.profile.ListProfileEventHandler;

public class ListProfileEvent
extends GwtEvent<ListProfileEventHandler> {
    public static GwtEvent.Type<ListProfileEventHandler> TYPE = new GwtEvent.Type();

    public GwtEvent.Type<ListProfileEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(ListProfileEventHandler handler) {
        handler.onListProfile(this);
    }
}

