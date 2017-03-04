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
import com.google.gwt.user.client.ui.Widget;

public class InputPaymentInfoViewImpl extends AbstractView implements InputPaymentInfoView
{
	private static UiBinder<Widget, InputPaymentInfoViewImpl> binder =  GWT
			.create( EditPaymentInfoViewImplBinder.class);
	@UiField
	HTMLPanel verifyWarning;

	@UiField
	CheckBox hasTicket;

	@UiField
	Label ticketTypeLabel;

	@UiField
	TicketTypeListBox ticketType;

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
