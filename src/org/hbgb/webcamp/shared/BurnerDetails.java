package org.hbgb.webcamp.shared;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BurnerDetails implements Serializable
{
	private String encodedKey;
	private String displayName;
	private String email;
	
	public BurnerDetails()
	{
		new BurnerDetails(null, "", "");
	}
	
	public BurnerDetails(String key, String displayName, String email)
	{
		this.encodedKey = key;
		this.displayName = displayName;
		this.email = email;
	}

	public String getEncodedKey()
	{
		return encodedKey;
	}

	public void setEncodedKey(String encodedKey)
	{
		this.encodedKey = encodedKey;
	}

	public String getDisplayName()
	{
		return displayName;
	}

	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

}
