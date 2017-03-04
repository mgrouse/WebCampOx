/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiFactory
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.Composite com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.widget;

import org.hbgb.webcamp.shared.enums.DietType;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DietListBox extends Composite
{
	private static UiBinder<Widget, DietListBox> binder = GWT.create(DietListBoxBinder.class);
	@UiField
	EnumListBox<DietType> list;

	DietListBox()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	public void setSelectedValue(DietType value)
	{
		this.list.setSelectedValue(value);
	}

	public DietType getSelectedValue()
	{
		return this.list.getSelectedEnumValue();
	}

	@UiFactory
	EnumListBox<DietType> listBoxFactory()
	{
		return new EnumListBox<>(DietType.class);
	}

	@UiTemplate(value = "DietListBox.ui.xml")
	static interface DietListBoxBinder extends UiBinder<Widget, DietListBox>
	{}

}
