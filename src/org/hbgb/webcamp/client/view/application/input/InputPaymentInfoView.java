/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.IView;
import org.hbgb.webcamp.shared.enums.TicketType;

public interface InputPaymentInfoView extends IView
{
	public void setPresenter(SequentialPresenterI var1);

	public void setHasTicket(Boolean var1);

	public Boolean getHasTicket();

	public void setTicketType(TicketType var1);

	public TicketType getTicketType();
}
