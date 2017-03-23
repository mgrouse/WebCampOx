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

public class GenderListBox extends EnumListBox<Gender> // implements //
														// HasChangeHandlers
{

	public GenderListBox()
	{
		super(Gender.class);
	}

	// @UiTemplate(value = "GenderListBox.ui.xml")
	// static interface GenderListBoxBinder extends UiBinder<Widget,
	// GenderListBox>
	// {}
	//
	// private static UiBinder<Widget, GenderListBox> binder =
	// GWT.create(GenderListBoxBinder.class);
	// @UiField
	// EnumListBox<Gender> list;
	//
	// // GenderListBox()
	// // {
	// // EnumListBox<Gender>();
	// // //initWidget(binder.createAndBindUi(this));
	// // }
	//
	// GenderListBox()
	// {
	// this.initWidget(binder.createAndBindUi(this));
	// }
	//
	// public void setSelectedValue(Gender value)
	// {
	// list.setSelectedValue(value);
	// }
	//
	// public Gender getSelectedValue()
	// {
	// return list.getSelectedEnumValue();
	// }
	//
	// @UiFactory
	// EnumListBox<Gender> listBoxFactory()
	// {
	// return new EnumListBox<>(Gender.class);
	// }
	//
	// public HandlerRegistration addChangeHandler(ChangeHandler handler)
	// {
	// return list.addChangeHandler(handler);
	// }
}
