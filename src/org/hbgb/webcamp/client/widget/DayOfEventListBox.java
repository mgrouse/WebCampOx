
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

	public void loadEventDates()
	{
		loadElements(DayOfEvent.getEventDays());
	}

	public void loadETArrivalDates()
	{
		loadElements(DayOfEvent.getETArrivalDays());
	}

	public void lodeStrikeDates()
	{
		loadElements(DayOfEvent.getStrikeDepartureDays());
	}

}
