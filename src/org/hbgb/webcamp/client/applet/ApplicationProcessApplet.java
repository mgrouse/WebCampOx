/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.ui.HasWidgets
 */
package org.hbgb.webcamp.client.applet;

import org.hbgb.webcamp.client.presenter.application.input.FinishPresenter;
import org.hbgb.webcamp.client.presenter.application.input.InputCommitteeNHealerSheetInfoPresenter;
import org.hbgb.webcamp.client.presenter.application.input.InputDietInfoPresenter;
import org.hbgb.webcamp.client.presenter.application.input.InputLogisticsInfoPresenter;
import org.hbgb.webcamp.client.presenter.application.input.InputPaymentInfoPresenter;
import org.hbgb.webcamp.client.presenter.application.input.InputPersonalInfoPresenter;
import org.hbgb.webcamp.client.presenter.application.input.InputShelterInfoPresenter;
import org.hbgb.webcamp.client.presenter.application.input.StartPresenter;
import org.hbgb.webcamp.client.presenter.application.input.UploadPhotoPresenter;

import com.google.gwt.user.client.ui.HasWidgets;

public class ApplicationProcessApplet implements IApplet
{
	private final StartPresenter enter = new StartPresenter();
	private final UploadPhotoPresenter picturePage = new UploadPhotoPresenter(null);
	private final InputPersonalInfoPresenter personalPage = new InputPersonalInfoPresenter(null);
	private final InputPaymentInfoPresenter paymentPage = new InputPaymentInfoPresenter(null);
	private final InputCommitteeNHealerSheetInfoPresenter committeePage = new InputCommitteeNHealerSheetInfoPresenter(null);
	private final InputDietInfoPresenter dietPage = new InputDietInfoPresenter(null);
	private final InputShelterInfoPresenter shelterPage = new InputShelterInfoPresenter(null);
	private final InputLogisticsInfoPresenter logisticPage = new InputLogisticsInfoPresenter(null);
	private final FinishPresenter exit = new FinishPresenter();
	private HasWidgets screen;

	public ApplicationProcessApplet()
	{
		this.setOrder();
	}

	private void setOrder()
	{
		this.enter.setNextPresenter(this.picturePage);
		this.picturePage.setNextPresenter(this.personalPage);
		this.personalPage.setNextPresenter(this.paymentPage);
		this.paymentPage.setNextPresenter(this.committeePage);
		this.committeePage.setNextPresenter(this.dietPage);
		this.dietPage.setNextPresenter(this.shelterPage);
		this.shelterPage.setNextPresenter(this.logisticPage);
		this.logisticPage.setNextPresenter(this.exit);
	}

	@Override
	public void run(HasWidgets container)
	{
		this.screen = container;
		this.enter.go(this.screen);
	}
}
