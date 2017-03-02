/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.shared;

import java.io.Serializable;

import org.hbgb.webcamp.shared.enums.DayOfEvent;

@SuppressWarnings("serial")
public class MealsReport implements Serializable
{
	Week earlyWeek = new Week("Early Week", DayOfEvent.StarMan_Saturday, DayOfEvent.Early_Sunday);
	Week burnWeek = new Week("Burn Week", DayOfEvent.Burn_Monday, DayOfEvent.Exodus_Monday);

	public void addMealsInfo(MealsInfo mealsInfo)
	{
		this.earlyWeek.addMealsInfo(mealsInfo);
		this.burnWeek.addMealsInfo(mealsInfo);
	}

	public Week getEarlyWeek()
	{
		return this.earlyWeek;
	}

	public Week getBurnWeek()
	{
		return this.burnWeek;
	}
}
