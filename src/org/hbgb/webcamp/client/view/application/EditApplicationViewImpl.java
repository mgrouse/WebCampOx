/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.event.dom.client.ClickEvent
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiHandler
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.Button com.google.gwt.user.client.ui.HasWidgets
 * com.google.gwt.user.client.ui.VerticalPanel
 * com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application;

import org.hbgb.webcamp.client.presenter.IWholePresenter;
import org.hbgb.webcamp.client.view.AbstractView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class EditApplicationViewImpl extends AbstractView implements IEditApplicationView
{
	@UiTemplate(value = "EditApplicationView.ui.xml")
	static interface EditApplicationViewUiBinder extends UiBinder<Widget, EditApplicationViewImpl>
	{
	}

	private static EditApplicationViewUiBinder uiBinder = (EditApplicationViewUiBinder) GWT
			.create( EditApplicationViewUiBinder.class);

	@UiField
	Button prevButton;
	@UiField
	Button listButton;
	@UiField
	Button nextButton;
	@UiField
	VerticalPanel content;
	private IWholePresenter presenter;

	public EditApplicationViewImpl()
	{
		this.initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(IWholePresenter p)
	{
		this.presenter = p;
	}

	@UiHandler(value = { "prevButton" })
	@Override
	public void onPrevButtonClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		this.presenter.onPrevButtonClicked();
	}

	@Override
	public void setPrevButtonEnabled(Boolean enabled)
	{
		this.prevButton.setEnabled(enabled.booleanValue());
	}

	@UiHandler(value = { "listButton" })
	@Override
	public void onListButtonClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		this.presenter.onListButtonClicked();
	}

	@Override
	public void setListButtonEnabled(Boolean enabled)
	{
		this.listButton.setEnabled(enabled.booleanValue());
	}

	@UiHandler(value = { "nextButton" })
	@Override
	public void onNextButtonClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		this.presenter.onNextButtonClicked();
	}

	@Override
	public void setNextButtonEnabled(Boolean enabled)
	{
		this.nextButton.setEnabled(enabled.booleanValue());
	}

	@Override
	public HasWidgets getScreen()
	{
		return this.content;
	}

	@Override
	public void clear()
	{
	}

}
