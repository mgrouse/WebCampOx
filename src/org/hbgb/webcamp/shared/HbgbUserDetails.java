/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.shared;

import java.io.Serializable;

public class HbgbUserDetails
implements Serializable {
    private String encodedKey;
    private String displayName;

    public HbgbUserDetails() {
        new org.hbgb.webcamp.shared.HbgbUserDetails(null, "");
    }

    public HbgbUserDetails(String key, String fullName) {
        this.encodedKey = key;
        this.displayName = fullName;
    }

    public String getKey() {
        return this.encodedKey;
    }

    public void setKey(String key) {
        this.encodedKey = key;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}

