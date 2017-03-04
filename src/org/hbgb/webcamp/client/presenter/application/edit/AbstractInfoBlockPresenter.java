/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.ui.HasWidgets com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.application.edit;

import org.hbgb.webcamp.client.model.IKeyedModel;
import org.hbgb.webcamp.client.presenter.IKeyedModelPresenter;
import org.hbgb.webcamp.client.presenter.IPartPresenter;
import org.hbgb.webcamp.client.view.IPartView;

import com.google.gwt.user.client.ui.HasWidgets;

public abstract class AbstractInfoBlockPresenter implements IPartPresenter, IKeyedModelPresenter
{
	String key;
	IKeyedModel keyedModel;
	IPartView view;
	HasWidgets screen;
	Boolean isViewAdded = false;

	public AbstractInfoBlockPresenter()
	{}

	public AbstractInfoBlockPresenter(IKeyedModel keyedModel, IPartView view)
	{
		this.setView(view);
		this.setKeyedModel(keyedModel);
	}

	protected abstract void setViewData();

	protected abstract void setModelData();

	protected void setView(IPartView v)
	{
		this.view = v;
		this.view.setPresenter(this);
	}

	protected void setKeyedModel(IKeyedModel m)
	{
		this.keyedModel = m;
		this.keyedModel.setPresenter(this);
	}

	@Override
	public void setKey(String key)
	{
		this.key = key;
		this.view.clear();
		this.keyedModel.fetchData(key);
	}

	@Override
	public void setScreen(HasWidgets container)
	{
		this.screen = container;
		this.screen.add(this.view.asWidget());
	}

	@Override
	public void onDataFetched()
	{
		this.setViewData();
	}

	@Override
	public void onDataPut()
	{
		this.view.setEditButtonEnabled(true);
		this.view.setSaveButtonEnabled(false);
	}

	@Override
	public void onExpandButtonClicked()
	{}

	@Override
	public void onEditButtonClicked()
	{}

	@Override
	public void onSaveButtonClicked()
	{
		this.setModelData();
		this.keyedModel.putData();
	}
}
