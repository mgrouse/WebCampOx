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

public class TransportationListBox extends EnumListBox<Transportation>
{

	/**
	 * @param eclass
	 */
	public TransportationListBox()
	{
		super(Transportation.class);
	}
	// private static UiBinder<Widget, TransportationListBox> binder =
	// GWT.create(TransportationListBoxBinder.class);
	// @UiField
	// EnumListBox<Transportation> list;
	//
	// TransportationListBox()
	// {
	// this.initWidget(binder.createAndBindUi(this));
	// }
	//
	// public void setSelectedValue(Transportation value)
	// {
	// this.list.setSelectedValue(value);
	// }
	//
	// public Transportation getSelectedValue()
	// {
	// return this.list.getSelectedEnumValue();
	// }
	//
	// @UiFactory
	// EnumListBox<Transportation> listBoxFactory()
	// {
	// return new EnumListBox<>(Transportation.class);
	// }
	//
	// @UiTemplate(value = "TransportationListBox.ui.xml")
	// static interface TransportationListBoxBinder extends UiBinder<Widget,
	// TransportationListBox>
	// {}

}
