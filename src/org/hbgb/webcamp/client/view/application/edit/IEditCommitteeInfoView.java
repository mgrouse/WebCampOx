/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.edit;

import org.hbgb.webcamp.shared.enums.Circle;

public interface IEditCommitteeInfoView
{
	public void setCommittee1(Circle var1);

	public Circle getCommittee1();

	public void setReason1(String var1);

	public String getReason1();

	public void setCommittee2(Circle var1);

	public Circle getCommittee2();

	public void setReason2(String var1);

	public String getReason2();

	public void setAssignedCommittee(Circle var1);

	public Circle getAssignedCommittee();

	public void setIsAssignedLead(Boolean var1);

	public Boolean getIsAssignedLead();
}
