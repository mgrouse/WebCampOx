/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.rpc.AsyncCallback
 */
package org.hbgb.webcamp.client.async;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;
import org.hbgb.webcamp.shared.Burner;
import org.hbgb.webcamp.shared.BurnerDetails;

public interface BurnerServiceAsync
{
	public void getBurnerByKey(String var1, AsyncCallback<Burner> var2);

	public void getBurnerByEmail(String var1, AsyncCallback<Burner> var2);

	public void getBurnerDetails(AsyncCallback<ArrayList<BurnerDetails>> var1);

	public void addBurner(Burner var1, AsyncCallback<Burner> var2);

	public void updateBurner(Burner var1, AsyncCallback<Burner> var2);

	public void deleteBurner(String var1, AsyncCallback<Boolean> var2);

	public void deleteBurners(ArrayList<String> var1, AsyncCallback<ArrayList<BurnerDetails>> var2);
}
