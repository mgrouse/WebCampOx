/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.IView;

public interface InputHealerSheetInfoView
extends IView {
    public void setPresenter(SequentialPresenterI var1);

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

