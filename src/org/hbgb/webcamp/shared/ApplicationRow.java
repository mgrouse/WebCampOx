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
import org.hbgb.webcamp.shared.enums.Committee;
import org.hbgb.webcamp.shared.enums.DietType;

/**
 * @author Michael
 *
 */

@SuppressWarnings("serial")
public class ApplicationRow implements Comparable<ApplicationRow>, Serializable
{

	private String encodedKey;

	private ApplicationStatus status;

	private String firstName;
	private String lastName;
	private String playaName;
	private String email;

	private Committee committee;

	private DietType diet;

	private Boolean hasTicket;
	private Boolean isET;
	private Boolean isStrike;
	private Boolean hasRV;
	private Boolean hasStructure;

	public ApplicationRow()
	{

	}

	/**
	 * @return the encodedKey
	 */
	public String getEncodedKey()
	{
		return encodedKey;
	}

	/**
	 * @param encodedKey
	 *            the encodedKey to set
	 */
	public void setEncodedKey(String encodedKey)
	{
		this.encodedKey = encodedKey;
	}

	/**
	 * @return the status
	 */
	public ApplicationStatus getStatus()
	{
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(ApplicationStatus status)
	{
		this.status = status;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * @return the playaName
	 */
	public String getPlayaName()
	{
		return playaName;
	}

	/**
	 * @param playaName
	 *            the playaName to set
	 */
	public void setPlayaName(String playaName)
	{
		this.playaName = playaName;
	}

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * @return the committee
	 */
	public Committee getCommittee()
	{
		return committee;
	}

	/**
	 * @param committee
	 *            the committee to set
	 */
	public void setCommittee(Committee committee)
	{
		this.committee = committee;
	}

	/**
	 * @return the diet
	 */
	public DietType getDiet()
	{
		return diet;
	}

	/**
	 * @param diet
	 *            the diet to set
	 */
	public void setDiet(DietType diet)
	{
		this.diet = diet;
	}

	/**
	 * @return the hasTicket
	 */
	public Boolean getHasTicket()
	{
		return hasTicket;
	}

	/**
	 * @param hasTicket
	 *            the hasTicket to set
	 */
	public void setHasTicket(Boolean hasTicket)
	{
		this.hasTicket = hasTicket;
	}

	/**
	 * @return the isET
	 */
	public Boolean getIsET()
	{
		return isET;
	}

	/**
	 * @param isET
	 *            the isET to set
	 */
	public void setIsET(Boolean isET)
	{
		this.isET = isET;
	}

	/**
	 * @return the isStrike
	 */
	public Boolean getIsStrike()
	{
		return isStrike;
	}

	/**
	 * @param isStrike
	 *            the isStrike to set
	 */
	public void setIsStrike(Boolean isStrike)
	{
		this.isStrike = isStrike;
	}

	/**
	 * @return the hasRV
	 */
	public Boolean getHasRV()
	{
		return hasRV;
	}

	/**
	 * @param hasRV
	 *            the hasRV to set
	 */
	public void setHasRV(Boolean hasRV)
	{
		this.hasRV = hasRV;
	}

	/**
	 * @return the hasStructure
	 */
	public Boolean getHasStructure()
	{
		return hasStructure;
	}

	/**
	 * @param hasStructure
	 *            the hasStructure to set
	 */
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
