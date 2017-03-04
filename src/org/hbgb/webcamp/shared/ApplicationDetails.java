package org.hbgb.webcamp.shared;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ApplicationDetails implements Comparable<ApplicationDetails>, Serializable
{
	private String encodedKey;
	private String status;
	private String displayName;
	private String playaName;
	private String committee;
	private String ticket;
	private String invoiced;
	private String paid;
	private String diet;
	private String email;

	public ApplicationDetails()
	{
		new ApplicationDetails(null, "", "", "", "", "", "", "", "", "");
	}

	public ApplicationDetails(String key, String status, String displayName, String playaName, String committee, String ticket, String invoiced,
			String paid, String diet, String email)
	{
		this.encodedKey = key;
		this.status = status;
		this.displayName = displayName;
		this.playaName = playaName;
		this.committee = committee;
		this.ticket = ticket;
		this.invoiced = invoiced;
		this.paid = paid;
		this.diet = diet;
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

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getDisplayName()
	{
		return displayName;
	}

	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

	public String getPlayaName()
	{
		return playaName;
	}

	public void setPlayaName(String playaName)
	{
		this.playaName = playaName;
	}

	public String getCommittee()
	{
		return committee;
	}

	public void setCommittee(String committee)
	{
		this.committee = committee;
	}

	public String getInvoiced()
	{
		return invoiced;
	}

	public void setInvoiced(String invoiced)
	{
		this.invoiced = invoiced;
	}

	public String getPaid()
	{
		return paid;
	}

	public void setPaid(String paid)
	{
		this.paid = paid;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getTicket()
	{
		return ticket;
	}

	public void setTicket(String ticket)
	{
		this.ticket = ticket;
	}

	public String getDiet()
	{
		return diet;
	}

	public void setDiet(String diet)
	{
		this.diet = diet;
	}

	@Override
	public int compareTo(ApplicationDetails ad)
	{
		int retval = 0;

		retval = this.status.compareTo(ad.status);

		if (retval == 0)
		{
			retval = this.committee.compareTo(ad.committee);
		}

		return retval;
	}
}
