package org.hbgb.webcamp.shared;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HbgbUserDetails implements Serializable
{
	private String encodedKey;
	private String displayName;
	private String email;

	public HbgbUserDetails()
	{
		new HbgbUserDetails(null, "");
	}

	public HbgbUserDetails(String key, String displayName)
	{
		this.encodedKey = key;
		this.displayName = displayName;
	}

	public String getKey()
	{
		return encodedKey;
	}

	public void setKey(String key)
	{
		this.encodedKey = key;
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
