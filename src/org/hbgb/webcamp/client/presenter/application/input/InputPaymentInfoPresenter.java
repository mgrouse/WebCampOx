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
import org.hbgb.webcamp.client.view.application.input.InputPaymentInfoView;
import org.hbgb.webcamp.shared.PaymentInfoBlock;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class InputPaymentInfoPresenter implements ISequentialPresenter
{
	private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	private final InputPaymentInfoView view;
	private String key;
	private PaymentInfoBlock paymentInfo;
	private HasWidgets screen;
	private IKeyPresenter nextPresenter;

	public InputPaymentInfoPresenter(String k)
	{
		key = k;
		view = ViewFinder.getPaymentInfoView();
		view.setPresenter(this);
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

	private void setView()
	{
		view.setHasTicket(paymentInfo.getHasTicket());
		view.setTicketType(paymentInfo.getTicketType());

	}

	private void setModel()
	{
		paymentInfo.setHasTicket(view.getHasTicket());
		paymentInfo.setTicketType(view.getTicketType());

	}

	@Override
	public void go()
	{
		fetchData();
		screen.clear();
	}

	@Override
	public void setNextPresenter(IKeyPresenter next)
	{
		nextPresenter = next;
	}

	public void fetchData()
	{
		if (key != null)
		{
			rpcService.getApplicantsPaymentInfoBlock(key, new AsyncCallback<PaymentInfoBlock>()
			{

				@Override
				public void onSuccess(PaymentInfoBlock result)
				{
					if (result == null)
					{
						Window.alert("Applicant's Payment Info reurned as null");
						return;
					}

					paymentInfo = result;
					setView();
					screen.add(view.asWidget());
				}

				@Override
				public void onFailure(Throwable caught)
				{
					Window.alert("DB Error retrieving Applicant's Payment Info");
				}
			});
			return;
		}
		Window.alert("Error no key for Applicant's Application!");
	}

	@Override
	public void onNextButtonClicked()
	{
		setModel();
		rpcService.updateApplicantsPaymentInfoBlock(paymentInfo, new AsyncCallback<Boolean>()
		{

			@Override
			public void onSuccess(Boolean saved)
			{
				if (saved.booleanValue())
				{
					screen.clear();
					nextPresenter.setKey(key);
					nextPresenter.setScreen(screen);
					nextPresenter.go();
					return;
				}
				Window.alert("DB Error saving Applicant's Payment Info");
			}

			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("RPC Error saving Applicant's Payment Info");
			}
		});
	}

}
