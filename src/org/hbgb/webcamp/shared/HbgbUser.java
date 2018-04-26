package org.hbgb.webcamp.shared;

import java.io.Serializable;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.hbgb.webcamp.shared.enums.SecurityRole;

@SuppressWarnings("serial")
@PersistenceCapable(detachable = "true", identityType = IdentityType.APPLICATION)
public class HbgbUser implements Serializable
{

	/**
	 * @return the securityRole
	 */
	public SecurityRole getSecurityRole()
	{
		return securityRole;
	}

	/**
	 * @param securityRole
	 *            the securityRole to set
	 */
	public void setSecurityRole(SecurityRole securityRole)
	{
		this.securityRole = securityRole;
	}

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String encodedKey;

	@Persistent
	private String emailAddress;

	@Persistent
	String password;

	@Persistent
	String firstName;

	@Persistent
	String lastName;

	@Persistent
	String playaName;

	@Persistent
	Boolean isEarlyTeam;

	@Persistent
	SecurityRole securityRole;

	public HbgbUser()
	{
	}

	public HbgbUser(String emailAddress, String password, String firstName, String lastName)
	{
		this.emailAddress = emailAddress;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public HbgbUserDetails getDetails()
	{
		return new HbgbUserDetails(getKey(), getFullName());
	}

	public String getKey()
	{
		return encodedKey;
	}

	public void setKey(String key)
	{
		this.encodedKey = key;
	}

	public String getEmailAddress()
	{
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
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

	public String getFullName()
	{
		return firstName + " " + lastName;
	}

	public boolean isPassword(String password2)
	{

		return false;
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
	 * @return the isEarlyTeam
	 */
	public Boolean getIsEarlyTeam()
	{
		return isEarlyTeam;
	}

	/**
	 * @param isEarlyTeam
	 *            the isEarlyTeam to set
	 */
	public void setIsEarlyTeam(Boolean isEarlyTeam)
	{
		this.isEarlyTeam = isEarlyTeam;
	}

}
