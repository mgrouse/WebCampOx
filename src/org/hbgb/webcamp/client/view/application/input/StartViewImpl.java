/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.event.dom.client.ClickEvent
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiHandler
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.Button com.google.gwt.user.client.ui.HTML
 * com.google.gwt.user.client.ui.TextBox com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.client.view.AbstractView;
import org.hbgb.webcamp.client.widget.MessagesWidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class StartViewImpl extends AbstractView implements IStartView
{
	@UiTemplate(value = "StartView.ui.xml")
	static interface EnterViewImplBinder extends UiBinder<Widget, StartViewImpl>
	{}

	private static UiBinder<Widget, StartViewImpl> binder = GWT.create(EnterViewImplBinder.class);

	@UiField
	MessagesWidget messages;

	@UiField
	Label emailLabel;

	@UiField
	TextBox emailBox;

	@UiField
	Button nextButton;

	private ISequentialPresenter presenter;

	public StartViewImpl()
	{
		initWidget(binder.createAndBindUi(this));
		messages.clear();
	}

	@Override
	public void setPresenter(ISequentialPresenter sp)
	{
		presenter = sp;
	}

	@UiHandler(value = { "emailBox" })
	protected void onEmailBoxChange(KeyUpEvent event)
	{
		clearErrorState();
	}

	@UiHandler(value = { "nextButton" })
	protected void onNextButtonClicked(ClickEvent event)
	{
		if ((presenter != null) && (formIsValid()))
		{
			clearErrorState();

			nextButton.setEnabled(false);
			presenter.onNextButtonClicked();
		}
	}

	/**
	 * @return
	 */
	private boolean formIsValid()
	{
		Boolean retVal = true;

		if ((null == getEmailText()) || getEmailText().isEmpty() || (!emailWellFormatted()))
		{
			addMessage("A valid email is required to continue.");
			emailLabel.getElement().getStyle().setColor("red");
			retVal = false;
		}

		return retVal;
	}

	/**
	 * @return
	 */
	private Boolean emailWellFormatted()
	{
		Boolean retVal = false;

		if (getEmailText().matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$"))
		{
			retVal = true;
		}

		return retVal;
	}

	@Override
	public void setEmailText(String text)
	{
		this.emailBox.setValue(text, false);
	}

	@Override
	public String getEmailText()
	{
		return emailBox.getText().trim().toLowerCase();
	}

	@Override
	public void addMessage(String text)
	{
		if (text != null && !text.isEmpty())
		{
			messages.addMessageIfUnique(text);
			messages.setVisible(true);
		}
	}

	@Override
	public void setNextButtonActive(boolean b)
	{
		this.nextButton.setEnabled(b);
	}

	@Override
	public void clear()
	{
		setEmailText("");
		messages.clear();
	}

	private void clearErrorState()
	{
		// set things back to normal mode
		emailLabel.getElement().getStyle().setColor("black");
		messages.clear();
	}
}
