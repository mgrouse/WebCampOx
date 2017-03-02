/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.IView;
import org.hbgb.webcamp.shared.enums.Committee;

public interface InputCommitteeInfoView
extends IView {
    public void setPresenter(SequentialPresenterI var1);

    public void setCommittee1(Committee var1);

    public Committee getCommittee1();

    public void setReason1(String var1);

    public String getReason1();

    public void setCommittee2(Committee var1);

    public Committee getCommittee2();

    public void setReason2(String var1);

    public String getReason2();

    public void setAssignedCommittee(Committee var1);

    public Committee getAssignedCommittee();

    public void setIsAssignedLead(Boolean var1);

    public Boolean getIsAssignedLead();

    public void setSessionLength(String var1);

    public String getSessionLength();

    public void setModality1(String var1);

    public String getModality1();

    public void setModality2(String var1);

    public String getModality2();

    public void setModality3(String var1);

    public String getModality3();

    public void setModality4(String var1);

    public String getModality4();

    public void setBioBox(String var1);

    public String getBioBox();
}

