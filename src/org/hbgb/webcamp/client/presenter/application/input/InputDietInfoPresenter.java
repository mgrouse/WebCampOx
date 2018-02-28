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
import org.hbgb.webcamp.client.view.application.input.InputDietInfoView;
import org.hbgb.webcamp.shared.DietInfoBlock;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class InputDietInfoPresenter implements ISequentialPresenter
{
	private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	private final InputDietInfoView view;
	private String key;
	private DietInfoBlock dietInfoBlock;
	private HasWidgets screen;
	private IKeyPresenter nextPresenter;

	public InputDietInfoPresenter(String k)
	{
		key = k;
		view = ViewFinder.getDietInfoView();
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

	@Override
	public void go()
	{
		fetchData();
		screen.clear();
	}

	private void setView()
	{
		view.setDietType(dietInfoBlock.getDietType());
		view.setIsGlutenFree(dietInfoBlock.getIsGlutenFree());
		view.setIsLactoseIntolerant(dietInfoBlock.getIsLactoseIntolerant());
		view.setDietaryRestrictions(dietInfoBlock.getDietaryRestrictions());
		view.setIsLactoseIntolerant(dietInfoBlock.getIsLactoseIntolerant());
	}

	private void setModel()
	{
		dietInfoBlock.setDietType(view.getDietType());
		dietInfoBlock.setIsGlutenFree(view.getIsGlutenFree());
		dietInfoBlock.setIsLactoseIntolerant(view.getIsLactoseIntolerant());
		dietInfoBlock.setDietaryRestrictions(view.getDietaryRestrictions());

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
			rpcService.getApplicantsDietInfoBlock(key, new AsyncCallback<DietInfoBlock>()
			{

				@Override
				public void onSuccess(DietInfoBlock result)
				{
					if (result == null)
					{
						Window.alert("Applicant's Payment Info reurned as null");
					}
					else
					{
						dietInfoBlock = result;
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
		rpcService.updateApplicantsDietInfoBlock(dietInfoBlock, new AsyncCallback<Boolean>()
		{

			@Override
			public void onSuccess(Boolean saved)
			{
				if (saved.booleanValue())
				{
					screen.clear();
					nextPresenter.setKey(key);
					nextPresenter.setScreen(screen);
					nextPresenter.go();
				}
				else
				{
					Window.alert("DB Error saving Applicant's Payment Info");
				}
			}

			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("RPC Error saving Applicant's Payment Info");
			}
		});
	}

}
