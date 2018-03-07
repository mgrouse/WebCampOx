
package org.hbgb.webcamp.shared.enums;

public enum Transportation
{
	Drive("driving a vehicle"),
	Ride_Sharing("riding in someone else's vehicle"),
	Burner_Express("taking the Burner Express"),
	Fly("flying into BRC airport"),
	Dont_Know("I don't know yet");

	private String display;

	private static Transportation[] values = new Transportation[] { Drive, Ride_Sharing,
			Burner_Express, Fly, Dont_Know };

	private Transportation(String name)
	{
		display = name;
	}

	@Override
	public String toString()
	{
		return display;
	}

	public static Transportation reverseLookup(String name)
	{
		Transportation retVal = null;
		for (Transportation t : values)
		{
			if (t.toString().equals(name))
			{
				retVal = t;
				break;
			}
		}
		return retVal;
	}

}
