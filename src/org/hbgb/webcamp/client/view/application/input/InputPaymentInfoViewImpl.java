/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.dom.client.Style com.google.gwt.event.dom.client.ClickEvent
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiHandler
 * com.google.gwt.uibinder.client.UiTemplate com.google.gwt.user.client.Element
 * com.google.gwt.user.client.ui.CheckBox
 * com.google.gwt.user.client.ui.HTMLPanel com.google.gwt.user.client.ui.Label
 * com.google.gwt.user.client.ui.Panel com.google.gwt.user.client.ui.TextBox
 * com.google.gwt.user.client.ui.Widget
 * com.google.gwt.user.datepicker.client.DatePicker
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.client.view.AbstractView;
import org.hbgb.webcamp.client.widget.MessagesWidget;
import org.hbgb.webcamp.client.widget.TicketTypeListBox;
import org.hbgb.webcamp.shared.enums.SecurityRole;
import org.hbgb.webcamp.shared.enums.TicketType;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class InputPaymentInfoViewImpl extends AbstractView implements InputPaymentInfoView
{
	@UiTemplate(value = "InputPaymentInfoView.ui.xml")
	static interface EditPaymentInfoViewImplBinder extends UiBinder<Widget, InputPaymentInfoViewImpl>
	{}

	private static UiBinder<Widget, InputPaymentInfoViewImpl> binder = GWT.create(EditPaymentInfoViewImplBinder.class);

	@UiField
	MessagesWidget messages;

	@UiField
	CheckBox hasTicket;

	@UiField
	Label ticketTypeLabel;

	@UiField
	TicketTypeListBox ticketType;

	@UiField
	Button nextButton;

	private ISequentialPresenter presenter;

	public InputPaymentInfoViewImpl()
	{
		initWidget(binder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(ISequentialPresenter sp)
	{
		presenter = sp;
	}

	@Override
	public void setVisibility(SecurityRole role)
	{

	}

	@UiHandler(value = { "nextButton" })
	void onNextButtonClicked(ClickEvent event)
	{
		if (presenter != null)
		{
			if (isFormComplete())
			{
				presenter.onNextButtonClicked();
			}
		}
	}

	@Override
	public void setHasTicket(Boolean bool)
	{
		hasTicket.setValue(bool, false);
	}

	@Override
	public Boolean getHasTicket()
	{
		return hasTicket.getValue();
	}

	@Override
	public void setTicketType(TicketType type)
	{
		ticketType.setSelectedValue(type);
	}

	@Override
	public TicketType getTicketType()
	{
		return ticketType.getSelectedEnumValue();
	}

	protected Boolean isFormComplete()
	{
		Boolean retVal = true;
		TicketType tt = getTicketType();

		if (tt == null)
		{
			retVal = false;

			ticketTypeLabel.getElement().getStyle().setColor("red");
			messages.addMessage("Please answer the question(s) in red");
		}
		return retVal;
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
		nextButton.setEnabled(b);
	}
}
