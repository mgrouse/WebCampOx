/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.shared.enums;

public enum CallTime
{
	Nine_Twelve("9:00 am - 12:00 pm"), Twelve_Three("12:00 pm - 3:00 pm"), Three_Six("3:00 pm - 6:00 pm"), Six_Nine("6:00 pm - 9:00 pm");

	private String display;

	private CallTime(String name)
	{
		display = name;
	}

	@Override
	public String toString()
	{
		return display;
	}

	/**
	 * @param temp
	 * @return
	 */
	public static CallTime reverseLookup(String text)
	{
		CallTime retVal = null;

		for (CallTime ct : CallTime.values())
		{
			if (ct.toString().contentEquals(text))
			{
				retVal = ct;
				break;
			}
		}

		return retVal;
	}

}
