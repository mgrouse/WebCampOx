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

public class DayOfEventListBox extends EnumListBox<DayOfEvent>
{

	/**
	 * @param eclass
	 */
	public DayOfEventListBox()
	{
		super(DayOfEvent.class);

	}

	@Override
	public DayOfEvent getSelectedEnumValue()
	{
		DayOfEvent doe = null;

		String temp = getSelectedItemText();
		doe = DayOfEvent.reverseLookup(temp);

		return doe;
	}

	// @UiTemplate(value = "DayOfEventListBox.ui.xml")
	// static interface DayOfEventListBoxBinder extends UiBinder<Widget,
	// DayOfEventListBox>
	// {}
	//
	// private static UiBinder<Widget, DayOfEventListBox> binder =
	// GWT.create(DayOfEventListBoxBinder.class);
	//
	// @UiField
	// EnumListBox<DayOfEvent> list;
	//
	// DayOfEventListBox()
	// {
	// this.initWidget(binder.createAndBindUi(this));
	// }
	//
	// public void removeETDates()
	// {
	// for (int i = 0; i < 8; ++i)
	// {
	// list.removeItem(0);
	// }
	// }
	//
	// public void setSelectedValue(DayOfEvent value)
	// {
	// this.list.setSelectedValue(value);
	// }
	//
	// public DayOfEvent getSelectedValue()
	// {
	// DayOfEvent doe = null;
	// String temp = list.getSelectedItemText();
	// doe = DayOfEvent.reverseLookup(temp);
	//
	// return doe;
	// }
	//
	// @UiFactory
	// EnumListBox<DayOfEvent> listBoxFactory()
	// {
	// return new EnumListBox<>(DayOfEvent.class);
	// }

}
