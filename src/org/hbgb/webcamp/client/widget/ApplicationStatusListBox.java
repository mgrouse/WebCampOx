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

import org.hbgb.webcamp.shared.enums.ApplicationStatus;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationStatusListBox extends Composite
{
	private static UiBinder<Widget, ApplicationStatusListBox> binder = GWT.create(ApplicationStatusListBoxBinder.class);
	@UiField
	EnumListBox<ApplicationStatus> list;

	ApplicationStatusListBox()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	public void setSelectedValue(ApplicationStatus value)
	{
		this.list.setSelectedValue(value);
	}

	public ApplicationStatus getSelectedValue()
	{
		return this.list.getSelectedEnumValue();
	}

	@UiFactory
	EnumListBox<ApplicationStatus> listBoxFactory()
	{
		return new EnumListBox<>(ApplicationStatus.class);
	}

	@UiTemplate(value = "CommitteeListBox.ui.xml")
	static interface ApplicationStatusListBoxBinder extends UiBinder<Widget, ApplicationStatusListBox>
	{}

}
