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

import org.hbgb.webcamp.shared.enums.Transportation;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TransportationListBox extends Composite
{
	private static UiBinder<Widget, TransportationListBox> binder = (UiBinder) GWT
			.create((Class) TransportationListBoxBinder.class);
	@UiField
	EnumListBox<Transportation> list;

	TransportationListBox()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	public void setSelectedValue(Transportation value)
	{
		this.list.setSelectedValue(value);
	}

	public Transportation getSelectedValue()
	{
		return this.list.getSelectedEnumValue();
	}

	@UiFactory
	EnumListBox<Transportation> listBoxFactory()
	{
		return new EnumListBox<>(Transportation.class);
	}

	@UiTemplate(value = "TransportationListBox.ui.xml")
	static interface TransportationListBoxBinder extends UiBinder<Widget, TransportationListBox>
	{
	}

}
