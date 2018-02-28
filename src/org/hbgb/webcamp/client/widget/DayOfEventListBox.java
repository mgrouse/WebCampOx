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

import org.hbgb.webcamp.shared.enums.DayOfEvent;

public class DayOfEventListBox extends EnumListBox<DayOfEvent>
{

	public DayOfEventListBox()
	{
		super(DayOfEvent.class);

	}

	@Override
	public DayOfEvent getSelectedEnumValue()
	{
		DayOfEvent doe = null;

		String temp = getSelectedItemText();
		doe = DayOfEvent.reverseLookup(temp);

		return doe;
	}

	public void removeETDates()
	{
		for (int i = 0; i < 8; ++i)
		{
			// [0:Choose]
			removeItem(1);
		}
	}

	public void leaveOnlyStarManDates()
	{
		while (getItemCount() > 3)
		{
			// [0:Choose, 1:Starman Sat, 2:Starman Sun]
			removeItem(3);
		}
	}

	public void leaveOnlyStrikeDates()
	{
		while (getItemCount() > 3)
		{
			removeItem(1);
		}

	}

}
