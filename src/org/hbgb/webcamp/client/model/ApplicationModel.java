/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.user.client.Window
 * com.google.gwt.user.client.rpc.AsyncCallback
 */
package org.hbgb.webcamp.client.model;

import org.hbgb.webcamp.client.async.ApplicationServiceAsync;
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.presenter.IKeyedModelPresenter;
import org.hbgb.webcamp.shared.Application;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ApplicationModel implements IKeyedModel
{
	ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	IKeyedModelPresenter presenter;
	Application model;

	@Override
	public void setPresenter(IKeyedModelPresenter p)
	{
		presenter = p;
	}

	@Override
	public void fetchData(String key)
	{
		if (key != null)
		{
			rpcService.getApplication(key, new AsyncCallback<Application>()
			{

				@Override
				public void onSuccess(Application result)
				{
					if (result == null)
					{
						Window.alert("Applicant's Info reurned as null");
						return;
					}
					model = result;
					presenter.onDataFetched();
				}

				@Override
				public void onFailure(Throwable caught)
				{
					Window.alert("DB Error retrieving Applicant's Info");
				}
			});
			return;
		}
		Window.alert("Error no key for Applicant's Application!");
	}

	@Override
	public void putData()
	{
		rpcService.updateApplication(model, new AsyncCallback<Boolean>()
		{

			@Override
			public void onSuccess(Boolean saved)
			{
				if (saved.booleanValue())
				{
					presenter.onDataPut();
					return;
				}
				Window.alert("DB Error saving Applicant's Info");
			}

			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("RPC Error saving Applicant's Info");
			}
		});
	}

	public Application getData()
	{
		return model;
	}

	public void setData(Application t)
	{
		model = t;
	}

}
