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
import org.hbgb.webcamp.shared.PaymentInfoBlock;

public class PaymentInfoBlockModel implements IKeyedModel
{
	ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	IKeyedModelPresenter presenter;
	PaymentInfoBlock model;

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
			this.rpcService.getApplicantsPaymentInfoBlock(key, new AsyncCallback<PaymentInfoBlock>()
			{

				public void onSuccess(PaymentInfoBlock result)
				{
					if (result == null)
					{
						Window.alert((String) "Applicant's Payment Info reurned as null");
						return;
					}
					PaymentInfoBlockModel.this.model = result;
					PaymentInfoBlockModel.this.presenter.onDataFetched();
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
		this.rpcService.updateApplicantsPaymentInfoBlock(this.model, new AsyncCallback<Boolean>()
		{

			public void onSuccess(Boolean saved)
			{
				if (saved.booleanValue())
				{
					PaymentInfoBlockModel.this.presenter.onDataPut();
					return;
				}
				Window.alert((String) "DB Error saving Applicant's Payment Info");
			}

			public void onFailure(Throwable caught)
			{
				Window.alert((String) "RPC Error saving Applicant's Payment Info");
			}
		});
	}

	public PaymentInfoBlock getData()
	{
		return this.model;
	}

	public void setData(PaymentInfoBlock t)
	{
		this.model = t;
	}

}
