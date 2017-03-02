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
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.async.HbgbAppUserServiceAsync;
import org.hbgb.webcamp.client.model.IKeyedModel;
import org.hbgb.webcamp.client.presenter.IKeyedModelPresenter;
import org.hbgb.webcamp.shared.HbgbUser;

public class HbgbUserModel
implements IKeyedModel {
    HbgbAppUserServiceAsync rpcService = AsyncServiceFinder.getHbgbUserService();
    IKeyedModelPresenter presenter;
    HbgbUser model = new HbgbUser();

    @Override
    public void setPresenter(IKeyedModelPresenter p) {
        this.presenter = p;
    }

    @Override
    public void fetchData(String key) {
        if (key != null) {
            this.rpcService.getHbgbUser(key, new AsyncCallback<HbgbUser>(){

                public void onSuccess(HbgbUser result) {
                    if (result == null) {
                        Window.alert((String)"Member's ET Data returned as null");
                        HbgbUserModel.this.presenter.onDataFetched();
                        return;
                    }
                    HbgbUserModel.this.model = result;
                    HbgbUserModel.this.presenter.onDataFetched();
                }

                public void onFailure(Throwable caught) {
                    Window.alert((String)"DB Error retrieving Member's ET Data");
                    HbgbUserModel.this.presenter.onDataFetched();
                }
            });
            return;
        }
        Window.alert((String)"Error: no key for Member's ET Data!");
    }

    public void fetchDataByEmail(final String email) {
        if (email != null) {
            this.rpcService.getHbgbUserByEmail(email, new AsyncCallback<HbgbUser>(){

                public void onSuccess(HbgbUser result) {
                    if (result == null) {
                        Window.alert((String)"Member's ET Data returned as null");
                        HbgbUserModel.this.model = new HbgbUser();
                        HbgbUserModel.this.model.setEmailAddress(email);
                        HbgbUserModel.this.presenter.onDataFetched();
                        return;
                    }
                    HbgbUserModel.this.model = result;
                    HbgbUserModel.this.presenter.onDataFetched();
                }

                public void onFailure(Throwable caught) {
                    Window.alert((String)"DB Error retrieving Member's ET Data");
                }
            });
            return;
        }
        Window.alert((String)"Error: no email for Member's ET Data!");
    }

    @Override
    public void putData() {
        if (this.model.getKey() == null) {
            this.addUser();
            return;
        }
        this.updateUser();
    }

    private void addUser() {
        this.rpcService.addHbgbUser(this.model, new AsyncCallback<HbgbUser>(){

            public void onSuccess(HbgbUser user) {
                if (user == null) return;
                Window.alert((String)"User added");
                HbgbUserModel.this.presenter.onDataPut();
            }

            public void onFailure(Throwable caught) {
                Window.alert((String)"Error updating User");
                HbgbUserModel.this.presenter.onDataPut();
            }
        });
    }

    private void updateUser() {
        this.rpcService.updateHbgbUser(this.model, new AsyncCallback<Boolean>(){

            public void onSuccess(Boolean saved) {
                if (saved == false) return;
                Window.alert((String)"User updated");
                HbgbUserModel.this.presenter.onDataPut();
            }

            public void onFailure(Throwable caught) {
                Window.alert((String)"Error updating User");
                HbgbUserModel.this.presenter.onDataPut();
            }
        });
    }

    public HbgbUser getData() {
        return this.model;
    }

    public void setData(HbgbUser t) {
        this.model = t;
    }

}

