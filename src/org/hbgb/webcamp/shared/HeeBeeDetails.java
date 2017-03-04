package org.hbgb.webcamp.shared;

public class HeeBeeDetails
{
	private String encodedKey;
	private String displayName;
	private String email;

	public HeeBeeDetails()
	{
		new BurnerDetails(null, "", "");
	}

	public HeeBeeDetails(String key, String displayName, String email)
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
