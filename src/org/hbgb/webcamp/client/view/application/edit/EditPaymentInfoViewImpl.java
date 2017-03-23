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

import org.hbgb.webcamp.client.widget.TicketTypeListBox;
import org.hbgb.webcamp.shared.enums.TicketType;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Widget;

public class EditPaymentInfoViewImpl extends AbstractPartView implements IEditPaymentInfoView
{

	@UiTemplate(value = "EditPaymentInfoView.ui.xml")
	static interface EditPaymentInfoViewImplBinder extends UiBinder<Widget, EditPaymentInfoViewImpl>
	{}

	private static UiBinder<Widget, EditPaymentInfoViewImpl> binder = GWT.create(EditPaymentInfoViewImplBinder.class);

	@UiField
	CheckBox hasTicket;

	@UiField
	TicketTypeListBox ticketType;

	// @UiField
	// CheckBox hasBeenInvoiced;
	//
	// @UiField
	// CheckBox hasPaidDues;
	//
	// @UiField
	// TextBox paidDate;
	//
	// @UiField
	// CheckBox wasSubsidized;
	//
	// @UiField
	// TextBox subsidyAmt;
	//
	// @UiField
	// TextBox subsidyReason;

	public EditPaymentInfoViewImpl()
	{
		initWidget(binder.createAndBindUi(this));
		expand();
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

	// @Override
	// public void setHasBeenInvoiced(Boolean bool)
	// {
	// hasBeenInvoiced.setValue(bool, false);
	// }
	//
	// @Override
	// public Boolean getHasBeenInvoiced()
	// {
	// return hasBeenInvoiced.getValue();
	// }
	//
	// @Override
	// public void setHasPaidDues(Boolean bool)
	// {
	// hasPaidDues.setValue(bool, false);
	// }
	//
	// @Override
	// public Boolean getHasPaidDues()
	// {
	// return hasPaidDues.getValue();
	// }
	//
	// @Override
	// public void setPaidDate(Date d)
	// {
	// if (d != null)
	// {
	// paidDate.setText(d.toString());
	// return;
	// }
	// paidDate.setText("");
	// }
	//
	// @Override
	// public Date getPaidDate()
	// {
	// Date retVal = null;
	// if (paidDate.getText().isEmpty())
	// return retVal;
	// return new Date(Date.parse(paidDate.getText()));
	// }
	//
	// @Override
	// public void setWasSubsidized(Boolean bool)
	// {
	// wasSubsidized.setValue(bool, false);
	// }
	//
	// @Override
	// public Boolean getWasSubsidized()
	// {
	// return wasSubsidized.getValue();
	// }
	//
	// @Override
	// public void setSubsidyAmt(Integer amt)
	// {
	// subsidyAmt.setValue(amt.toString(), false);
	// }
	//
	// @Override
	// public Integer getSubsidyAmt()
	// {
	// return Integer.valueOf(subsidyAmt.getValue());
	// }
	//
	// @Override
	// public void setSubsidyReason(String r)
	// {
	// subsidyReason.setValue(r, false);
	// }
	//
	// @Override
	// public String getSubsidyReason()
	// {
	// return subsidyReason.getValue();
	// }

}
