package org.hbgb.webcamp.client;

import java.util.logging.Logger;

import org.hbgb.webcamp.client.applet.ApplicationProcessApplet;
import org.hbgb.webcamp.client.applet.HealerSheetInputApplet;
import org.hbgb.webcamp.client.applet.HealerSheetListApplet;
import org.hbgb.webcamp.client.presenter.admin.RosterPresenter;
import org.hbgb.webcamp.client.window.AdminWindowManager;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class WebCampEntryPoint implements EntryPoint, ValueChangeHandler<String>
{
	private static final Logger log = Logger.getLogger(WebCampEntryPoint.class.getName());
	private static final RootLayoutPanel rp = RootLayoutPanel.get();

	@Override
	public void onModuleLoad()
	{
		log.info("Module loaded. BaseURL - " + GWT.getModuleBaseURL());

		History.addValueChangeHandler(this);

		if ("".equals(History.getToken()))
		{
			History.newItem("apply");
		}
		else
		{
			History.fireCurrentHistoryState();
		}
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event)
	{
		String token = event.getValue();

		if (token != null)
		{
			switch (token)
			{
			case "admin":
				startAdminPanel(rp);
				break;

			case "apply":
				startApplication(rp);
				break;

			case "healer":
				startHealer(rp);
				break;

			case "roster":
				startRoster(rp);
				break;

			case "sheet":
				startSheet(rp);
				break;

			case "profile":
				startProfileEdit(rp);
				break;

			case "test":
				startTest(rp);
			}
		}
	}

	private void startAdminPanel(final RootLayoutPanel rp)
	{
		AdminWindowManager winMan = new AdminWindowManager();
		rp.clear();
		rp.add(winMan);

		/*
		 * LoginPresenter login = new LoginPresenter(new LoginPopup());
		 * EventBus.get().addHandler(AuthenticatedEvent.TYPE, new
		 * AuthenticatedHandler() {
		 * 
		 * @Override public void onAuthenticated(AuthenticatedEvent event) {
		 * 
		 * WindowManager winMan = new WindowManager();//event.getUser());
		 * rp.add(winMan); }
		 * 
		 * });
		 * 
		 * login.go(rp);
		 */
	}

	private void startApplication(RootLayoutPanel rp)
	{
		ApplicationProcessApplet appProcApp = new ApplicationProcessApplet();
		rp.clear();
		appProcApp.run(rp);
	}

	private void startHealer(final RootLayoutPanel rp)
	{
		HealerSheetInputApplet healerApp = new HealerSheetInputApplet();
		rp.clear();
		healerApp.run(rp);
	}

	private void startSheet(final RootLayoutPanel rp)
	{
		HealerSheetListApplet healerApp = new HealerSheetListApplet();
		rp.clear();
		healerApp.run(rp);
	}

	private void startRoster(RootLayoutPanel rp)
	{
		RosterPresenter presenter = new RosterPresenter();
		rp.clear();
		presenter.setScreen(rp);
		presenter.go();
	}

	private void startProfileEdit(RootLayoutPanel rp)
	{

	}

	private void startTest(RootLayoutPanel rp)
	{

	}
}
