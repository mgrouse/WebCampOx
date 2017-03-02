/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.presenter;

import org.hbgb.webcamp.shared.enums.SecurityRole;

public interface HbgbIdentification {
    public String getApplicationKey();

    public String getEmail();

    public Boolean isSecurityRole(SecurityRole var1);

    public Boolean isPassword(String var1);
}

