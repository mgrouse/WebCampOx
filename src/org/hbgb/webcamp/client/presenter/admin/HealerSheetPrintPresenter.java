/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.event.shared.HandlerManager
 *  com.google.gwt.user.client.ui.HasWidgets
 *  com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.presenter.admin;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import org.hbgb.webcamp.client.presenter.IPresenter;
import org.hbgb.webcamp.client.view.application.HTMLPanelView;
import org.hbgb.webcamp.client.view.application.HTMLPanelViewImpl;
import org.hbgb.webcamp.shared.HealerSheetDetails;

public class HealerSheetPrintPresenter
implements IPresenter {
    private HandlerManager eventBus;
    private HealerSheetDetails details;
    private HTMLPanelView view;
    private HasWidgets screen;

    public HealerSheetPrintPresenter(HandlerManager eventBus) {
        this.eventBus = eventBus;
        this.view = new HTMLPanelViewImpl();
    }

    @Override
    public void setScreen(HasWidgets container) {
        this.screen = container;
    }

    public void setHealerSheetDetails(HealerSheetDetails details) {
        this.details = details;
    }

    @Override
    public void go() {
        this.screen.clear();
        this.printSheetToView();
        this.screen.add(this.view.asWidget());
    }

    private void printSheetToView() {
        StringBuffer html = new StringBuffer();
        html.append("<div>");
        html.append("<table cellspacing = \"0\" cellpadding = \"0px\">");
        html.append("<tr>");
        html.append("<td><img src=\"http://storage.googleapis.com/hbgbwebcamp.appspot.com/HeeBeeManAndFlames.jpg\"></td>");
        html.append("<td><img src=\"http://storage.googleapis.com/hbgbwebcamp.appspot.com/HBGB_ChangeWorldOneBurnerHorizTxt.jpg\"></td>");
        html.append("<td><img src=\"http://storage.googleapis.com/hbgbwebcamp.appspot.com/HBGBHealersTxt.jpg\"></td>");
        html.append("<td><img src=\"http://storage.googleapis.com/hbgbwebcamp.appspot.com/HBGB_ChangeWorldOneBurnerHorizTxt.jpg\"></td>");
        html.append("<td><img src=\"http://storage.googleapis.com/hbgbwebcamp.appspot.com/HeeBeeManAndFlames.jpg\"></td>");
        html.append("</tr>");
        html.append("</table>");
        html.append("</div>");
        html.append("<div>");
        html.append("<div class= \"modality\">");
        html.append("<h2>Sign up sheet for " + this.details.getPlayaName() + "</h2>");
        html.append("<ul>");
        if (!this.details.getModality1().isEmpty()) {
            html.append("<li>" + this.details.getModality1() + "</li>");
        }
        if (!this.details.getModality2().isEmpty()) {
            html.append("<li>" + this.details.getModality2() + "</li>");
        }
        if (!this.details.getModality3().isEmpty()) {
            html.append("<li>" + this.details.getModality3() + "</li>");
        }
        if (!this.details.getModality4().isEmpty()) {
            html.append("<li>" + this.details.getModality4() + "</li>");
        }
        html.append("</ul>");
        html.append("<div class= \"sessionTiming\">");
        html.append("<p class= \"sessionTiming\"> Sessions average ");
        if (!this.details.getSessionLength().isEmpty()) {
            html.append("<u>" + this.details.getSessionLength() + "</u>");
        } else {
            html.append("<u>&nbsp;&nbsp;&nbsp;&nbsp;</u>");
        }
        html.append(" minutes.<br>");
        html.append("Please be patient... timing is approximate.<br><b>Sign up for a session below</b> </p>");
        html.append("</div>");
        html.append("</div>");
        html.append("<div class = \"picture\">");
        html.append("<img src=" + this.details.getImageURL() + "=s300-c>");
        html.append("</div>");
        html.append("<div class = \"whoIs\">");
        html.append("<h1>Who is " + this.details.getPlayaName() + " ?</h1>");
        html.append("<p class= \"bio\">" + this.details.getBio() + "</p>");
        html.append("</div>");
        html.append("</div>");
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
        this.view.setHTML(html.toString());
    }
}

