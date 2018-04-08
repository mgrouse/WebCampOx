/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.rpc.RemoteService
 * com.google.gwt.user.client.rpc.RemoteServiceRelativePath
 */
package org.hbgb.webcamp.client.async;

import org.hbgb.webcamp.shared.enums.Circle;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath(value = "emailService")
public interface EmailService extends RemoteService
{
	public String sendApplicationRecievedEmail(String var1) throws Exception;

	public String sendEmailToCircle(Circle circle, String subject, String message,
			String replyAddress);
}
