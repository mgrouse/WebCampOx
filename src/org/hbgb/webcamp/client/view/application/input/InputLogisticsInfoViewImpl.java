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

import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.client.view.AbstractView;
import org.hbgb.webcamp.client.widget.DayOfEventListBox;
import org.hbgb.webcamp.client.widget.MessagesWidget;
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
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class InputLogisticsInfoViewImpl extends AbstractView implements InputLogisticsInfoView
{
	@UiTemplate(value = "InputLogisticsInfoView.ui.xml")
	static interface InputLogisticsInfoViewImplBinder extends UiBinder<Widget, InputLogisticsInfoViewImpl>
	{}

	private static UiBinder<Widget, InputLogisticsInfoViewImpl> binder = GWT.create(InputLogisticsInfoViewImplBinder.class);

	@UiField
	MessagesWidget messages;

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

	@UiField
	Button nextButton;

	private ISequentialPresenter presenter;

	public InputLogisticsInfoViewImpl()
	{
		initWidget(binder.createAndBindUi(this));

		messages.setVisible(false);
		messages.clear();
		setAllLabelsNormal();
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
		if (isFormComplete() == true)
		{
			if (presenter != null)
			{
				presenter.onNextButtonClicked();
			}
		}
	}

	@Override
	public void setWantsEarlyTeam(Boolean bool)
	{
		wantsEarlyTeam.setValue(bool, false);
	}

	@Override
	public Boolean getWantsEarlyTeam()
	{
		return wantsEarlyTeam.getValue();
	}

	@Override
	public void setWantsStrikeTeam(Boolean bool)
	{
		wantsStrikeTeam.setValue(bool, false);
	}

	@Override
	public Boolean getWantsStrikeTeam()
	{
		return wantsStrikeTeam.getValue();
	}

	@Override
	public void setTransportation(Transportation t)
	{
		transportation.setSelectedValue(t);
	}

	@Override
	public Transportation getTransportation()
	{
		return transportation.getSelectedValue();
	}

	@Override
	public void setArrivalDate(DayOfEvent doe)
	{
		arrivalDoE.setSelectedValue(doe);
	}

	@Override
	public DayOfEvent getArrivalDate()
	{
		DayOfEvent doe = arrivalDoE.getSelectedValue();
		return doe;
	}

	@Override
	public void setArrivalTime(PlayaTime pt)
	{
		arrivalTime.setSelectedValue(pt);
	}

	@Override
	public PlayaTime getArrivalTime()
	{

		return arrivalTime.getSelectedValue();
	}

	@Override
	public void setDepartureDate(DayOfEvent doe)
	{
		departureDoE.setSelectedValue(doe);
	}

	@Override
	public DayOfEvent getDepartureDate()
	{
		return departureDoE.getSelectedValue();
	}

	@Override
	public void setDepartureTime(PlayaTime pt)
	{
		departureTime.setSelectedValue(pt);
	}

	@Override
	public PlayaTime getDepartureTime()
	{
		return departureTime.getSelectedValue();
	}

	@Override
	public void removeETDates()
	{
		arrivalDoE.removeETDates();
		departureDoE.removeETDates();
	}

	@Override
	protected Boolean isFormComplete()
	{
		Boolean retVal = true;

		setAllLabelsNormal();

		if (getArrivalDate() == null)
		{
			retVal = false;
			arrivalDayLabel.getElement().getStyle().setColor("red");
			addMessage("Please answer the questions in red.");
		}

		if (getArrivalTime() == null)
		{
			retVal = false;
			arrivalTimeLabel.getElement().getStyle().setColor("red");
			addMessage("Please answer the questions in red.");
		}

		if (getDepartureDate() == null)
		{
			retVal = false;
			departureDayLabel.getElement().getStyle().setColor("red");
			addMessage("Please answer the questions in red.");
		}

		if (getDepartureTime() == null)
		{
			retVal = false;
			departureTimeLabel.getElement().getStyle().setColor("red");
			addMessage("Please answer the questions in red.");
		}
		return retVal;
	}

	private void setAllLabelsNormal()
	{
		arrivalDayLabel.getElement().getStyle().setColor("black");
		arrivalTimeLabel.getElement().getStyle().setColor("black");
		departureDayLabel.getElement().getStyle().setColor("black");
		departureTimeLabel.getElement().getStyle().setColor("black");
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
