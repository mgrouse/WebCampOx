/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.admin;

import org.hbgb.webcamp.client.view.IView;
import org.hbgb.webcamp.shared.enums.SecurityRole;

public interface IUserEditView
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

    public void setPasswordText(String var1);

    public String getPasswordText();

    public void setSecurityRole(SecurityRole var1);

    public SecurityRole getSecurityRole();

    public void setIsEarlyTeam(Boolean var1);

    public Boolean getIsEarlyTeam();

    public static interface Presenter {
        public void onSaveButtonClicked();

        public void onCancelButtonClicked();
    }

}

