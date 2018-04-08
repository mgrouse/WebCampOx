
package org.hbgb.webcamp.server;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hbgb.webcamp.client.async.ApplicationService;
import org.hbgb.webcamp.client.async.EmailService;
import org.hbgb.webcamp.shared.Application;
import org.hbgb.webcamp.shared.enums.Circle;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class EmailServiceImpl extends RemoteServiceServlet implements EmailService
{
	private static final ApplicationService appServ = new ApplicationServiceImpl();
	private static final Logger log = Logger.getLogger(EmailServiceImpl.class.getName());

	@Override
	public String sendApplicationRecievedEmail(String key)
	{
		ApplicationServiceImpl appServ = new ApplicationServiceImpl();
		Application app = appServ.getApplication(key);

		List<String> recipient = new ArrayList<>();
		String replyTo = getRegistrationLeadAddressAsText();

		// first to the Lead
		recipient.add(getRegistrationLeadAddressAsText());

		sendMail(recipient, "HeeBee application received! for: " + app.getEmail(),
				getNotificationEmailBody(), getRegistrationLeadAddressAsText());

		// then to the camper
		recipient.clear();
		recipient.add(app.getEmail());

		return sendMail(recipient, "Your HeeBee application was received!",
				getApplicationEmailBody(), replyTo);
	}

	@Override
	public String sendEmailToCircle(Circle circle, String subject, String message,
			String replyAddress)
	{
		List<String> recipients = appServ.getCircleEmailList(circle);

		if (0 == recipients.size())
		{
			return "NoRecipients";
		}

		return sendMail(recipients, subject, message, replyAddress);
	}

	private String sendMail(List<String> recipients, String subject, String message, String replyTo)
	{
		String output = "Success";
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, (Authenticator) null);
		try
		{
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(getWebmasterAddress());

			for (String address : recipients)
			{
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(address));
			}

			// add me for tracking performance
			msg.addRecipient(Message.RecipientType.TO, getWebmasterAddress());

			msg.setSubject(subject);
			msg.setText(message);
			msg.setReplyTo(new InternetAddress[] { asInternetAddress(replyTo) });
			Transport.send(msg);
		}
		catch (Exception e)
		{
			output = "Failure";
			// log error
			log.severe(e.getMessage());
			// throw e;
		}

		return output;
	}

	/**
	 * @return
	 */
	private String getNotificationEmailBody()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("A new application has been created.\n");
		sb.append("\n\n");
		sb.append("http://www.hbgbwebcamp.appspot.com/#admin");
		return sb.toString();
	}

	private String getApplicationEmailBody()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Thank you for applying to be part of the HeeBee camp.\n");
		sb.append("If you don't hear from us soon, email ");
		sb.append(getRegistrationLeadAddressAsText());
		sb.append("\nPlease don't reply to this email address.\n");
		sb.append("Meet the rest of us by joining the HeeBeeGeeBee Healers Facebook Group at: ");
		sb.append("https://www.facebook.com/groups/23767999265 \n");
		sb.append("\n");
		sb.append("This year's co-leads, \n");
		sb.append("Quiggles and DragonHeart\n");
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

	private InternetAddress asInternetAddress(String address) throws UnsupportedEncodingException
	{
		return new InternetAddress(address, "Scarab");
	}
}
