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
import org.hbgb.webcamp.client.view.application.input.IStartView;
import org.hbgb.webcamp.shared.Application;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class StartPresenter implements ISequentialPresenter
{
	private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	private final IStartView view = ViewFinder.getEnterView();

	private String key = null;
	private String email;

	private HasWidgets screen;
	private IKeyPresenter nextPresenter;

	public StartPresenter()
	{
		this.view.setPresenter(this);
	}

	@Override
	public void setKey(String key)
	{}

	@Override
	public void setScreen(HasWidgets container)
	{
		screen = container;
	}

	@Override
	public void go()
	{
		screen.clear();
		view.clear();
		screen.add(view.asWidget());
	}

	@Override
	public void setNextPresenter(IKeyPresenter next)
	{
		nextPresenter = next;
	}

	@Override
	public void onNextButtonClicked()
	{
		view.setNextButtonActive(false);
		setModel();

		rpcService.findOrAddApplication(email, new AsyncCallback<Application>()
		{
			@Override
			public void onSuccess(Application result)
			{
				if (null == result)
				{
					Window.alert("Applicant's Info came back as NULL.");
				}
				else
				{
					key = result.getEncodedKey();

					if (null == key)
					{
						Window.alert("Applicant's Info came back with null key");
					}
					else
					{
						screen.clear();
						nextPresenter.setKey(key);
						nextPresenter.setScreen(screen);
						nextPresenter.go();
					}
				}
			}

			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("RPC Error saving Applicant's Info" + caught.getMessage());
			}
		});
	}

	private void setModel()
	{
		email = view.getEmailText();
	}

}
