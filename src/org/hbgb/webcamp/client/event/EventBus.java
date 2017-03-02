/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.GWT
 *  com.google.gwt.event.shared.SimpleEventBus
 */
package org.hbgb.webcamp.client.event;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;

public class EventBus {
    private static final SimpleEventBus INSTANCE = (SimpleEventBus)GWT.create((Class)SimpleEventBus.class);

    private EventBus() {
    }

    public static SimpleEventBus get() {
        return INSTANCE;
    }
}

