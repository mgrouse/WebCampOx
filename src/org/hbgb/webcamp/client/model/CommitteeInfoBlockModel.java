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
import org.hbgb.webcamp.shared.CommitteeInfoBlock;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CommitteeInfoBlockModel implements IKeyedModel
{
	ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	IKeyedModelPresenter presenter;
	CommitteeInfoBlock model;

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
			this.rpcService.getApplicantsCommitteeInfoBlock(key, new AsyncCallback<CommitteeInfoBlock>()
			{

				public void onSuccess(CommitteeInfoBlock result)
				{
					if (result == null)
					{
						Window.alert((String) "Applicant's Committee Info reurned as null");
						return;
					}
					CommitteeInfoBlockModel.this.model = result;
					CommitteeInfoBlockModel.this.presenter.onDataFetched();
				}

				public void onFailure(Throwable caught)
				{
					Window.alert((String) "DB Error retrieving Applicant's Committee Info");
				}
			});
			return;
		}
		Window.alert((String) "Error no key for Applicant's Application!");
	}

	@Override
	public void putData()
	{
		this.rpcService.updateApplicantsCommitteeInfoBlock(this.model, new AsyncCallback<Boolean>()
		{

			public void onSuccess(Boolean saved)
			{
				if (saved.booleanValue())
				{
					CommitteeInfoBlockModel.this.presenter.onDataPut();
					return;
				}
				Window.alert((String) "DB Error saving Applicant's Committee Info");
			}

			public void onFailure(Throwable caught)
			{
				Window.alert((String) "RPC Error saving Applicant's Committee Info");
			}
		});
	}

	public CommitteeInfoBlock getData()
	{
		return this.model;
	}

	public void setData(CommitteeInfoBlock t)
	{
		this.model = t;
	}

}
