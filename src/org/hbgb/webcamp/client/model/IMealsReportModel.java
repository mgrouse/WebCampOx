/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.model;

import org.hbgb.webcamp.client.presenter.IReportPresenter;
import org.hbgb.webcamp.shared.MealsReport;

public interface IMealsReportModel {
    public void setPresenter(IReportPresenter var1);

    public void fetchData();

    public MealsReport getReportData();
}

