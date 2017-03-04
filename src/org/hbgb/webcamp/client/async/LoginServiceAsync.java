/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.rpc.AsyncCallback
 */
package org.hbgb.webcamp.client.async;

import com.google.gwt.user.client.rpc.AsyncCallback;
import org.hbgb.webcamp.shared.HbgbUser;

public interface LoginServiceAsync
{
	public void authenticate(String var1, String var2, AsyncCallback<HbgbUser> var3);
}
