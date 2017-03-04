package org.hbgb.webcamp.shared;

import java.io.Serializable;

import org.hbgb.webcamp.shared.enums.DayOfEvent;

@SuppressWarnings("serial")
public class MealsReport implements Serializable
{
	Week earlyWeek;
	Week burnWeek;

	public MealsReport()
	{
		earlyWeek = new Week("Early Week", DayOfEvent.StarMan_Saturday, DayOfEvent.Early_Sunday);
		burnWeek = new Week("Burn Week", DayOfEvent.Burn_Monday, DayOfEvent.Exodus_Monday);
	}

	public void addMealsInfo(MealsInfo mealsInfo)
	{
		earlyWeek.addMealsInfo(mealsInfo);
		burnWeek.addMealsInfo(mealsInfo);
	}

	public Week getEarlyWeek()
	{
		return earlyWeek;
	}

	public Week getBurnWeek()
	{
		return burnWeek;
	}

}
