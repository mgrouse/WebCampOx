package org.hbgb.webcamp.shared;

import java.io.Serializable;

import org.hbgb.webcamp.shared.enums.DietType;

@SuppressWarnings("serial")
public class Meal implements Serializable
{
	private String name;

	private int[] dietNumbers = new int[DietType.values().length];

	private int glutenFreeNum = 0;

	public Meal()
	{
		new Meal("");
	}

	public Meal(String name)
	{
		this.name = name;
	}

	public void incrementValueForDietType(DietType dt, boolean gFree)
	{
		dietNumbers[dt.ordinal()] += 1;

		if (gFree)
		{
			glutenFreeNum += 1;
		}
	}

	// public void setValueForDietType(DietType dt, int value)
	// {
	//
	// }

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public int[] getDietNumbers()
	{
		return dietNumbers;
	}

	public void setDietNumbers(int[] dietNumbers)
	{
		this.dietNumbers = dietNumbers;
	}

	public int getGlutenFreeNum()
	{
		return glutenFreeNum;
	}

	public void setGlutenFreeNum(int glutenFreeNum)
	{
		this.glutenFreeNum = glutenFreeNum;
	}

}
