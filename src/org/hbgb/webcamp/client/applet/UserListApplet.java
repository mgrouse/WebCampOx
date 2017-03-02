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
import org.hbgb.webcamp.client.presenter.admin.UserEditPresenter;
import org.hbgb.webcamp.client.presenter.admin.UserListPresenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public class UserListApplet implements IApplet
{
	private final HandlerManager eventBus = new HandlerManager((Object) null);
	private HasWidgets screen;
	private final UserListPresenter userListPresenter = new UserListPresenter(this.eventBus);
	private final UserEditPresenter editUserPresenter = new UserEditPresenter(this.eventBus, null);

	public UserListApplet()
	{
		this.registerEvents();
	}

	private void registerEvents()
	{
		this.eventBus.addHandler(AddUserEvent.TYPE, new AddUserEventHandler()
		{

			@Override
			public void onAddUser(AddUserEvent event)
			{
				UserListApplet.this.screen.clear();
				UserListApplet.this.editUserPresenter.setScreen(UserListApplet.this.screen);
				UserListApplet.this.editUserPresenter.setKey(null);
				UserListApplet.this.editUserPresenter.go();
			}
		});
		this.eventBus.addHandler(EditUserEvent.TYPE, new EditUserEventHandler()
		{

			@Override
			public void onEditUser(EditUserEvent event)
			{
				UserListApplet.this.screen.clear();
				UserListApplet.this.editUserPresenter.setScreen(UserListApplet.this.screen);
				UserListApplet.this.editUserPresenter.setKey(event.getKey());
				UserListApplet.this.editUserPresenter.go();
			}
		});
		this.eventBus.addHandler(ListUserEvent.TYPE, new ListUserEventHandler()
		{

			@Override
			public void onListUser(ListUserEvent event)
			{
				UserListApplet.this.screen.clear();
				UserListApplet.this.userListPresenter.go();
			}
		});
	}

	@Override
	public void run(HasWidgets container)
	{
		this.screen = container;
		this.userListPresenter.setScreen(container);
		this.userListPresenter.go();
	}

}
