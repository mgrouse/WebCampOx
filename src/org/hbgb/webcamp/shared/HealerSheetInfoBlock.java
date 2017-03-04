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
@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class HealerSheetInfoBlock implements Serializable
{
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
	
	@Persistent
	private String email = "";
	
	@Persistent
	private String sessionLength = "";

	@Persistent
	private String modality1 = "";
	
	@Persistent
	private String modality2 = "";
	
	@Persistent
	private String modality3 = "";
	
	@Persistent
	private String modality4 = "";
	
	@Persistent
	private Text bio = new Text(""); 
	
	
	public HealerSheetInfoBlock(){}


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


	public String getModality1()
	{
		return modality1;
	}

	
	public String getSessionLength()
	{
		return sessionLength;
	}


	public void setSessionLength(String sessionLength)
	{
		this.sessionLength = sessionLength;
	}
	
	
	public void setModality1(String modality1)
	{
		this.modality1 = modality1;
	}


	public String getModality2()
	{
		return modality2;
	}


	public void setModality2(String modality2)
	{
		this.modality2 = modality2;
	}


	public String getModality3()
	{
		return modality3;
	}


	public void setModality3(String modality3)
	{
		this.modality3 = modality3;
	}


	public String getModality4()
	{
		return modality4;
	}


	public void setModality4(String modality4)
	{
		this.modality4 = modality4;
	}


	public String getBio()
	{
		return bio.getValue();
	}


	public void setBio(String bio)
	{
		this.bio = new Text(bio);
	}

}
