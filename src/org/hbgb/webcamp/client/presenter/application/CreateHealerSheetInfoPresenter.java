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
import org.hbgb.webcamp.client.presenter.KeyPresenterI;
import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.shared.HealerSheetInfoBlock;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class CreateHealerSheetInfoPresenter implements SequentialPresenterI
{
	private final HealerSheetServiceAsync rpcService = AsyncServiceFinder.getHealerSheetService();
	private String email;
	private HasWidgets screen;
	private KeyPresenterI nextPresenter;
	private HealerSheetInfoBlock model;

	@Override
	public void setKey(String key)
	{
		this.email = key;
		this.model = new HealerSheetInfoBlock();
		this.model.setEmail(this.email);
	}

	@Override
	public void go(HasWidgets container)
	{
		this.screen = container;
		this.screen.clear();
		this.rpcService.addHealerSheetInfoBlock(this.model, new AsyncCallback<HealerSheetInfoBlock>()
		{

			public void onSuccess(HealerSheetInfoBlock block)
			{
				if (block != null)
				{
					CreateHealerSheetInfoPresenter.this.nextPresenter.setKey(block.getEncodedKey());
					CreateHealerSheetInfoPresenter.this.nextPresenter.go(CreateHealerSheetInfoPresenter.this.screen);
					return;
				}
				Window.alert((String) "DB Error saving Healer Sheet Info");
			}

			public void onFailure(Throwable caught)
			{
				Window.alert((String) "RPC Error saving Healer Sheet Info");
			}
		});
	}

	@Override
	public void setNextPresenter(KeyPresenterI next)
	{
		this.nextPresenter = next;
	}

	@Override
	public void onNextButtonClicked()
	{}

}
