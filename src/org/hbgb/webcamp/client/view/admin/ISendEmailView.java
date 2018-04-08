/*
 * This is an unpublished work protected by the United States copyright laws and
 * is proprietary to Michael A. Grouse. Disclosure, copying, reproduction,
 * merger translation, modification, enhancement or use by anyone other than
 * authorized employees or licensees of Michael A. Grouse without prior written
 * consent of Michael A. Grouse is prohibited.
 *
 * Copyright (C) 2018 Michael A. Grouse, All Rights Reserved.
 *
 * This copyright notice should not be construed as evidence of publication.
 */
package org.hbgb.webcamp.client.view.admin;

import org.hbgb.webcamp.client.view.IView;
import org.hbgb.webcamp.shared.enums.Circle;

/**
 * @author Michael
 *
 */
public interface ISendEmailView extends IView
{
	public interface Presenter
	{
		public void onSendButtonClicked();
	}

	public void setPresenter(Presenter p);

	public Circle getRecipientCircle();

	public void setRecipientCircle(Circle circle);

	public String getSubjectLineText();

	public void setSubjectLineText(String text);

	public String getEmailBodyText();

	public void setEmailBodyText(String emailText);

	public String getRespondEmailAddress();

	public void setRespondEmailAddress(String address);

	public void setSendButtonEnabled(boolean b);
}
