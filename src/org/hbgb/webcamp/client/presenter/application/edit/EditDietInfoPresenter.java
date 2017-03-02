/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.presenter.application.edit;

import org.hbgb.webcamp.client.model.DietInfoBlockModel;
import org.hbgb.webcamp.client.model.IKeyedModel;
import org.hbgb.webcamp.client.presenter.application.edit.AbstractInfoBlockPresenter;
import org.hbgb.webcamp.client.view.IPartView;
import org.hbgb.webcamp.client.view.application.edit.EditDietInfoViewImpl;
import org.hbgb.webcamp.shared.DietInfoBlock;
import org.hbgb.webcamp.shared.enums.DietType;

public class EditDietInfoPresenter
extends AbstractInfoBlockPresenter {
    static EditDietInfoViewImpl view = new EditDietInfoViewImpl();
    static DietInfoBlockModel model = new DietInfoBlockModel();

    public EditDietInfoPresenter() {
        super(model, view);
    }

    @Override
    protected void setViewData() {
        DietInfoBlock block = model.getData();
        view.setDietType(block.getDietType());
        view.setIsGlutenFree(block.getIsGlutenFree());
        view.setDietaryRestrictions(block.getDietaryRestrictions());
    }

    @Override
    protected void setModelData() {
        DietInfoBlock block = model.getData();
        block.setDietType(view.getDietType());
        block.setIsGlutenFree(view.getIsGlutenFree());
        block.setDietaryRestrictions(view.getDietaryRestrictions());
    }
}

