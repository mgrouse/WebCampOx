/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.edit;

import org.hbgb.webcamp.shared.enums.ApplicationStatus;

public interface IEditApplicationInfoView
{
	public void setApplicationStatus(ApplicationStatus var1);

	public ApplicationStatus getApplicationStatus();

	public void setImageURL(String var1);

	public String getImageURL();
}
