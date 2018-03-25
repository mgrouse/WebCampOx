/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.edit;

import java.util.Date;

import org.hbgb.webcamp.shared.enums.TicketType;

public interface IEditPaymentInfoView
{
	public void setHasTicket(Boolean var1);

	public Boolean getHasTicket();

	public void setTicketType(TicketType var1);

	public TicketType getTicketType();

	// public void setHasBeenInvoiced(Boolean var1);

	// public Boolean getHasBeenInvoiced();

	public void setHasPaidDues(Boolean var1);

	public Boolean getHasPaidDues();

	public void setPaidDate(Date var1);

	public Date getPaidDate();

	public void setWasSubsidized(Boolean var1);

	public Boolean getWasSubsidized();

	public void setSubsidyAmt(Integer var1);

	public Integer getSubsidyAmt();

	public void setSubsidyReason(String var1);

	public String getSubsidyReason();
}
