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
package org.hbgb.webcamp.client.applet;

import org.hbgb.webcamp.client.event.application.EditApplicationEvent;
import org.hbgb.webcamp.client.event.application.EditApplicationEventHandler;
import org.hbgb.webcamp.client.event.application.ListApplicationEvent;
import org.hbgb.webcamp.client.event.application.ListApplicationEventHandler;
import org.hbgb.webcamp.client.presenter.application.ApplicationListFancyPresenter;
import org.hbgb.webcamp.client.presenter.application.EditWholeApplicationPresenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * @author Michael
 *
 */
public class ApplicationListFancyApplet implements IApplet
{
	private final HandlerManager eventBus = new HandlerManager(null);
	private HasWidgets screen;
	private final ApplicationListFancyPresenter applicationListPresenter = new ApplicationListFancyPresenter(
			eventBus);
	private final EditWholeApplicationPresenter editWholeApplicationPresenter = new EditWholeApplicationPresenter(
			eventBus);

	public ApplicationListFancyApplet()
	{
		registerEvents();
	}

	private void registerEvents()
	{
		eventBus.addHandler(EditApplicationEvent.TYPE, new EditApplicationEventHandler()
		{

			@Override
			public void onEditApplication(EditApplicationEvent event)
			{
				screen.clear();
				editWholeApplicationPresenter.setScreen(screen);
				editWholeApplicationPresenter.setKey(event.getKey());
				editWholeApplicationPresenter.setKeyList(event.getKeyList());
			}
		});
		eventBus.addHandler(ListApplicationEvent.TYPE, new ListApplicationEventHandler()
		{

			@Override
			public void onListApplication(ListApplicationEvent event)
			{
				screen.clear();
				applicationListPresenter.go();
			}
		});
	}

	@Override
	public void run(HasWidgets container)
	{
		screen = container;
		applicationListPresenter.setScreen(container);
		applicationListPresenter.go();
	}

}
