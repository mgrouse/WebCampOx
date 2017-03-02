/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.event.dom.client.ClickEvent
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiHandler
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.Button com.google.gwt.user.client.ui.CheckBox
 * com.google.gwt.user.client.ui.TextBox com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.admin;

import org.hbgb.webcamp.client.view.AbstractView;
import org.hbgb.webcamp.client.widget.SecurityRoleListBox;
import org.hbgb.webcamp.shared.enums.SecurityRole;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class UserEditViewImpl extends AbstractView implements IUserEditView
{
	@UiTemplate(value = "UserEditView.ui.xml")
	static interface UserEditViewUiBinder extends UiBinder<Widget, UserEditViewImpl>
	{
	}

	private static UserEditViewUiBinder uiBinder = GWT.create(UserEditViewUiBinder.class);

	@UiField
	TextBox firstNameBox;

	@UiField
	TextBox lastNameBox;

	@UiField
	TextBox playaNameBox;

	@UiField
	CheckBox etCheckBox;

	@UiField
	TextBox emailBox;

	@UiField
	TextBox passwordBox;

	@UiField
	SecurityRoleListBox securityRoleBox;

	@UiField
	Button saveButton;

	@UiField
	Button cancelButton;

	private IUserEditView.Presenter presenter;

	public UserEditViewImpl()
	{
		this.initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(IUserEditView.Presenter presenter)
	{
		this.presenter = presenter;
	}

	@UiHandler(value = { "saveButton" })
	void onSaveButtonClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		this.presenter.onSaveButtonClicked();
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
	public void setIsEarlyTeam(Boolean bool)
	{
		this.etCheckBox.setValue(bool, false);
	}

	@Override
	public Boolean getIsEarlyTeam()
	{
		return this.etCheckBox.getValue();
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
	public void setPasswordText(String password)
	{
		this.passwordBox.setValue(password, false);
	}

	@Override
	public String getPasswordText()
	{
		return this.passwordBox.getValue();
	}

	@Override
	public void setSecurityRole(SecurityRole securityRole)
	{
		this.securityRoleBox.setSelectedValue(securityRole);
	}

	@Override
	public SecurityRole getSecurityRole()
	{
		return this.securityRoleBox.getSelectedValue();
	}

	@Override
	public void clear()
	{
		this.setFirstNameText("");
		this.setLastNameText("");
		this.setPlayaNameText("");
		this.setIsEarlyTeam(false);
		this.setEmailText("");
		this.setPasswordText("");
		this.setSecurityRole(null);
	}

}
