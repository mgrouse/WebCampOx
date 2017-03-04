/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.user.client.Window
 * com.google.gwt.user.client.rpc.AsyncCallback
 * com.google.gwt.user.client.ui.HasWidgets com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.application;

import org.hbgb.webcamp.client.async.ApplicationServiceAsync;
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.presenter.KeyPresenterI;
import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.application.input.ApplicationLookupByEmailView;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class ApplicationLookupByEmailPresenter implements SequentialPresenterI
{
	private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	private final ApplicationLookupByEmailView view;
	private Boolean byKey;
	private String key;
	private String email;
	private HasWidgets screen;
	private KeyPresenterI nextPresenter;

	public ApplicationLookupByEmailPresenter(Boolean byKey)
	{
		this.byKey = byKey;
		this.view = ViewFinder.getApplicationLookupByEmailView();
		this.view.setPresenter(this);
	}

	@Override
	public void setKey(String key)
	{}

	@Override
	public void go(HasWidgets container)
	{
		this.screen = container;
		this.screen.clear();
		this.view.clear();
		this.screen.add(this.view.asWidget());
	}

	@Override
	public void setNextPresenter(KeyPresenterI next)
	{
		this.nextPresenter = next;
	}

	@Override
	public void onNextButtonClicked()
	{
		this.setModel();
		Boolean good = this.validateModel();
		if (good)
		{
			this.view.setNextButtonActive(false);
			this.rpcService.findApplicationKeyByEmail(this.email, new AsyncCallback<String>()
			{

				@Override
				public void onSuccess(String result)
				{
					// this email not in there
					if (null == result)
					{
						screen.clear();
						view.setWarningText(getMissingEmailWarningText());
						view.setNextButtonActive(true);
						screen.add(view.asWidget());
					}
					else
					{
						// this was a good email
						key = result;
						{
							screen.clear();
							// this is a hack
							if (byKey)
							{
								nextPresenter.setKey(key);
							}
							else
							{
								nextPresenter.setKey(email);
							}

							nextPresenter.go(screen);
						}
					}
				}

				@Override
				public void onFailure(Throwable caught)
				{
					Window.alert("RPC Error during lookup. Try again later.");
				}
			});
		} // good
		else
		{
			this.screen.clear();
			this.view.setWarningText("<p>A valid email is required to continue.</p>");
			this.screen.add(this.view.asWidget());
		}
	}

	private void setModel()
	{
		this.email = this.view.getEmailText();
	}

	private Boolean validateModel()
	{
		Boolean retVal = true;

		if ((null == email) || email.isEmpty())
		{
			retVal = false;
		}

		return retVal;
	}

	private String getMissingEmailWarningText()
	{
		return "<p>The email address you supplied was not used for an application. Please try again.</p>";
	}

}
