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
import org.hbgb.webcamp.client.model.CommitteeInfoBlockModel;
import org.hbgb.webcamp.client.model.HealerSheetInfoBlockModel;
import org.hbgb.webcamp.client.presenter.IKeyedModelPresenter;
import org.hbgb.webcamp.client.presenter.KeyPresenterI;
import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.application.input.InputCommitteeInfoView;
import org.hbgb.webcamp.shared.CommitteeInfoBlock;
import org.hbgb.webcamp.shared.HealerSheetInfoBlock;
import org.hbgb.webcamp.shared.enums.Committee;
import org.hbgb.webcamp.shared.enums.SecurityRole;

public class InputCommitteeNHealerSheetInfoPresenter
implements SequentialPresenterI,
IKeyedModelPresenter {
    private static final int THIS_YEAR = 2016;
    private static final int NUM_MODELS = 2;
    private int num_calls = 0;
    private String key;
    private InputCommitteeInfoView view;
    private HasWidgets screen;
    private KeyPresenterI nextPresenter;
    private HealerSheetInfoBlockModel hsModel;
    private CommitteeInfoBlockModel ciModel;

    public InputCommitteeNHealerSheetInfoPresenter(String key) {
        this.key = key;
        this.hsModel = new HealerSheetInfoBlockModel();
        this.ciModel = new CommitteeInfoBlockModel();
        this.hsModel.setPresenter(this);
        this.ciModel.setPresenter(this);
        this.view = ViewFinder.getCommitteeInfoView();
        this.view.setVisibility(SecurityRole.USER);
        this.view.setPresenter(this);
    }

    @Override
    public void setKey(String key) {
        this.key = key;
        this.num_calls = 0;
    }

    @Override
    public void go(HasWidgets container) {
        this.screen = container;
        this.screen.clear();
        this.view.clear();
        this.hsModel.fetchDataByAppKey(this.key);
        this.ciModel.fetchData(this.key);
    }

    @Override
    public void onDataFetched() {
        this.setView();
        this.screen.clear();
        this.screen.add(this.view.asWidget());
    }

    @Override
    public void onDataPut() {
        ++this.num_calls;
        if (2 != this.num_calls) return;
        this.screen.clear();
        this.nextPresenter.setKey(this.key);
        this.nextPresenter.go(this.screen);
    }

    @Override
    public void setNextPresenter(KeyPresenterI next) {
        this.nextPresenter = next;
    }

    @Override
    public void onNextButtonClicked() {
        this.setModel();
        this.hsModel.putData();
        this.ciModel.putData();
    }

    private void setView() {
        CommitteeInfoBlock ciBlock;
        HealerSheetInfoBlock hsBlock = this.hsModel.getData();
        if (hsBlock != null) {
            this.view.setSessionLength(hsBlock.getSessionLength());
            this.view.setModality1(hsBlock.getModality1());
            this.view.setModality2(hsBlock.getModality2());
            this.view.setModality3(hsBlock.getModality3());
            this.view.setModality4(hsBlock.getModality4());
            this.view.setBioBox(hsBlock.getBio());
        }
        if ((ciBlock = this.ciModel.getData()) == null) return;
        this.view.setReason1(ciBlock.getReason1());
        this.view.setReason2(ciBlock.getReason2());
        this.view.setCommittee1(ciBlock.getCommittee1());
        this.view.setCommittee2(ciBlock.getCommittee2());
        this.view.setAssignedCommittee(ciBlock.getAssignedCommittee());
        this.view.setIsAssignedLead(ciBlock.getIsAssignedLead());
    }

    private void setModel() {
        HealerSheetInfoBlock block = this.hsModel.getData();
        block.setSessionLength(this.view.getSessionLength());
        block.setModality1(this.view.getModality1());
        block.setModality2(this.view.getModality2());
        block.setModality3(this.view.getModality3());
        block.setModality4(this.view.getModality4());
        block.setBio(this.view.getBioBox());
        this.hsModel.setData(block);
        CommitteeInfoBlock ciBlock = this.ciModel.getData();
        ciBlock.setReason1(this.view.getReason1());
        ciBlock.setReason2(this.view.getReason2());
        ciBlock.setCommittee1(this.view.getCommittee1());
        ciBlock.setCommittee2(this.view.getCommittee2());
        ciBlock.setAssignedCommittee(this.view.getAssignedCommittee());
        ciBlock.setIsAssignedLead(this.view.getIsAssignedLead());
        this.ciModel.setData(ciBlock);
    }
}

