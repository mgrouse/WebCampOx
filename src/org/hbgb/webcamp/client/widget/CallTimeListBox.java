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

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class CallTimeListBox extends Composite
{
	private static UiBinder<Widget, CallTimeListBox> binder = (UiBinder) GWT
			.create((Class) CallTimeListBoxBinder.class);
	@UiField
	ListBox list;

	CallTimeListBox()
	{
		this.initWidget(binder.createAndBindUi(this));
		this.list.addItem("Choose One", "Choose One");
		this.list.addItem(" 9:00 am - 12:00 pm", CallTime.Nine_Twelve.toString());
		this.list.addItem("12:00 pm -  3:00 pm", CallTime.Twelve_Three.toString());
		this.list.addItem(" 3:00 pm -  6:00 pm", CallTime.Three_Six.toString());
		this.list.addItem(" 6:00 pm -  9:00 pm", CallTime.Six_Nine.toString());
	}

	public void setSelectedValue(CallTime value)
	{
		if (value == null)
		{
			this.list.setSelectedIndex(0);
			return;
		}
		String valstr = value.toString();
		int i = 1;
		while (i < this.list.getItemCount())
		{
			if (this.list.getValue(i).equals(valstr))
			{
				this.list.setSelectedIndex(i);
				return;
			}
			++i;
		}
	}

	public CallTime getSelectedValue()
	{
		int selidx = this.list.getSelectedIndex();
		if (selidx == 0)
		{
			return null;
		}
		CallTime callTime = (CallTime) (Enum.valueOf(CallTime.class, this.list.getValue(selidx)));
		return callTime;
	}

	@UiTemplate(value = "CallTimeListBox.ui.xml")
	static interface CallTimeListBoxBinder extends UiBinder<Widget, CallTimeListBox>
	{
	}

}
