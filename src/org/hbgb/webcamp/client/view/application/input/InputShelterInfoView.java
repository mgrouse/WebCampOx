/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.client.view.ISequentialView;
import org.hbgb.webcamp.client.view.IView;

public interface InputShelterInfoView extends ISequentialView, IView
{
	@Override
	public void setPresenter(ISequentialPresenter var1);

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
