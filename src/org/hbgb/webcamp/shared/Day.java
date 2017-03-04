package org.hbgb.webcamp.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hbgb.webcamp.shared.enums.DayOfEvent;

@SuppressWarnings("serial")
public class Day implements Serializable
{
	private DayOfEvent today;
	
	private Meal breakfast;
	private Meal lunch;
	private Meal dinner;
	private String restrictions;
	
	
	public Day()
	{
		
	}
	
	public Day(DayOfEvent date)
	{
		today = date;
		
		breakfast = new Meal("breakfast");
		lunch = new Meal("lunch");
		dinner = new Meal("dinner");
		
		restrictions = "[";
	}
	
	
	public void addMealInfo(MealsInfo mealsInfo)
	{
		if( today == mealsInfo.getArrivalDate() )
		{
			addAsBeginning(mealsInfo);
		}
		else if( today == mealsInfo.getDepartureDate() )
		{
			addAsEnd(mealsInfo);
		}
		else if(dateIsInTheMiddle(today, 
				                  mealsInfo.getArrivalDate(), 
								  mealsInfo.getDepartureDate()) )
		{
			addAsMiddle( mealsInfo);
		}
	}
	
	
	
	public void addDietaryRestriction(String value)
	{
		if(!value.isEmpty())
		{
			restrictions = restrictions + value + "]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[" ;
		}
	}
	
	public String getRestrictions()
	{
		return restrictions;
	}
	
	public void setRestrictions(String value)
	{
		this.restrictions = value;
	}
	
	public void setBreakfast(Meal b)
	{
		this.breakfast = b;
	}
	
	public Meal getBreakfast()
	{
		return breakfast;
	}
	
	public DayOfEvent getToday()
	{
		return today;
	}

	public void setToday(DayOfEvent today)
	{
		this.today = today;
	}

	public Meal getLunch()
	{
		return lunch;
	}

	public void setLunch(Meal lunch)
	{
		this.lunch = lunch;
	}

	public Meal getDinner()
	{
		return dinner;
	}

	public void setDinner(Meal dinner)
	{
		this.dinner = dinner;
	}

	
	public List<Meal> getMeals()
	{
		List<Meal> list = new ArrayList<Meal>();
		list.add(breakfast);
		list.add(lunch);
		list.add(dinner);
		
		return list;
	}
	
	
	private void addAsBeginning(MealsInfo mealsInfo)
	{
		switch(mealsInfo.getArrivalTime())
		{
			case before_breakfast:
				breakfast.incrementValueForDietType(mealsInfo.getDietType(), mealsInfo.getIsGlutenFree());
				
			case before_lunch:
				lunch.incrementValueForDietType(mealsInfo.getDietType(), mealsInfo.getIsGlutenFree());
				
			case before_dinner:
				dinner.incrementValueForDietType(mealsInfo.getDietType(), mealsInfo.getIsGlutenFree());
				this.addDietaryRestriction(mealsInfo.getDietaryRestrictions());
				
			case after_dinner:
				break;
				
			default:
				break;
		}
	}
	
	private void addAsEnd(MealsInfo mealsInfo)
	{
		switch(mealsInfo.getDepartureTime())
		{
			case after_dinner:
				dinner.incrementValueForDietType(mealsInfo.getDietType(), mealsInfo.getIsGlutenFree());
				
			case before_dinner:
				lunch.incrementValueForDietType(mealsInfo.getDietType(), mealsInfo.getIsGlutenFree());
				
			case before_lunch:
				breakfast.incrementValueForDietType(mealsInfo.getDietType(), mealsInfo.getIsGlutenFree());
				this.addDietaryRestriction(mealsInfo.getDietaryRestrictions());
				
			case before_breakfast:
				break;
			
			default:
				break;
		}
	}
	
	private void addAsMiddle(MealsInfo mealsInfo)
	{
		Boolean gFree = false;
		
		if(null != mealsInfo.getIsGlutenFree())
		{
			gFree = mealsInfo.getIsGlutenFree();
		}
		
		breakfast.incrementValueForDietType(mealsInfo.getDietType(), gFree);
		lunch.incrementValueForDietType(mealsInfo.getDietType(), gFree);
		dinner.incrementValueForDietType(mealsInfo.getDietType(), gFree);
	
		this.addDietaryRestriction(mealsInfo.getDietaryRestrictions());
	}
	
	private Boolean dateIsInTheMiddle(DayOfEvent date, DayOfEvent begin, DayOfEvent end)
	{
		return ( begin.ordinal() < date.ordinal() ) &&
				( end.ordinal() > date.ordinal() );
	}
	
	
}
