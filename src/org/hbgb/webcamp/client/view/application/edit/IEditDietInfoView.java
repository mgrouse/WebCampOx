/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.edit;

import org.hbgb.webcamp.client.view.IPartView;
import org.hbgb.webcamp.shared.enums.DietType;

public interface IEditDietInfoView extends IPartView
{
	public void setDietType(DietType var1);

	public DietType getDietType();

	public void setIsGlutenFree(Boolean var1);

	public Boolean getIsGlutenFree();

	public void setIsLactoseIntolerant(Boolean bool);

	public Boolean getIsLactoseIntolerant();

	public void setDietaryRestrictions(String var1);

	public String getDietaryRestrictions();

}
