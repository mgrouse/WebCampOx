/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.ui.HasWidgets
 *  com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.report;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import org.hbgb.webcamp.client.model.IMealsReportModel;
import org.hbgb.webcamp.client.model.MealsReportModel;
import org.hbgb.webcamp.client.presenter.IReportPresenter;
import org.hbgb.webcamp.client.view.report.IMealsReportView;
import org.hbgb.webcamp.client.view.report.MealsReportViewImpl;
import org.hbgb.webcamp.shared.MealsReport;

public class MealsReportPresenter
implements IReportPresenter {
    IMealsReportModel model = new MealsReportModel();
    IMealsReportView view;
    HasWidgets screen;

    public MealsReportPresenter() {
        this.model.setPresenter(this);
        this.view = new MealsReportViewImpl();
        this.view.setPresenter(this);
    }

    @Override
    public void setScreen(HasWidgets container) {
        this.screen = container;
        this.screen.clear();
    }

    @Override
    public void report() {
        this.model.fetchData();
    }

    @Override
    public void onDataFetched() {
        this.view.setReportData(this.model.getReportData());
        this.screen.add(this.view.asWidget());
    }
}

