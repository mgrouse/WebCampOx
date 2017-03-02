/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.shared;

import java.io.Serializable;

public class HealerSheetDetails
implements Comparable<HealerSheetDetails>,
Serializable {
    private String encodedKey = null;
    private String email = "";
    private String playaName = "";
    private String imageURL = "";
    private String sessionLength = "";
    private String modality1 = "";
    private String modality2 = "";
    private String modality3 = "";
    private String modality4 = "";
    private String bio = "";

    public HealerSheetDetails() {
    }

    public HealerSheetDetails(String key, String email, String playaName, String imageURL, String sessionLength, String modality1, String modality2, String modality3, String modality4, String bio) {
        this.encodedKey = key;
        this.email = email;
        this.playaName = playaName;
        this.imageURL = imageURL;
        this.sessionLength = sessionLength;
        this.modality1 = modality1;
        this.modality2 = modality2;
        this.modality3 = modality3;
        this.modality4 = modality4;
        this.bio = bio;
    }

    public String getEncodedKey() {
        return this.encodedKey;
    }

    public void setEncodedKey(String encodedKey) {
        this.encodedKey = encodedKey;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlayaName() {
        return this.playaName;
    }

    public void setPlayaName(String playaName) {
        this.playaName = playaName;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getSessionLength() {
        return this.sessionLength;
    }

    public void setSessionLength(String sessionLength) {
        this.sessionLength = sessionLength;
    }

    public String getModality1() {
        return this.modality1;
    }

    public void setModality1(String modality1) {
        this.modality1 = modality1;
    }

    public String getModality2() {
        return this.modality2;
    }

    public void setModality2(String modality2) {
        this.modality2 = modality2;
    }

    public String getModality3() {
        return this.modality3;
    }

    public void setModality3(String modality3) {
        this.modality3 = modality3;
    }

    public String getModality4() {
        return this.modality4;
    }

    public void setModality4(String modality4) {
        this.modality4 = modality4;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public int compareTo(HealerSheetDetails o) {
        return 0;
    }
}

