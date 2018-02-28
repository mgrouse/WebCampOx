/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.Composite com.google.gwt.user.client.ui.ListBox
 * com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.widget;

import java.util.Date;

import org.hbgb.webcamp.shared.Utils;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class BirthDateWidget extends Composite
{
	private static final int NUM_YEARS = 100;
	private static UiBinder<Widget, BirthDateWidget> binder = GWT
			.create(BirthDateWidgetBinder.class);
	@UiField
	ListBox month;
	@UiField
	ListBox day;
	@UiField
	ListBox year;

	public BirthDateWidget()
	{
		this.initWidget(binder.createAndBindUi(this));
		this.fillMonth();
		this.fillDay();
		this.fillYear();
	}

	private void fillYear()
	{
		this.year.addItem("Choose One", "0");
		Integer startYear = Utils.getThisYearInt() - 100;
		Integer i = 100;
		while (i >= 0)
		{
			this.year.addItem(new Integer(startYear + i).toString());
			i = i - 1;
		}
	}

	private void fillDay()
	{
		this.day.addItem("Choose One", "0");
		Integer i = 1;
		while (i <= 31)
		{
			this.day.addItem(i.toString());
			i = i + 1;
		}
	}

	private void fillMonth()
	{
		this.month.addItem("Choose One", "0");
		this.month.addItem("January", "1");
		this.month.addItem("February", "2");
		this.month.addItem("March", "3");
		this.month.addItem("April", "4");
		this.month.addItem("May", "5");
		this.month.addItem("June", "6");
		this.month.addItem("July", "7");
		this.month.addItem("August", "8");
		this.month.addItem("September", "9");
		this.month.addItem("October", "10");
		this.month.addItem("November", "11");
		this.month.addItem("December", "12");
	}

	private Integer getDayAsInt()
	{
		return this.day.getSelectedIndex();
	}

	private Integer getMonthAsInt()
	{
		return this.month.getSelectedIndex();
	}

	private Integer getYearAsInt()
	{
		String yearStr = this.year.getValue(this.year.getSelectedIndex());
		return Integer.decode(yearStr) - 1900;
	}

	private void setDay(Integer value)
	{
		this.day.setSelectedIndex(value.intValue());
	}

	private void setMonth(Integer value)
	{
		this.month.setSelectedIndex(value.intValue());
	}

	private void setYear(Integer value)
	{
		if (value == 0)
		{
			this.year.setSelectedIndex(0);
			return;
		}
		Integer yearInt = value + 1900;
		this.year.setSelectedIndex(Utils.getThisYearInt() - yearInt + 1);
	}

	public void setSelectedValue(Date value)
	{
		if (value != null)
		{
			this.setDay(value.getDate());
			this.setMonth(value.getMonth() + 1);
			this.setYear(value.getYear());
			return;
		}
		this.setDay(0);
		this.setMonth(0);
		this.setYear(0);
	}

	public Date getSelectedValue()
	{
		Date retVal = null;
		if (this.getDayAsInt() == 0)
			return retVal;
		if (this.getMonthAsInt() == 0)
			return retVal;
		if (this.getYearAsInt() == 0)
			return retVal;
		retVal = new Date();
		retVal.setDate(this.getDayAsInt());
		retVal.setMonth(this.getMonthAsInt() - 1);
		retVal.setYear(this.getYearAsInt());
		return retVal;
	}

	@UiTemplate(value = "BirthDateWidget.ui.xml")
	static interface BirthDateWidgetBinder extends UiBinder<Widget, BirthDateWidget>
	{}

}
