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
import org.hbgb.webcamp.client.widget.CircleListBox;
import org.hbgb.webcamp.client.widget.LoadingPopup;
import org.hbgb.webcamp.client.widget.MessagesWidget;
import org.hbgb.webcamp.shared.enums.Circle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Michael
 *
 */
public class SendEmailViewImpl extends AbstractView implements ISendEmailView
{

	@UiTemplate(value = "SendEmailView.ui.xml")
	static interface SendEmailViewImplBinder extends UiBinder<Widget, SendEmailViewImpl>
	{
	}

	private static UiBinder<Widget, SendEmailViewImpl> binder = GWT
			.create(SendEmailViewImplBinder.class);

	@UiField
	MessagesWidget messages;

	@UiField
	Label recipientLabel;

	@UiField
	CircleListBox recipientListBox;

	@UiField
	Label subjectLabel;

	@UiField
	TextBox subjectLine;

	@UiField
	Label emailBodyLabel;

	@UiField
	TextArea emailBody;

	@UiField
	Label respondNameLabel;

	@UiField
	TextBox respondName;

	@UiField
	Label respondEmailLabel;

	@UiField
	TextBox respondEmailAddress;

	@UiField
	Button sendButton;

	private LoadingPopup loadPop;

	private Presenter presenter;

	public SendEmailViewImpl()
	{
		initWidget(binder.createAndBindUi(this));
		loadPop = new LoadingPopup();
	}

	@UiHandler(value = { "sendButton" })
	void onNextButtonClicked(ClickEvent event)
	{
		setSendButtonEnabled(false);

		if ((presenter != null) && (formIsValid()))
		{
			loadPop.go();
			presenter.onSendButtonClicked();
		}
		else
		{
			setSendButtonEnabled(true);
		}
	}

	private boolean formIsValid()
	{
		Boolean retVal = true;

		clearErrorState();

		if (null == recipientListBox.getSelectedEnumValue())
		{
			addMessage("Please answer the question(s) in red.");
			recipientLabel.getElement().getStyle().setColor("red");
			retVal = false;
		}

		if (subjectLine.getText().isEmpty())
		{
			addMessage("Please answer the question(s) in red.");
			subjectLabel.getElement().getStyle().setColor("red");
			retVal = false;
		}

		if (emailBody.getText().isEmpty())
		{
			addMessage("Please answer the question(s) in red.");
			emailBodyLabel.getElement().getStyle().setColor("red");
			retVal = false;
		}

		if (respondName.getText().isEmpty())
		{
			addMessage("Please answer the question(s) in red.");
			respondNameLabel.getElement().getStyle().setColor("red");
			retVal = false;
		}

		if (respondEmailAddress.getText().isEmpty())
		{
			addMessage("Please answer the question(s) in red.");
			respondEmailLabel.getElement().getStyle().setColor("red");
			retVal = false;
		}

		return retVal;
	}

	private void clearErrorState()
	{
		recipientLabel.getElement().getStyle().setColor("black");
		subjectLabel.getElement().getStyle().setColor("black");
		emailBodyLabel.getElement().getStyle().setColor("black");
		respondNameLabel.getElement().getStyle().setColor("black");
		respondEmailLabel.getElement().getStyle().setColor("black");

		messages.clear();
	}

	@Override
	public void displaySendResult(String result)
	{
		Window.alert(result);
		loadPop.stop();
		setSendButtonEnabled(true);
	}

	@Override
	public Circle getRecipientCircle()
	{
		return recipientListBox.getSelectedEnumValue();
	}

	@Override
	public void setRecipientCircle(Circle circle)
	{
		recipientListBox.setSelectedValue(circle);
	}

	@Override
	public String getSubjectLineText()
	{
		return subjectLine.getText();
	}

	@Override
	public void setSubjectLineText(String text)
	{
		subjectLine.setText(text);
	}

	@Override
	public String getEmailBodyText()
	{
		return emailBody.getText();
	}

	@Override
	public void setEmailBodyText(String emailText)
	{
		emailBody.setText(emailText);
	}

	@Override
	public String getRespondName()
	{
		return respondName.getText();
	}

	@Override
	public void setRespondName(String name)
	{
		respondName.setText(name);
	}

	@Override
	public String getRespondEmailAddress()
	{
		return respondEmailAddress.getText();
	}

	@Override
	public void setRespondEmailAddress(String address)
	{
		respondEmailAddress.setText(address);
	}

	private void setSendButtonEnabled(boolean b)
	{
		sendButton.setEnabled(b);
	}

	private void addMessage(String text)
	{
		if (text != null && !text.isEmpty())
		{
			messages.addMessageIfUnique(text);
			messages.setVisible(true);
		}
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
