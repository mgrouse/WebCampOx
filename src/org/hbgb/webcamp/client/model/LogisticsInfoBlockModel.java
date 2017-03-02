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
import org.hbgb.webcamp.shared.LogisticsInfoBlock;

public class LogisticsInfoBlockModel
implements IKeyedModel {
    ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
    IKeyedModelPresenter presenter;
    LogisticsInfoBlock model;

    @Override
    public void setPresenter(IKeyedModelPresenter p) {
        this.presenter = p;
    }

    @Override
    public void fetchData(String key) {
        if (key != null) {
            this.rpcService.getApplicantsLogisticsInfoBlock(key, new AsyncCallback<LogisticsInfoBlock>(){

                public void onSuccess(LogisticsInfoBlock result) {
                    if (result == null) {
                        Window.alert((String)"Applicant's Payment Info returned as null");
                        return;
                    }
                    LogisticsInfoBlockModel.this.model = result;
                    LogisticsInfoBlockModel.this.presenter.onDataFetched();
                }

                public void onFailure(Throwable caught) {
                    Window.alert((String)"DB Error retrieving Applicant's Payment Info");
                }
            });
            return;
        }
        Window.alert((String)"Error no key for Applicant's Application!");
    }

    @Override
    public void putData() {
        this.rpcService.updateApplicantsLogisticsInfoBlock(this.model, new AsyncCallback<Boolean>(){

            public void onSuccess(Boolean saved) {
                if (saved.booleanValue()) {
                    LogisticsInfoBlockModel.this.presenter.onDataPut();
                    return;
                }
                Window.alert((String)"DB Error saving Applicant's Shelter Info");
            }

            public void onFailure(Throwable caught) {
                Window.alert((String)"RPC Error saving Applicant's Shelter Info");
            }
        });
    }

    public LogisticsInfoBlock getData() {
        return this.model;
    }

    public void setData(LogisticsInfoBlock t) {
        this.model = t;
    }

}

