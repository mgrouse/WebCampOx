/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.ui.Composite
 *  com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.hbgb.webcamp.client.view.IView;
import org.hbgb.webcamp.shared.enums.SecurityRole;

public abstract class AbstractView
extends Composite
implements IView {
    @Override
    public Widget asWidget() {
        return this;
    }

    @Override
    public void clear() {
    }

    protected Boolean isFormComplete() {
        return true;
    }

    @Override
    public void setVisibility(SecurityRole role) {
    }
}

