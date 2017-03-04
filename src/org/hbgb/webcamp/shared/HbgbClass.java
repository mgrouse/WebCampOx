package org.hbgb.webcamp.shared;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class HbgbClass implements Serializable
{
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String encodedKey;
	
	@Persistent
	private String title;
	
	@Persistent
	private Teacher teacher;
	
	@Persistent
	private Date date;
	
	@Persistent
	private String startTime;
	
	@Persistent
	private String endTime;
}
