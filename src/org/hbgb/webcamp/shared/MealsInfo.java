package org.hbgb.webcamp.shared;

import java.io.Serializable;

import org.hbgb.webcamp.shared.enums.DayOfEvent;
import org.hbgb.webcamp.shared.enums.DietType;
import org.hbgb.webcamp.shared.enums.PlayaTime;

@SuppressWarnings("serial")
public class MealsInfo implements Serializable
{
	private String fullName = "";

	private DayOfEvent arrivalDate;

	private PlayaTime arrivalTime = PlayaTime.before_dinner;

	private DayOfEvent departureDate;

	private PlayaTime departureTime = PlayaTime.before_dinner;

	private DietType dietType = DietType.Omnivore;

	private Boolean isGlutenFree = false;

	private String dietaryRestrictions = "";

	public String getFullName()
	{
		return fullName;
	}

	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	public DayOfEvent getArrivalDate()
	{
		return arrivalDate;
	}

	public void setArrivalDate(DayOfEvent arrivalDate)
	{
		this.arrivalDate = arrivalDate;
	}

	public DayOfEvent getDepartureDate()
	{
		return departureDate;
	}

	public void setDepartureDate(DayOfEvent departureDate)
	{
		this.departureDate = departureDate;
	}

	public Boolean getIsGlutenFree()
	{
		return isGlutenFree;
	}

	public void setIsGlutenFree(Boolean glutenFree)
	{
		this.isGlutenFree = glutenFree;
	}

	public PlayaTime getArrivalTime()
	{
		return arrivalTime;
	}

	public void setArrivalTime(PlayaTime arrivalTime)
	{
		this.arrivalTime = arrivalTime;
	}

	public PlayaTime getDepartureTime()
	{
		return departureTime;
	}

	public void setDepartureTime(PlayaTime departureTime)
	{
		this.departureTime = departureTime;
	}

	public DietType getDietType()
	{
		return dietType;
	}

	public void setDietType(DietType dietType)
	{
		this.dietType = dietType;
	}

	public String getDietaryRestrictions()
	{
		return dietaryRestrictions;
	}

	public void setDietaryRestrictions(String dietaryRestrictions)
	{
		this.dietaryRestrictions = dietaryRestrictions;
	}
}
