/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.event.shared.GwtEvent
 * com.google.gwt.event.shared.HandlerManager
 * com.google.gwt.user.client.ui.HasWidgets com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.application;

import java.util.List;
import java.util.ListIterator;

import org.hbgb.webcamp.client.event.application.ListApplicationEvent;
import org.hbgb.webcamp.client.presenter.IWholePresenter;
import org.hbgb.webcamp.client.presenter.application.edit.AbstractInfoBlockPresenter;
import org.hbgb.webcamp.client.presenter.application.edit.EditApplicationInfoPresenter;
import org.hbgb.webcamp.client.presenter.application.edit.EditCommitteeInfoPresenter;
import org.hbgb.webcamp.client.presenter.application.edit.EditDietInfoPresenter;
import org.hbgb.webcamp.client.presenter.application.edit.EditLogisticsInfoPresenter;
import org.hbgb.webcamp.client.presenter.application.edit.EditPaymentInfoPresenter;
import org.hbgb.webcamp.client.presenter.application.edit.EditPersonalInfoPresenter;
import org.hbgb.webcamp.client.presenter.application.edit.EditShelterInfoPresenter;
import org.hbgb.webcamp.client.view.application.EditApplicationViewImpl;
import org.hbgb.webcamp.client.view.application.IEditApplicationView;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public class EditWholeApplicationPresenter implements IWholePresenter
{
	private final HandlerManager eventBus;
	IEditApplicationView view;
	EditApplicationInfoPresenter appPresenter;
	EditCommitteeInfoPresenter committeePresenter;
	EditDietInfoPresenter dietPresenter;
	EditLogisticsInfoPresenter logisticsPresenter;
	EditPaymentInfoPresenter paymentPresenter;
	EditPersonalInfoPresenter personalPresenter;
	EditShelterInfoPresenter shelterPresenter;
	private String key;
	private List<String> list;
	private HasWidgets screen;

	public EditWholeApplicationPresenter(HandlerManager eventBus)
	{
		this.eventBus = eventBus;
		this.view = new EditApplicationViewImpl();
		this.view.setPresenter(this);
		this.appPresenter = new EditApplicationInfoPresenter();
		this.appPresenter.setScreen(this.view.getScreen());

		this.personalPresenter = new EditPersonalInfoPresenter();
		this.personalPresenter.setScreen(this.view.getScreen());

		this.paymentPresenter = new EditPaymentInfoPresenter();
		this.paymentPresenter.setScreen(this.view.getScreen());

		this.committeePresenter = new EditCommitteeInfoPresenter();
		this.committeePresenter.setScreen(this.view.getScreen());

		this.dietPresenter = new EditDietInfoPresenter();
		this.dietPresenter.setScreen(this.view.getScreen());

		this.logisticsPresenter = new EditLogisticsInfoPresenter();
		this.logisticsPresenter.setScreen(this.view.getScreen());

		this.shelterPresenter = new EditShelterInfoPresenter();
		this.shelterPresenter.setScreen(this.view.getScreen());
	}

	@Override
	public void setKey(String key)
	{
		this.key = key;
		this.appPresenter.setKey(key);
		this.personalPresenter.setKey(key);
		this.paymentPresenter.setKey(key);
		this.committeePresenter.setKey(key);
		this.dietPresenter.setKey(key);
		this.logisticsPresenter.setKey(key);
		this.shelterPresenter.setKey(key);
	}

	@Override
	public void setKeyList(List<String> list)
	{
		this.list = list;
		ListIterator<String> iterator = list.listIterator(list.indexOf(this.key));
		iterator.next();
		this.setNextPrevButtonState(iterator);
	}

	@Override
	public void setScreen(HasWidgets container)
	{
		this.screen = container;
		this.screen.add(this.view.asWidget());
	}

	@Override
	public void onPrevButtonClicked()
	{
		ListIterator<String> iterator = this.list.listIterator(this.list.indexOf(this.key));
		if (iterator.hasPrevious())
		{
			this.setKey(iterator.previous());
		}
		iterator.next();
		this.setNextPrevButtonState(iterator);
	}

	@Override
	public void onListButtonClicked()
	{
		this.eventBus.fireEvent(new ListApplicationEvent());
	}

	@Override
	public void onNextButtonClicked()
	{
		ListIterator<String> iterator = this.list.listIterator(this.list.indexOf(this.key));
		iterator.next();
		if (iterator.hasNext())
		{
			this.setKey(iterator.next());
		}
		this.setNextPrevButtonState(iterator);
	}

	private void setNextPrevButtonState(ListIterator<String> iterator)
	{
		if (iterator.hasNext())
		{
			this.view.setNextButtonEnabled(true);
		}
		else
		{
			this.view.setNextButtonEnabled(false);
		}
		iterator.previous();
		if (iterator.hasPrevious())
		{
			this.view.setPrevButtonEnabled(true);
			return;
		}
		this.view.setPrevButtonEnabled(false);
	}

	@Override
	public void setParts(List<AbstractInfoBlockPresenter> parts)
	{}
}
