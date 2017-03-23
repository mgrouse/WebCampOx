/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.event.dom.client.ClickEvent
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiHandler
 * com.google.gwt.uibinder.client.UiTemplate com.google.gwt.user.client.Element
 * com.google.gwt.user.client.ui.Button com.google.gwt.user.client.ui.TextArea
 * com.google.gwt.user.client.ui.TextBox com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application.input;

import java.util.Date;

import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.client.view.AbstractView;
import org.hbgb.webcamp.client.widget.AddressWidget;
import org.hbgb.webcamp.client.widget.BirthDateWidget;
import org.hbgb.webcamp.client.widget.EnumListBox;
import org.hbgb.webcamp.client.widget.MessagesWidget;
import org.hbgb.webcamp.shared.Address;
import org.hbgb.webcamp.shared.enums.CallTime;
import org.hbgb.webcamp.shared.enums.ContactMethod;
import org.hbgb.webcamp.shared.enums.Gender;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class InputPersonalInfoViewImpl extends AbstractView implements InputPersonalInfoView
{
	@UiTemplate(value = "InputPersonalInfoView.ui.xml")
	static interface InputPersonalInfoViewImplBinder extends UiBinder<Widget, InputPersonalInfoViewImpl>
	{}

	private static UiBinder<Widget, InputPersonalInfoViewImpl> binder = GWT.create(InputPersonalInfoViewImplBinder.class);

	@UiField
	MessagesWidget messages;

	@UiField
	TextBox emailBox;

	@UiField
	Label firstNameLabel;

	@UiField
	TextBox firstNameBox;

	@UiField
	Label lastNameLabel;

	@UiField
	TextBox lastNameBox;

	@UiField
	TextBox playaNameBox;

	@UiField
	Label genderLabel;

	@UiField
	EnumListBox<Gender> genderBox;

	@UiField
	BirthDateWidget birthDate;

	@UiField
	TextBox defaultWorldJobBox;

	@UiField
	TextArea bioBox;

	@UiField
	AddressWidget homeAddress;

	@UiField
	Label phoneLabel;

	@UiField
	TextBox phoneBox;

	@UiField
	Label skypeLabel;

	@UiField
	TextBox skypeNameBox;

	@UiField
	Label contactMethodLabel;

	@UiField
	EnumListBox<ContactMethod> contactMethodBox;

	@UiField
	Label contactTimeLabel;

	@UiField
	EnumListBox<CallTime> contactTimeBox;

	@UiField
	Button nextButton;

	private ISequentialPresenter presenter;

	public InputPersonalInfoViewImpl()
	{
		initWidget(binder.createAndBindUi(this));

		bioBox.getElement().setAttribute("maxlength", "250");
		// at this point an applicant cannot change their email address as this
		// is their username
		emailBox.setEnabled(false);

		messages.clear();
	}

	@Override
	public void setPresenter(ISequentialPresenter presenter)
	{
		this.presenter = presenter;
	}

	@UiHandler(value = { "firstNameBox", "lastNameBox" })
	protected void onEmailBoxChange(KeyUpEvent event)
	{
		clearErrorState();
	}

	// Phone and Skype IFF their labels are red or contactMethodBox indicates?

	@UiHandler(value = { "genderBox", "contactMethodBox", "contactTimeBox" })
	protected void onListBoxChange(ChangeEvent event)
	{
		clearErrorState();
	}

	@UiHandler(value = { "nextButton" })
	void onNextButtonClicked(ClickEvent event)
	{
		if ((this.presenter != null) && (formIsValid()))
		{
			clearErrorState();

			nextButton.setEnabled(false);
			presenter.onNextButtonClicked();
		}
	}

	private boolean formIsValid()
	{
		Boolean retVal = true;

		// firstNameBox
		if ((null == getFirstNameText()) || getFirstNameText().isEmpty())
		{
			addMessage("Please answer the question(s) in red.");
			firstNameLabel.getElement().getStyle().setColor("red");
			retVal = false;
		}

		// lastNameBox
		if ((null == getFirstNameText()) || getFirstNameText().isEmpty())
		{
			addMessage("Please answer the question(s) in red.");
			lastNameLabel.getElement().getStyle().setColor("red");
			retVal = false;
		}

		// genderBox
		if (null == genderBox.getSelectedValue())
		{
			addMessage("Please answer the question(s) in red.");
			genderLabel.getElement().getStyle().setColor("red");
			retVal = false;
		}

		// contactMethodBox
		if (null == contactMethodBox.getSelectedValue())
		{
			addMessage("Please answer the question(s) in red.");
			contactMethodLabel.getElement().getStyle().setColor("red");
			retVal = false;
		}

		// phone number
		if (ContactMethod.Phone == contactMethodBox.getSelectedEnumValue())
		{
			if ((null == phoneBox.getText()) || (phoneBox.getText().isEmpty()))
			{
				addMessage("Please answer the question(s) in red.");
				phoneLabel.getElement().getStyle().setColor("red");
				retVal = false;
			}
		}

		// skype name
		if (ContactMethod.Skype == contactMethodBox.getSelectedEnumValue())
		{
			if ((null == skypeNameBox.getText()) || (skypeNameBox.getText().isEmpty()))
			{
				addMessage("Please answer the question(s) in red.");
				skypeLabel.getElement().getStyle().setColor("red");
				retVal = false;
			}
		}

		// contactTimeBox
		if (null == contactTimeBox.getSelectedValue())
		{
			addMessage("Please answer the question(s) in red.");
			contactTimeLabel.getElement().getStyle().setColor("red");
			retVal = false;
		}

		return retVal;
	}

	private void clearErrorState()
	{
		firstNameLabel.getElement().getStyle().setColor("black");
		lastNameLabel.getElement().getStyle().setColor("black");
		genderLabel.getElement().getStyle().setColor("black");
		contactMethodLabel.getElement().getStyle().setColor("black");
		phoneLabel.getElement().getStyle().setColor("black");
		skypeLabel.getElement().getStyle().setColor("black");

		messages.clear();
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
		return this.genderBox.getSelectedEnumValue();
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
		return this.contactMethodBox.getSelectedEnumValue();
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
		return this.contactTimeBox.getSelectedEnumValue();
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

	// @UiFactory
	// EnumListBox<E> genderListBoxFactory(E e)
	// {
	// return new EnumListBox<>(Gender.class);
	// }
	//
	// @UiFactory
	// EnumListBox<ContactMethod> contactMethodListBoxFactory()
	// {
	// return new EnumListBox<>(ContactMethod.class);
	// }
	//
	// @UiFactory
	// EnumListBox<CallTime> callTimeListBoxFactory()
	// {
	// return new EnumListBox<>(CallTime.class);
	// }

}
