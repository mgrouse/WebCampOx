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
import org.hbgb.webcamp.client.async.HealerSheetServiceAsync;
import org.hbgb.webcamp.client.model.IKeyedModel;
import org.hbgb.webcamp.client.presenter.IKeyedModelPresenter;
import org.hbgb.webcamp.shared.HealerSheetInfoBlock;

public class HealerSheetInfoBlockModel
implements IKeyedModel {
    HealerSheetServiceAsync hsRpcService = AsyncServiceFinder.getHealerSheetService();
    ApplicationServiceAsync appRpcService = AsyncServiceFinder.getApplicationService();
    IKeyedModelPresenter presenter;
    HealerSheetInfoBlock model;

    @Override
    public void setPresenter(IKeyedModelPresenter p) {
        this.presenter = p;
    }

    @Override
    public void fetchData(String key) {
        if (key != null) {
            this.hsRpcService.getHealerSheetInfoBlock(key, new AsyncCallback<HealerSheetInfoBlock>(){

                public void onSuccess(HealerSheetInfoBlock result) {
                    if (result == null) {
                        Window.alert((String)"Camper's Healer Sheet info returned as null");
                        return;
                    }
                    HealerSheetInfoBlockModel.this.model = result;
                    HealerSheetInfoBlockModel.this.presenter.onDataFetched();
                }

                public void onFailure(Throwable caught) {
                    Window.alert((String)"DB Error retrieving Camper's Healer Sheet");
                }
            });
            return;
        }
        Window.alert((String)"Error no key for Camper's Healer Sheet!");
    }

    private void fetcHSInfoBlockByEmail(String email) {
        this.hsRpcService.getHealerSheetInfoBlockByEmail(email, true, new AsyncCallback<HealerSheetInfoBlock>(){

            public void onSuccess(HealerSheetInfoBlock result) {
                if (result == null) {
                    Window.alert((String)"Camper's Healer Sheet info returned as null");
                    return;
                }
                HealerSheetInfoBlockModel.this.model = result;
                HealerSheetInfoBlockModel.this.presenter.onDataFetched();
            }

            public void onFailure(Throwable caught) {
                Window.alert((String)"DB Error retrieving Camper's Healer Sheet: ");
            }
        });
    }

    public void fetchDataByAppKey(String key) {
        if (key == null) return;
        this.appRpcService.findApplicationEmailByKey(key, new AsyncCallback<String>(){

            public void onSuccess(String result) {
                if (result == null) {
                    Window.alert((String)"Camper's email returned as null");
                    return;
                }
                HealerSheetInfoBlockModel.this.fetcHSInfoBlockByEmail(result);
            }

            public void onFailure(Throwable caught) {
                Window.alert((String)"DB Error retrieving Camper's Email");
            }
        });
    }

    @Override
    public void putData() {
        this.hsRpcService.updateHealerSheetInfoBlock(this.model, new AsyncCallback<Boolean>(){

            public void onSuccess(Boolean saved) {
                if (saved.booleanValue()) {
                    HealerSheetInfoBlockModel.this.presenter.onDataPut();
                    return;
                }
                Window.alert((String)"DB Error saving Healer Sheet Info");
            }

            public void onFailure(Throwable caught) {
                Window.alert((String)("RPC Error saving Healer Sheet Info: " + caught));
            }
        });
    }

    public HealerSheetInfoBlock getData() {
        return this.model;
    }

    public void setData(HealerSheetInfoBlock t) {
        this.model = t;
    }

}

