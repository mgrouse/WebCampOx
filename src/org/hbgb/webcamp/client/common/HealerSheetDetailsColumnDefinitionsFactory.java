/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.common;

import java.util.List;
import org.hbgb.webcamp.client.common.ColumnDefinition;
import org.hbgb.webcamp.client.common.HealerSheetDetailsColumnDefinitionsImpl;
import org.hbgb.webcamp.shared.HealerSheetDetails;

public class HealerSheetDetailsColumnDefinitionsFactory {
    public static List<ColumnDefinition<HealerSheetDetails>> getHealerSheetColumnDefinitions() {
        return HealerSheetDetailsColumnDefinitionsImpl.getInstance();
    }
}

