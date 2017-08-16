/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.event.shared.HandlerManager
 * com.google.gwt.user.client.ui.HasWidgets com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.admin;

import org.hbgb.webcamp.client.presenter.IPresenter;
import org.hbgb.webcamp.client.view.application.HTMLPanelView;
import org.hbgb.webcamp.client.view.application.HTMLPanelViewImpl;
import org.hbgb.webcamp.shared.HealerSheetDetails;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public class HealerSheetPrintPresenter implements IPresenter
{
	private HandlerManager eventBus;
	private HealerSheetDetails details;
	private HTMLPanelView view;
	private HasWidgets screen;

	public HealerSheetPrintPresenter(HandlerManager eb)
	{
		eventBus = eb;
		view = new HTMLPanelViewImpl();
	}

	@Override
	public void setScreen(HasWidgets container)
	{
		screen = container;
	}

	public void setHealerSheetDetails(HealerSheetDetails hsd)
	{
		details = hsd;
	}

	@Override
	public void go()
	{
		screen.clear();
		printSheetToView();
		screen.add(view.asWidget());
	}

	private void printSheetToView()
	{
		StringBuffer html = new StringBuffer();

		// Header
		html.append("<div>");
		html.append("<table cellspacing = \"0\" cellpadding = \"0px\">");
		html.append("<tr>");
		html.append(
				"<td><img src=\"http://storage.googleapis.com/hbgbwebcamp.appspot.com/HeeBeeManAndFlames.jpg\"></td>");
		html.append(
				"<td><img src=\"http://storage.googleapis.com/hbgbwebcamp.appspot.com/HBGB_ChangeWorldOneBurnerHorizTxt.jpg\"></td>");
		html.append(
				"<td><img src=\"http://storage.googleapis.com/hbgbwebcamp.appspot.com/HBGBHealersTxt.jpg\"></td>");
		html.append(
				"<td><img src=\"http://storage.googleapis.com/hbgbwebcamp.appspot.com/HBGB_ChangeWorldOneBurnerHorizTxt.jpg\"></td>");
		html.append(
				"<td><img src=\"http://storage.googleapis.com/hbgbwebcamp.appspot.com/HeeBeeManAndFlames.jpg\"></td>");
		html.append("</tr>");
		html.append("</table>");
		html.append("</div>");

		// Left - Modality List
		html.append("<div>");
		html.append("<div class= \"modality\">");
		html.append("<h2>Sign up sheet for " + details.getPlayaName() + "</h2>");
		html.append("<ul>");
		if (!details.getModality1().isEmpty())
		{
			html.append("<li>" + details.getModality1() + "</li>");
		}
		if (!details.getModality2().isEmpty())
		{
			html.append("<li>" + details.getModality2() + "</li>");
		}
		if (!details.getModality3().isEmpty())
		{
			html.append("<li>" + details.getModality3() + "</li>");
		}
		if (!details.getModality4().isEmpty())
		{
			html.append("<li>" + details.getModality4() + "</li>");
		}
		html.append("</ul>");
		html.append("<div class= \"sessionTiming\">");
		html.append("<p class= \"sessionTiming\"> Sessions average ");
		if (!details.getSessionLength().isEmpty())
		{
			html.append("<u>" + details.getSessionLength() + "</u>");
		}
		else
		{
			html.append("<u>&nbsp;&nbsp;&nbsp;&nbsp;</u>");
		}
		html.append(" minutes.<br>");
		html.append("Please be patient... timing is approximate.");
		html.append("<br><br>");
		html.append("<b>Sign up for a session below</b> </p>");
		html.append("</div>");
		html.append("</div>");

		// Center - Pic
		html.append("<div class = \"picture\">");
		html.append("<img src=" + details.getImageURL() + "=s300-c>");
		html.append("</div>");

		// Right - Who is <name>?
		html.append("<div class = \"whoIs\">");
		html.append("<h1>Who is " + details.getPlayaName() + " ?</h1>");
		html.append("<p class= \"bio\">" + details.getBio() + "</p>");
		html.append("</div>");
		html.append("</div>");

		// Bottom - Sign up
		html.append("<div class = \"clearFloats\"></div>");

		html.append("<div class = \"signUp\">");
		html.append("<table class = \"signUp\">");
		html.append("<th></th> <th>Time In (staff use)</th>");
		html.append("<tr> <td class=\"sigCell\">1)</td> <td class=\"timeCell\">&nbsp;</td> </tr>");
		html.append("<tr> <td class=\"sigCell\">2)</td> <td class=\"timeCell\">&nbsp;</td> </tr>");
		html.append("<tr> <td class=\"sigCell\">3)</td> <td class=\"timeCell\">&nbsp;</td> </tr>");
		html.append("<tr> <td class=\"sigCell\">4)</td> <td class=\"timeCell\">&nbsp;</td> </tr>");
		html.append("<tr> <td class=\"sigCell\">5)</td> <td class=\"timeCell\">&nbsp;</td> </tr>");
		html.append("<tr> <td class=\"sigCell\">6)</td> <td class=\"timeCell\">&nbsp;</td> </tr>");
		html.append("<tr> <td class=\"sigCell\">7)</td> <td class=\"timeCell\">&nbsp;</td> </tr>");
		html.append("<tr> <td class=\"sigCell\">8)</td> <td class=\"timeCell\">&nbsp;</td> </tr>");
		html.append("</table>");
		html.append("</div>");

		view.setHTML(html.toString());
	}
}
