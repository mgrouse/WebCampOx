/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.event.shared.GwtEvent
 * com.google.gwt.event.shared.HandlerManager com.google.gwt.user.client.Window
 * com.google.gwt.user.client.rpc.AsyncCallback
 * com.google.gwt.user.client.ui.HasWidgets com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.admin;

import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.async.HbgbAppUserServiceAsync;
import org.hbgb.webcamp.client.event.user.ListUserEvent;
import org.hbgb.webcamp.client.presenter.IKeyedModelPresenter;
import org.hbgb.webcamp.client.presenter.IPresenter;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.admin.IUserEditView;
import org.hbgb.webcamp.shared.HbgbUser;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class UserEditPresenter implements IPresenter, IKeyedModelPresenter, IUserEditView.Presenter
{
	private final HbgbAppUserServiceAsync rpcService = AsyncServiceFinder.getHbgbUserService();
	private final HandlerManager eventBus;
	private final IUserEditView view;
	private String key;
	private HbgbUser hbgbUser;
	private HasWidgets screen;

	public UserEditPresenter(HandlerManager eventBus, String key)
	{
		this.eventBus = eventBus;
		this.key = key;
		this.hbgbUser = new HbgbUser();
		this.view = ViewFinder.getEditUserView();
		this.view.clear();
		this.view.setPresenter(this);
	}

	@Override
	public void setKey(String key)
	{
		this.key = key;
		this.view.clear();
	}

	@Override
	public void setScreen(HasWidgets container)
	{
		this.screen = container;
	}

	@Override
	public void go()
	{
		this.hbgbUser = new HbgbUser();
		this.fetchUserDetail();
	}

	private void setView()
	{
		this.view.setFirstNameText(this.hbgbUser.getFirstName());
		this.view.setLastNameText(this.hbgbUser.getLastName());
		this.view.setPlayaNameText(this.hbgbUser.getPlayaName());
		this.view.setIsEarlyTeam(this.hbgbUser.getIsEarlyTeam());
		this.view.setEmailText(this.hbgbUser.getEmailAddress());
		this.view.setPasswordText("********");
		this.view.setSecurityRole(this.hbgbUser.getSecurityRole());
	}

	private void setModel()
	{
		this.hbgbUser.setFirstName(this.view.getFirstNameText());
		this.hbgbUser.setLastName(this.view.getLastNameText());
		this.hbgbUser.setPlayaName(this.view.getPlayaNameText());
		this.hbgbUser.setIsEarlyTeam(this.view.getIsEarlyTeam());
		this.hbgbUser.setEmailAddress(this.view.getEmailText());
		this.hbgbUser.setPassword(this.view.getPasswordText());
		this.hbgbUser.setSecurityRole(this.view.getSecurityRole());
	}

	private void fetchUserDetail()
	{
		if (this.key != null)
		{
			this.rpcService.getHbgbUser(this.key, new AsyncCallback<HbgbUser>()
			{

				@Override
				public void onSuccess(HbgbUser result)
				{
					UserEditPresenter.access$0(UserEditPresenter.this, result);
					UserEditPresenter.this.setView();
				}

				@Override
				public void onFailure(Throwable caught)
				{
					Window.alert("Error retrieving user");
				}
			});
		}
		this.screen.clear();
		this.screen.add(this.view.asWidget());
	}

	@Override
	public void onSaveButtonClicked()
	{
		this.setModel();
		if (this.key == null)
		{
			this.addUser();
			return;
		}
		this.updateUser();
	}

	private void addUser()
	{
		this.rpcService.addHbgbUser(this.hbgbUser, new AsyncCallback<HbgbUser>()
		{

			@Override
			public void onSuccess(HbgbUser user)
			{
				if (user == null)
					return;
				Window.alert("User updated");
				UserEditPresenter.this.eventBus.fireEvent(new ListUserEvent());
			}

			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("Error updating User");
				UserEditPresenter.this.eventBus.fireEvent(new ListUserEvent());
			}
		});
	}

	private void updateUser()
	{
		this.rpcService.updateHbgbUser(this.hbgbUser, new AsyncCallback<Boolean>()
		{

			@Override
			public void onSuccess(Boolean saved)
			{
				if (saved == false)
					return;
				Window.alert("User updated.");
				UserEditPresenter.this.eventBus.fireEvent(new ListUserEvent());
			}

			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("Error updating User");
				UserEditPresenter.this.eventBus.fireEvent(new ListUserEvent());
			}
		});
	}

	@Override
	public void onCancelButtonClicked()
	{
		this.eventBus.fireEvent(new ListUserEvent());
	}

	@Override
	public void onDataFetched()
	{}

	@Override
	public void onDataPut()
	{}

	static /* synthetic */ void access$0(UserEditPresenter userEditPresenter, HbgbUser hbgbUser)
	{
		userEditPresenter.hbgbUser = hbgbUser;
	}

}
