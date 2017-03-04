/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.ui.HasWidgets
 */
package org.hbgb.webcamp.client.applet;

import org.hbgb.webcamp.client.presenter.application.ApplicationLookupByEmailPresenter;
import org.hbgb.webcamp.client.presenter.application.CreateHealerSheetInfoPresenter;
import org.hbgb.webcamp.client.presenter.application.ThankYouPresenter;
import org.hbgb.webcamp.client.presenter.application.input.InputHealerSheetInfoPresenter;

import com.google.gwt.user.client.ui.HasWidgets;

public class HealerSheetInputApplet implements IApplet
{
	private InputHealerSheetInfoPresenter personalPage = new InputHealerSheetInfoPresenter(null);
	private CreateHealerSheetInfoPresenter plugIn = new CreateHealerSheetInfoPresenter();
	private ApplicationLookupByEmailPresenter appLookUp = new ApplicationLookupByEmailPresenter(false);
	private ThankYouPresenter exit = new ThankYouPresenter();
	private HasWidgets screen;

	public HealerSheetInputApplet()
	{
		this.appLookUp.setNextPresenter(this.plugIn);
		this.plugIn.setNextPresenter(this.personalPage);
		this.personalPage.setNextPresenter(this.exit);
	}

	@Override
	public void run(HasWidgets container)
	{
		this.screen = container;
		this.appLookUp.go(container);
	}
}
