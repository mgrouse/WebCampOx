/*
 * This is an unpublished work protected by the United States copyright laws and
 * is proprietary to Michael A. Grouse. Disclosure, copying, reproduction,
 * merger translation, modification, enhancement or use by anyone other than
 * authorized employees or licensees of Michael A. Grouse without prior written
 * consent of Michael A. Grouse is prohibited.
 *
 * Copyright (C) 1992 - 2017 Michael A. Grouse, All Rights Reserved.
 *
 * This copyright notice should not be construed as evidence of publication.
 */
package org.hbgb.webcamp.shared;

import java.io.Serializable;

import org.hbgb.webcamp.shared.enums.ApplicationStatus;
import org.hbgb.webcamp.shared.enums.Circle;
import org.hbgb.webcamp.shared.enums.DietType;

import com.google.gwt.view.client.ProvidesKey;

/**
 * @author Michael
 *
 */

@SuppressWarnings("serial")
public class ApplicationRow implements Comparable<ApplicationRow>, Serializable
{

	public static final ProvidesKey<ApplicationRow> KEY_PROVIDER = new ProvidesKey<ApplicationRow>()
	{
		@Override
		public Object getKey(ApplicationRow item)
		{
			return item == null ? null : item.getEncodedKey();
		}
	};

	private String encodedKey;

	private ApplicationStatus status;

	private String firstName;
	private String lastName;
	private String playaName;
	private String email;

	private Circle committee;

	private DietType diet;

	private Boolean hasTicket;
	private Boolean isET;
	private Boolean isStrike;
	private Boolean hasRV;
	private Boolean hasStructure;

	public ApplicationRow()
	{

	}

	public String getEncodedKey()
	{
		return encodedKey;
	}

	public void setEncodedKey(String encodedKey)
	{
		this.encodedKey = encodedKey;
	}

	public ApplicationStatus getStatus()
	{
		return status;
	}

	public void setStatus(ApplicationStatus status)
	{
		this.status = status;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getPlayaName()
	{
		return playaName;
	}

	public void setPlayaName(String playaName)
	{
		this.playaName = playaName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Circle getCommittee()
	{
		return committee;
	}

	public void setCommittee(Circle committee)
	{
		this.committee = committee;
	}

	public DietType getDiet()
	{
		return diet;
	}

	public void setDiet(DietType diet)
	{
		this.diet = diet;
	}

	public Boolean getHasTicket()
	{
		return hasTicket;
	}

	public void setHasTicket(Boolean hasTicket)
	{
		this.hasTicket = hasTicket;
	}

	public Boolean getIsET()
	{
		return isET;
	}

	public void setIsET(Boolean isET)
	{
		this.isET = isET;
	}

	public Boolean getIsStrike()
	{
		return isStrike;
	}

	public void setIsStrike(Boolean isStrike)
	{
		this.isStrike = isStrike;
	}

	public Boolean getHasRV()
	{
		return hasRV;
	}

	public void setHasRV(Boolean hasRV)
	{
		this.hasRV = hasRV;
	}

	public Boolean getHasStructure()
	{
		return hasStructure;
	}

	public void setHasStructure(Boolean hasStructure)
	{
		this.hasStructure = hasStructure;
	}

	@Override
	public int compareTo(ApplicationRow row)
	{
		int retVal = status.compareTo(row.status);

		if (0 == retVal)
		{
			retVal = committee.compareTo(row.committee);
		}

		if (0 == retVal)
		{
			retVal = lastName.compareTo(row.lastName);
		}

		return retVal;
	}

}
