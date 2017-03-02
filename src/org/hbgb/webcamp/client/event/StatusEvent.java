/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.web.bindery.event.shared.Event
 *  com.google.web.bindery.event.shared.Event$Type
 */
package org.hbgb.webcamp.client.event;

import com.google.web.bindery.event.shared.Event;
import org.hbgb.webcamp.client.event.StatusHandler;

public class StatusEvent
extends Event<StatusHandler> {
    public static final Event.Type<StatusHandler> TYPE = new Event.Type();
    private String status;

    public StatusEvent(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public Event.Type<StatusHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(StatusHandler handler) {
        handler.onStatusChange(this);
    }
}

