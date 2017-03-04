/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.event.shared.GwtEvent
 * com.google.gwt.event.shared.HandlerManager
 * com.google.gwt.user.client.ui.HasWidgets com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.admin;

import org.hbgb.webcamp.client.event.user.ListUserEvent;
import org.hbgb.webcamp.client.model.HbgbUserModel;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.admin.IEarlyTeamMemberView;
import org.hbgb.webcamp.shared.HbgbUser;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public class EarlyTeamMemberPresenter implements IEarlyTeamMemberPresenter
{
	private final HandlerManager eventBus;
	private final IEarlyTeamMemberView view;
	private String key;
	private HbgbUserModel model;
	private HasWidgets screen;

	public EarlyTeamMemberPresenter(HandlerManager eventBus, String key)
	{
		this.eventBus = eventBus;
		this.key = key;
		this.model = new HbgbUserModel();
		this.model.setPresenter(this);
		this.view = ViewFinder.getEarlyTeamMemberView();
		this.view.setPresenter(this);
		this.view.clear();
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
		if (this.key != null)
		{
			this.model.fetchData(this.key);
			return;
		}
		this.model = new HbgbUserModel();
		this.model.setPresenter(this);
		this.onDataFetched();
	}

	@Override
	public void onLookUpButtonClicked()
	{
		this.model.fetchDataByEmail(this.view.getEmailText());
	}

	@Override
	public void onSaveButtonClicked()
	{
		this.setModel();
		this.model.putData();
		this.eventBus.fireEvent(new ListUserEvent());
	}

	@Override
	public void onCancelButtonClicked()
	{
		this.eventBus.fireEvent(new ListUserEvent());
	}

	private void setView()
	{
		HbgbUser hbgbUser = this.model.getData();
		this.view.setEmailText(hbgbUser.getEmailAddress());
		this.view.setFirstNameText(hbgbUser.getFirstName());
		this.view.setLastNameText(hbgbUser.getLastName());
		this.view.setPlayaNameText(hbgbUser.getPlayaName());
	}

	private void setModel()
	{
		HbgbUser hbgbUser = new HbgbUser();
		hbgbUser.setFirstName(this.view.getFirstNameText());
		hbgbUser.setLastName(this.view.getLastNameText());
		hbgbUser.setPlayaName(this.view.getPlayaNameText());
		hbgbUser.setEmailAddress(this.view.getEmailText());
		hbgbUser.setIsEarlyTeam(true);
		this.model.setData(hbgbUser);
	}

	@Override
	public void onDataFetched()
	{
		this.setView();
		this.screen.clear();
		if (!this.model.getData().getIsEarlyTeam().booleanValue())
		{
			this.view.setSaveButtonEnabled(true);
		}
		this.screen.add(this.view.asWidget());
	}

	@Override
	public void onDataPut()
	{
		this.eventBus.fireEvent(new ListUserEvent());
	}
}
