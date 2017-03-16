/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.user.client.Window
 * com.google.gwt.user.client.rpc.AsyncCallback
 * com.google.gwt.user.client.ui.HasWidgets com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.application.input;

import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.async.EmailServiceAsync;
import org.hbgb.webcamp.client.presenter.IKeyPresenter;
import org.hbgb.webcamp.client.view.application.input.FinishViewI;
import org.hbgb.webcamp.client.view.application.input.FinishViewImpl;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class FinishPresenter implements IKeyPresenter
{
	private final EmailServiceAsync emailService = AsyncServiceFinder.getEmailService();
	private final FinishViewI view = new FinishViewImpl();
	private HasWidgets screen;
	private String key;

	public FinishPresenter()
	{
		view.setSuccessMessageVisability(false);
		view.setFailureMessageVisability(false);
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

	@Override
	public void go()
	{

		screen.clear();
		sendEmail();
	}

	private void sendEmail()
	{
		this.emailService.sendApplicationRecievedEmail(key, new AsyncCallback<String>()
		{
			@Override
			public void onSuccess(String result)
			{
				if (result == null)
				{
					Window.alert("RPC Error: Result is returned as NULL");
				}
				else
				{
					if (result.equals("Success"))
					{
						view.setSuccessMessageVisability(true);
					}
					else
					{
						view.setFailureMessageVisability(true);
					}

					screen.add(view.asWidget());
				}
			}

			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("RPC Error: " + caught.getMessage());
			}
		});
	}
}
