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

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ContactMethodListBox extends Composite
{
	private static UiBinder<Widget, ContactMethodListBox> binder = (UiBinder) GWT
			.create((Class) ContactMethodListBoxBinder.class);
	@UiField
	EnumListBox<ContactMethod> list;

	ContactMethodListBox()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	public void setSelectedValue(ContactMethod value)
	{
		this.list.setSelectedValue(value);
	}

	public ContactMethod getSelectedValue()
	{
		return this.list.getSelectedEnumValue();
	}

	@UiFactory
	EnumListBox<ContactMethod> listBoxFactory()
	{
		return new EnumListBox<>(ContactMethod.class);
	}

	@UiTemplate(value = "EnumListBox.ui.xml")
	static interface ContactMethodListBoxBinder extends UiBinder<Widget, ContactMethodListBox>
	{
	}

}
