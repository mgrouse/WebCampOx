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

import org.hbgb.webcamp.shared.enums.DayOfEvent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DayOfEventListBox extends Composite
{
	private static UiBinder<Widget, DayOfEventListBox> binder =  GWT
			.create( DayOfEventListBoxBinder.class);
	@UiField
	EnumListBox<DayOfEvent> list;

	DayOfEventListBox()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	public void setSelectedValue(DayOfEvent value)
	{
		this.list.setSelectedValue(value);
	}

	public DayOfEvent getSelectedValue()
	{
		return this.list.getSelectedEnumValue();
	}

	@UiFactory
	EnumListBox<DayOfEvent> listBoxFactory()
	{
		return new EnumListBox<>(DayOfEvent.class);
	}

	@UiTemplate(value = "DayOfEventListBox.ui.xml")
	static interface DayOfEventListBoxBinder extends UiBinder<Widget, DayOfEventListBox>
	{
	}

}
