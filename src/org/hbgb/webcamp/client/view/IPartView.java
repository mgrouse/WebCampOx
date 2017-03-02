/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.dom.client.ClickEvent
 */
package org.hbgb.webcamp.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import org.hbgb.webcamp.client.presenter.IPartPresenter;
import org.hbgb.webcamp.client.view.IView;

public interface IPartView
extends IView {
    public void setPresenter(IPartPresenter var1);

    public void expand();

    public void contract();

    public boolean isExpanded();

    public void onExpandButtonClicked(ClickEvent var1);

    public void setExpandButtonEnabled(Boolean var1);

    public void onEditButtonClicked(ClickEvent var1);

    public void setEditButtonEnabled(Boolean var1);

    public void onSaveButtonClicked(ClickEvent var1);

    public void setSaveButtonEnabled(Boolean var1);
}

