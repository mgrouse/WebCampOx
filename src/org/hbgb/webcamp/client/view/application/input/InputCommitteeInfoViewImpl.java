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

import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.AbstractView;
import org.hbgb.webcamp.client.widget.CommitteeListBox;
import org.hbgb.webcamp.shared.enums.Committee;
import org.hbgb.webcamp.shared.enums.SecurityRole;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
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
	CommitteeListBox committee1;

	@UiField
	TextArea reason1;

	@UiField
	CommitteeListBox committee2;

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

	private SequentialPresenterI presenter;

	public InputCommitteeInfoViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
		this.healerSheetPanel.setVisible(false);
		this.reason1.getElement().setAttribute("maxlength", "250");
		this.reason2.getElement().setAttribute("maxlength", "250");
		this.bioBox.getElement().setAttribute("maxlength", "500");
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

	@UiHandler(value = { "committee1", "committee2" })
	void onCommitteeChosen(ChangeEvent event)
	{
		this.setHealerSheetPanelVisibility();
	}

	@UiHandler(value = { "nextButton" })
	void onNextButtonClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		this.presenter.onNextButtonClicked();
	}

	private void setHealerSheetPanelVisibility()
	{
		if (this.committee1.getSelectedValue() != Committee.Healers && this.committee2.getSelectedValue() != Committee.Healers)
		{
			this.healerSheetPanel.setVisible(false);
			return;
		}
		this.healerSheetPanel.setVisible(true);
	}

	@Override
	public void setCommittee1(Committee c)
	{
		this.committee1.setSelectedValue(c);
		this.setHealerSheetPanelVisibility();
	}

	@Override
	public Committee getCommittee1()
	{
		return this.committee1.getSelectedValue();
	}

	@Override
	public void setReason1(String text)
	{
		this.reason1.setValue(text, false);
	}

	@Override
	public String getReason1()
	{
		return this.reason1.getText();
	}

	@Override
	public void setCommittee2(Committee c)
	{
		this.committee2.setSelectedValue(c);
		this.setHealerSheetPanelVisibility();
	}

	@Override
	public Committee getCommittee2()
	{
		return this.committee2.getSelectedValue();
	}

	@Override
	public void setReason2(String text)
	{
		this.reason2.setValue(text, false);
	}

	@Override
	public String getReason2()
	{
		return this.reason2.getText();
	}

	@Override
	public void setSessionLength(String text)
	{
		this.sessionLength.setText(text);
	}

	@Override
	public String getSessionLength()
	{
		return this.sessionLength.getText();
	}

	@Override
	public void setModality1(String text)
	{
		this.modality1.setText(text);
	}

	@Override
	public String getModality1()
	{
		return this.modality1.getText();
	}

	@Override
	public void setModality2(String text)
	{
		this.modality2.setText(text);
	}

	@Override
	public String getModality2()
	{
		return this.modality2.getText();
	}

	@Override
	public void setModality3(String text)
	{
		this.modality3.setText(text);
	}

	@Override
	public String getModality3()
	{
		return this.modality3.getText();
	}

	@Override
	public void setModality4(String text)
	{
		this.modality4.setText(text);
	}

	@Override
	public String getModality4()
	{
		return this.modality4.getText();
	}

	@Override
	public void setBioBoxText(String text)
	{
		this.bioBox.setValue(text, false);
	}

	@Override
	public String getBioBoxText()
	{
		return this.bioBox.getText();
	}

	@Override
	public void clear()
	{
		this.setModality1("");
		this.setModality2("");
		this.setModality3("");
		this.setModality4("");
	}

}
