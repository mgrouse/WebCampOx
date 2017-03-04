/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.rpc.AsyncCallback
 */
package org.hbgb.webcamp.client.async;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;
import org.hbgb.webcamp.shared.HeeBee;
import org.hbgb.webcamp.shared.HeeBeeDetails;

public interface HeeBeeServiceAsync
{
	public void getHeeBee(String var1, AsyncCallback<HeeBee> var2);

	public void getHeeBeeDetails(AsyncCallback<ArrayList<HeeBeeDetails>> var1);

	public void addHeeBee(HeeBee var1, AsyncCallback<HeeBee> var2);

	public void updateHeeBee(HeeBee var1, AsyncCallback<HeeBee> var2);

	public void deleteHeeBee(String var1, AsyncCallback<Boolean> var2);

	public void deleteHeeBees(ArrayList<String> var1, AsyncCallback<ArrayList<HeeBeeDetails>> var2);
}
