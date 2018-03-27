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

import org.hbgb.webcamp.client.view.admin.ISendEmailView;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * @author Michael
 *
 */
public class SendEmailPresenter implements ISendEmailPresenter, ISendEmailView.Presenter
{

	private HasWidgets screen;

	public SendEmailPresenter()
	{

	}

	@Override
	public void setScreen(HasWidgets container)
	{
		this.screen = container;
	}

	@Override
	public void go()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onSendButtonClicked()
	{
		// TODO Auto-generated method stub

	}

}
