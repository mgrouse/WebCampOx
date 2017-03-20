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
 * com.google.gwt.user.client.ui.HTMLPanel
 * com.google.gwt.user.client.ui.TextArea com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.client.view.AbstractView;
import org.hbgb.webcamp.client.widget.MessagesWidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class InputShelterInfoViewImpl extends AbstractView implements InputShelterInfoView
{
	@UiTemplate(value = "InputShelterInfoView.ui.xml")
	static interface InputShelterInfoViewBinder extends UiBinder<Widget, InputShelterInfoViewImpl>
	{}

	private static UiBinder<Widget, InputShelterInfoViewImpl> binder = GWT.create(InputShelterInfoViewBinder.class);

	@UiField
	MessagesWidget messages;

	@UiField
	Label hsRvLabel;

	@UiField
	CheckBox hasRv;

	@UiField
	TextArea rvInfo;

	@UiField
	Label isInDormTentLabel;

	@UiField
	CheckBox isInDormTent;

	@UiField
	Label hasStructureLabel;

	@UiField
	CheckBox hasStructure;

	@UiField
	TextArea structureInfo;

	@UiField
	Button nextButton;

	private ISequentialPresenter presenter;

	public InputShelterInfoViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(ISequentialPresenter presenter)
	{
		this.presenter = presenter;
	}

	@UiHandler(value = { "nextButton" })
	void onNextButtonClicked(ClickEvent event)
	{
		if (presenter != null)
		{
			if (isFormComplete())
			{
				presenter.onNextButtonClicked();
			}
		}
	}

	@Override
	public void setHasRv(Boolean bool)
	{
		this.hasRv.setValue(bool, false);
	}

	@Override
	public Boolean getHasRv()
	{
		return this.hasRv.getValue();
	}

	@Override
	public void setRvInfoText(String text)
	{
		this.rvInfo.setText(text);
	}

	@Override
	public String getRvInfoText()
	{
		return this.rvInfo.getText();
	}

	@Override
	public void setIsInDormTent(Boolean bool)
	{
		this.isInDormTent.setValue(bool, false);
	}

	@Override
	public Boolean getIsInDormTent()
	{
		return this.isInDormTent.getValue();
	}

	@Override
	public void setHasStructure(Boolean bool)
	{
		this.hasStructure.setValue(bool, false);
	}

	@Override
	public Boolean getHasStructure()
	{
		return this.hasStructure.getValue();
	}

	@Override
	public void setStructureInfoText(String text)
	{
		this.structureInfo.setText(text);
	}

	@Override
	public String getStructureInfoText()
	{
		return this.structureInfo.getText();
	}

	protected Boolean isFormComplete()
	{
		Boolean retVal = true;

		if (!getHasRv() && !getIsInDormTent() && !getHasStructure())
		{
			retVal = false;

			this.hsRvLabel.getElement().getStyle().setColor("red");
			this.isInDormTentLabel.getElement().getStyle().setColor("red");
			this.hasStructureLabel.getElement().getStyle().setColor("red");

			messages.addMessageIfUnique("Please pick at least one option in red");
		}

		// if rv is checked better have a rvInfo

		// if Structure is checked better have a structureInfo

		return retVal;
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
