/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.presenter.application.edit;

import org.hbgb.webcamp.client.model.ApplicationModel;
import org.hbgb.webcamp.client.model.IKeyedModel;
import org.hbgb.webcamp.client.presenter.application.edit.AbstractInfoBlockPresenter;
import org.hbgb.webcamp.client.view.IPartView;
import org.hbgb.webcamp.client.view.application.edit.EditApplicationInfoViewImpl;
import org.hbgb.webcamp.shared.Application;
import org.hbgb.webcamp.shared.enums.ApplicationStatus;

public class EditApplicationInfoPresenter extends AbstractInfoBlockPresenter
{
	static EditApplicationInfoViewImpl view = new EditApplicationInfoViewImpl();
	static ApplicationModel model = new ApplicationModel();

	public EditApplicationInfoPresenter()
	{
		super(model, view);
	}

	@Override
	protected void setViewData()
	{
		Application app = model.getData();
		view.setApplicationStatus(app.getStatus());
		view.setImageURL(app.getImageURL());
	}

	@Override
	protected void setModelData()
	{
		Application app = model.getData();
		app.setStatus(view.getApplicationStatus());
		app.setImageURL(view.getImageURL());
	}
}
