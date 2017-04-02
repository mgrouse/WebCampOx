/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.user.client.Window
 * com.google.gwt.user.client.rpc.AsyncCallback
 * com.google.gwt.user.client.ui.HasWidgets com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.application.input;

import org.hbgb.webcamp.client.async.ApplicationServiceAsync;
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.presenter.IKeyPresenter;
import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.application.input.InputShelterInfoView;
import org.hbgb.webcamp.shared.ShelterInfoBlock;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class InputShelterInfoPresenter implements ISequentialPresenter
{
	private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	private final InputShelterInfoView view;
	private String key;
	private ShelterInfoBlock shelterInfoBlock;
	private HasWidgets screen;
	private IKeyPresenter nextPresenter;

	public InputShelterInfoPresenter(String k)
	{
		key = k;
		view = ViewFinder.getShelterInfoView();
		view.setPresenter(this);
	}

	@Override
	public void setKey(String k)
	{
		key = k;
	}

	@Override
	public void setScreen(HasWidgets container)
	{
		screen = container;
	}

	private void setView()
	{
		view.setHasRv(shelterInfoBlock.getIsBringingRv());
		view.setRvInfoText(shelterInfoBlock.getRvInfo());
		view.setIsInDormTent(shelterInfoBlock.getIsInDormTent());
		view.setHasStructure(shelterInfoBlock.getHasStructure());
		view.setStructureInfoText(shelterInfoBlock.getStructureInfo());
	}

	private void setModel()
	{
		shelterInfoBlock.setIsBringingRv(view.getHasRv());
		shelterInfoBlock.setRvInfo(view.getRvInfoText());
		shelterInfoBlock.setIsInDormTent(view.getIsInDormTent());
		shelterInfoBlock.setHasStructure(view.getHasStructure());
		shelterInfoBlock.setStructureInfo(view.getStructureInfoText());
	}

	@Override
	public void go()
	{
		fetchData();
		screen.clear();
	}

	@Override
	public void setNextPresenter(IKeyPresenter next)
	{
		nextPresenter = next;
	}

	public void fetchData()
	{
		if (key != null)
		{
			rpcService.getApplicantsShelterInfoBlock(key, new AsyncCallback<ShelterInfoBlock>()
			{

				@Override
				public void onSuccess(ShelterInfoBlock result)
				{
					if (result == null)
					{
						Window.alert("Applicant's Payment Info reurned as null");
					}
					else
					{
						shelterInfoBlock = result;
						setView();
						screen.add(view.asWidget());
					}
				}

				@Override
				public void onFailure(Throwable caught)
				{
					Window.alert("DB Error retrieving Applicant's Payment Info");
				}
			});
			return;
		}
		Window.alert("Error no key for Applicant's Application!");
	}

	@Override
	public void onNextButtonClicked()
	{
		setModel();
		rpcService.updateApplicantsShelterInfoBlock(shelterInfoBlock, new AsyncCallback<Boolean>()
		{

			@Override
			public void onSuccess(Boolean saved)
			{
				if (saved)
				{
					screen.clear();
					nextPresenter.setKey(key);
					nextPresenter.setScreen(screen);
					nextPresenter.go();
				}
				else
				{
					Window.alert("DB Error saving Applicant's Shelter Info");
				}
			}

			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("RPC Error: " + caught.getMessage());
			}
		});
	}
}
