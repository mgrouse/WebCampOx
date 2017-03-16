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
import org.hbgb.webcamp.shared.enums.SecurityRole;

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

	public InputPaymentInfoPresenter(String key)
	{
		this.key = key;
		this.view = ViewFinder.getPaymentInfoView();
		view.setPresenter(this);
		this.view.setVisibility(SecurityRole.USER);
	}

	@Override
	public void setKey(String key)
	{
		this.key = key;
	}

	@Override
	public void setScreen(HasWidgets container)
	{
		screen = container;
	}

	private void setView()
	{
		this.view.setHasTicket(this.paymentInfo.getHasTicket());
		this.view.setTicketType(this.paymentInfo.getTicketType());

	}

	private void setModel()
	{
		this.paymentInfo.setHasTicket(this.view.getHasTicket());
		this.paymentInfo.setTicketType(this.view.getTicketType());

	}

	@Override
	public void go()
	{
		this.fetchData();
		this.screen.clear();
	}

	@Override
	public void setNextPresenter(IKeyPresenter next)
	{
		this.nextPresenter = next;
	}

	public void fetchData()
	{
		if (this.key != null)
		{
			this.rpcService.getApplicantsPaymentInfoBlock(this.key, new AsyncCallback<PaymentInfoBlock>()
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
		this.setModel();
		this.rpcService.updateApplicantsPaymentInfoBlock(this.paymentInfo, new AsyncCallback<Boolean>()
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
