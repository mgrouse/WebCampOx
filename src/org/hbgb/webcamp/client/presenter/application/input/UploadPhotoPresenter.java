/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.user.client.Window
 * com.google.gwt.user.client.rpc.AsyncCallback
 * com.google.gwt.user.client.ui.HasWidgets com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.application.input;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import org.hbgb.webcamp.client.async.ApplicationServiceAsync;
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.presenter.KeyPresenterI;
import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.application.input.UploadPhotoView;
import org.hbgb.webcamp.shared.Application;
import org.hbgb.webcamp.shared.enums.SecurityRole;

public class UploadPhotoPresenter implements SequentialPresenterI
{
	private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	private String key;
	private final UploadPhotoView view;
	private HasWidgets screen;
	private KeyPresenterI nextPresenter;
	private Application app;

	public UploadPhotoPresenter(String key)
	{
		this.key = key;
		this.view = ViewFinder.getUploadPhotoView();
		this.view.setPresenter(this);
		this.view.setVisibility(SecurityRole.USER);
	}

	@Override
	public void setKey(String key)
	{
		this.key = key;
	}

	@Override
	public void setNextPresenter(KeyPresenterI next)
	{
		this.nextPresenter = next;
	}

	private void setView()
	{
		this.view.setImageURL(this.app.getImageURL());
	}

	private void setModel()
	{
		this.app.setImageURL(this.view.getImageURL());
	}

	@Override
	public void go(HasWidgets container)
	{
		this.screen = container;
		this.fetchData();
		this.screen.clear();
	}

	public void fetchData()
	{
		if (this.key != null)
		{
			this.rpcService.getApplication(this.key, new AsyncCallback<Application>()
			{

				public void onSuccess(Application result)
				{
					if (result == null)
					{
						Window.alert((String) "Applicant's Info reurned as null");
						return;
					}
					UploadPhotoPresenter.access$0(UploadPhotoPresenter.this, result);
					UploadPhotoPresenter.this.setView();
					UploadPhotoPresenter.this.screen.add(UploadPhotoPresenter.this.view.asWidget());
				}

				public void onFailure(Throwable caught)
				{
					Window.alert((String) "DB Error retrieving Applicant's Info");
				}
			});
			return;
		}
		Window.alert((String) "Error no key for the applicant's Application!");
	}

	@Override
	public void onNextButtonClicked()
	{
		this.setModel();
		this.rpcService.updateApplication(this.app, new AsyncCallback<Boolean>()
		{

			public void onSuccess(Boolean saved)
			{
				if (saved.booleanValue())
				{
					UploadPhotoPresenter.this.screen.clear();
					UploadPhotoPresenter.this.nextPresenter.setKey(UploadPhotoPresenter.this.key);
					UploadPhotoPresenter.this.nextPresenter.go(UploadPhotoPresenter.this.screen);
					return;
				}
				Window.alert((String) "DB Error saving Applicant's Picture Info");
			}

			public void onFailure(Throwable caught)
			{
				Window.alert((String) "RPC Error saving Applicant's Picture Info");
			}
		});
	}

	static /* synthetic */ void access$0(UploadPhotoPresenter uploadPhotoPresenter, Application application)
	{
		uploadPhotoPresenter.app = application;
	}

}
