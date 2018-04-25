
package org.hbgb.webcamp.client.presenter.application.input;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hbgb.webcamp.client.async.ApplicationServiceAsync;
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.async.EmailServiceAsync;
import org.hbgb.webcamp.client.presenter.IKeyPresenter;
import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.application.input.IStartView;
import org.hbgb.webcamp.shared.FindAppResult;
import org.hbgb.webcamp.shared.enums.FindApp;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class StartPresenter implements ISequentialPresenter
{
	private static final Logger log = Logger.getLogger(StartPresenter.class.getName());

	private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	private final EmailServiceAsync emailService = AsyncServiceFinder.getEmailService();

	private final IStartView view = ViewFinder.getEnterView();

	// private int finishedCalls;

	private FindAppResult findResult = null;
	private String email;

	private HasWidgets screen;
	private IKeyPresenter nextPresenter;

	public StartPresenter()
	{
		// finishedCalls = 0;
		view.setPresenter(this);
	}

	@Override
	public void setKey(String key)
	{
	}

	@Override
	public void setScreen(HasWidgets container)
	{
		screen = container;
	}

	@Override
	public void go()
	{
		// finishedCalls = 0;
		screen.clear();
		view.clear();
		screen.add(view.asWidget());
	}

	@Override
	public void setNextPresenter(IKeyPresenter next)
	{
		nextPresenter = next;
	}

	// waits on calls to complete. A poor man's semaphore
	// private void onAsyncReturn()
	// {
	// finishedCalls += 1;
	// if (2 == finishedCalls)
	// {
	// notifyNextPresenter();
	// }
	// }

	@Override
	public void onNextButtonClicked()
	{
		view.setNextButtonActive(false);
		setModel();
	
		// starting two Async calls
		getApplicationKey();
		// sendEmail();
	}

	private void notifyNextPresenter()
	{
		// mostly just in case the same browser comes back
		// to enter another registration
		view.setNextButtonActive(true);

		screen.clear();
		nextPresenter.setKey(findResult.getKey());
		nextPresenter.setScreen(screen);
		nextPresenter.go();
	}

	private void setModel()
	{
		email = view.getEmailText();
	}

	private void getApplicationKey()
	{
		rpcService.findOrAddApplication(email, new AsyncCallback<FindAppResult>()
		{
			@Override
			public void onSuccess(FindAppResult result)
			{
				if (null == result)
				{
					log.log(Level.WARNING, "Applicant's AppFind came back as NULL.");
					Window.alert("Applicant's AppFind came back as NULL.");
				}
				else
				{
					findResult = result;

					if (null == findResult.getKey())
					{
						log.log(Level.WARNING, "Applicant's Info came back with null key");
						Window.alert("Applicant's Info came back with null key");
					}
					else if (FindApp.Found != findResult.getFind())
					{
						sendEmail();
					}
					else
					{
						notifyNextPresenter();
					}
				}
				// onAsyncReturn();
			}

			@Override
			public void onFailure(Throwable caught)
			{
				log.log(Level.WARNING,
						"RPC Error involving Applicant's Info" + caught.getMessage());
				Window.alert("RPC Error involving Applicant's Info" + caught.getMessage());
				// onAsyncReturn();
			}
		});
	}

	private void sendEmail()
	{
		emailService.sendApplicationRecievedEmail(email, new AsyncCallback<String>()
		{
			@Override
			public void onSuccess(String result)
			{
				if (result == null)
				{
					log.log(Level.WARNING, "RPC Error: Email Result is returned as NULL");
				}
				else if (result.equals("Failure"))
				{
					// log failure of email
					log.log(Level.WARNING, "RPC Error: Email Result is returned as 'Failure'");
				}

				// onAsyncReturn();
				notifyNextPresenter();
			}

			@Override
			public void onFailure(Throwable caught)
			{
				// log failure of email
				log.log(Level.SEVERE, "Exception.msg: " + caught.getMessage());
				// onAsyncReturn();
				notifyNextPresenter();
			}
		});
	}
}
