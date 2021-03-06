/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.ui.HasWidgets com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.report;

import org.hbgb.webcamp.client.model.IMealsReportModel;
import org.hbgb.webcamp.client.model.MealsReportModel;
import org.hbgb.webcamp.client.presenter.IReportPresenter;
import org.hbgb.webcamp.client.view.report.IMealsReportView;
import org.hbgb.webcamp.client.view.report.MealsReportViewImpl;

import com.google.gwt.user.client.ui.HasWidgets;

public class MealsReportPresenter implements IReportPresenter
{
	IMealsReportModel model = new MealsReportModel();
	IMealsReportView view;
	HasWidgets screen;

	public MealsReportPresenter()
	{
		model.setPresenter(this);
		view = new MealsReportViewImpl();
		view.setPresenter(this);
	}

	@Override
	public void setScreen(HasWidgets container)
	{
		screen = container;
		screen.clear();
		view.clear();
		screen.add(view.asWidget());
	}

	@Override
	public void report()
	{
		model.fetchData();
	}

	@Override
	public void onDataFetched()
	{
		view.setReportData(model.getReportData());
	}
}
