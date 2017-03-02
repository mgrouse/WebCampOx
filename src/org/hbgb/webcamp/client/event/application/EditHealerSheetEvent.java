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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hbgb.webcamp.client.event.application.EditHealerSheetEventHandler;

public class EditHealerSheetEvent
extends GwtEvent<EditHealerSheetEventHandler> {
    public static GwtEvent.Type<EditHealerSheetEventHandler> TYPE = new GwtEvent.Type();
    private final String key;
    private final ArrayList<String> list;

    public EditHealerSheetEvent(String encodedKey, Collection<String> list) {
        this.key = encodedKey;
        this.list = new ArrayList<String>(list);
    }

    public String getKey() {
        return this.key;
    }

    public List<String> getKeyList() {
        return this.list;
    }

    public GwtEvent.Type<EditHealerSheetEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(EditHealerSheetEventHandler handler) {
        handler.onEditHealerSheet(this);
    }
}

