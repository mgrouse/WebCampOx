package org.hbgb.webcamp.shared;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.hbgb.webcamp.shared.enums.TicketType;

@SuppressWarnings("serial")
@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class PaymentInfoBlock implements Serializable
{
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
	
	@Persistent
	private String email = "";
	
	@Persistent
	private Boolean hasTicket = false;

	@Persistent
	private TicketType ticketType;
	
	@Persistent
	private Boolean hasBeenInvoiced = false;
	
	@Persistent
	private Boolean hasPaidDues = false;

	@Persistent
	private Date paidDate;
	
	@Persistent
	private Boolean wasHeeBeeSubsidized = false;

	@Persistent
	private Integer subsidyAmt = 0;
	
	@Persistent
	private String subsidyReason = "";
	
	

	public PaymentInfoBlock(){}
	
	public PaymentInfoBlock(String emailText)
	{
		this.setEmail(emailText);
	}
	
	public PaymentInfoBlock(String email, PaymentInfoBlock source)
	{
		if(null != source)
		{
			this.setEmail(source.getEmail());
			//this.setHasTicket(source.getHasTicket());
			//this.setTicketType(source.getTicketType());
			//this.setHasBeenInvoiced(source.getHasBeenInvoiced());
			//this.setHasPaidDues(source.getHasPaidDues());
			//this.setPaidDate(source.getPaidDate());
			//this.setWasHeeBeeSubsidized(source.getWasHeeBeeSubsidized());
			//this.setSubsidyAmt(source.getSubsidyAmt());
			//this.setSubsidyReason(source.getSubsidyReason());
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

	public Boolean getHasTicket()
	{
		return hasTicket;
	}

	public void setHasTicket(Boolean hasTicket)
	{
		this.hasTicket = hasTicket;
	}

	public TicketType getTicketType()
	{
		return ticketType;
	}

	public void setTicketType(TicketType ticketType)
	{
		this.ticketType = ticketType;
	}

	public Boolean getHasBeenInvoiced()
	{
		return hasBeenInvoiced;
	}

	public void setHasBeenInvoiced(Boolean hasBeenInvoiced)
	{
		this.hasBeenInvoiced = hasBeenInvoiced;
	}

	public Boolean getHasPaidDues()
	{
		return hasPaidDues;
	}

	public void setHasPaidDues(Boolean hasPaidDues)
	{
		this.hasPaidDues = hasPaidDues;
	}

	public Date getPaidDate()
	{
		return paidDate;
	}

	public void setPaidDate(Date paidDate)
	{
		this.paidDate = paidDate;
	}

	public Boolean getWasHeeBeeSubsidized()
	{
		return wasHeeBeeSubsidized;
	}

	public void setWasHeeBeeSubsidized(Boolean wasHeeBeeSubsidized)
	{
		this.wasHeeBeeSubsidized = wasHeeBeeSubsidized;
	}

	public Integer getSubsidyAmt()
	{
		return subsidyAmt;
	}

	public void setSubsidyAmt(Integer subsidyAmt)
	{
		this.subsidyAmt = subsidyAmt;
	}

	public String getSubsidyReason()
	{
		return subsidyReason;
	}

	public void setSubsidyReason(String subsidyReason)
	{
		this.subsidyReason = subsidyReason;
	}
	
	
	
	
	
	
}
