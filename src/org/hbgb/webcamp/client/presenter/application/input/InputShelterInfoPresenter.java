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
import org.hbgb.webcamp.client.presenter.KeyPresenterI;
import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.application.input.InputShelterInfoView;
import org.hbgb.webcamp.shared.ShelterInfoBlock;
import org.hbgb.webcamp.shared.enums.SecurityRole;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class InputShelterInfoPresenter implements SequentialPresenterI
{
	private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	private final InputShelterInfoView view;
	private String key;
	private ShelterInfoBlock shelterInfoBlock;
	private HasWidgets screen;
	private KeyPresenterI nextPresenter;

	public InputShelterInfoPresenter(String key)
	{
		this.key = key;
		this.view = ViewFinder.getShelterInfoView();
		this.view.setPresenter(this);
		this.view.setVisibility(SecurityRole.USER);
	}

	@Override
	public void setKey(String key)
	{
		this.key = key;
	}

	private void setView()
	{
		this.view.setHasRv(this.shelterInfoBlock.getIsBringingRv());
		this.view.setRvInfoText(this.shelterInfoBlock.getRvInfo());
		this.view.setIsInDormTent(this.shelterInfoBlock.getIsInDormTent());
		this.view.setHasStructure(this.shelterInfoBlock.getHasStructure());
		this.view.setStructureInfoText(this.shelterInfoBlock.getStructureInfo());
	}

	private void setModel()
	{
		this.shelterInfoBlock.setIsBringingRv(this.view.getHasRv());
		this.shelterInfoBlock.setRvInfo(this.view.getRvInfoText());
		this.shelterInfoBlock.setIsInDormTent(this.view.getIsInDormTent());
		this.shelterInfoBlock.setHasStructure(this.view.getHasStructure());
		this.shelterInfoBlock.setStructureInfo(this.view.getStructureInfoText());
	}

	@Override
	public void go(HasWidgets container)
	{
		this.screen = container;
		this.fetchData();
		this.screen.clear();
	}

	@Override
	public void setNextPresenter(KeyPresenterI next)
	{
		this.nextPresenter = next;
	}

	public void fetchData()
	{
		if (this.key != null)
		{
			this.rpcService.getApplicantsShelterInfoBlock(this.key, new AsyncCallback<ShelterInfoBlock>()
			{

				public void onSuccess(ShelterInfoBlock result)
				{
					if (result == null)
					{
						Window.alert((String) "Applicant's Payment Info reurned as null");
						return;
					}
					InputShelterInfoPresenter.access$0(InputShelterInfoPresenter.this, result);
					InputShelterInfoPresenter.this.setView();
					InputShelterInfoPresenter.this.screen.add(InputShelterInfoPresenter.this.view.asWidget());
				}

				public void onFailure(Throwable caught)
				{
					Window.alert((String) "DB Error retrieving Applicant's Payment Info");
				}
			});
			return;
		}
		Window.alert((String) "Error no key for Applicant's Application!");
	}

	@Override
	public void onNextButtonClicked()
	{
		this.setModel();
		this.rpcService.updateApplicantsShelterInfoBlock(this.shelterInfoBlock, new AsyncCallback<Boolean>()
		{

			public void onSuccess(Boolean saved)
			{
				if (saved.booleanValue())
				{
					InputShelterInfoPresenter.this.screen.clear();
					InputShelterInfoPresenter.this.nextPresenter.setKey(InputShelterInfoPresenter.this.key);
					InputShelterInfoPresenter.this.nextPresenter.go(InputShelterInfoPresenter.this.screen);
					return;
				}
				Window.alert((String) "DB Error saving Applicant's Shelter Info");
			}

			public void onFailure(Throwable caught)
			{
				Window.alert((String) "RPC Error saving Applicant's Shelter Info");
			}
		});
	}

	static /* synthetic */ void access$0(InputShelterInfoPresenter inputShelterInfoPresenter, ShelterInfoBlock shelterInfoBlock)
	{
		inputShelterInfoPresenter.shelterInfoBlock = shelterInfoBlock;
	}

}
