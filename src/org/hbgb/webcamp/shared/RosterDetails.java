package org.hbgb.webcamp.shared;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RosterDetails implements Comparable<RosterDetails>, Serializable
{
	private String encodedKey;
	private String photoURL;
	private String playaName;
	private String firstName;
	private String homeTown;
	private String committee;
	private String bio;

	public RosterDetails()
	{
		new RosterDetails(null, "", "", "", "", "", "");
	}

	public RosterDetails(String key, String photoURL, String playaName, String firstName,
			String homeTown, String committee, String bio)
	{
		this.encodedKey = key;
		this.photoURL = photoURL;
		this.playaName = playaName;
		this.firstName = firstName;
		this.homeTown = homeTown;
		this.committee = committee;
		this.bio = bio;
	}

	public String getEncodedKey()
	{
		return encodedKey;
	}

	public void setEncodedKey(String encodedKey)
	{
		this.encodedKey = encodedKey;
	}

	public String getPhotoURL()
	{
		return photoURL;
	}

	public void setPhotoURL(String photoURL)
	{
		this.photoURL = photoURL;
	}

	public String getPlayaName()
	{
		return playaName;
	}

	public void setPlayaName(String playaName)
	{
		this.playaName = playaName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getHomeTown()
	{
		return homeTown;
	}

	public void setHomeTown(String homeTown)
	{
		this.homeTown = homeTown;
	}

	public String getCommittee()
	{
		return committee;
	}

	public void setCommittee(String committee)
	{
		this.committee = committee;
	}

	public String getBio()
	{
		return bio;
	}

	public void setBio(String bio)
	{
		this.bio = bio;
	}

	@Override
	public int compareTo(RosterDetails rd)
	{
		String name1, name2;

		if (isEmpty(this.getPlayaName()))
		{
			name1 = this.getFirstName();
		}
		else
		{
			name1 = this.getPlayaName();
		}

		if (isEmpty(rd.getPlayaName()))
		{
			name2 = rd.getFirstName();
		}
		else
		{
			name2 = rd.getPlayaName();
		}

		return name1.compareToIgnoreCase(name2);
	}

	private Boolean isEmpty(String text)
	{
		return ((null == text) || (text.trim().isEmpty()));
	}
}
