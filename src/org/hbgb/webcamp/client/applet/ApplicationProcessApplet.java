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
	private final StartPresenter enter;
	private final UploadPhotoPresenter picturePage;
	private final InputPersonalInfoPresenter personalPage;
	private final InputPaymentInfoPresenter paymentPage;
	private final InputCommitteeNHealerSheetInfoPresenter committeePage;
	private final InputDietInfoPresenter dietPage;
	private final InputShelterInfoPresenter shelterPage;
	private final InputLogisticsInfoPresenter logisticPage;
	private final FinishPresenter exit;
	private HasWidgets screen;

	public ApplicationProcessApplet()
	{
		enter = new StartPresenter();
		picturePage = new UploadPhotoPresenter(null);
		personalPage = new InputPersonalInfoPresenter(null);
		paymentPage = new InputPaymentInfoPresenter(null);
		committeePage = new InputCommitteeNHealerSheetInfoPresenter(null);
		dietPage = new InputDietInfoPresenter(null);
		shelterPage = new InputShelterInfoPresenter(null);
		logisticPage = new InputLogisticsInfoPresenter(null);
		exit = new FinishPresenter();

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
