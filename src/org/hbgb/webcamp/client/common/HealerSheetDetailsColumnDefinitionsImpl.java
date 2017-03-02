/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.ui.CheckBox
 *  com.google.gwt.user.client.ui.HTML
 *  com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.common;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;
import org.hbgb.webcamp.client.common.ColumnDefinition;
import org.hbgb.webcamp.shared.HealerSheetDetails;

public class HealerSheetDetailsColumnDefinitionsImpl
extends ArrayList<ColumnDefinition<HealerSheetDetails>> {
    private static HealerSheetDetailsColumnDefinitionsImpl instance = null;

    public static HealerSheetDetailsColumnDefinitionsImpl getInstance() {
        if (instance != null) return instance;
        instance = new HealerSheetDetailsColumnDefinitionsImpl();
        return instance;
    }

    protected HealerSheetDetailsColumnDefinitionsImpl() {
        this.add(new ColumnDefinition<HealerSheetDetails>(){

            @Override
            public Widget render(HealerSheetDetails h) {
                return new CheckBox();
            }

            @Override
            public boolean isSelectable() {
                return true;
            }
        });
        this.add(new ColumnDefinition<HealerSheetDetails>(){

            @Override
            public Widget render(HealerSheetDetails h) {
                return new HTML("<img src=" + h.getImageURL() + ">");
            }

            @Override
            public boolean isClickable() {
                return true;
            }
        });
        this.add(new ColumnDefinition<HealerSheetDetails>(){

            @Override
            public Widget render(HealerSheetDetails h) {
                return new HTML(h.getEmail());
            }

            @Override
            public boolean isClickable() {
                return true;
            }
        });
        this.add(new ColumnDefinition<HealerSheetDetails>(){

            @Override
            public Widget render(HealerSheetDetails h) {
                return new HTML(h.getPlayaName());
            }

            @Override
            public boolean isClickable() {
                return true;
            }
        });
        this.add(new ColumnDefinition<HealerSheetDetails>(){

            @Override
            public Widget render(HealerSheetDetails h) {
                return new HTML(h.getSessionLength());
            }

            @Override
            public boolean isClickable() {
                return true;
            }
        });
        this.add(new ColumnDefinition<HealerSheetDetails>(){

            @Override
            public Widget render(HealerSheetDetails h) {
                return new HTML(h.getModality1());
            }

            @Override
            public boolean isClickable() {
                return true;
            }
        });
        this.add(new ColumnDefinition<HealerSheetDetails>(){

            @Override
            public Widget render(HealerSheetDetails h) {
                return new HTML(h.getModality2());
            }

            @Override
            public boolean isClickable() {
                return true;
            }
        });
        this.add(new ColumnDefinition<HealerSheetDetails>(){

            @Override
            public Widget render(HealerSheetDetails h) {
                return new HTML(h.getModality3());
            }

            @Override
            public boolean isClickable() {
                return true;
            }
        });
        this.add(new ColumnDefinition<HealerSheetDetails>(){

            @Override
            public Widget render(HealerSheetDetails h) {
                return new HTML(h.getModality4());
            }

            @Override
            public boolean isClickable() {
                return true;
            }
        });
        this.add(new ColumnDefinition<HealerSheetDetails>(){

            @Override
            public Widget render(HealerSheetDetails h) {
                return new HTML(h.getBio());
            }

            @Override
            public boolean isClickable() {
                return true;
            }
        });
    }

}

