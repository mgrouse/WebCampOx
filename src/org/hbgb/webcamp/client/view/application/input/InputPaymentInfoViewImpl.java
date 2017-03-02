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

import java.util.Date;

import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.AbstractView;
import org.hbgb.webcamp.client.widget.TicketTypeListBox;
import org.hbgb.webcamp.shared.enums.SecurityRole;
import org.hbgb.webcamp.shared.enums.TicketType;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;

public class InputPaymentInfoViewImpl extends AbstractView implements InputPaymentInfoView
{
	private static UiBinder<Widget, InputPaymentInfoViewImpl> binder = (UiBinder) GWT
			.create((Class) EditPaymentInfoViewImplBinder.class);
	@UiField
	HTMLPanel verifyWarning;
	@UiField
	CheckBox hasTicket;
	@UiField
	Label ticketTypeLabel;
	@UiField
	TicketTypeListBox ticketType;
	@UiField
	Panel payProcessPanel;
	@UiField
	CheckBox hasBeenInvoiced;
	@UiField
	CheckBox hasPaidDues;
	@UiField
	DatePicker paidDate;
	@UiField
	CheckBox wasSubsidized;
	@UiField
	TextBox subsidyAmt;
	@UiField
	TextBox subsidyReason;
	private SequentialPresenterI presenter;

	public InputPaymentInfoViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
		this.verifyWarning.setVisible(false);
	}

	@Override
	public void setPresenter(SequentialPresenterI presenter)
	{
		this.presenter = presenter;
	}

	@Override
	public void setVisibility(SecurityRole role)
	{
		if (role == SecurityRole.USER)
		{
			this.payProcessPanel.setVisible(false);
			return;
		}
		this.payProcessPanel.setVisible(true);
	}

	@UiHandler(value = { "nextButton" })
	void onNextButtonClicked(ClickEvent event)
	{
		if (this.isFormComplete() == false)
			return;
		if (this.presenter == null)
			return;
		this.presenter.onNextButtonClicked();
	}

	@Override
	public void setHasTicket(Boolean bool)
	{
		this.hasTicket.setValue(bool, false);
	}

	@Override
	public Boolean getHasTicket()
	{
		return this.hasTicket.getValue();
	}

	@Override
	public void setTicketType(TicketType type)
	{
		this.ticketType.setSelectedValue(type);
	}

	@Override
	public TicketType getTicketType()
	{
		return this.ticketType.getSelectedValue();
	}

	@Override
	public void setHasBeenInvoiced(Boolean bool)
	{
		this.hasBeenInvoiced.setValue(bool, false);
	}

	@Override
	public Boolean getHasBeenInvoiced()
	{
		return this.hasBeenInvoiced.getValue();
	}

	@Override
	public void setHasPaidDues(Boolean bool)
	{
		this.hasPaidDues.setValue(bool, false);
	}

	@Override
	public Boolean getHasPaidDues()
	{
		return this.hasPaidDues.getValue();
	}

	@Override
	public void setPaidDate(Date d)
	{
		this.paidDate.setValue(d, false);
	}

	@Override
	public Date getPaidDate()
	{
		return this.paidDate.getValue();
	}

	@Override
	public void setWasSubsidized(Boolean bool)
	{
		this.wasSubsidized.setValue(bool, false);
	}

	@Override
	public Boolean getWasSubsidized()
	{
		return this.wasSubsidized.getValue();
	}

	@Override
	public void setSubsidyAmt(Integer amt)
	{
		this.subsidyAmt.setValue(amt.toString(), false);
	}

	@Override
	public Integer getSubsidyAmt()
	{
		return Integer.valueOf(this.subsidyAmt.getValue());
	}

	@Override
	public void setSubsidyReason(String r)
	{
		this.subsidyReason.setValue(r, false);
	}

	@Override
	public String getSubsidyReason()
	{
		return this.subsidyReason.getValue();
	}

	@Override
	protected Boolean isFormComplete()
	{
		Boolean retVal = true;
		TicketType tt = this.getTicketType();
		if (tt != null)
			return retVal;
		retVal = false;
		this.ticketTypeLabel.getElement().getStyle().setColor("red");
		this.verifyWarning.setVisible(true);
		return retVal;
	}

	@UiTemplate(value = "InputPaymentInfoView.ui.xml")
	static interface EditPaymentInfoViewImplBinder
			extends UiBinder<Widget, InputPaymentInfoViewImpl>
	{
	}

}
