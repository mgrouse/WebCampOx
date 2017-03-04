package org.hbgb.webcamp.shared;

import java.io.Serializable;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Text;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class ShelterInfoBlock implements Serializable
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
	private Boolean isBringingRv = false;

	@Persistent
	private String rvInfo = "";

	@Persistent
	private Boolean isInDormTent = false;

	@Persistent
	private Boolean hasStructure = false;

	@Persistent
	private Text structureInfo = new Text("");

	public ShelterInfoBlock()
	{}

	public ShelterInfoBlock(String emailText)
	{
		this.setEmail(emailText);
	}

	public ShelterInfoBlock(String email, ShelterInfoBlock source)
	{
		if (null != source)
		{
			this.setEmail(source.getEmail());
			this.setIsProfile(source.getIsProfile());
			this.setIsBringingRv(source.getIsBringingRv());
			this.setRvInfo(source.getRvInfo());
			this.setIsInDormTent(source.getIsInDormTent());
			this.setHasStructure(source.getHasStructure());
			this.setStructureInfo(source.getStructureInfo());
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

	public Boolean getIsBringingRv()
	{
		return isBringingRv;
	}

	public void setIsBringingRv(Boolean isBringingRv)
	{
		this.isBringingRv = isBringingRv;
	}

	public String getRvInfo()
	{
		return rvInfo;
	}

	public void setRvInfo(String rvInfo)
	{
		this.rvInfo = rvInfo;
	}

	public Boolean getIsInDormTent()
	{
		return isInDormTent;
	}

	public void setIsInDormTent(Boolean isInDormTent)
	{
		this.isInDormTent = isInDormTent;
	}

	public String getStructureInfo()
	{
		return structureInfo.getValue();
	}

	public void setStructureInfo(String structureInfo)
	{
		this.structureInfo = new Text(structureInfo);
	}

	public Boolean getHasStructure()
	{
		return hasStructure;
	}

	public void setHasStructure(Boolean hasStructure)
	{
		this.hasStructure = hasStructure;
	}
}
