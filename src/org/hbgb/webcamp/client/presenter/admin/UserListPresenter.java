/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.event.shared.GwtEvent
 * com.google.gwt.event.shared.HandlerManager com.google.gwt.user.client.Window
 * com.google.gwt.user.client.rpc.AsyncCallback
 * com.google.gwt.user.client.ui.HasWidgets com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.admin;

import java.util.ArrayList;
import java.util.List;

import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.async.HbgbAppUserServiceAsync;
import org.hbgb.webcamp.client.common.SelectionModel;
import org.hbgb.webcamp.client.common.UserColumnDefinitionsFactory;
import org.hbgb.webcamp.client.event.user.AddUserEvent;
import org.hbgb.webcamp.client.event.user.EditUserEvent;
import org.hbgb.webcamp.client.presenter.IPresenter;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.admin.UserListView;
import org.hbgb.webcamp.shared.HbgbUserDetails;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class UserListPresenter implements IPresenter, UserListView.Presenter<HbgbUserDetails>
{
	private List<HbgbUserDetails> hbgbUserDetails;
	protected final HbgbAppUserServiceAsync rpcService = AsyncServiceFinder.getHbgbUserService();
	private final HandlerManager eventBus;
	private final UserListView<HbgbUserDetails> view;
	private final SelectionModel<HbgbUserDetails> selectionModel;
	private HasWidgets screen;

	public UserListPresenter(HandlerManager eventBus)
	{
		this.eventBus = eventBus;
		this.view = ViewFinder.getUserListView();
		this.selectionModel = new SelectionModel<>();
		this.view.setPresenter(this);
		this.view.setColumnDefinitions(UserColumnDefinitionsFactory.getUserColumnDefinitions());
	}

	@Override
	public void onAddButtonClicked()
	{
		this.eventBus.fireEvent(new AddUserEvent());
	}

	@Override
	public void onDeleteButtonClicked()
	{
		this.deleteSelectedUsers();
	}

	@Override
	public void onRefreshButtonClicked()
	{
		this.fetchHbgbUserDetails();
	}

	@Override
	public void onItemClicked(HbgbUserDetails hbgbUserDetails)
	{
		this.eventBus.fireEvent(new EditUserEvent(hbgbUserDetails.getKey()));
	}

	@Override
	public void onItemSelected(HbgbUserDetails hbgbUserDetails)
	{
		if (this.selectionModel.isSelected(hbgbUserDetails))
		{
			this.selectionModel.removeSelection(hbgbUserDetails);
			return;
		}
		this.selectionModel.addSelection(hbgbUserDetails);
	}

	@Override
	public void setScreen(HasWidgets container)
	{
		this.screen = container;
	}

	@Override
	public void go()
	{
		this.fetchHbgbUserDetails();
	}

	public void setHbgbUserDetails(List<HbgbUserDetails> hbgbUserDetails)
	{
		this.hbgbUserDetails = hbgbUserDetails;
	}

	public List<HbgbUserDetails> getHbgbUserDetails()
	{
		return this.hbgbUserDetails;
	}

	public HbgbUserDetails getHbgbUserDetail(int index)
	{
		return this.hbgbUserDetails.get(index);
	}

	private void fetchHbgbUserDetails()
	{
		this.rpcService.getHbgbUserDetails(new AsyncCallback<ArrayList<HbgbUserDetails>>()
		{

			@Override
			public void onSuccess(ArrayList<HbgbUserDetails> result)
			{
				hbgbUserDetails = result;

				UserListPresenter.this.screen.clear();
				UserListPresenter.this.view.setRowData(UserListPresenter.this.hbgbUserDetails);
				UserListPresenter.this.screen.add(UserListPresenter.this.view.asWidget());
			}

			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("Error fetching user details");
			}
		});
	}

	private void deleteSelectedUsers()
	{
		List<HbgbUserDetails> selectedUsers = this.selectionModel.getSelectedItems();
		ArrayList<String> ids = new ArrayList<>();
		int i = 0;
		while (i < selectedUsers.size())
		{
			ids.add(selectedUsers.get(i).getKey());
			++i;
		}
		this.rpcService.deleteUsers(ids, new AsyncCallback<ArrayList<HbgbUserDetails>>()
		{

			@Override
			public void onSuccess(ArrayList<HbgbUserDetails> result)
			{
				hbgbUserDetails = result;
				UserListPresenter.this.screen.clear();
				UserListPresenter.this.selectionModel.clearSelections();

				UserListPresenter.this.view.setRowData(UserListPresenter.this.hbgbUserDetails);
				UserListPresenter.this.screen.add(UserListPresenter.this.view.asWidget());
			}

			@Override
			public void onFailure(Throwable caught)
			{
				System.out.println("Error deleting selected Users");
			}
		});
	}

}
