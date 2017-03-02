/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.CheckBox com.google.gwt.user.client.ui.TextArea
 * com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application.edit;

import org.hbgb.webcamp.client.widget.DietListBox;
import org.hbgb.webcamp.shared.enums.DietType;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class EditDietInfoViewImpl extends AbstractPartView implements IEditDietInfoView
{

	@UiTemplate(value = "EditDietInfoView.ui.xml")
	static interface EditDietInfoViewImplBinder extends UiBinder<Widget, EditDietInfoViewImpl>
	{
	}

	private static UiBinder<Widget, EditDietInfoViewImpl> binder = (UiBinder) GWT
			.create((Class) EditDietInfoViewImplBinder.class);

	@UiField
	DietListBox dietType;

	@UiField
	CheckBox isGlutenFree;

	@UiField
	TextArea dietaryRestrictions;

	public EditDietInfoViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
		this.expand();
	}

	@Override
	public void setDietType(DietType type)
	{
		this.dietType.setSelectedValue(type);
	}

	@Override
	public DietType getDietType()
	{
		return this.dietType.getSelectedValue();
	}

	@Override
	public void setIsGlutenFree(Boolean bool)
	{
		this.isGlutenFree.setValue(bool, false);
	}

	@Override
	public Boolean getIsGlutenFree()
	{
		return this.isGlutenFree.getValue();
	}

	@Override
	public void setDietaryRestrictions(String text)
	{
		this.dietaryRestrictions.setValue(text, false);
	}

	@Override
	public String getDietaryRestrictions()
	{
		return this.dietaryRestrictions.getText();
	}

}
