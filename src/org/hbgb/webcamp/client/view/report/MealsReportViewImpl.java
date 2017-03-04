/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.Composite
 * com.google.gwt.user.client.ui.FlexTable
 * com.google.gwt.user.client.ui.FlexTable$FlexCellFormatter
 * com.google.gwt.user.client.ui.HTML com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.report;

import org.hbgb.webcamp.client.presenter.IReportPresenter;
import org.hbgb.webcamp.shared.Day;
import org.hbgb.webcamp.shared.Meal;
import org.hbgb.webcamp.shared.MealsReport;
import org.hbgb.webcamp.shared.Week;
import org.hbgb.webcamp.shared.enums.DietType;
import org.hbgb.webcamp.shared.enums.SecurityRole;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class MealsReportViewImpl extends Composite implements IMealsReportView
{
	private static UiBinder<Widget, MealsReportViewImpl> binder =  GWT
			.create( MealsReportViewImplBinder.class);
	@UiField
	FlexTable table;
	IReportPresenter presenter;

	public MealsReportViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
		this.table.setBorderWidth(1);
		this.table.setCellPadding(5);
	}

	@Override
	public void setPresenter(IReportPresenter p)
	{
		this.presenter = p;
	}

	@Override
	public void setReportData(MealsReport report)
	{
		this.table.removeAllRows();
		this.formatAWeek(report.getEarlyWeek());
		this.formatAWeek(report.getBurnWeek());
	}

	private void formatAWeek(Week week)
	{
		FlexTable.FlexCellFormatter formatter = this.table.getFlexCellFormatter();
		int i = this.table.getRowCount();
		this.table.setWidget(i, 0, new HTML(week.getName()));
		formatter.setColSpan(i, 0, 9);
		this.table.setWidget(++i, 0, new HTML("Date"));
		this.table.setWidget(i, 1, new HTML("Meal"));
		this.table.setWidget(i, 2, new HTML("Omnivore"));
		this.table.setWidget(i, 3, new HTML("Vegetarian"));
		this.table.setWidget(i, 4, new HTML("Vegan  "));
		this.table.setWidget(i, 5, new HTML("Total  "));
		this.table.setWidget(i, 6, new HTML("Gluten Free"));
		this.table.setWidget(i, 7, new HTML("Restrictions"));
		for (Day day : week.getDays())
		{
			this.formatADay(day);
		}
	}

	private void formatADay(Day day)
	{
		FlexTable.FlexCellFormatter formatter = this.table.getFlexCellFormatter();
		int i = this.table.getRowCount();
		this.formatAMeal(day.getBreakfast(), 1);
		this.formatAMeal(day.getLunch(), 0);
		this.formatAMeal(day.getDinner(), 0);
		this.table.setWidget(i, 0, new HTML(day.getToday().toString()));
		formatter.setRowSpan(i, 0, 3);
		this.table.setWidget(i, DietType.values().length + 4, new HTML(day.getRestrictions()));
		formatter.setRowSpan(i, DietType.values().length + 4, 3);
	}

	private void formatAMeal(Meal meal, int j)
	{
		int i = this.table.getRowCount();
		Integer sum = 0;
		this.table.setWidget(i, j, new HTML(meal.getName()));
		int[] arrn = meal.getDietNumbers();
		int n = arrn.length;
		int n2 = 0;
		while (n2 < n)
		{
			Integer num = arrn[n2];
			sum = sum + num;
			this.table.setWidget(i, ++j, new HTML(num.toString()));
			++n2;
		}
		this.table.setWidget(i, ++j, new HTML(sum.toString()));
		Integer temp = meal.getGlutenFreeNum();
		this.table.setWidget(i, ++j, new HTML(temp.toString()));
	}

	@Override
	public void clear()
	{
	}

	@Override
	public void setVisibility(SecurityRole role)
	{
	}

	@UiTemplate(value = "MealsReportView.ui.xml")
	static interface MealsReportViewImplBinder extends UiBinder<Widget, MealsReportViewImpl>
	{
	}

}
