/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.event.dom.client.ClickEvent
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiHandler com.google.gwt.user.client.ui.Button
 * com.google.gwt.user.client.ui.HorizontalPanel
 * com.google.gwt.user.client.ui.VerticalPanel
 */
package org.hbgb.webcamp.client.view.application.edit;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.hbgb.webcamp.client.presenter.IPartPresenter;
import org.hbgb.webcamp.client.view.AbstractView;
import org.hbgb.webcamp.client.view.IPartView;

public abstract class AbstractPartView extends AbstractView implements IPartView
{
	Boolean isExpanded = false;
	@UiField
	public VerticalPanel form;
	@UiField
	public HorizontalPanel buttonPanel;
	@UiField
	public Button expandButton;
	@UiField
	public Button editButton;
	@UiField
	public Button saveButton;
	protected IPartPresenter presenter;

	@Override
	public void setPresenter(IPartPresenter p)
	{
		this.presenter = p;
	}

	@Override
	public void expand()
	{
		this.isExpanded = true;
		this.form.setVisible(true);
		this.expandButton.setHTML("-");
	}

	@Override
	public void contract()
	{
		this.isExpanded = false;
		this.form.setVisible(false);
		this.expandButton.setHTML("+");
	}

	@Override
	public boolean isExpanded()
	{
		return this.isExpanded;
	}

	@UiHandler(value = { "expandButton" })
	@Override
	public void onExpandButtonClicked(ClickEvent event)
	{
		if (this.presenter != null)
		{
			this.presenter.onExpandButtonClicked();
		}
		if (this.isExpanded.booleanValue())
		{
			this.contract();
			return;
		}
		this.expand();
	}

	@UiHandler(value = { "editButton" })
	@Override
	public void onEditButtonClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		this.setEditButtonEnabled(false);
		this.presenter.onEditButtonClicked();
		this.setSaveButtonEnabled(true);
	}

	@UiHandler(value = { "saveButton" })
	@Override
	public void onSaveButtonClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		this.setSaveButtonEnabled(false);
		this.presenter.onSaveButtonClicked();
	}

	@Override
	public void setExpandButtonEnabled(Boolean enabled)
	{
		this.expandButton.setEnabled(enabled.booleanValue());
	}

	@Override
	public void setEditButtonEnabled(Boolean enabled)
	{
		this.editButton.setEnabled(enabled.booleanValue());
	}

	@Override
	public void setSaveButtonEnabled(Boolean enabled)
	{
		this.saveButton.setEnabled(enabled.booleanValue());
	}
}
