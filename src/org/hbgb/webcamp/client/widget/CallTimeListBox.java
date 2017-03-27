/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.Composite com.google.gwt.user.client.ui.ListBox
 * com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.widget;

import org.hbgb.webcamp.shared.enums.CallTime;

public class CallTimeListBox extends EnumListBox<CallTime>
{
	public CallTimeListBox()
	{
		super(CallTime.class);
	}

	@Override
	public CallTime getSelectedEnumValue()
	{
		CallTime ct = null;

		String temp = getSelectedItemText();
		ct = CallTime.reverseLookup(temp);

		return ct;
	}
}
