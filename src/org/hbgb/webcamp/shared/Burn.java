package org.hbgb.webcamp.shared;

import java.io.Serializable;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Burn implements Serializable
{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String encodedKey;

	@Persistent
	private String email;

	@Persistent
	private String year;

	@Persistent
	private String camp;

	@Persistent
	private String note;

	public Burn()
	{}

	public Burn(String email)
	{
		this.setEmail(email);
	}

	public Burn(Burn source)
	{
		this.setEmail(source.getEmail());
		this.setYear(source.getYear());
		this.setCamp(source.getCamp());
		this.setNote(source.getNote());
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getYear()
	{
		return year;
	}

	public void setYear(String year)
	{
		this.year = year;
	}

	public String getCamp()
	{
		return camp;
	}

	public void setCamp(String camp)
	{
		this.camp = camp;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

}
