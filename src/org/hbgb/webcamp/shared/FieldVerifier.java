/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.shared;

public class FieldVerifier {
    public static boolean isValidName(String name) {
        if (name == null) {
            return false;
        }
        if (name.length() <= 3) return false;
        return true;
    }
}

