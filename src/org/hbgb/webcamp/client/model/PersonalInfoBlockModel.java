/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.user.client.Window
 * com.google.gwt.user.client.rpc.AsyncCallback
 */
package org.hbgb.webcamp.client.model;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import org.hbgb.webcamp.client.async.ApplicationServiceAsync;
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.model.IKeyedModel;
import org.hbgb.webcamp.client.presenter.IKeyedModelPresenter;
import org.hbgb.webcamp.shared.Burner;

public class PersonalInfoBlockModel implements IKeyedModel
{
	ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	IKeyedModelPresenter presenter;
	Burner model;

	@Override
	public void setPresenter(IKeyedModelPresenter p)
	{
		this.presenter = p;
	}

	@Override
	public void fetchData(String key)
	{
		if (key != null)
		{
			this.rpcService.getApplicant(key, new AsyncCallback<Burner>()
			{

				public void onSuccess(Burner result)
				{
					PersonalInfoBlockModel.this.model = result;
					PersonalInfoBlockModel.this.presenter.onDataFetched();
				}

				public void onFailure(Throwable caught)
				{
					Window.alert((String) "Error retrieving Applicant");
				}
			});
			return;
		}
		Window.alert((String) "Error no key for Applicant's Application!");
	}

	@Override
	public void putData()
	{
		this.rpcService.updateApplicant(this.model, new AsyncCallback<Boolean>()
		{

			public void onSuccess(Boolean saved)
			{
				if (saved.booleanValue())
				{
					PersonalInfoBlockModel.this.presenter.onDataPut();
					return;
				}
				Window.alert((String) "DB Error saving Applicant's Info");
			}

			public void onFailure(Throwable caught)
			{
				Window.alert((String) "RPC Error saving Applicant's Info");
			}
		});
	}

	public Burner getData()
	{
		return this.model;
	}

	public void setData(Burner t)
	{
		this.model = t;
	}

}
