/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.model;

import org.hbgb.webcamp.client.presenter.IKeyedModelPresenter;

public interface IKeyedModel {
    public void setPresenter(IKeyedModelPresenter var1);

    public void fetchData(String var1);

    public void putData();
}

