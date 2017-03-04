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
import org.hbgb.webcamp.client.model.IMealsReportModel;
import org.hbgb.webcamp.client.presenter.IReportPresenter;
import org.hbgb.webcamp.shared.MealsReport;

public class MealsReportModel implements IMealsReportModel
{
	ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	IReportPresenter presenter;
	MealsReport model;

	@Override
	public void setPresenter(IReportPresenter p)
	{
		this.presenter = p;
	}

	@Override
	public void fetchData()
	{
		this.rpcService.getMealsReport(new AsyncCallback<MealsReport>()
		{

			public void onSuccess(MealsReport result)
			{
				if (result == null)
				{
					Window.alert((String) "Meals Report Info reurned as null");
					return;
				}
				MealsReportModel.this.model = result;
				MealsReportModel.this.presenter.onDataFetched();
			}

			public void onFailure(Throwable caught)
			{
				Window.alert((String) "RPC Error retrieving Meals report");
			}
		});
	}

	@Override
	public MealsReport getReportData()
	{
		return this.model;
	}

}
