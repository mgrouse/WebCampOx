/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.shared.GwtEvent
 *  com.google.gwt.event.shared.HandlerManager
 *  com.google.gwt.user.client.ui.HasWidgets
 *  com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.application;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.hbgb.webcamp.client.event.application.ListHealerSheetEvent;
import org.hbgb.webcamp.client.presenter.IWholePresenter;
import org.hbgb.webcamp.client.presenter.application.edit.AbstractInfoBlockPresenter;
import org.hbgb.webcamp.client.view.application.EditApplicationViewImpl;
import org.hbgb.webcamp.client.view.application.IEditApplicationView;

public class WholePresenter
implements IWholePresenter {
    private final HandlerManager eventBus;
    private List<AbstractInfoBlockPresenter> parts;
    private String key;
    private List<String> keyList;
    IEditApplicationView view;
    private HasWidgets screen;

    public WholePresenter(HandlerManager eventBus) {
        this.eventBus = eventBus;
        this.view = new EditApplicationViewImpl();
        this.view.setPresenter(this);
    }

    @Override
    public void setScreen(HasWidgets container) {
        this.screen = container;
        this.screen.add(this.view.asWidget());
    }

    @Override
    public void setParts(List<AbstractInfoBlockPresenter> partList) {
        this.parts = new ArrayList<AbstractInfoBlockPresenter>();
        for (AbstractInfoBlockPresenter part : partList) {
            part.setScreen(this.view.getScreen());
            this.parts.add(part);
        }
    }

    @Override
    public void setKey(String key) {
        this.key = key;
        for (AbstractInfoBlockPresenter part : this.parts) {
            part.setKey(key);
        }
    }

    @Override
    public void setKeyList(List<String> list) {
        this.keyList = list;
        this.setNextPrevButtonState();
    }

    @Override
    public void onPrevButtonClicked() {
        ListIterator<String> iterator = this.keyList.listIterator(this.keyList.indexOf(this.key));
        if (iterator.hasPrevious()) {
            this.setKey(iterator.previous());
        }
        iterator.next();
        this.setNextPrevButtonState();
    }

    @Override
    public void onListButtonClicked() {
        this.eventBus.fireEvent((GwtEvent)new ListHealerSheetEvent());
    }

    @Override
    public void onNextButtonClicked() {
        ListIterator<String> iterator = this.keyList.listIterator(this.keyList.indexOf(this.key));
        iterator.next();
        if (iterator.hasNext()) {
            this.setKey(iterator.next());
        }
        this.setNextPrevButtonState();
    }

    private void setNextPrevButtonState() {
        ListIterator<String> iterator = this.keyList.listIterator(this.keyList.indexOf(this.key));
        iterator.next();
        if (iterator.hasNext()) {
            this.view.setNextButtonEnabled(true);
        } else {
            this.view.setNextButtonEnabled(false);
        }
        iterator.previous();
        if (iterator.hasPrevious()) {
            this.view.setPrevButtonEnabled(true);
            return;
        }
        this.view.setPrevButtonEnabled(false);
    }
}

