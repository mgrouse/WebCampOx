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

import org.hbgb.webcamp.shared.enums.ContactMethod;

public class ContactMethodListBox extends EnumListBox<ContactMethod>
{

	public ContactMethodListBox()
	{
		super(ContactMethod.class);
	}

	// private static UiBinder<Widget, ContactMethodListBox> binder =
	// GWT.create(ContactMethodListBoxBinder.class);
	// @UiField
	// EnumListBox<ContactMethod> list;
	//
	// ContactMethodListBox()
	// {
	// this.initWidget(binder.createAndBindUi(this));
	// }
	//
	// public void setSelectedValue(ContactMethod value)
	// {
	// this.list.setSelectedValue(value);
	// }
	//
	// public ContactMethod getSelectedValue()
	// {
	// return this.list.getSelectedEnumValue();
	// }
	//
	// @UiFactory
	// EnumListBox<ContactMethod> listBoxFactory()
	// {
	// return new EnumListBox<>(ContactMethod.class);
	// }
	//
	// @UiTemplate(value = "EnumListBox.ui.xml")
	// static interface ContactMethodListBoxBinder extends UiBinder<Widget,
	// ContactMethodListBox>
	// {}

}
