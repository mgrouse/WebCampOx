/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.rpc.AsyncCallback
 */
package org.hbgb.webcamp.client.async;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EmailServiceAsync
{
	public void sendApplicationRecievedEmail(String var1, AsyncCallback<String> var2);

	public void sendEmailToCircle(String circle, String subject, String message, String replyName,
			String replyAddress, AsyncCallback<String> var2);
}
