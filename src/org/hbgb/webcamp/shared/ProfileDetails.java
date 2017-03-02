/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.shared;

import java.io.Serializable;

public class ProfileDetails
implements Serializable {
    private String encodedKey;
    private String displayName;
    private String email;

    public ProfileDetails() {
    }

    public ProfileDetails(String key, String displayName, String email) {
        this.encodedKey = key;
        this.displayName = displayName;
        this.email = email;
    }

    public String getEncodedKey() {
        return this.encodedKey;
    }

    public void setEncodedKey(String encodedKey) {
        this.encodedKey = encodedKey;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

