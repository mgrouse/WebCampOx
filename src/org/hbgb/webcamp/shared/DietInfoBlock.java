package org.hbgb.webcamp.shared;

import java.io.Serializable;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.hbgb.webcamp.shared.enums.DietType;

import com.google.appengine.api.datastore.Text;

@SuppressWarnings("serial")
@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class DietInfoBlock implements Serializable
{
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
	
	@Persistent
	private String email = "";
	
	@Persistent
	private Boolean isProfile = false;
	
	@Persistent
	private DietType dietType;
	
	@Persistent
	private Boolean isGlutenFree = false;

	@Persistent
	private Text dietaryRestrictions = new Text(""); 
	
	
	//TODO remove these.
//	@Persistent
//	private Boolean eatsBeef = false; 
//
//	@Persistent
//	private Boolean eatsChicken = false; 
//
//	@Persistent
//	private Boolean eatsPork = false; 
//
//	@Persistent
//	private Boolean eatsBacon = false; 
//
//	@Persistent
//	private Boolean eatsFish = false; 
//
//	@Persistent
//	private Boolean eatsTofu = false; 


	
	
	public DietInfoBlock(){}
	
	public DietInfoBlock(String emailText)
	{
		this.setEmail(emailText);
	}
	
	public DietInfoBlock(String Email, DietInfoBlock source)
	{
		if(null != source)
		{
			this.setEmail(source.getEmail());
			this.setIsProfile(source.getIsProfile());
			this.setDietType(source.getDietType());
			this.setIsGlutenFree(source.isGlutenFree);
			this.setDietaryRestrictions(source.getDietaryRestrictions());
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

	public DietType getDietType()
	{
		return dietType;
	}

	public void setDietType(DietType dietType)
	{
		this.dietType = dietType;
	}

	public Boolean getIsGlutenFree()
	{
		return isGlutenFree;
	}

	public void setIsGlutenFree(Boolean isGlutenFree)
	{
		this.isGlutenFree = isGlutenFree;
	}

	public String getDietaryRestrictions()
	{
		return dietaryRestrictions.getValue();
	}

	public void setDietaryRestrictions(String dietaryRestrictions)
	{
		this.dietaryRestrictions = new Text(dietaryRestrictions);
	}
	
//	public Boolean getEatsBeef()
//	{
//		return eatsBeef;
//	}
//
//	public void setEatsBeef(Boolean eatsBeef)
//	{
//		this.eatsBeef = eatsBeef;
//	}
//
//	public Boolean getEatsChicken()
//	{
//		return eatsChicken;
//	}
//
//	public void setEatsChicken(Boolean eatsChicken)
//	{
//		this.eatsChicken = eatsChicken;
//	}
//
//	public Boolean getEatsPork()
//	{
//		return eatsPork;
//	}
//
//	public void setEatsPork(Boolean eatsPork)
//	{
//		this.eatsPork = eatsPork;
//	}
//
//	public Boolean getEatsBacon()
//	{
//		return eatsBacon;
//	}
//
//	public void setEatsBacon(Boolean eatsBacon)
//	{
//		this.eatsBacon = eatsBacon;
//	}
//
//	public Boolean getEatsFish()
//	{
//		return eatsFish;
//	}
//
//	public void setEatsFish(Boolean eatsFish)
//	{
//		this.eatsFish = eatsFish;
//	}
//
//	public Boolean getEatsTofu()
//	{
//		return eatsTofu;
//	}
//
//	public void setEatsTofu(Boolean eatsTofu)
//	{
//		this.eatsTofu = eatsTofu;
//	}

	
}
