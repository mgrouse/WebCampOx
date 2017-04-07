
package org.hbgb.webcamp.client.view.admin;

import org.hbgb.webcamp.client.view.AbstractView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class EarlyTeamMemberViewImpl extends AbstractView implements IEarlyTeamMemberView
{
	@UiTemplate(value = "EarlyTeamMemberView.ui.xml")
	static interface EarlyTeamMemberViewUiBinder extends UiBinder<Widget, EarlyTeamMemberViewImpl>
	{}

	private static EarlyTeamMemberViewUiBinder uiBinder = (EarlyTeamMemberViewUiBinder) GWT
			.create(EarlyTeamMemberViewUiBinder.class);

	@UiField
	TextBox emailBox;

	@UiField
	Button lookUpButton;

	@UiField
	TextBox firstNameBox;

	@UiField
	TextBox lastNameBox;

	@UiField
	TextBox playaNameBox;

	@UiField
	Button saveButton;

	@UiField
	Button cancelButton;

	private IEarlyTeamMemberView.Presenter presenter;

	public EarlyTeamMemberViewImpl()
	{
		this.initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(IEarlyTeamMemberView.Presenter presenter)
	{
		this.presenter = presenter;
	}

	@UiHandler(value = { "emailBox" })
	void onEmailBoxKeyUp(KeyUpEvent event)
	{
		this.lookUpButton.setEnabled(true);
	}

	@UiHandler(value = { "lookUpButton" })
	void onlookUpButtonClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		this.lookUpButton.setEnabled(false);
		this.presenter.onLookUpButtonClicked();
	}

	@UiHandler(value = { "saveButton" })
	void onSaveButtonClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		this.presenter.onSaveButtonClicked();
	}

	@Override
	public void setSaveButtonEnabled(Boolean bool)
	{
		this.saveButton.setEnabled(bool.booleanValue());
	}

	@UiHandler(value = { "cancelButton" })
	void onCancelButtonClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		this.presenter.onCancelButtonClicked();
	}

	@Override
	public void setFirstNameText(String firstName)
	{
		this.firstNameBox.setText(firstName);
	}

	@Override
	public String getFirstNameText()
	{
		return this.firstNameBox.getText();
	}

	@Override
	public void setLastNameText(String lastName)
	{
		this.lastNameBox.setText(lastName);
	}

	@Override
	public String getLastNameText()
	{
		return this.lastNameBox.getText();
	}

	@Override
	public String getPlayaNameText()
	{
		return this.playaNameBox.getText();
	}

	@Override
	public void setPlayaNameText(String playaName)
	{
		this.playaNameBox.setText(playaName);
	}

	@Override
	public void setEmailText(String email)
	{
		this.emailBox.setText(email);
	}

	@Override
	public String getEmailText()
	{
		return this.emailBox.getText();
	}

	@Override
	public void clear()
	{
		this.setEmailText("");
		this.setFirstNameText("");
		this.setLastNameText("");
		this.setPlayaNameText("");
		this.emailBox.setEnabled(true);
		this.lookUpButton.setEnabled(false);
		this.firstNameBox.setEnabled(false);
		this.lastNameBox.setEnabled(false);
		this.playaNameBox.setEnabled(false);
		this.saveButton.setEnabled(false);
	}

}
