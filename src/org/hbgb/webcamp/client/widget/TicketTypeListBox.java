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

import org.hbgb.webcamp.shared.enums.TicketType;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TicketTypeListBox extends Composite
{
	private static UiBinder<Widget, TicketTypeListBox> binder = (UiBinder) GWT
			.create((Class) TicketTypeListBoxBinder.class);
	@UiField
	EnumListBox<TicketType> list;

	TicketTypeListBox()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	public void setSelectedValue(TicketType value)
	{
		this.list.setSelectedValue(value);
	}

	public TicketType getSelectedValue()
	{
		return this.list.getSelectedEnumValue();
	}

	@UiFactory
	EnumListBox<TicketType> listBoxFactory()
	{
		return new EnumListBox<>(TicketType.class);
	}

	@UiTemplate(value = "TicketTypeListBox.ui.xml")
	static interface TicketTypeListBoxBinder extends UiBinder<Widget, TicketTypeListBox>
	{
	}

}
