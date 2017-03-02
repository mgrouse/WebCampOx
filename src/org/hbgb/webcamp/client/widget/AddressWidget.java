/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.user.client.ui.Composite com.google.gwt.user.client.ui.TextBox
 * com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.widget;

import org.hbgb.webcamp.shared.Address;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class AddressWidget extends Composite
{
	private static UiBinder<Widget, AddressWidget> binder = (UiBinder) GWT
			.create((Class) AddressWidgetBinder.class);
	@UiField
	TextBox street1Box;
	@UiField
	TextBox street2Box;
	@UiField
	TextBox cityBox;
	@UiField
	TextBox stateBox;
	@UiField
	TextBox countryBox;
	@UiField
	TextBox postCodeBox;

	public AddressWidget()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	public void setAllValues(Address a)
	{
		if (a != null)
		{
			this.setStreet1Text(a.getStreet1());
			this.setStreet2Text(a.getStreet2());
			this.setCityText(a.getCity());
			this.setStateText(a.getState());
			this.setCountryText(a.getCountry());
			this.setPostCodeText(a.getPostalCode());
			return;
		}
		this.setStreet1Text("");
		this.setStreet2Text("");
		this.setCityText("");
		this.setStateText("");
		this.setCountryText("");
		this.setPostCodeText("");
	}

	public Address getAllValues()
	{
		Address a = new Address();
		a.setStreet1(this.getStreet1NameText());
		a.setStreet2(this.getStreet2Text());
		a.setCity(this.getCityText());
		a.setState(this.getStateText());
		a.setCountry(this.getCountryText());
		a.setPostalCode(this.getPostCodeText());
		return a;
	}

	public void setStreet1Text(String text)
	{
		this.street1Box.setText(text);
	}

	public String getStreet1NameText()
	{
		return this.street1Box.getText();
	}

	public void setStreet2Text(String text)
	{
		this.street2Box.setText(text);
	}

	public String getStreet2Text()
	{
		return this.street2Box.getText();
	}

	public void setCityText(String text)
	{
		this.cityBox.setText(text);
	}

	public String getCityText()
	{
		return this.cityBox.getText();
	}

	public void setStateText(String text)
	{
		this.stateBox.setText(text);
	}

	public String getStateText()
	{
		return this.stateBox.getText();
	}

	public void setCountryText(String text)
	{
		this.countryBox.setText(text);
	}

	public String getCountryText()
	{
		return this.countryBox.getText();
	}

	public void setPostCodeText(String text)
	{
		this.postCodeBox.setText(text);
	}

	public String getPostCodeText()
	{
		return this.postCodeBox.getText();
	}

	static interface AddressWidgetBinder extends UiBinder<Widget, AddressWidget>
	{
	}

}
