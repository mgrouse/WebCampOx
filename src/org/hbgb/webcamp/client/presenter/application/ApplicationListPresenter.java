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
package org.hbgb.webcamp.client.presenter.application;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hbgb.webcamp.client.async.ApplicationServiceAsync;
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.common.ApplicationColumnDefinitionsFactory;
import org.hbgb.webcamp.client.common.ColumnDefinition;
import org.hbgb.webcamp.client.common.SelectionModel;
import org.hbgb.webcamp.client.event.application.AddApplicationEvent;
import org.hbgb.webcamp.client.event.application.EditApplicationEvent;
import org.hbgb.webcamp.client.presenter.IPresenter;
import org.hbgb.webcamp.client.view.ViewFinder;
import org.hbgb.webcamp.client.view.application.ApplicationListView;
import org.hbgb.webcamp.shared.ApplicationDetails;

public class ApplicationListPresenter
implements IPresenter,
ApplicationListView.Presenter<ApplicationDetails> {
    private List<ApplicationDetails> applicationDetails;
    private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
    private final HandlerManager eventBus;
    private final ApplicationListView<ApplicationDetails> view;
    private final SelectionModel<ApplicationDetails> selectionModel;
    private HasWidgets screen;

    public ApplicationListPresenter(HandlerManager eventBus) {
        this.eventBus = eventBus;
        this.view = ViewFinder.getApplicationListView();
        this.selectionModel = new SelectionModel();
        this.view.setPresenter(this);
        this.view.setColumnDefinitions(ApplicationColumnDefinitionsFactory.getApplicationColumnDefinitions());
    }

    @Override
    public void onAddButtonClicked() {
        this.eventBus.fireEvent((GwtEvent)new AddApplicationEvent());
    }

    @Override
    public void onDeleteButtonClicked() {
    }

    @Override
    public void onItemClicked(ApplicationDetails clickedItem) {
        ArrayList<String> keyList = new ArrayList<String>();
        for (ApplicationDetails ad : this.applicationDetails) {
            keyList.add(ad.getEncodedKey());
        }
        this.eventBus.fireEvent((GwtEvent)new EditApplicationEvent(clickedItem.getEncodedKey(), keyList));
    }

    @Override
    public void onItemSelected(ApplicationDetails selectedItem) {
        if (this.selectionModel.isSelected(selectedItem)) {
            this.selectionModel.removeSelection(selectedItem);
            return;
        }
        this.selectionModel.addSelection(selectedItem);
    }

    @Override
    public void setScreen(HasWidgets container) {
        this.screen = container;
    }

    @Override
    public void go() {
        this.view.clear();
        this.fetchApplicationDetails();
    }

    public void setApplicationDetails(List<ApplicationDetails> applicationDetails) {
        this.applicationDetails = applicationDetails;
    }

    public List<ApplicationDetails> getApplicationDetails() {
        return this.applicationDetails;
    }

    public ApplicationDetails getApplicationDetail(int index) {
        return this.applicationDetails.get(index);
    }

    private void fetchApplicationDetails() {
        this.rpcService.getApplicationDetails(new AsyncCallback<ArrayList<ApplicationDetails>>(){

            public void onSuccess(ArrayList<ApplicationDetails> result) {
                ApplicationListPresenter.access$2(ApplicationListPresenter.this, result);
                ApplicationListPresenter.this.screen.clear();
                ApplicationListPresenter.this.view.setRowData(ApplicationListPresenter.this.applicationDetails);
                ApplicationListPresenter.this.screen.add(ApplicationListPresenter.this.view.asWidget());
            }

            public void onFailure(Throwable caught) {
                Window.alert((String)"Error fetching Application details");
            }
        });
    }

    private void deleteSelectedApplications() {
        List<ApplicationDetails> selectedUsers = this.selectionModel.getSelectedItems();
        ArrayList<String> ids = new ArrayList<String>();
        int i = 0;
        while (i < selectedUsers.size()) {
            ids.add(selectedUsers.get(i).getEncodedKey());
            ++i;
        }
        this.rpcService.deleteApplications(ids, new AsyncCallback<ArrayList<ApplicationDetails>>(){

            public void onSuccess(ArrayList<ApplicationDetails> result) {
                ApplicationListPresenter.this.selectionModel.clearSelections();
                ApplicationListPresenter.access$2(ApplicationListPresenter.this, result);
                ApplicationListPresenter.this.view.setRowData(ApplicationListPresenter.this.applicationDetails);
            }

            public void onFailure(Throwable caught) {
                System.out.println("Error deleting selected applications");
            }
        });
    }

    static /* synthetic */ void access$2(ApplicationListPresenter applicationListPresenter, List list) {
        applicationListPresenter.applicationDetails = list;
    }

}

