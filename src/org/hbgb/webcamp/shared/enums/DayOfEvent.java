/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.shared.enums;

public enum DayOfEvent
{
	//
	// TODO put code here to look up the first Monday in Sept
	// and count from there to put the M/DD at end of Strings
	//

	StarMan_Saturday("StarMan's Saturday 8/18"), StarMan_Sunday("StarMan's Sunday 8/19"),

	Early_Monday("Early Team Monday 8/20"), Early_Tuesday(
			"Early Team Tuesday 8/21"), Early_Wednesday(
					"Early Team Wednesday 8/22"), Early_Thursday(
							"Early Team Thursday 8/23"), Early_Friday(
									"Early Team Friday 8/24"), Early_Saturday(
											"Early Team Saturday 8/25"),

	Early_Sunday("Gate Opens Sunday 8/26"), Burn_Monday("Burn Monday 8/27"), Burn_Tuesday(
			"Burn Tuesday 8/28"), Burn_Wednesday("Burn Wednesday 8/29"), Burn_Thursday(
					"Burn Thursday 8/30"), Burn_Friday("Burn Friday 8/31"), Burn_Saturday(
							"Burn Saturday 9/1"), Burn_Sunday("Burn Sunday 9/2"),

	Exodus_Monday("Exodus Monday 9/3"), Exodus_Tuesday("Exodus Tuesday 9/4");

	private String display;

	private static DayOfEvent[] val = new DayOfEvent[] { StarMan_Saturday, StarMan_Sunday,
			Early_Monday, Early_Tuesday, Early_Wednesday, Early_Thursday, Early_Friday,
			Early_Saturday, Early_Sunday, Burn_Monday, Burn_Tuesday, Burn_Wednesday, Burn_Thursday,
			Burn_Friday, Burn_Saturday, Burn_Sunday, Exodus_Monday, Exodus_Tuesday };

	private DayOfEvent(String name)
	{
		display = name;
	}

	@Override
	public String toString()
	{
		return display;
	}

	public static DayOfEvent atIndex(int i)
	{
		return val[i];
	}

	public static DayOfEvent reverseLookup(String name)
	{
		DayOfEvent retVal = null;
		for (DayOfEvent day : val)
		{
			if (day.toString().equals(name))
			{
				retVal = day;
				break;
			}
		}
		return retVal;
	}
}
