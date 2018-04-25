/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: javax.servlet.ServletException
 * javax.servlet.http.HttpServlet javax.servlet.http.HttpServletRequest
 * javax.servlet.http.HttpServletResponse
 */
package org.hbgb.webcamp.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hbgb.webcamp.shared.RosterDetails;

@SuppressWarnings("serial")
public class CamperRosterServlet extends HttpServlet
{

	private ApplicationServiceImpl appServ = new ApplicationServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		// get year parameter
		int year = Integer.parseInt(req.getParameter("year"));

		// get all Applications from that year that are ACCEPTED
		List<RosterDetails> roster = appServ.getAcceptedRosterDetailsByYear(year);

		// set up output stream
		resp.setHeader("Content-Type", "text/html");

		// Start Table
		resp.getWriter().println("<table>");

		// for each
		for (RosterDetails details : roster)
		{
			// start row
			resp.getWriter().println("<tr>");

			// display photo in cell #1
			resp.getWriter().println("<td style=\"background-image:url('");
			resp.getWriter().println(details.getPhotoURL());
			resp.getWriter().println("')\"; class=\"rosterPic\">");
			resp.getWriter().println("</td>");
			// display info in Cell #2
			resp.getWriter().println("<td>");

			// display playa name
			resp.getWriter().println("<h2>Playa Name: " + details.getPlayaName() + " </h2> <br/>");

			// display assigned committee
			resp.getWriter().println("Circle: " + details.getCommittee() + " <br/>");

			// display bio
			resp.getWriter().println("Bio: " + details.getBio());

			resp.getWriter().println("</td>");

			// end row
			resp.getWriter().println("</tr>");
		}

		// end table
		resp.getWriter().println("</table>");
	}
}
