/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.client.view.ISequentialView;
import org.hbgb.webcamp.client.view.IView;
import org.hbgb.webcamp.shared.enums.DietType;

public interface InputDietInfoView extends ISequentialView, IView
{
	@Override
	public void setPresenter(ISequentialPresenter var1);

	public void setDietType(DietType var1);

	public DietType getDietType();

	public void setIsGlutenFree(Boolean var1);

	public Boolean getIsGlutenFree();

	public void setIsLactoseIntolerant(Boolean var1);

	public Boolean getIsLactoseIntolerant();

	public void setDietaryRestrictions(String var1);

	public String getDietaryRestrictions();

}
