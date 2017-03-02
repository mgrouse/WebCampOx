/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.shared.GwtEvent
 *  com.google.gwt.event.shared.HandlerManager
 *  com.google.gwt.user.client.Window
 *  com.google.gwt.user.client.rpc.AsyncCallback
 *  com.google.gwt.user.client.ui.HasWidgets
 *  com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.admin;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.async.HealerSheetServiceAsync;
import org.hbgb.webcamp.client.common.ColumnDefinition;
import org.hbgb.webcamp.client.common.HealerSheetDetailsColumnDefinitionsFactory;
import org.hbgb.webcamp.client.common.SelectionModel;
import org.hbgb.webcamp.client.event.application.EditHealerSheetEvent;
import org.hbgb.webcamp.client.event.application.PrintHealerSheetEvent;
import org.hbgb.webcamp.client.presenter.IPresenter;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.application.HealerSheetListView;
import org.hbgb.webcamp.shared.HealerSheetDetails;

public class HealerSheetListPresenter
implements IPresenter,
HealerSheetListView.Presenter<HealerSheetDetails> {
    private final HandlerManager eventBus;
    private final HealerSheetServiceAsync rpcService = AsyncServiceFinder.getHealerSheetService();
    private List<HealerSheetDetails> sheets;
    private final SelectionModel<HealerSheetDetails> selectionModel;
    private final HealerSheetListView<HealerSheetDetails> view;
    private HasWidgets screen;

    public HealerSheetListPresenter(HandlerManager eventBus) {
        this.eventBus = eventBus;
        this.selectionModel = new SelectionModel();
        this.view = ViewFinder.getHealerSheetListView();
        this.view.setPresenter(this);
        this.view.setColumnDefinitions(HealerSheetDetailsColumnDefinitionsFactory.getHealerSheetColumnDefinitions());
    }

    @Override
    public void setScreen(HasWidgets container) {
        this.screen = container;
    }

    @Override
    public void go() {
        this.view.clear();
        this.fetchHealerSheets();
    }

    @Override
    public void onItemClicked(HealerSheetDetails clickedItem, int column) {
        if (9 == column) {
            this.eventBus.fireEvent((GwtEvent)new PrintHealerSheetEvent(clickedItem));
            return;
        }
        ArrayList<String> keyList = new ArrayList<String>();
        for (HealerSheetDetails hs : this.sheets) {
            keyList.add(hs.getEncodedKey());
        }
        this.eventBus.fireEvent((GwtEvent)new EditHealerSheetEvent(clickedItem.getEncodedKey(), keyList));
    }

    @Override
    public void onItemSelected(HealerSheetDetails selectedItem) {
        if (this.selectionModel.isSelected(selectedItem)) {
            this.selectionModel.removeSelection(selectedItem);
            return;
        }
        this.selectionModel.addSelection(selectedItem);
    }

    private void fetchHealerSheets() {
        this.rpcService.getAllHealerSheetDetails(new AsyncCallback<List<HealerSheetDetails>>(){

            public void onSuccess(List<HealerSheetDetails> result) {
                HealerSheetListPresenter.access$2(HealerSheetListPresenter.this, result);
                HealerSheetListPresenter.this.view.setRowData(HealerSheetListPresenter.this.sheets);
                HealerSheetListPresenter.this.screen.add(HealerSheetListPresenter.this.view.asWidget());
            }

            public void onFailure(Throwable caught) {
                Window.alert((String)("Error fetching Healer Sheet Details: " + caught.getMessage()));
            }
        });
    }

    static /* synthetic */ void access$2(HealerSheetListPresenter healerSheetListPresenter, List list) {
        healerSheetListPresenter.sheets = list;
    }

}

