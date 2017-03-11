/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.presenter.application.edit;

import org.hbgb.webcamp.client.model.PaymentInfoBlockModel;
import org.hbgb.webcamp.client.view.application.edit.EditPaymentInfoViewImpl;
import org.hbgb.webcamp.shared.PaymentInfoBlock;

public class EditPaymentInfoPresenter extends AbstractInfoBlockPresenter
{
	static EditPaymentInfoViewImpl view = new EditPaymentInfoViewImpl();
	static PaymentInfoBlockModel model = new PaymentInfoBlockModel();

	public EditPaymentInfoPresenter()
	{
		super(model, view);
	}

	@Override
	protected void setViewData()
	{
		PaymentInfoBlock paymentInfo = model.getData();
		view.setHasTicket(paymentInfo.getHasTicket());
		view.setTicketType(paymentInfo.getTicketType());
		// view.setHasBeenInvoiced(paymentInfo.getHasBeenInvoiced());
		// view.setHasPaidDues(paymentInfo.getHasPaidDues());
		// view.setPaidDate(paymentInfo.getPaidDate());
		// view.setWasSubsidized(paymentInfo.getWasHeeBeeSubsidized());
		// view.setSubsidyAmt(paymentInfo.getSubsidyAmt());
		// view.setSubsidyReason(paymentInfo.getSubsidyReason());
	}

	@Override
	protected void setModelData()
	{
		PaymentInfoBlock paymentInfo = model.getData();
		paymentInfo.setHasTicket(view.getHasTicket());
		paymentInfo.setTicketType(view.getTicketType());
		// paymentInfo.setHasBeenInvoiced(view.getHasBeenInvoiced());
		// paymentInfo.setHasPaidDues(view.getHasPaidDues());
		// paymentInfo.setPaidDate(view.getPaidDate());
		// paymentInfo.setWasHeeBeeSubsidized(view.getWasSubsidized());
		// paymentInfo.setSubsidyAmt(view.getSubsidyAmt());
		// paymentInfo.setSubsidyReason(view.getSubsidyReason());
	}
}
