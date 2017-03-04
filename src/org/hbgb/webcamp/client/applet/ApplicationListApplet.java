/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.event.shared.EventHandler com.google.gwt.event.shared.GwtEvent
 * com.google.gwt.event.shared.GwtEvent$Type
 * com.google.gwt.event.shared.HandlerManager
 * com.google.gwt.event.shared.HandlerRegistration
 * com.google.gwt.user.client.ui.HasWidgets
 */
package org.hbgb.webcamp.client.applet;

import org.hbgb.webcamp.client.event.application.EditApplicationEvent;
import org.hbgb.webcamp.client.event.application.EditApplicationEventHandler;
import org.hbgb.webcamp.client.event.application.ListApplicationEvent;
import org.hbgb.webcamp.client.event.application.ListApplicationEventHandler;
import org.hbgb.webcamp.client.presenter.application.ApplicationListPresenter;
import org.hbgb.webcamp.client.presenter.application.EditWholeApplicationPresenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public class ApplicationListApplet implements IApplet
{
	private final HandlerManager eventBus = new HandlerManager((Object) null);
	private HasWidgets screen;
	private final ApplicationListPresenter applicationListPresenter = new ApplicationListPresenter(this.eventBus);
	private final EditWholeApplicationPresenter editWholeApplicationPresenter = new EditWholeApplicationPresenter(this.eventBus);

	public ApplicationListApplet()
	{
		this.registerEvents();
	}

	private void registerEvents()
	{
		this.eventBus.addHandler(EditApplicationEvent.TYPE, new EditApplicationEventHandler()
		{

			@Override
			public void onEditApplication(EditApplicationEvent event)
			{
				ApplicationListApplet.this.screen.clear();
				ApplicationListApplet.this.editWholeApplicationPresenter.setScreen(ApplicationListApplet.this.screen);
				ApplicationListApplet.this.editWholeApplicationPresenter.setKey(event.getKey());
				ApplicationListApplet.this.editWholeApplicationPresenter.setKeyList(event.getKeyList());
			}
		});
		this.eventBus.addHandler(ListApplicationEvent.TYPE, new ListApplicationEventHandler()
		{

			@Override
			public void onListApplication(ListApplicationEvent event)
			{
				ApplicationListApplet.this.screen.clear();
				ApplicationListApplet.this.applicationListPresenter.go();
			}
		});
	}

	@Override
	public void run(HasWidgets container)
	{
		this.screen = container;
		this.applicationListPresenter.setScreen(container);
		this.applicationListPresenter.go();
	}

}
