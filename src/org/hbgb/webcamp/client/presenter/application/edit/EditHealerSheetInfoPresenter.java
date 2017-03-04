/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.presenter.application.edit;

import org.hbgb.webcamp.client.model.HealerSheetInfoBlockModel;
import org.hbgb.webcamp.client.view.application.edit.EditHealerSheetInfoBlockViewImpl;
import org.hbgb.webcamp.client.view.application.edit.IEditHealerSheetInfoView;
import org.hbgb.webcamp.shared.HealerSheetInfoBlock;

public class EditHealerSheetInfoPresenter extends AbstractInfoBlockPresenter
{
	static IEditHealerSheetInfoView view = new EditHealerSheetInfoBlockViewImpl();
	static HealerSheetInfoBlockModel model = new HealerSheetInfoBlockModel();

	public EditHealerSheetInfoPresenter()
	{
		super(model, view);
	}

	@Override
	protected void setViewData()
	{
		HealerSheetInfoBlock block = model.getData();
		view.setSessionLength(block.getSessionLength());
		view.setModality1(block.getModality1());
		view.setModality2(block.getModality2());
		view.setModality3(block.getModality3());
		view.setModality4(block.getModality4());
		view.setBioBox(block.getBio());
	}

	@Override
	protected void setModelData()
	{
		HealerSheetInfoBlock block = model.getData();
		block.setSessionLength(view.getSessionLength());
		block.setModality1(view.getModality1());
		block.setModality2(view.getModality2());
		block.setModality3(view.getModality3());
		block.setModality4(view.getModality4());
		block.setBio(view.getBioBox());
	}
}
