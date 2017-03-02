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

import org.hbgb.webcamp.client.event.user.AddUserEvent;
import org.hbgb.webcamp.client.event.user.AddUserEventHandler;
import org.hbgb.webcamp.client.event.user.EditUserEvent;
import org.hbgb.webcamp.client.event.user.EditUserEventHandler;
import org.hbgb.webcamp.client.event.user.ListUserEvent;
import org.hbgb.webcamp.client.event.user.ListUserEventHandler;
import org.hbgb.webcamp.client.presenter.admin.EarlyTeamListPresenter;
import org.hbgb.webcamp.client.presenter.admin.EarlyTeamMemberPresenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public class EarlyTeamListApplet implements IApplet
{
	private final HandlerManager eventBus = new HandlerManager(null);
	private HasWidgets screen;
	private final EarlyTeamListPresenter etListPresenter = new EarlyTeamListPresenter(eventBus);
	private final EarlyTeamMemberPresenter etEditPresenter = new EarlyTeamMemberPresenter(eventBus,
			null);

	public EarlyTeamListApplet()
	{
		registerEvents();
	}

	private void registerEvents()
	{
		eventBus.addHandler(AddUserEvent.TYPE, new AddUserEventHandler()
		{

			@Override
			public void onAddUser(AddUserEvent event)
			{
				screen.clear();
				etEditPresenter.setScreen(screen);
				etEditPresenter.setKey(null);
				etEditPresenter.go();
			}
		});
		eventBus.addHandler(EditUserEvent.TYPE, new EditUserEventHandler()
		{

			@Override
			public void onEditUser(EditUserEvent event)
			{
				screen.clear();
				etEditPresenter.setScreen(screen);
				etEditPresenter.setKey(event.getKey());
				etEditPresenter.go();
			}
		});
		eventBus.addHandler(ListUserEvent.TYPE, new ListUserEventHandler()
		{

			@Override
			public void onListUser(ListUserEvent event)
			{
				screen.clear();
				etListPresenter.go();
			}
		});
	}

	@Override
	public void run(HasWidgets container)
	{
		screen = container;
		etListPresenter.setScreen(container);
		etListPresenter.go();
	}

}
