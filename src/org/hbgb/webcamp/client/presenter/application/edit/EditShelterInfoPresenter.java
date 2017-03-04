/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.presenter.application.edit;

import org.hbgb.webcamp.client.model.ShelterInfoBlockModel;
import org.hbgb.webcamp.client.view.application.edit.EditShelterInfoViewImpl;
import org.hbgb.webcamp.shared.ShelterInfoBlock;

public class EditShelterInfoPresenter extends AbstractInfoBlockPresenter
{
	static EditShelterInfoViewImpl view = new EditShelterInfoViewImpl();
	static ShelterInfoBlockModel model = new ShelterInfoBlockModel();

	public EditShelterInfoPresenter()
	{
		super(model, view);
	}

	@Override
	protected void setViewData()
	{
		ShelterInfoBlock shelterInfoBlock = model.getData();
		view.setHasRv(shelterInfoBlock.getIsBringingRv());
		view.setRvInfoText(shelterInfoBlock.getRvInfo());
		view.setIsInDormTent(shelterInfoBlock.getIsInDormTent());
		view.setHasStructure(shelterInfoBlock.getHasStructure());
		view.setStructureInfoText(shelterInfoBlock.getStructureInfo());
	}

	@Override
	protected void setModelData()
	{
		ShelterInfoBlock shelterInfoBlock = model.getData();
		shelterInfoBlock.setIsBringingRv(view.getHasRv());
		shelterInfoBlock.setRvInfo(view.getRvInfoText());
		shelterInfoBlock.setIsInDormTent(view.getIsInDormTent());
		shelterInfoBlock.setHasStructure(view.getHasStructure());
		shelterInfoBlock.setStructureInfo(view.getStructureInfoText());
	}
}
