/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.input;

import java.util.Date;

import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.client.view.ISequentialView;
import org.hbgb.webcamp.client.view.IView;
import org.hbgb.webcamp.shared.Address;
import org.hbgb.webcamp.shared.enums.CallTime;
import org.hbgb.webcamp.shared.enums.ContactMethod;
import org.hbgb.webcamp.shared.enums.Gender;

public interface InputPersonalInfoView extends ISequentialView, IView
{
	@Override
	public void setPresenter(ISequentialPresenter var1);

	public void setEmailText(String var1);

	public String getEmailText();

	public void setFirstNameText(String var1);

	public String getFirstNameText();

	public void setLastNameText(String var1);

	public String getLastNameText();

	public void setPlayaNameText(String var1);

	public String getPlayaNameText();

	public void setGender(Gender var1);

	public Gender getGender();

	public void setBirthDate(Date var1);

	public Date getBirthDate();

	public void setDefaultWorldJobText(String var1);

	public String getDefaultWorldJobText();

	public void setBioText(String var1);

	public String getBioText();

	public void setPhoneText(String var1);

	public String getPhoneText();

	public void setSkypeNameText(String var1);

	public String getSkypeNameText();

	public ContactMethod getContactMethod();

	public void setContactMethod(ContactMethod var1);

	public void setCallTime(CallTime var1);

	public CallTime getCallTime();

	public void setAddress(Address var1);

	public Address getAddress();
}
