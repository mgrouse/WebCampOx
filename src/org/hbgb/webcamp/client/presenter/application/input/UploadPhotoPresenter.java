/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.user.client.Window
 * com.google.gwt.user.client.rpc.AsyncCallback
 * com.google.gwt.user.client.ui.HasWidgets com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.application.input;

import org.hbgb.webcamp.client.async.ApplicationServiceAsync;
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.presenter.IKeyPresenter;
import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.application.input.UploadPhotoView;
import org.hbgb.webcamp.shared.Application;
import org.hbgb.webcamp.shared.enums.SecurityRole;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class UploadPhotoPresenter implements ISequentialPresenter
{
	private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	private String key;
	private final UploadPhotoView view;
	private HasWidgets screen;
	private IKeyPresenter nextPresenter;
	private Application app;

	public UploadPhotoPresenter(String k)
	{
		key = k;
		view = ViewFinder.getUploadPhotoView();
		view.setPresenter(this);
		view.setVisibility(SecurityRole.USER);
	}

	@Override
	public void setKey(String k)
	{
		key = k;
	}

	@Override
	public void setScreen(HasWidgets container)
	{
		screen = container;
	}

	@Override
	public void setNextPresenter(IKeyPresenter next)
	{
		nextPresenter = next;
	}

	private void setView()
	{
		view.setImageURL(app.getImageURL());
	}

	private void setModel()
	{
		app.setImageURL(view.getImageURL());
	}

	@Override
	public void go()
	{
		fetchData();
		screen.clear();
	}

	public void fetchData()
	{
		if (this.key != null)
		{
			this.rpcService.getApplication(this.key, new AsyncCallback<Application>()
			{

				@Override
				public void onSuccess(Application result)
				{
					if (result == null)
					{
						Window.alert("Applicant's Info reurned as null");
					}
					else
					{
						setView();
						screen.add(view.asWidget());
					}
				}

				@Override
				public void onFailure(Throwable caught)
				{
					Window.alert("RPC Error: " + caught.getMessage());
				}
			});
			return;
		}
		Window.alert("Error no key for the applicant's Application!");
	}

	@Override
	public void onNextButtonClicked()
	{
		this.setModel();
		this.rpcService.updateApplication(this.app, new AsyncCallback<Boolean>()
		{

			@Override
			public void onSuccess(Boolean saved)
			{
				if (saved.booleanValue())
				{
					screen.clear();
					nextPresenter.setKey(UploadPhotoPresenter.this.key);
					nextPresenter.setScreen(screen);
					nextPresenter.go();
					return;
				}
				Window.alert("DB Error saving Applicant's Picture Info");
			}

			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("RPC Error: " + caught.getMessage());
			}
		});
	}
}
