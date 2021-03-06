/*
 * This is an unpublished work protected by the United States copyright laws and
 * is proprietary to Michael A. Grouse. Disclosure, copying, reproduction,
 * merger translation, modification, enhancement or use by anyone other than
 * authorized employees or licensees of Michael A. Grouse without prior written
 * consent of Michael A. Grouse is prohibited.
 *
 * Copyright (C) 1992 - 2017 Michael A. Grouse, All Rights Reserved.
 *
 * This copyright notice should not be construed as evidence of publication.
 */
package org.hbgb.webcamp.client.presenter.application;

import org.hbgb.webcamp.client.model.ApplicationTableModel;
import org.hbgb.webcamp.client.presenter.IModelPresenter;
import org.hbgb.webcamp.client.view.admin.ApplicationListTableView;
import org.hbgb.webcamp.client.view.admin.ApplicationListTableViewImpl;
import org.hbgb.webcamp.shared.ApplicationRow;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.view.client.ListDataProvider;

/**
 * @author Michael
 *
 */
public class ApplicationListFancyPresenter
		implements IModelPresenter, ApplicationListTableView.Presenter
{

	private ApplicationTableModel model;
	private ApplicationListTableView view;

	private ListDataProvider<ApplicationRow> dataProvider;

	private final HandlerManager eventBus;
	private HasWidgets screen;

	public ApplicationListFancyPresenter(HandlerManager bus)
	{
		eventBus = bus;

		model = new ApplicationTableModel();
		model.setPresenter(this);

	}

	@Override
	public void setScreen(HasWidgets container)
	{
		screen = container;
	}

	@Override
	public void go()
	{
		// view.clear();

		model.fetch();
	}

	@Override
	public void onFetchComplete()
	{
		dataProvider = new ListDataProvider<>(model.getData(), ApplicationRow.KEY_PROVIDER);

		view = new ApplicationListTableViewImpl(dataProvider);
		view.setPresenter(this);
		view.clear();
		view.setRowData(dataProvider);

		screen.add(view.asWidget());
	}

	@Override
	public void onPutComplete()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onRowSelect()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onRowEdit()
	{
		// can send new data to database here
		// wait?
		dataProvider.refresh();
	}

}
