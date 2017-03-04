/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.event.dom.client.ClickEvent
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiHandler
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.Button com.google.gwt.user.client.ui.HTML
 * com.google.gwt.user.client.ui.TextBox com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.AbstractView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class StartViewImpl extends AbstractView implements StartViewI
{
	private static UiBinder<Widget, StartViewImpl> binder =  GWT
			.create( EnterViewImplBinder.class);
	@UiField
	HTML warning;
	@UiField
	TextBox emailBox;
	@UiField
	Button nextButton;
	private SequentialPresenterI presenter;

	public StartViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
		this.warning.setVisible(false);
	}

	@Override
	public void setPresenter(SequentialPresenterI presenter)
	{
		this.presenter = presenter;
	}

	@UiHandler(value = { "nextButton" })
	void onNextButtonClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		this.presenter.onNextButtonClicked();
	}

	@Override
	public void setEmailText(String text)
	{
		this.emailBox.setValue(text, false);
	}

	@Override
	public String getEmailText()
	{
		return this.emailBox.getText().trim().toLowerCase();
	}

	private void setWarningVisible(Boolean bool)
	{
		this.warning.setVisible(bool.booleanValue());
	}

	@Override
	public void setWarningText(String text)
	{
		if (text != null && !text.isEmpty())
		{
			this.warning.setHTML(text);
			this.setWarningVisible(true);
			return;
		}
		this.warning.setHTML("");
		this.setWarningVisible(false);
	}

	@Override
	public void setNextButtonActive(boolean b)
	{
		this.nextButton.setEnabled(b);
	}

	@Override
	public void clear()
	{
		this.setEmailText("");
		this.setWarningText("");
	}

	@UiTemplate(value = "StartView.ui.xml")
	static interface EnterViewImplBinder extends UiBinder<Widget, StartViewImpl>
	{
	}

}
