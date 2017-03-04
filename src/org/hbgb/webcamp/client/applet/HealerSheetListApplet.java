/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.event.shared.EventHandler com.google.gwt.event.shared.GwtEvent
 * com.google.gwt.event.shared.GwtEvent$Type
 * com.google.gwt.event.shared.HandlerManager
 * com.google.gwt.event.shared.HandlerRegistration
 * com.google.gwt.user.client.ui.HasWidgets
 */
package org.hbgb.webcamp.client.applet;

import java.util.ArrayList;

import org.hbgb.webcamp.client.event.application.EditHealerSheetEvent;
import org.hbgb.webcamp.client.event.application.EditHealerSheetEventHandler;
import org.hbgb.webcamp.client.event.application.ListHealerSheetEvent;
import org.hbgb.webcamp.client.event.application.ListHealerSheetEventHandler;
import org.hbgb.webcamp.client.event.application.PrintHealerSheetEvent;
import org.hbgb.webcamp.client.event.application.PrintHealerSheetEventHandler;
import org.hbgb.webcamp.client.presenter.admin.HealerSheetListPresenter;
import org.hbgb.webcamp.client.presenter.admin.HealerSheetPrintPresenter;
import org.hbgb.webcamp.client.presenter.application.WholePresenter;
import org.hbgb.webcamp.client.presenter.application.edit.AbstractInfoBlockPresenter;
import org.hbgb.webcamp.client.presenter.application.edit.EditHealerSheetInfoPresenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public class HealerSheetListApplet implements IApplet
{
	private final HandlerManager eventBus = new HandlerManager((Object) null);
	private HasWidgets screen;
	private final HealerSheetListPresenter listPresenter = new HealerSheetListPresenter(this.eventBus);
	private final WholePresenter editPresenter = new WholePresenter(this.eventBus);
	private final HealerSheetPrintPresenter printPresenter = new HealerSheetPrintPresenter(this.eventBus);

	public HealerSheetListApplet()
	{
		ArrayList<AbstractInfoBlockPresenter> partList = new ArrayList<>();
		partList.add(new EditHealerSheetInfoPresenter());
		this.editPresenter.setParts(partList);
		this.registerEvents();
	}

	private void registerEvents()
	{
		this.eventBus.addHandler(PrintHealerSheetEvent.TYPE, new PrintHealerSheetEventHandler()
		{

			@Override
			public void onPrintHealerSheet(PrintHealerSheetEvent event)
			{
				HealerSheetListApplet.this.screen.clear();
				HealerSheetListApplet.this.printPresenter.setScreen(HealerSheetListApplet.this.screen);
				HealerSheetListApplet.this.printPresenter.setHealerSheetDetails(event.getDetails());
				HealerSheetListApplet.this.printPresenter.go();
			}
		});
		this.eventBus.addHandler(EditHealerSheetEvent.TYPE, new EditHealerSheetEventHandler()
		{

			@Override
			public void onEditHealerSheet(EditHealerSheetEvent event)
			{
				HealerSheetListApplet.this.screen.clear();
				HealerSheetListApplet.this.editPresenter.setScreen(HealerSheetListApplet.this.screen);
				HealerSheetListApplet.this.editPresenter.setKey(event.getKey());
				HealerSheetListApplet.this.editPresenter.setKeyList(event.getKeyList());
			}
		});
		this.eventBus.addHandler(ListHealerSheetEvent.TYPE, new ListHealerSheetEventHandler()
		{

			@Override
			public void onListHealerSheet(ListHealerSheetEvent event)
			{
				HealerSheetListApplet.this.screen.clear();
				HealerSheetListApplet.this.listPresenter.go();
			}
		});
	}

	@Override
	public void run(HasWidgets container)
	{
		this.screen = container;
		this.listPresenter.setScreen(container);
		this.listPresenter.go();
	}

}
