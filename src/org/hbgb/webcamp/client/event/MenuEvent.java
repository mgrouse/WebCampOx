/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.web.bindery.event.shared.Event
 *  com.google.web.bindery.event.shared.Event$Type
 */
package org.hbgb.webcamp.client.event;

import com.google.web.bindery.event.shared.Event;
import org.hbgb.webcamp.client.event.MenuHandler;

public class MenuEvent
extends Event<MenuHandler> {
    public static final Event.Type<MenuHandler> TYPE = new Event.Type();
    private String menu;

    public MenuEvent(String menu) {
        this.menu = menu;
    }

    public String getMenu() {
        return this.menu;
    }

    public Event.Type<MenuHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(MenuHandler handler) {
        handler.onMenuSelection(this);
    }
}

