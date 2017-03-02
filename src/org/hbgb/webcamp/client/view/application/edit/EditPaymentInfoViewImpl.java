/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.CheckBox com.google.gwt.user.client.ui.TextBox
 * com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application.edit;

import java.util.Date;

import org.hbgb.webcamp.client.widget.TicketTypeListBox;
import org.hbgb.webcamp.shared.enums.TicketType;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class EditPaymentInfoViewImpl extends AbstractPartView implements IEditPaymentInfoView
{

	@UiTemplate(value = "EditPaymentInfoView.ui.xml")
	static interface EditPaymentInfoViewImplBinder extends UiBinder<Widget, EditPaymentInfoViewImpl>
	{
	}

	private static UiBinder<Widget, EditPaymentInfoViewImpl> binder = (UiBinder) GWT
			.create((Class) EditPaymentInfoViewImplBinder.class);

	@UiField
	CheckBox hasTicket;

	@UiField
	TicketTypeListBox ticketType;

	@UiField
	CheckBox hasBeenInvoiced;

	@UiField
	CheckBox hasPaidDues;

	@UiField
	TextBox paidDate;

	@UiField
	CheckBox wasSubsidized;

	@UiField
	TextBox subsidyAmt;

	@UiField
	TextBox subsidyReason;

	public EditPaymentInfoViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
		this.expand();
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
		if (d != null)
		{
			this.paidDate.setText(d.toString());
			return;
		}
		this.paidDate.setText("");
	}

	@Override
	public Date getPaidDate()
	{
		Date retVal = null;
		if (this.paidDate.getText().isEmpty())
			return retVal;
		return new Date(Date.parse(this.paidDate.getText()));
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

}
