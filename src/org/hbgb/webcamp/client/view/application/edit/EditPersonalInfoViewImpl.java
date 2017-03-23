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
	static interface EditPersonalInfoViewImplBinder extends UiBinder<Widget, EditPersonalInfoViewImpl>
	{}

	private static UiBinder<Widget, EditPersonalInfoViewImpl> binder = GWT.create(EditPersonalInfoViewImplBinder.class);

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
		initWidget(binder.createAndBindUi(this));
		expand();
	}

	@Override
	public void setEmailText(String text)
	{
		emailBox.setValue(text, false);
	}

	@Override
	public String getEmailText()
	{
		return emailBox.getText();
	}

	@Override
	public void setFirstNameText(String text)
	{
		firstNameBox.setText(text);
	}

	@Override
	public String getFirstNameText()
	{
		return firstNameBox.getText();
	}

	@Override
	public void setLastNameText(String text)
	{
		lastNameBox.setText(text);
	}

	@Override
	public String getLastNameText()
	{
		return lastNameBox.getText();
	}

	@Override
	public void setPlayaNameText(String text)
	{
		playaNameBox.setText(text);
	}

	@Override
	public String getPlayaNameText()
	{
		return playaNameBox.getText();
	}

	@Override
	public void setGender(Gender gender)
	{
		genderBox.setSelectedValue(gender);
	}

	@Override
	public Gender getGender()
	{
		return genderBox.getSelectedEnumValue();
	}

	@Override
	public void setBirthDate(Date date)
	{
		birthDate.setSelectedValue(date);
	}

	@Override
	public Date getBirthDate()
	{
		return birthDate.getSelectedValue();
	}

	@Override
	public void setAddress(Address adress)
	{
		homeAddress.setAllValues(adress);
	}

	@Override
	public Address getAddress()
	{
		return homeAddress.getAllValues();
	}

	@Override
	public void setDefaultWorldJobText(String text)
	{
		defaultWorldJobBox.setText(text);
	}

	@Override
	public String getDefaultWorldJobText()
	{
		return defaultWorldJobBox.getText();
	}

	@Override
	public void setBioText(String text)
	{
		bioBox.setText(text);
	}

	@Override
	public String getBioText()
	{
		return bioBox.getText();
	}

	@Override
	public void setPhoneText(String text)
	{
		phoneBox.setText(text);
	}

	@Override
	public String getPhoneText()
	{
		return phoneBox.getText();
	}

	@Override
	public void setSkypeNameText(String text)
	{
		skypeNameBox.setText(text);
	}

	@Override
	public String getSkypeNameText()
	{
		return skypeNameBox.getText();
	}

	@Override
	public ContactMethod getContactMethod()
	{
		return contactMethodBox.getSelectedEnumValue();
	}

	@Override
	public void setContactMethod(ContactMethod contactMethod)
	{
		contactMethodBox.setSelectedValue(contactMethod);
	}

	@Override
	public void setCallTime(CallTime time)
	{
		contactTimeBox.setSelectedValue(time);
	}

	@Override
	public CallTime getCallTime()
	{
		return contactTimeBox.getSelectedEnumValue();
	}
}
