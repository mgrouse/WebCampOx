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
import org.hbgb.webcamp.client.event.profile.AddProfileEventHandler;

public class AddProfileEvent
extends GwtEvent<AddProfileEventHandler> {
    public static GwtEvent.Type<AddProfileEventHandler> TYPE = new GwtEvent.Type();

    public GwtEvent.Type<AddProfileEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(AddProfileEventHandler handler) {
        handler.onAddProfile(this);
    }
}

