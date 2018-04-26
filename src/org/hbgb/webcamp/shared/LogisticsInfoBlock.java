package org.hbgb.webcamp.shared;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.hbgb.webcamp.shared.enums.DayOfEvent;
import org.hbgb.webcamp.shared.enums.PlayaTime;
import org.hbgb.webcamp.shared.enums.Transportation;

@SuppressWarnings("serial")
@PersistenceCapable(detachable = "true", identityType = IdentityType.APPLICATION)
public class LogisticsInfoBlock implements Serializable
{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String encodedKey;

	@Persistent
	private String email = "";

	@Persistent
	private Boolean isProfile = false;

	@Persistent
	private Boolean wantsEarlyTeam = false;

	@Persistent
	private Boolean isAssignedEarlyTeam = false;

	@Persistent
	private Boolean wantsStrikeTeam = false;

	@Persistent
	private Transportation transType;

	@Persistent
	private Date arrivalDate;

	@Persistent
	private DayOfEvent arrivalDoE;

	@Persistent
	private PlayaTime arrivalTime;

	@Persistent
	private Date departureDate;

	@Persistent
	private DayOfEvent departureDoE;

	@Persistent
	private PlayaTime departureTime;

	public LogisticsInfoBlock()
	{
	}

	public LogisticsInfoBlock(String emailText)
	{
		this.setEmail(emailText);
	}

	public LogisticsInfoBlock(String email, LogisticsInfoBlock source)
	{
		if (null != source)
		{
			this.setEmail(source.getEmail());
			this.setIsProfile(source.getIsProfile());
			this.setWantsEarlyTeam(source.getWantsEarlyTeam());
			// this.setIsAssignedEarlyTeam(source.getIsAssignedEarlyTeam());
			this.setWantsStrikeTeam(source.getWantsStrikeTeam());
			this.setTransType(source.getTransType());
			this.setArrivalDoE(source.getArrivalDoE());
			this.setArrivalTime(source.getArrivalTime());
			this.setDepartureDoE(source.getDepartureDoE());
			this.setDepartureTime(source.getDepartureTime());
		}
		else
		{
			this.setEmail(email);
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

	public Boolean getIsProfile()
	{
		return isProfile;
	}

	public void setIsProfile(Boolean isProfile)
	{
		this.isProfile = isProfile;
	}

	public Boolean getWantsEarlyTeam()
	{
		return wantsEarlyTeam;
	}

	public void setWantsEarlyTeam(Boolean wantsEarlyTeam)
	{
		this.wantsEarlyTeam = wantsEarlyTeam;
	}

	public Boolean getIsAssignedEarlyTeam()
	{
		return isAssignedEarlyTeam;
	}

	public void setIsAssignedEarlyTeam(Boolean isAssignedEarlyTeam)
	{
		this.isAssignedEarlyTeam = isAssignedEarlyTeam;
	}

	public Boolean getWantsStrikeTeam()
	{
		return wantsStrikeTeam;
	}

	public void setWantsStrikeTeam(Boolean wantsStrikeTeam)
	{
		this.wantsStrikeTeam = wantsStrikeTeam;
	}

	public Transportation getTransType()
	{
		return transType;
	}

	public void setTransType(Transportation transType)
	{
		this.transType = transType;
	}

	@Deprecated
	public Date getArrivalDate()
	{
		return arrivalDate;
	}

	@Deprecated
	public void setArrivalDate(Date arrivalDate)
	{
		this.arrivalDate = arrivalDate;
	}

	public PlayaTime getArrivalTime()
	{
		return arrivalTime;
	}

	public void setArrivalTime(PlayaTime arrivalTime)
	{
		this.arrivalTime = arrivalTime;
	}

	@Deprecated
	public Date getDepartureDate()
	{
		return departureDate;
	}

	@Deprecated
	public void setDepartureDate(Date departureDate)
	{
		this.departureDate = departureDate;
	}

	public PlayaTime getDepartureTime()
	{
		return departureTime;
	}

	public void setDepartureTime(PlayaTime departureTime)
	{
		this.departureTime = departureTime;
	}

	public DayOfEvent getArrivalDoE()
	{
		return arrivalDoE;
	}

	public void setArrivalDoE(DayOfEvent arrivalDoE)
	{
		this.arrivalDoE = arrivalDoE;
	}

	public DayOfEvent getDepartureDoE()
	{
		return departureDoE;
	}

	public void setDepartureDoE(DayOfEvent departureDoE)
	{
		this.departureDoE = departureDoE;
	}
}
