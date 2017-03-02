/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.admin;

import org.hbgb.webcamp.client.view.IView;

public interface IEarlyTeamMemberView
extends IView {
    public void setPresenter(Presenter var1);

    public void setFirstNameText(String var1);

    public String getFirstNameText();

    public void setLastNameText(String var1);

    public String getLastNameText();

    public void setPlayaNameText(String var1);

    public String getPlayaNameText();

    public void setEmailText(String var1);

    public String getEmailText();

    public void setSaveButtonEnabled(Boolean var1);

    public static interface Presenter {
        public void onSaveButtonClicked();

        public void onCancelButtonClicked();

        public void onLookUpButtonClicked();
    }

}

