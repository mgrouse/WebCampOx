/*
 * This is an unpublished work protected by the United States copyright laws and
 * is proprietary to Michael A. Grouse. Disclosure, copying, reproduction,
 * merger translation, modification, enhancement or use by anyone other than
 * authorized employees or licensees of Michael A. Grouse without prior written
 * consent of Michael A. Grouse is prohibited.
 *
 * Copyright (C) 1992 - 2018 Michael A. Grouse, All Rights Reserved.
 *
 * This copyright notice should not be construed as evidence of publication.
 */
package org.hbgb.webcamp.client.presenter.admin;

import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.async.EmailServiceAsync;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.admin.ISendEmailView;
import org.hbgb.webcamp.shared.enums.Circle;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * @author Michael
 *
 */
public class SendEmailPresenter implements ISendEmailPresenter, ISendEmailView.Presenter
{
	private EmailServiceAsync service = AsyncServiceFinder.getEmailService();

	private HasWidgets screen;
	private ISendEmailView view;

	private Circle recipientCircle;
	private String subject;
	private String body;
	private String sender;

	public SendEmailPresenter()
	{
		view = ViewFinder.getSendEmailView();
		view.setPresenter(this);
	}

	@Override
	public void setScreen(HasWidgets container)
	{
		this.screen = container;
	}

	@Override
	public void go()
	{
		screen.clear();
		view.clear();
		screen.add(view.asWidget());
	}

	@Override
	public void onSendButtonClicked()
	{
		getViewData();
		sendMail();
		view.setSendButtonEnabled(true);
	}

	private void getViewData()
	{
		recipientCircle = view.getRecipientCircle();
		subject = view.getSubjectLineText();
		body = view.getEmailBodyText();
		sender = view.getRespondEmailAddress();
	}

	private void sendMail()
	{
		service.sendEmailToCircle(recipientCircle, subject, sender, body,
				new AsyncCallback<String>()
				{

					@Override
					public void onSuccess(String result)
					{
						if (result == "Failure")
						{
							Window.alert("Your email was not sent. ;( /n/n "
									+ "Please contact Scarab and tell him what time it is now;"
									+ "and that your email failed");
						}
						else if (result == "Success")
						{
							Window.alert("Congrats!!! your email was sent!");
						}
						else if (result == "NoRecipients")
						{
							Window.alert("That Circle has no members in database!");
						}

					}

					@Override
					public void onFailure(Throwable caught)
					{
						Window.alert("Please contact Scarab and let him know "
								+ "that the following error has occurred: " + caught.getMessage());
					}
				});

	}

}
