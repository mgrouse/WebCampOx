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

import org.hbgb.webcamp.shared.enums.Gender;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class GenderListBox extends Composite
{
	private static UiBinder<Widget, GenderListBox> binder =  GWT
			.create( GenderListBoxBinder.class);
	@UiField
	EnumListBox<Gender> list;

	GenderListBox()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	public void setSelectedValue(Gender value)
	{
		this.list.setSelectedValue(value);
	}

	public Gender getSelectedValue()
	{
		return this.list.getSelectedEnumValue();
	}

	@UiFactory
	EnumListBox<Gender> listBoxFactory()
	{
		return new EnumListBox<>(Gender.class);
	}

	@UiTemplate(value = "GenderListBox.ui.xml")
	static interface GenderListBoxBinder extends UiBinder<Widget, GenderListBox>
	{
	}

}
