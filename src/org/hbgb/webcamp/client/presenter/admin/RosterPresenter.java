/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.user.client.Window
 * com.google.gwt.user.client.rpc.AsyncCallback
 * com.google.gwt.user.client.ui.HasWidgets com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.admin;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import java.util.List;
import org.hbgb.webcamp.client.async.ApplicationServiceAsync;
import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.presenter.IPresenter;
import org.hbgb.webcamp.client.view.application.HTMLPanelView;
import org.hbgb.webcamp.client.view.application.HTMLPanelViewImpl;
import org.hbgb.webcamp.shared.RosterDetails;

public class RosterPresenter implements IPresenter
{
	private final ApplicationServiceAsync rpcService = AsyncServiceFinder.getApplicationService();
	HTMLPanelView view = new HTMLPanelViewImpl();
	HasWidgets screen;

	@Override
	public void setScreen(HasWidgets container)
	{
		this.screen = container;
	}

	@Override
	public void go()
	{
		this.view.clear();
		this.fetchData();
	}

	private void fetchData()
	{
		this.rpcService.getAcceptedRosterDetailsByYear("2016", new AsyncCallback<List<RosterDetails>>()
		{

			public void onSuccess(List<RosterDetails> result)
			{
				RosterPresenter.this.setViewHTML(result);
				RosterPresenter.this.screen.add(RosterPresenter.this.view.asWidget());
			}

			public void onFailure(Throwable caught)
			{
				Window.alert((String) "Error fetching RosterDetails");
			}
		});
	}

	private void setViewHTML(List<RosterDetails> roster)
	{
		StringBuilder html = new StringBuilder();
		html.append("<table border=1><tr><td align='center'> <b>Photo</b> </td><td align='center'> <b>Stats</b> </td></tr>");
		for (RosterDetails details : roster)
		{
			html.append("<tr>");
			html.append("<td>");
			html.append("<img src=" + details.getPhotoURL() + ">");
			html.append("</td>");
			html.append("<td>");
			if (details.getPlayaName() != null && !details.getPlayaName().isEmpty())
			{
				html.append("<h2>Playa Name: " + details.getPlayaName() + " </h2> <br/>");
			}
			else
			{
				html.append("<h2>First Name: " + details.getFirstName() + " </h2> <br/>");
			}
			html.append("Home town: " + details.getHomeTown() + " <br/>");
			html.append("Committee: " + details.getCommittee() + " <br/>");
			html.append("Bio: " + details.getBio());
			html.append("</td>");
			html.append("</tr>");
		}
		html.append("</table>");
		this.view.setHTML(html.toString());
	}

}
