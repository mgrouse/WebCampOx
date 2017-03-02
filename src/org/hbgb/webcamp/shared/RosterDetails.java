/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.shared;

import java.io.Serializable;

public class RosterDetails
implements Comparable<RosterDetails>,
Serializable {
    private String encodedKey;
    private String photoURL;
    private String playaName;
    private String firstName;
    private String homeTown;
    private String committee;
    private String bio;

    public RosterDetails() {
        new org.hbgb.webcamp.shared.RosterDetails(null, "", "", "", "", "", "");
    }

    public RosterDetails(String key, String photoURL, String playaName, String firstName, String homeTown, String committee, String bio) {
        this.encodedKey = key;
        this.photoURL = photoURL;
        this.playaName = playaName;
        this.firstName = firstName;
        this.homeTown = homeTown;
        this.committee = committee;
        this.bio = bio;
    }

    public String getEncodedKey() {
        return this.encodedKey;
    }

    public void setEncodedKey(String encodedKey) {
        this.encodedKey = encodedKey;
    }

    public String getPhotoURL() {
        return this.photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getPlayaName() {
        return this.playaName;
    }

    public void setPlayaName(String playaName) {
        this.playaName = playaName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHomeTown() {
        return this.homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getCommittee() {
        return this.committee;
    }

    public void setCommittee(String committee) {
        this.committee = committee;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public int compareTo(RosterDetails rd) {
        int retval = 0;
        return this.playaName.compareTo(rd.playaName);
    }
}

