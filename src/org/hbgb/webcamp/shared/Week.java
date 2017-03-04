package org.hbgb.webcamp.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hbgb.webcamp.shared.enums.DayOfEvent;


@SuppressWarnings("serial")
public class Week implements Serializable
{
	private List<Day> days;

	private String name;
	
	
	public Week()
	{
		days = new ArrayList<Day>();
		name = "";
	}
	
	public Week(String name, DayOfEvent begin, DayOfEvent end)
	{
		this.name = name;
		days = new ArrayList<Day>();
		
		
		for(int i = begin.ordinal(); i <= end.ordinal(); ++i)
		{
			DayOfEvent dayOE = DayOfEvent.atIndex(i);
			
			Day day = new Day(dayOE);
			days.add(day);
		}
	}

	public void setDays(List<Day> list)
	{
		days.addAll(list);
	}
	
	public List<Day> getDays()
	{
		return days;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void addMealsInfo(MealsInfo mealsInfo)
	{
		for(Day day : days)
		{
			day.addMealInfo(mealsInfo);
		}
	}
	
	
}
