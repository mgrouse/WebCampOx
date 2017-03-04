/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.server.rpc.RemoteServiceServlet javax.mail.Address
 * javax.mail.Authenticator javax.mail.Message javax.mail.Message$RecipientType
 * javax.mail.Session javax.mail.Transport javax.mail.internet.InternetAddress
 * javax.mail.internet.MimeMessage
 */
package org.hbgb.webcamp.server;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hbgb.webcamp.client.async.EmailService;
import org.hbgb.webcamp.shared.Application;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class EmailServiceImpl extends RemoteServiceServlet implements EmailService
{
	@Override
	public String sendApplicationRecievedEmail(String key)
	{
		ApplicationServiceImpl appServ = new ApplicationServiceImpl();
		Application app = appServ.getApplication(key);
		return this.sendMail(app.getEmail(), "HeeBee Application Received!", this.getApplicationEmailBody());
	}

	private String sendMail(String to, String subject, String message)
	{
		String output = "Success";
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, (Authenticator) null);
		try
		{
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(this.getWebmasterAddress());
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(subject);
			msg.setText(message);
			msg.setReplyTo(new InternetAddress[] { this.getRegistrationLeadAddress() });
			Transport.send(msg);
			return output;
		}
		catch (Exception e)
		{
			return e.toString();
		}
	}

	private String getApplicationEmailBody()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Thank you for Applying to be part of the HeeBee camp.\n");
		sb.append("If you don't hear from us soon, email ");
		sb.append(getRegistrationLeadAddressAsText());
		sb.append("\nPlease don't reply to this email address.\n");
		sb.append("Meet the rest of us by joining the HeeBeeGeeBee Healers Google Group at:");
		sb.append("https://groups.google.com/forum/#!forum/heebees.\n");
		sb.append("\n");
		sb.append("This year's co-leads:\n");
		sb.append("Quiggles and Dragonheart\n");
		return sb.toString();
	}

	private InternetAddress getWebmasterAddress() throws Exception
	{
		return new InternetAddress("michael.grouse@gmail.com", "Scarab");
	}

	private InternetAddress getRegistrationLeadAddress() throws Exception
	{
		return new InternetAddress("shanalory@hotmail.com", "Quiggles");
	}

	private String getRegistrationLeadAddressAsText()
	{
		return "shanalory@hotmail.com";
	}
}
