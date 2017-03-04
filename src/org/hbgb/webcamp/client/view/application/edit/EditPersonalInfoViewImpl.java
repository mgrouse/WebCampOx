/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.TextArea com.google.gwt.user.client.ui.TextBox
 * com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application.edit;

import java.util.Date;

import org.hbgb.webcamp.client.widget.AddressWidget;
import org.hbgb.webcamp.client.widget.BirthDateWidget;
import org.hbgb.webcamp.client.widget.CallTimeListBox;
import org.hbgb.webcamp.client.widget.ContactMethodListBox;
import org.hbgb.webcamp.client.widget.GenderListBox;
import org.hbgb.webcamp.shared.Address;
import org.hbgb.webcamp.shared.enums.CallTime;
import org.hbgb.webcamp.shared.enums.ContactMethod;
import org.hbgb.webcamp.shared.enums.Gender;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class EditPersonalInfoViewImpl extends AbstractPartView implements IEditPersonalInfoView
{

	@UiTemplate(value = "EditPersonalInfoView.ui.xml")
	static interface EditPersonalInfoViewImplBinder
			extends UiBinder<Widget, EditPersonalInfoViewImpl>
	{
	}

	private static UiBinder<Widget, EditPersonalInfoViewImpl> binder =  GWT
			.create( EditPersonalInfoViewImplBinder.class);
	@UiField
	TextBox emailBox;
	@UiField
	TextBox firstNameBox;
	@UiField
	TextBox lastNameBox;
	@UiField
	TextBox playaNameBox;
	@UiField
	GenderListBox genderBox;
	@UiField
	BirthDateWidget birthDate;
	@UiField
	TextBox defaultWorldJobBox;
	@UiField
	TextArea bioBox;
	@UiField
	AddressWidget homeAddress;
	@UiField
	TextBox phoneBox;
	@UiField
	TextBox skypeNameBox;
	@UiField
	ContactMethodListBox contactMethodBox;
	@UiField
	CallTimeListBox contactTimeBox;

	public EditPersonalInfoViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
		this.expand();
	}

	@Override
	public void setEmailText(String text)
	{
		this.emailBox.setValue(text, false);
	}

	@Override
	public String getEmailText()
	{
		return this.emailBox.getText();
	}

	@Override
	public void setFirstNameText(String text)
	{
		this.firstNameBox.setText(text);
	}

	@Override
	public String getFirstNameText()
	{
		return this.firstNameBox.getText();
	}

	@Override
	public void setLastNameText(String text)
	{
		this.lastNameBox.setText(text);
	}

	@Override
	public String getLastNameText()
	{
		return this.lastNameBox.getText();
	}

	@Override
	public void setPlayaNameText(String text)
	{
		this.playaNameBox.setText(text);
	}

	@Override
	public String getPlayaNameText()
	{
		return this.playaNameBox.getText();
	}

	@Override
	public void setGender(Gender gender)
	{
		this.genderBox.setSelectedValue(gender);
	}

	@Override
	public Gender getGender()
	{
		return this.genderBox.getSelectedValue();
	}

	@Override
	public void setBirthDate(Date date)
	{
		this.birthDate.setSelectedValue(date);
	}

	@Override
	public Date getBirthDate()
	{
		return this.birthDate.getSelectedValue();
	}

	@Override
	public void setAddress(Address adress)
	{
		this.homeAddress.setAllValues(adress);
	}

	@Override
	public Address getAddress()
	{
		return this.homeAddress.getAllValues();
	}

	@Override
	public void setDefaultWorldJobText(String text)
	{
		this.defaultWorldJobBox.setText(text);
	}

	@Override
	public String getDefaultWorldJobText()
	{
		return this.defaultWorldJobBox.getText();
	}

	@Override
	public void setBioText(String text)
	{
		this.bioBox.setText(text);
	}

	@Override
	public String getBioText()
	{
		return this.bioBox.getText();
	}

	@Override
	public void setPhoneText(String text)
	{
		this.phoneBox.setText(text);
	}

	@Override
	public String getPhoneText()
	{
		return this.phoneBox.getText();
	}

	@Override
	public void setSkypeNameText(String text)
	{
		this.skypeNameBox.setText(text);
	}

	@Override
	public String getSkypeNameText()
	{
		return this.skypeNameBox.getText();
	}

	@Override
	public ContactMethod getContactMethod()
	{
		return this.contactMethodBox.getSelectedValue();
	}

	@Override
	public void setContactMethod(ContactMethod contactMethod)
	{
		this.contactMethodBox.setSelectedValue(contactMethod);
	}

	@Override
	public void setCallTime(CallTime time)
	{
		this.contactTimeBox.setSelectedValue(time);
	}

	@Override
	public CallTime getCallTime()
	{
		return this.contactTimeBox.getSelectedValue();
	}
}
