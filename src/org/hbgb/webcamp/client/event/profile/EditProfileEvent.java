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
import org.hbgb.webcamp.client.event.profile.EditProfileEventHandler;

public class EditProfileEvent
extends GwtEvent<EditProfileEventHandler> {
    public static GwtEvent.Type<EditProfileEventHandler> TYPE = new GwtEvent.Type();
    private final String encodedKey;

    public EditProfileEvent(String encodedKey) {
        this.encodedKey = encodedKey;
    }

    public GwtEvent.Type<EditProfileEventHandler> getAssociatedType() {
        return TYPE;
    }

    public String getEncodedKey() {
        return this.encodedKey;
    }

    protected void dispatch(EditProfileEventHandler handler) {
        handler.onEditProfile(this);
    }
}

