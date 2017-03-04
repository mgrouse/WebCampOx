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

import org.hbgb.webcamp.shared.enums.SecurityRole;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class SecurityRoleListBox extends Composite
{
	private static UiBinder<Widget, SecurityRoleListBox> binder =  GWT
			.create( SecurityRoleListBoxBinder.class);
	@UiField
	EnumListBox<SecurityRole> list;

	SecurityRoleListBox()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	public void setSelectedValue(SecurityRole value)
	{
		this.list.setSelectedValue(value);
	}

	public SecurityRole getSelectedValue()
	{
		return this.list.getSelectedEnumValue();
	}

	@UiFactory
	EnumListBox<SecurityRole> listBoxFactory()
	{
		return new EnumListBox<>(SecurityRole.class);
	}

	@UiTemplate(value = "SecurityRoleListBox.ui.xml")
	static interface SecurityRoleListBoxBinder extends UiBinder<Widget, SecurityRoleListBox>
	{
	}

}
