package org.hbgb.webcamp.shared;

import java.io.Serializable;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.hbgb.webcamp.shared.enums.CallTime;
import org.hbgb.webcamp.shared.enums.ContactMethod;

@SuppressWarnings("serial")
@PersistenceCapable(detachable="true", identityType = IdentityType.APPLICATION)
public class ContactInfo implements Serializable
{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String					encodedKey;


	// if we only had one email field this would be it
	@Persistent
	private String					email = "";

	@Persistent
	private Address					address;

	@Persistent
	private String					phone = "";

	@Persistent
	private String					skypeName = "";

	@Persistent
	private Boolean					isReturningHeeBee;
	
	@Persistent
	private String                  pastYearsText;
	
	@Persistent
	private ContactMethod			contactMethod;

	@Persistent
	private CallTime				callTime;
	
	

	public ContactInfo(){}
	
	public ContactInfo(String emailText)
	{
		email = emailText;
	}
	
	public ContactInfo(String email, ContactInfo source)
	{
		if(null != source)
		{
			this.setEmail(source.getEmail());
			this.setAddress(new Address(source.getAddress()));
			this.setPhone(source.getPhone());
			this.setSkypeName(source.getSkypeName());
			this.setContactMethod(source.getContactMethod());
			this.setCallTime(source.getCallTime());
		}
		else
		{
			this.setEmail(email);
			this.setAddress(new Address());
		}
	}
	
	

	public String getEncodedKey()
	{
		return encodedKey;
	}

	public void setEncodedKey(String encodedKey)
	{
		this.encodedKey = encodedKey;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getSkypeName()
	{
		return skypeName;
	}

	public void setSkypeName(String skypeName)
	{
		this.skypeName = skypeName;
	}

	public ContactMethod getContactMethod()
	{
		return contactMethod;
	}

	public void setContactMethod(ContactMethod contactMethod)
	{
		this.contactMethod = contactMethod;
	}

	public CallTime getCallTime()
	{
		return callTime;
	}

	public void setCallTime(CallTime callTime)
	{
		this.callTime = callTime;
	}

}
