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
import org.hbgb.webcamp.client.event.application.PrintHealerSheetEventHandler;
import org.hbgb.webcamp.shared.HealerSheetDetails;

public class PrintHealerSheetEvent
extends GwtEvent<PrintHealerSheetEventHandler> {
    public static GwtEvent.Type<PrintHealerSheetEventHandler> TYPE = new GwtEvent.Type();
    private final HealerSheetDetails details;

    public PrintHealerSheetEvent(HealerSheetDetails hd) {
        this.details = hd;
    }

    public HealerSheetDetails getDetails() {
        return this.details;
    }

    public GwtEvent.Type<PrintHealerSheetEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(PrintHealerSheetEventHandler handler) {
        handler.onPrintHealerSheet(this);
    }
}

