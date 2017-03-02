/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.report;

import org.hbgb.webcamp.client.presenter.IReportPresenter;
import org.hbgb.webcamp.client.view.IView;
import org.hbgb.webcamp.shared.MealsReport;

public interface IMealsReportView
extends IView {
    public void setPresenter(IReportPresenter var1);

    public void setReportData(MealsReport var1);
}

