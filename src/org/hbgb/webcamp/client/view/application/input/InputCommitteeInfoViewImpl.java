/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.event.dom.client.ChangeEvent
 * com.google.gwt.event.dom.client.ClickEvent
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiHandler
 * com.google.gwt.uibinder.client.UiTemplate com.google.gwt.user.client.Element
 * com.google.gwt.user.client.ui.CheckBox com.google.gwt.user.client.ui.Panel
 * com.google.gwt.user.client.ui.TextArea com.google.gwt.user.client.ui.TextBox
 * com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.client.view.AbstractView;
import org.hbgb.webcamp.client.widget.EnumListBox;
import org.hbgb.webcamp.client.widget.MessagesWidget;
import org.hbgb.webcamp.shared.enums.Committee;
import org.hbgb.webcamp.shared.enums.SecurityRole;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class InputCommitteeInfoViewImpl extends AbstractView implements InputCommitteeInfoView
{
	@UiTemplate(value = "InputCommitteeInfoView.ui.xml")
	static interface EditComitteeInfoViewImplBinder extends UiBinder<Widget, InputCommitteeInfoViewImpl>
	{}

	private static UiBinder<Widget, InputCommitteeInfoViewImpl> binder = GWT.create(EditComitteeInfoViewImplBinder.class);

	@UiField
	MessagesWidget messages;

	@UiField
	EnumListBox<Committee> committee1;

	@UiField
	TextArea reason1;

	@UiField
	EnumListBox<Committee> committee2;

	@UiField
	TextArea reason2;

	@UiField
	Panel healerSheetPanel;

	@UiField
	TextBox sessionLength;

	@UiField
	TextBox modality1;

	@UiField
	TextBox modality2;

	@UiField
	TextBox modality3;

	@UiField
	TextBox modality4;

	@UiField
	TextArea bioBox;

	@UiField
	Button nextButton;

	private ISequentialPresenter presenter;

	public InputCommitteeInfoViewImpl()
	{
		initWidget(binder.createAndBindUi(this));
		healerSheetPanel.setVisible(false);
		reason1.getElement().setAttribute("maxlength", "250");
		reason2.getElement().setAttribute("maxlength", "250");
		bioBox.getElement().setAttribute("maxlength", "500");
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

	@UiHandler(value = { "committee1", "committee2" })
	void onCommitteeChosen(ChangeEvent event)
	{
		setHealerSheetPanelVisibility();
	}

	@UiHandler(value = { "nextButton" })
	void onNextButtonClicked(ClickEvent event)
	{
		if (presenter == null)
			return;
		presenter.onNextButtonClicked();
	}

	private void setHealerSheetPanelVisibility()
	{
		if (committee1.getSelectedEnumValue() == Committee.Healers || committee2.getSelectedEnumValue() == Committee.Healers)
		{
			healerSheetPanel.setVisible(true);
		}
		else
		{
			healerSheetPanel.setVisible(false);
		}

	}

	@Override
	public void setCommittee1(Committee c)
	{
		committee1.setSelectedValue(c);
		setHealerSheetPanelVisibility();
	}

	@Override
	public Committee getCommittee1()
	{
		return committee1.getSelectedEnumValue();
	}

	@Override
	public void setReason1(String text)
	{
		reason1.setValue(text, false);
	}

	@Override
	public String getReason1()
	{
		return reason1.getText();
	}

	@Override
	public void setCommittee2(Committee c)
	{
		committee2.setSelectedValue(c);
		setHealerSheetPanelVisibility();
	}

	@Override
	public Committee getCommittee2()
	{
		return committee2.getSelectedEnumValue();
	}

	@Override
	public void setReason2(String text)
	{
		reason2.setValue(text, false);
	}

	@Override
	public String getReason2()
	{
		return reason2.getText();
	}

	@Override
	public void setSessionLength(String text)
	{
		sessionLength.setText(text);
	}

	@Override
	public String getSessionLength()
	{
		return sessionLength.getText();
	}

	@Override
	public void setModality1(String text)
	{
		modality1.setText(text);
	}

	@Override
	public String getModality1()
	{
		return modality1.getText();
	}

	@Override
	public void setModality2(String text)
	{
		modality2.setText(text);
	}

	@Override
	public String getModality2()
	{
		return modality2.getText();
	}

	@Override
	public void setModality3(String text)
	{
		modality3.setText(text);
	}

	@Override
	public String getModality3()
	{
		return modality3.getText();
	}

	@Override
	public void setModality4(String text)
	{
		modality4.setText(text);
	}

	@Override
	public String getModality4()
	{
		return modality4.getText();
	}

	@Override
	public void setBioBoxText(String text)
	{
		bioBox.setValue(text, false);
	}

	@Override
	public String getBioBoxText()
	{
		return bioBox.getText();
	}

	@Override
	public void clear()
	{
		setModality1("");
		setModality2("");
		setModality3("");
		setModality4("");
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

	@UiFactory
	EnumListBox<Committee> callTimeListBoxFactory()
	{
		return new EnumListBox<>(Committee.class);
	}

}
