/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.rpc.AsyncCallback
 */
package org.hbgb.webcamp.client.async;

import org.hbgb.webcamp.shared.enums.Circle;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EmailServiceAsync
{
	public void sendApplicationRecievedEmail(String var1, AsyncCallback<String> var2);

	public void sendEmailToCircle(Circle circle, String subject, String message,
			String replyAddress, AsyncCallback<String> var2);
}
