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
package org.hbgb.webcamp.client.view.admin;

import org.hbgb.webcamp.client.view.AbstractView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Michael
 *
 */
public class SendEmailViewImpl extends AbstractView implements ISendEmailView
{

	@UiTemplate(value = "SendEmailView.ui.xml")
	static interface InputComitteeInfoViewImplBinder extends UiBinder<Widget, SendEmailViewImpl>
	{
	}

	private static UiBinder<Widget, SendEmailViewImpl> binder = GWT
			.create(InputComitteeInfoViewImplBinder.class);

	// Label ui:field="recipientLabel";
	// TextBox ui:field="subjectLine";
	// HTML ui:field="reason1HTML";
	// TextArea ui:field="emailBody"
	// Label ui:field="returnAddressLabel";
	// TextBox ui:field="respondEmailAddress";
	// Button ui:field="sendButton";

	private Presenter presenter;

	public SendEmailViewImpl()
	{
		initWidget(binder.createAndBindUi(this));
	}

	@UiHandler(value = { "nextButton" })
	void onNextButtonClicked(ClickEvent event)
	{
		if ((presenter != null) && (formIsValid()))
		{
			// nextButton.setEnabled(false);
			// presenter.onNextButtonClicked();
		}
	}

	private boolean formIsValid()
	{
		Boolean retVal = true;

		// clearErrorState();
		//
		// if (null == committee1ListBox.getSelectedEnumValue())
		// {
		// addMessage("Please answer the question(s) in red.");
		// committee1Label.getElement().getStyle().setColor("red");
		// retVal = false;
		// }
		//
		// if (reason1.getText().isEmpty())
		// {
		// addMessage("Please answer the question(s) in red.");
		// reason1HTML.getElement().getStyle().setColor("red");
		// retVal = false;
		// }
		//
		// if (getSessionLength().isEmpty())
		// {
		// addMessage("Please answer the question(s) in red.");
		// sessionLengthLabel.getElement().getStyle().setColor("red");
		// retVal = false;
		// }

		return retVal;
	}

	@Override
	public void setPresenter(Presenter p)
	{
		presenter = p;
	}

	@Override
	public void clear()
	{

	}

}
