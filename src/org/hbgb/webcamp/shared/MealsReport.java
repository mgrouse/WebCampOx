package org.hbgb.webcamp.shared;

import java.io.Serializable;
import java.util.ArrayList;

import org.hbgb.webcamp.shared.enums.DayOfEvent;

@SuppressWarnings("serial")
public class MealsReport implements Serializable
{
	Week earlyWeek;
	Week burnWeek;
	ArrayList<String> badList;

	public MealsReport()
	{
		earlyWeek = new Week("Early Week", DayOfEvent.StarMan_Saturday, DayOfEvent.Early_Sunday);
		burnWeek = new Week("Burn Week", DayOfEvent.Burn_Monday, DayOfEvent.Exodus_Monday);
		badList = new ArrayList<>();
	}

	public void addMealsInfo(MealsInfo mealsInfo)
	{
		if (Verify(mealsInfo))
		{
			earlyWeek.addMealsInfo(mealsInfo);
			burnWeek.addMealsInfo(mealsInfo);
		}
	}

	private boolean Verify(MealsInfo mealsInfo)
	{
		boolean retVal = true;

		if (mealsInfo.getArrivalDate() == null || mealsInfo.getArrivalTime() == null
				|| mealsInfo.getDepartureDate() == null || mealsInfo.getDepartureTime() == null
				|| mealsInfo.getDietType() == null || mealsInfo.getIsGlutenFree() == null)
		{
			badList.add(mealsInfo.getFullName());
			retVal = false;
		}

		return retVal;
	}

	public Week getEarlyWeek()
	{
		return earlyWeek;
	}

	public Week getBurnWeek()
	{
		return burnWeek;
	}

	public ArrayList<String> getBadList()
	{
		return badList;
	}
}
