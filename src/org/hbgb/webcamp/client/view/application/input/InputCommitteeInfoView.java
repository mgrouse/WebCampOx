/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.client.view.ISequentialView;
import org.hbgb.webcamp.client.view.IView;
import org.hbgb.webcamp.shared.enums.Circle;

public interface InputCommitteeInfoView extends ISequentialView, IView
{
	@Override
	public void setPresenter(ISequentialPresenter var1);

	public void setCommittee1(Circle var1);

	public Circle getCommittee1();

	public void setReason1(String var1);

	public String getReason1();

	public void setCommittee2(Circle var1);

	public Circle getCommittee2();

	public void setReason2(String var1);

	public String getReason2();

	public void setSessionLength(String var1);

	public String getSessionLength();

	public void setModality1(String var1);

	public String getModality1();

	public void setModality2(String var1);

	public String getModality2();

	public void setModality3(String var1);

	public String getModality3();

	public void setModality4(String var1);

	public String getModality4();

	public void setBioBoxText(String var1);

	public String getBioBoxText();
}
