/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.user.client.Window
 * com.google.gwt.user.client.rpc.AsyncCallback
 * com.google.gwt.user.client.ui.HasWidgets
 */
package org.hbgb.webcamp.client.presenter.application;

import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.async.HealerSheetServiceAsync;
import org.hbgb.webcamp.client.presenter.IKeyPresenter;
import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.shared.HealerSheetInfoBlock;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class CreateHealerSheetInfoPresenter implements ISequentialPresenter
{
	private final HealerSheetServiceAsync rpcService = AsyncServiceFinder.getHealerSheetService();
	private String email;
	private HasWidgets screen;
	private IKeyPresenter nextPresenter;
	private HealerSheetInfoBlock model;

	@Override
	public void setKey(String key)
	{
		this.email = key;
		this.model = new HealerSheetInfoBlock();
		this.model.setEmail(this.email);
	}

	@Override
	public void go()
	{

		this.screen.clear();
		this.rpcService.addHealerSheetInfoBlock(this.model, new AsyncCallback<HealerSheetInfoBlock>()
		{

			@Override
			public void onSuccess(HealerSheetInfoBlock block)
			{
				if (block != null)
				{
					nextPresenter.setKey(block.getEncodedKey());
					nextPresenter.setScreen(screen);
					nextPresenter.go();
				}
				else
				{
					Window.alert("DB Error: HealerSheetInfoBlock returned as NULL");
				}
			}

			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("RPC Error: " + caught.getMessage());
			}
		});
	}

	@Override
	public void setNextPresenter(IKeyPresenter next)
	{
		this.nextPresenter = next;
	}

	@Override
	public void onNextButtonClicked()
	{}

	@Override
	public void setScreen(HasWidgets container)
	{
		screen = container;
	}

}
