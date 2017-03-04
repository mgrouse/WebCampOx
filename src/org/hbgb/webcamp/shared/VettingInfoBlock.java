package org.hbgb.webcamp.shared;

import java.io.Serializable;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class VettingInfoBlock implements Serializable
{
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
	
	@Persistent
	private String email = "";
	
	@Persistent
	private Boolean isSparklePony = false;
	
	
	public VettingInfoBlock(){}
	
	public VettingInfoBlock(String emailText)
	{
		email = emailText;
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

	public Boolean getIsSparklePony()
	{
		return isSparklePony;
	}

	public void setIsSparklePony(Boolean isSparklePony)
	{
		this.isSparklePony = isSparklePony;
	}	
}
