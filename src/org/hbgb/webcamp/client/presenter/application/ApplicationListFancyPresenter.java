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

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * @author Michael
 *
 */
public class ApplicationListFancyPresenter implements IModelPresenter
{

	private ApplicationTableModel appTableModel;
	private ApplicationListTableView view = new ApplicationListTableViewImpl();

	private final HandlerManager eventBus;
	private HasWidgets screen;

	public ApplicationListFancyPresenter(HandlerManager bus)
	{
		eventBus = bus;
	}

	@Override
	public void setScreen(HasWidgets container)
	{
		screen = container;
	}

	@Override
	public void go()
	{
		view.clear();
		// model.fetch();
	}

	@Override
	public void onFetchComplete()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onPutComplete()
	{
		// TODO Auto-generated method stub

	}

}
