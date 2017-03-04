/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.dom.client.Style com.google.gwt.event.dom.client.ClickEvent
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiHandler
 * com.google.gwt.uibinder.client.UiTemplate com.google.gwt.user.client.Element
 * com.google.gwt.user.client.ui.CheckBox com.google.gwt.user.client.ui.HTML
 * com.google.gwt.user.client.ui.HTMLPanel com.google.gwt.user.client.ui.Label
 * com.google.gwt.user.client.ui.Panel com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.AbstractView;
import org.hbgb.webcamp.client.widget.DayOfEventListBox;
import org.hbgb.webcamp.client.widget.PlayaTimeListBox;
import org.hbgb.webcamp.client.widget.TransportationListBox;
import org.hbgb.webcamp.shared.enums.DayOfEvent;
import org.hbgb.webcamp.shared.enums.PlayaTime;
import org.hbgb.webcamp.shared.enums.SecurityRole;
import org.hbgb.webcamp.shared.enums.Transportation;

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

public class InputLogisticsInfoViewImpl extends AbstractView implements InputLogisticsInfoView
{
	@UiTemplate(value = "InputLogisticsInfoView.ui.xml")
	static interface InputLogisticsInfoViewImplBinder extends UiBinder<Widget, InputLogisticsInfoViewImpl>
	{}

	private static UiBinder<Widget, InputLogisticsInfoViewImpl> binder = GWT.create(InputLogisticsInfoViewImplBinder.class);

	@UiField
	HTMLPanel verifyWarning;

	@UiField
	CheckBox wantsEarlyTeam;

	@UiField
	CheckBox wantsStrikeTeam;

	@UiField
	Label transportationLabel;

	@UiField
	TransportationListBox transportation;

	@UiField
	Label arrivalDayLabel;

	@UiField
	DayOfEventListBox arrivalDoE;

	@UiField
	Label arrivalTimeLabel;

	@UiField
	PlayaTimeListBox arrivalTime;

	@UiField
	Label departureDayLabel;

	@UiField
	DayOfEventListBox departureDoE;

	@UiField
	Label departureTimeLabel;

	@UiField
	PlayaTimeListBox departureTime;

	private SequentialPresenterI presenter;

	public InputLogisticsInfoViewImpl()
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
	public void setWantsEarlyTeam(Boolean bool)
	{
		this.wantsEarlyTeam.setValue(bool, false);
	}

	@Override
	public Boolean getWantsEarlyTeam()
	{
		return this.wantsEarlyTeam.getValue();
	}

	@Override
	public void setWantsStrikeTeam(Boolean bool)
	{
		this.wantsStrikeTeam.setValue(bool, false);
	}

	@Override
	public Boolean getWantsStrikeTeam()
	{
		return this.wantsStrikeTeam.getValue();
	}

	@Override
	public void setTransportation(Transportation t)
	{
		this.transportation.setSelectedValue(t);
	}

	@Override
	public Transportation getTransportation()
	{
		return this.transportation.getSelectedValue();
	}

	@Override
	public void setArrivalDate(DayOfEvent doe)
	{
		this.arrivalDoE.setSelectedValue(doe);
	}

	@Override
	public DayOfEvent getArrivalDate()
	{
		return this.arrivalDoE.getSelectedValue();
	}

	@Override
	public void setArrivalTime(PlayaTime pt)
	{
		this.arrivalTime.setSelectedValue(pt);
	}

	@Override
	public PlayaTime getArrivalTime()
	{
		return this.arrivalTime.getSelectedValue();
	}

	@Override
	public void setDepartureDate(DayOfEvent doe)
	{
		this.departureDoE.setSelectedValue(doe);
	}

	@Override
	public DayOfEvent getDepartureDate()
	{
		return this.departureDoE.getSelectedValue();
	}

	@Override
	public void setDepartureTime(PlayaTime pt)
	{
		this.departureTime.setSelectedValue(pt);
	}

	@Override
	public PlayaTime getDepartureTime()
	{
		return this.departureTime.getSelectedValue();
	}

	@Override
	protected Boolean isFormComplete()
	{
		Boolean retVal = true;

		DayOfEvent day = this.getArrivalDate();
		if (day == null)
		{
			retVal = false;
			this.arrivalDayLabel.getElement().getStyle().setColor("red");
			this.verifyWarning.setVisible(true);
		}

		if (getArrivalTime() == null)
		{
			retVal = false;
			this.arrivalTimeLabel.getElement().getStyle().setColor("red");
			this.verifyWarning.setVisible(true);
		}

		if (getDepartureDate() == null)
		{
			retVal = false;
			this.departureDayLabel.getElement().getStyle().setColor("red");
			this.verifyWarning.setVisible(true);
		}

		if (getDepartureTime() != null)
			return retVal;
		retVal = false;
		this.departureTimeLabel.getElement().getStyle().setColor("red");
		this.verifyWarning.setVisible(true);
		return retVal;
	}

}
