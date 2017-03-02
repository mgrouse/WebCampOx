/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.ui.HasWidgets
 *  com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.application.input;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import org.hbgb.webcamp.client.model.HealerSheetInfoBlockModel;
import org.hbgb.webcamp.client.presenter.IKeyedModelPresenter;
import org.hbgb.webcamp.client.presenter.KeyPresenterI;
import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.application.input.InputHealerSheetInfoView;
import org.hbgb.webcamp.shared.HealerSheetInfoBlock;

public class InputHealerSheetInfoPresenter
implements SequentialPresenterI,
IKeyedModelPresenter {
    private String key;
    private InputHealerSheetInfoView view;
    private HasWidgets screen;
    private KeyPresenterI nextPresenter;
    private HealerSheetInfoBlockModel model;

    public InputHealerSheetInfoPresenter(String key) {
        this.key = key;
        this.view = ViewFinder.getHealerSheetInfoView();
        this.view.setPresenter(this);
        this.model = new HealerSheetInfoBlockModel();
        this.model.setPresenter(this);
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public void go(HasWidgets container) {
        this.screen = container;
        this.screen.clear();
        this.view.clear();
        this.model.fetchData(this.key);
    }

    @Override
    public void setNextPresenter(KeyPresenterI next) {
        this.nextPresenter = next;
    }

    @Override
    public void onNextButtonClicked() {
        this.setModel();
        this.model.putData();
    }

    private void setView() {
        HealerSheetInfoBlock block = this.model.getData();
        this.view.setSessionLength(block.getSessionLength());
        this.view.setModality1(block.getModality1());
        this.view.setModality2(block.getModality2());
        this.view.setModality3(block.getModality3());
        this.view.setModality4(block.getModality4());
        this.view.setBioBox(block.getBio());
    }

    private void setModel() {
        HealerSheetInfoBlock block = this.model.getData();
        block.setSessionLength(this.view.getSessionLength());
        block.setModality1(this.view.getModality1());
        block.setModality2(this.view.getModality2());
        block.setModality3(this.view.getModality3());
        block.setModality4(this.view.getModality4());
        block.setBio(this.view.getBioBox());
        this.model.setData(block);
    }

    @Override
    public void onDataFetched() {
        this.setView();
        this.screen.add(this.view.asWidget());
    }

    @Override
    public void onDataPut() {
        this.screen.clear();
        this.nextPresenter.setKey(this.key);
        this.nextPresenter.go(this.screen);
    }
}

