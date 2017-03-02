/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.IView;
import org.hbgb.webcamp.shared.enums.DietType;

public interface InputDietInfoView
extends IView {
    public void setPresenter(SequentialPresenterI var1);

    public void setDietType(DietType var1);

    public DietType getDietType();

    public void setIsGlutenFree(Boolean var1);

    public Boolean getIsGlutenFree();

    public void setDietaryRestrictions(String var1);

    public String getDietaryRestrictions();
}

