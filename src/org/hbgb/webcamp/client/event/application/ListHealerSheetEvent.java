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
import org.hbgb.webcamp.client.event.application.ListHealerSheetEventHandler;

public class ListHealerSheetEvent
extends GwtEvent<ListHealerSheetEventHandler> {
    public static GwtEvent.Type<ListHealerSheetEventHandler> TYPE = new GwtEvent.Type();

    public GwtEvent.Type<ListHealerSheetEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(ListHealerSheetEventHandler handler) {
        handler.onListHealerSheet(this);
    }
}

