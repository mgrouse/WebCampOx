/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package org.hbgb.webcamp.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hbgb.webcamp.server.ApplicationServiceImpl;
import org.hbgb.webcamp.shared.RosterDetails;

public class CamperRosterServlet
extends HttpServlet {
    private ApplicationServiceImpl appServ = new ApplicationServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String year = req.getParameter("year");
        List<RosterDetails> roster = this.appServ.getAcceptedRosterDetailsByYear(year);
        resp.setHeader("Content-Type", "text/html");
        resp.getWriter().println("<table border=1><tr><td align='center'> <b>Photo</b> </td><td align='center'> <b>Stats</b> </td></tr>");
        for (RosterDetails details : roster) {
            resp.getWriter().println("<tr>");
            resp.getWriter().println("<td>");
            resp.getWriter().println("<img src=" + details.getPhotoURL() + "/>");
            resp.getWriter().println("</td>");
            resp.getWriter().println("<td>");
            resp.getWriter().println("<h2>Playa Name: " + details.getPlayaName() + " </h2> <br/>");
            resp.getWriter().println("Committee: " + details.getCommittee() + " <br/>");
            resp.getWriter().println("Bio: " + details.getBio());
            resp.getWriter().println("</td>");
            resp.getWriter().println("</tr>");
        }
        resp.getWriter().println("</table>");
    }
}

