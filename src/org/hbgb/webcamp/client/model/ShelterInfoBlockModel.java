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
import org.hbgb.webcamp.shared.ShelterInfoBlock;

public class ShelterInfoBlockModel implements IKeyedModel
{
	ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	IKeyedModelPresenter presenter;
	ShelterInfoBlock model;

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
			this.rpcService.getApplicantsShelterInfoBlock(key, new AsyncCallback<ShelterInfoBlock>()
			{

				public void onSuccess(ShelterInfoBlock result)
				{
					if (result == null)
					{
						Window.alert((String) "Applicant's Payment Info reurned as null");
						return;
					}
					ShelterInfoBlockModel.this.model = result;
					ShelterInfoBlockModel.this.presenter.onDataFetched();
				}

				public void onFailure(Throwable caught)
				{
					Window.alert((String) "DB Error retrieving Applicant's Payment Info");
				}
			});
			return;
		}
		Window.alert((String) "Error no key for Applicant's Application!");
	}

	@Override
	public void putData()
	{
		this.rpcService.updateApplicantsShelterInfoBlock(this.model, new AsyncCallback<Boolean>()
		{

			public void onSuccess(Boolean saved)
			{
				if (saved.booleanValue())
				{
					ShelterInfoBlockModel.this.presenter.onDataPut();
					return;
				}
				Window.alert((String) "DB Error saving Applicant's Shelter Info");
			}

			public void onFailure(Throwable caught)
			{
				Window.alert((String) "RPC Error saving Applicant's Shelter Info");
			}
		});
	}

	public ShelterInfoBlock getData()
	{
		return this.model;
	}

	public void setData(ShelterInfoBlock t)
	{
		this.model = t;
	}

}
