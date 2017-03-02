/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.Window
 *  com.google.gwt.user.client.rpc.AsyncCallback
 */
package org.hbgb.webcamp.client.model;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import org.hbgb.webcamp.client.async.ApplicationServiceAsync;
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.model.IKeyedModel;
import org.hbgb.webcamp.client.presenter.IKeyedModelPresenter;
import org.hbgb.webcamp.shared.Application;

public class ApplicationModel
implements IKeyedModel {
    ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
    IKeyedModelPresenter presenter;
    Application model;

    @Override
    public void setPresenter(IKeyedModelPresenter p) {
        this.presenter = p;
    }

    @Override
    public void fetchData(String key) {
        if (key != null) {
            this.rpcService.getApplication(key, new AsyncCallback<Application>(){

                public void onSuccess(Application result) {
                    if (result == null) {
                        Window.alert((String)"Applicant's Info reurned as null");
                        return;
                    }
                    ApplicationModel.this.model = result;
                    ApplicationModel.this.presenter.onDataFetched();
                }

                public void onFailure(Throwable caught) {
                    Window.alert((String)"DB Error retrieving Applicant's Info");
                }
            });
            return;
        }
        Window.alert((String)"Error no key for Applicant's Application!");
    }

    @Override
    public void putData() {
        this.rpcService.updateApplication(this.model, new AsyncCallback<Boolean>(){

            public void onSuccess(Boolean saved) {
                if (saved.booleanValue()) {
                    ApplicationModel.this.presenter.onDataPut();
                    return;
                }
                Window.alert((String)"DB Error saving Applicant's Info");
            }

            public void onFailure(Throwable caught) {
                Window.alert((String)"RPC Error saving Applicant's Info");
            }
        });
    }

    public Application getData() {
        return this.model;
    }

    public void setData(Application t) {
        this.model = t;
    }

}

