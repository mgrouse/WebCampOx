/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.event.shared.GwtEvent
 * com.google.gwt.event.shared.HandlerManager com.google.gwt.user.client.Window
 * com.google.gwt.user.client.rpc.AsyncCallback
 * com.google.gwt.user.client.ui.HasWidgets com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.application;

import java.util.ArrayList;
import java.util.List;

import org.hbgb.webcamp.client.async.ApplicationServiceAsync;
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.common.ApplicationColumnDefinitionsFactory;
import org.hbgb.webcamp.client.common.SelectionModel;
import org.hbgb.webcamp.client.event.application.EditApplicationEvent;
import org.hbgb.webcamp.client.presenter.IPresenter;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.application.ApplicationListByYearView;
import org.hbgb.webcamp.shared.ApplicationDetails;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class ApplicationListByYearPresenter
		implements IPresenter, ApplicationListByYearView.Presenter<ApplicationDetails>
{
	private List<ApplicationDetails> applicationDetails;
	private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	private final HandlerManager eventBus;
	private final ApplicationListByYearView<ApplicationDetails> view;
	private final SelectionModel<ApplicationDetails> selectionModel;
	private HasWidgets screen;

	public ApplicationListByYearPresenter(HandlerManager bus)
	{
		eventBus = bus;

		view = ViewFinder.getApplicationListPastView();
		view.clear();

		selectionModel = new SelectionModel<>();

		view.setPresenter(this);
		view.setColumnDefinitions(
				ApplicationColumnDefinitionsFactory.getApplicationColumnDefinitions());
	}

	@Override
	public void onRefreshButtonClicked()
	{
		fetchApplicationDetails();
	}

	@Override
	public void onAddButtonClicked()
	{
		// eventBus.fireEvent(new AddApplicationEvent());
	}

	@Override
	public void onDeleteButtonClicked()
	{
		// deleteSelectedApplications();
	}

	@Override
	public void onItemClicked(ApplicationDetails clickedItem)
	{
		ArrayList<String> keyList = new ArrayList<>();
		for (ApplicationDetails ad : this.applicationDetails)
		{
			keyList.add(ad.getEncodedKey());
		}
		this.eventBus.fireEvent(new EditApplicationEvent(clickedItem.getEncodedKey(), keyList));
	}

	@Override
	public void onItemSelected(ApplicationDetails selectedItem)
	{
		if (selectionModel.isSelected(selectedItem))
		{
			selectionModel.removeSelection(selectedItem);
		}
		else
		{
			selectionModel.addSelection(selectedItem);
		}
	}

	@Override
	public void setScreen(HasWidgets container)
	{
		screen = container;
	}

	@Override
	public void go()
	{
		screen.clear();
		view.clear();
		screen.add(view.asWidget());

		fetchApplicationDetails();
	}

	public void setApplicationDetails(List<ApplicationDetails> applicationDetails)
	{
		this.applicationDetails = applicationDetails;
	}

	public List<ApplicationDetails> getApplicationDetails()
	{
		return this.applicationDetails;
	}

	public ApplicationDetails getApplicationDetail(int index)
	{
		return this.applicationDetails.get(index);
	}

	private void fetchApplicationDetails()
	{

		this.rpcService.getApplicationDetails(view.getYearValue(),
				new AsyncCallback<ArrayList<ApplicationDetails>>()
				{

					@Override
					public void onSuccess(ArrayList<ApplicationDetails> result)
					{
						applicationDetails = result;
						view.setRowData(applicationDetails);
					}

					@Override
					public void onFailure(Throwable caught)
					{
						Window.alert("Error fetching Application details");
					}
				});
	}

	@SuppressWarnings("unused")
	private void deleteSelectedApplications()
	{
		List<ApplicationDetails> selectedUsers = this.selectionModel.getSelectedItems();
		ArrayList<String> ids = new ArrayList<>();
		for (int i = 0; i < selectedUsers.size(); ++i)
		{
			ids.add(selectedUsers.get(i).getEncodedKey());
		}

		this.rpcService.deleteApplications(ids, new AsyncCallback<ArrayList<ApplicationDetails>>()
		{

			@Override
			public void onSuccess(ArrayList<ApplicationDetails> result)
			{
				selectionModel.clearSelections();
				applicationDetails = result;

				view.setRowData(applicationDetails);
			}

			@Override
			public void onFailure(Throwable caught)
			{
				System.out.println("Error deleting selected applications");
			}
		});
	}

}
