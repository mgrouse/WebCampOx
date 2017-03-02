/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.shared;

import java.io.Serializable;

public class ApplicationDetails
implements Comparable,
Serializable {
    private String encodedKey;
    private String status;
    private String displayName;
    private String playaName;
    private String committee;
    private String ticket;
    private String invoiced;
    private String paid;
    private String diet;
    private String email;

    public ApplicationDetails() {
        new org.hbgb.webcamp.shared.ApplicationDetails(null, "", "", "", "", "", "", "", "", "");
    }

    public ApplicationDetails(String key, String status, String displayName, String playaName, String committee, String ticket, String invoiced, String paid, String diet, String email) {
        this.encodedKey = key;
        this.status = status;
        this.displayName = displayName;
        this.playaName = playaName;
        this.committee = committee;
        this.ticket = ticket;
        this.invoiced = invoiced;
        this.paid = paid;
        this.diet = diet;
        this.email = email;
    }

    public String getEncodedKey() {
        return this.encodedKey;
    }

    public void setEncodedKey(String encodedKey) {
        this.encodedKey = encodedKey;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPlayaName() {
        return this.playaName;
    }

    public void setPlayaName(String playaName) {
        this.playaName = playaName;
    }

    public String getCommittee() {
        return this.committee;
    }

    public void setCommittee(String committee) {
        this.committee = committee;
    }

    public String getInvoiced() {
        return this.invoiced;
    }

    public void setInvoiced(String invoiced) {
        this.invoiced = invoiced;
    }

    public String getPaid() {
        return this.paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTicket() {
        return this.ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getDiet() {
        return this.diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public int compareTo(Object o) {
        int retval = 0;
        ApplicationDetails ad = (ApplicationDetails)o;
        retval = this.status.compareTo(ad.status);
        if (retval != 0) return retval;
        return this.committee.compareTo(ad.committee);
    }
}

