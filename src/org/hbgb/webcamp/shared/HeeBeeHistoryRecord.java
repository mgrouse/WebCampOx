package org.hbgb.webcamp.shared;

import java.io.Serializable;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.hbgb.webcamp.shared.enums.Circle;

@SuppressWarnings("serial")
@PersistenceCapable(detachable = "true", identityType = IdentityType.APPLICATION)
public class HeeBeeHistoryRecord implements Serializable
{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String encodedKey;

	@Persistent
	private String email;

	// private picture

	@Persistent
	private Integer year;

	@Persistent
	private Circle committee;

	@Persistent
	private Boolean wasGoodOnCommittee;

	@Persistent
	private Boolean wasEarlyTeam;

	@Persistent
	private Boolean wasStrikeTeam;

	@Persistent
	private String notes;
}
