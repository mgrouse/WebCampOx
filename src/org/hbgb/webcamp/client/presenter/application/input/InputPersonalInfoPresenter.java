/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.appengine.api.datastore.Text
 * com.google.gwt.user.client.Window
 * com.google.gwt.user.client.rpc.AsyncCallback
 * com.google.gwt.user.client.ui.HasWidgets com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.application.input;

import org.hbgb.webcamp.client.async.ApplicationServiceAsync;
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.presenter.IKeyPresenter;
import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.application.input.InputPersonalInfoView;
import org.hbgb.webcamp.shared.Burner;
import org.hbgb.webcamp.shared.enums.SecurityRole;

import com.google.appengine.api.datastore.Text;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class InputPersonalInfoPresenter implements ISequentialPresenter
{
	private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	private final InputPersonalInfoView view;
	private String key;
	private Burner burner;
	private HasWidgets screen;
	private IKeyPresenter nextPresenter;

	public InputPersonalInfoPresenter(String key)
	{
		this.key = key;
		this.view = ViewFinder.getPersonalInfoView();
		this.view.setVisibility(SecurityRole.USER);
		this.view.setPresenter(this);
	}

	@Override
	public void setKey(String key)
	{
		this.key = key;
	}

	private void setView()
	{
		this.view.setEmailText(this.burner.getEmail());
		this.view.setFirstNameText(this.burner.getDemographics().getFirstName());
		this.view.setLastNameText(this.burner.getDemographics().getLastName());
		this.view.setPlayaNameText(this.burner.getDemographics().getPlayaName());
		this.view.setGender(this.burner.getDemographics().getGender());
		this.view.setBirthDate(this.burner.getDemographics().getBirthDate());
		this.view.setDefaultWorldJobText(this.burner.getDemographics().getDefaultWorldJob());
		this.view.setBioText(this.burner.getDemographics().getBio().toString());
		this.view.setPhoneText(this.burner.getContactInfo().getPhone());
		this.view.setSkypeNameText(this.burner.getContactInfo().getSkypeName());
		this.view.setContactMethod(this.burner.getContactInfo().getContactMethod());
		this.view.setCallTime(this.burner.getContactInfo().getCallTime());
		this.view.setAddress(this.burner.getContactInfo().getAddress());
	}

	private void setModel()
	{
		this.burner.setEmail(this.view.getEmailText());
		this.burner.getDemographics().setFirstName(this.view.getFirstNameText());
		this.burner.getDemographics().setLastName(this.view.getLastNameText());
		this.burner.getDemographics().setPlayaName(this.view.getPlayaNameText());
		this.burner.getDemographics().setGender(this.view.getGender());
		this.burner.getDemographics().setBirthDate(this.view.getBirthDate());
		this.burner.getDemographics().setDefaultWorldJob(this.view.getDefaultWorldJobText());
		this.burner.getDemographics().setBio(new Text(this.view.getBioText()));
		this.burner.getContactInfo().setEmail(this.view.getEmailText());
		this.burner.getContactInfo().setPhone(this.view.getPhoneText());
		this.burner.getContactInfo().setSkypeName(this.view.getSkypeNameText());
		this.burner.getContactInfo().setContactMethod(this.view.getContactMethod());
		this.burner.getContactInfo().setCallTime(this.view.getCallTime());
		this.burner.getContactInfo().setAddress(this.view.getAddress());
	}

	public void fetchData()
	{
		if (this.key != null)
		{
			this.rpcService.getApplicant(this.key, new AsyncCallback<Burner>()
			{

				public void onSuccess(Burner result)
				{
					InputPersonalInfoPresenter.access$0(InputPersonalInfoPresenter.this, result);
					InputPersonalInfoPresenter.this.setView();
					InputPersonalInfoPresenter.this.screen.add(InputPersonalInfoPresenter.this.view.asWidget());
				}

				public void onFailure(Throwable caught)
				{
					Window.alert((String) "Error retrieving Applicant");
				}
			});
			return;
		}
		Window.alert((String) "Error no key for Applicant's Application!");
	}

	@Override
	public void go(HasWidgets container)
	{
		this.screen = container;
		this.fetchData();
		this.screen.clear();
	}

	@Override
	public void setNextPresenter(IKeyPresenter next)
	{
		this.nextPresenter = next;
	}

	@Override
	public void onNextButtonClicked()
	{
		this.setModel();
		this.rpcService.updateApplicant(this.burner, new AsyncCallback<Boolean>()
		{

			public void onSuccess(Boolean saved)
			{
				if (saved.booleanValue())
				{
					InputPersonalInfoPresenter.this.screen.clear();
					InputPersonalInfoPresenter.this.nextPresenter.setKey(InputPersonalInfoPresenter.this.key);
					InputPersonalInfoPresenter.this.nextPresenter.go(InputPersonalInfoPresenter.this.screen);
					return;
				}
				Window.alert((String) "DB Error saving Applicant's Info");
			}

			public void onFailure(Throwable caught)
			{
				Window.alert((String) "RPC Error saving Applicant's Info");
			}
		});
	}

	static /* synthetic */ void access$0(InputPersonalInfoPresenter inputPersonalInfoPresenter, Burner burner)
	{
		inputPersonalInfoPresenter.burner = burner;
	}

}
