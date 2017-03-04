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
public class Profile implements Serializable
{
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
	
	@Persistent
	private String email;
	
	//Many of the following class instances may become
	// collections for the user to choose from for 
	// this years' application
	
    //private      picture;
	
	@Persistent
	private HeeBee heebee;

	@Persistent
	private CommitteeInfoBlock commitee;

	@Persistent
	private LogisticsInfoBlock logisticsInfoBlock;

	@Persistent
	private ShelterInfoBlock shelterInfoBlock;

	@Persistent
	private DietInfoBlock dietInfoBlock;

	@Persistent
	private VettingInfoBlock vettingInfoBlock;

	@Persistent
	private OfficeUse officeUse;
	
	

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

	public HeeBee getHeebee()
	{
		return heebee;
	}

	public void setHeebee(HeeBee heebee)
	{
		this.heebee = heebee;
	}

	public CommitteeInfoBlock getCommitee()
	{
		return commitee;
	}

	public void setCommitee(CommitteeInfoBlock commitee)
	{
		this.commitee = commitee;
	}

	public LogisticsInfoBlock getLogisticsInfoBlock()
	{
		return logisticsInfoBlock;
	}

	public void setLogisticsInfoBlock(LogisticsInfoBlock logisticsInfoBlock)
	{
		this.logisticsInfoBlock = logisticsInfoBlock;
	}

	public ShelterInfoBlock getShelterInfoBlock()
	{
		return shelterInfoBlock;
	}

	public void setShelterInfoBlock(ShelterInfoBlock shelterInfoBlock)
	{
		this.shelterInfoBlock = shelterInfoBlock;
	}

	public DietInfoBlock getDietInfoBlock()
	{
		return dietInfoBlock;
	}

	public void setDietInfoBlock(DietInfoBlock dietInfoBlock)
	{
		this.dietInfoBlock = dietInfoBlock;
	}

	public VettingInfoBlock getVettingInfoBlock()
	{
		return vettingInfoBlock;
	}

	public void setVettingInfoBlock(VettingInfoBlock vettingInfoBlock)
	{
		this.vettingInfoBlock = vettingInfoBlock;
	}

	public OfficeUse getOfficeUse()
	{
		return officeUse;
	}

	public void setOfficeUse(OfficeUse officeUse)
	{
		this.officeUse = officeUse;
	}
	
	
}

