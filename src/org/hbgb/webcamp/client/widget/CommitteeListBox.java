/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.event.dom.client.ChangeHandler
 * com.google.gwt.event.shared.HandlerRegistration
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiFactory
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.Composite com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.widget;

import org.hbgb.webcamp.shared.enums.Committee;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CommitteeListBox extends Composite
{
	private static UiBinder<Widget, CommitteeListBox> binder = (UiBinder) GWT
			.create((Class) CommitteeListBoxBinder.class);
	@UiField
	EnumListBox<Committee> list;

	CommitteeListBox()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	public void setSelectedValue(Committee value)
	{
		this.list.setSelectedValue(value);
	}

	public Committee getSelectedValue()
	{
		return this.list.getSelectedEnumValue();
	}

	public HandlerRegistration addChangeHandler(ChangeHandler handler)
	{
		return this.list.addChangeHandler(handler);
	}

	@UiFactory
	EnumListBox<Committee> listBoxFactory()
	{
		return new EnumListBox<>(Committee.class);
	}

	@UiTemplate(value = "CommitteeListBox.ui.xml")
	static interface CommitteeListBoxBinder extends UiBinder<Widget, CommitteeListBox>
	{
	}

}
