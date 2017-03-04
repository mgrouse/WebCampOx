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
		if (good.booleanValue())
		{
			this.view.setNextButtonActive(false);
			this.rpcService.findApplicationKeyByEmail(this.email, new AsyncCallback<String>()
			{

				public void onSuccess(String result)
				{
					if (result == null)
					{
						ApplicationLookupByEmailPresenter.this.screen.clear();
						ApplicationLookupByEmailPresenter.this.view
								.setWarningText(ApplicationLookupByEmailPresenter.this.getMissingEmailWarningText());
						ApplicationLookupByEmailPresenter.this.view.setNextButtonActive(true);
						ApplicationLookupByEmailPresenter.this.screen.add(ApplicationLookupByEmailPresenter.this.view.asWidget());
						return;
					}
					ApplicationLookupByEmailPresenter.access$3(ApplicationLookupByEmailPresenter.this, result);
					ApplicationLookupByEmailPresenter.this.screen.clear();
					if (ApplicationLookupByEmailPresenter.this.byKey.booleanValue())
					{
						ApplicationLookupByEmailPresenter.this.nextPresenter.setKey(ApplicationLookupByEmailPresenter.this.key);
					}
					else
					{
						ApplicationLookupByEmailPresenter.this.nextPresenter.setKey(ApplicationLookupByEmailPresenter.this.email);
					}
					ApplicationLookupByEmailPresenter.this.nextPresenter.go(ApplicationLookupByEmailPresenter.this.screen);
				}

				public void onFailure(Throwable caught)
				{
					Window.alert((String) "RPC Error during lookup. Try again later.");
				}
			});
			return;
		}
		this.screen.clear();
		this.view.setWarningText("<p>A valid email is required to continue.</p>");
		this.screen.add(this.view.asWidget());
	}

	private void setModel()
	{
		this.email = this.view.getEmailText();
	}

	private Boolean validateModel()
	{
		Boolean retVal = true;
		if (this.email == null)
			return false;
		if (!this.email.isEmpty())
			return retVal;
		return false;
	}

	private String getMissingEmailWarningText()
	{
		return "<p>The email address you supplied was not used for an application. Please try again.</p>";
	}

	static /* synthetic */ void access$3(ApplicationLookupByEmailPresenter applicationLookupByEmailPresenter, String string)
	{
		applicationLookupByEmailPresenter.key = string;
	}

}
