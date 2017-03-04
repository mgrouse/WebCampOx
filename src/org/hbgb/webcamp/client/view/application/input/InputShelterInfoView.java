/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.IView;

public interface InputShelterInfoView extends IView
{
	public void setPresenter(SequentialPresenterI var1);

	public void setHasRv(Boolean var1);

	public Boolean getHasRv();

	public void setRvInfoText(String var1);

	public String getRvInfoText();

	public void setIsInDormTent(Boolean var1);

	public Boolean getIsInDormTent();

	public void setHasStructure(Boolean var1);

	public Boolean getHasStructure();

	public void setStructureInfoText(String var1);

	public String getStructureInfoText();
}
