/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.common;

import java.util.ArrayList;
import java.util.List;
import org.hbgb.webcamp.client.common.ColumnDefinition;
import org.hbgb.webcamp.client.common.UserColumnDefinitionsImpl;
import org.hbgb.webcamp.shared.HbgbUserDetails;

public class UserColumnDefinitionsFactory<T> {
    public static List<ColumnDefinition<HbgbUserDetails>> getUserColumnDefinitions() {
        return UserColumnDefinitionsImpl.getInstance();
    }

    public static List<ColumnDefinition<HbgbUserDetails>> getTestUserColumnDefinitions() {
        return new ArrayList<ColumnDefinition<HbgbUserDetails>>();
    }
}

