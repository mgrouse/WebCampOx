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
@PersistenceCapable(detachable = "true", identityType = IdentityType.APPLICATION)
public class DietInfoBlock implements Serializable
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
	private DietType dietType;

	@Persistent
	private Boolean isGlutenFree = false;

	@Persistent
	private Boolean isLactoseIntolerant = false;

	@Persistent
	private Text dietaryRestrictions = new Text("");

	public DietInfoBlock()
	{
	}

	public DietInfoBlock(String emailText)
	{
		setEmail(emailText);
	}

	public DietInfoBlock(String Email, DietInfoBlock source)
	{
		if (null != source)
		{
			setEmail(source.getEmail());
			setIsProfile(source.getIsProfile());
			setDietType(source.getDietType());
			setIsGlutenFree(source.isGlutenFree);
			setIsLactoseIntolerant(source.isLactoseIntolerant);

			setDietaryRestrictions(source.getDietaryRestrictions());
		}
		else
		{
			setEmail(email);
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

	public Boolean getIsLactoseIntolerant()
	{
		return isLactoseIntolerant;
	}

	public void setIsLactoseIntolerant(Boolean isLactoseIntolerant)
	{
		this.isLactoseIntolerant = isLactoseIntolerant;
	}

}
