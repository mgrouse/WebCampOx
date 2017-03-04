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
import org.hbgb.webcamp.client.presenter.KeyPresenterI;
import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.application.input.StartViewI;
import org.hbgb.webcamp.shared.Application;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class StartPresenter implements SequentialPresenterI
{
	private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	private final StartViewI view = ViewFinder.getEnterView();

	private String key = null;
	private String email;

	private HasWidgets screen;
	private KeyPresenterI nextPresenter;

	public StartPresenter()
	{
		this.view.setPresenter(this);
	}

	@Override
	public void go(HasWidgets container)
	{
		this.screen = container;
		this.screen.clear();
		this.view.clear();
		this.screen.add(view.asWidget());
	}

	@Override
	public void setNextPresenter(KeyPresenterI next)
	{
		nextPresenter = next;
	}

	@Override
	public void onNextButtonClicked()
	{
		setModel();
		Boolean good = validateModel();

		if (good)
		{
			view.setNextButtonActive(false);
			rpcService.findOrAddApplication(email, new AsyncCallback<Application>()
			{
				@Override
				public void onSuccess(Application result)
				{
					// this email used before
					if (null == result)
					{
						screen.clear();
						view.setWarningText(getUsedEmailWarningText());
						view.setNextButtonActive(true);
						screen.add(view.asWidget());
					}
					else
					{
						// this was a new email
						key = result.getEncodedKey();

						if (null == key)
						{
							Window.alert("Applicant's Info came back with null key");
						}
						else
						{
							screen.clear();
							nextPresenter.setKey(key);
							nextPresenter.go(screen);
						}
					}
				}

				@Override
				public void onFailure(Throwable caught)
				{
					Window.alert("RPC Error saving Applicant's Info" + caught.getMessage());
				}
			});
		} // end if good
		else
		{
			// clear and add?
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
			view.setWarningText("<p>A valid email is required to continue.</p>");
			retVal = false;
		}

		return retVal;
	}

	private String getUsedEmailWarningText()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<h1>Warning!</h1>");
		stringBuilder.append("<p>The email address you have supplied has already been used to apply for this year. ");
		stringBuilder.append("Editing your application is not supported. If you feel this warning is in error, ");
		stringBuilder.append("contact Scarab at: michael.grouse@gmail.com.</p>");
		return stringBuilder.toString();
	}

	@Override
	public void setKey(String key)
	{}

}
