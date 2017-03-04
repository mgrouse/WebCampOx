/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.rpc.RemoteService
 * com.google.gwt.user.client.rpc.RemoteServiceRelativePath
 */
package org.hbgb.webcamp.client.async;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;
import org.hbgb.webcamp.shared.Burner;
import org.hbgb.webcamp.shared.BurnerDetails;

@RemoteServiceRelativePath(value = "burnerService")
public interface BurnerService extends RemoteService
{
	public Burner getBurnerByKey(String var1);

	public Burner getBurnerByEmail(String var1);

	public ArrayList<BurnerDetails> getBurnerDetails();

	public Burner addBurner(Burner var1);

	public Burner updateBurner(Burner var1);

	public Boolean deleteBurner(String var1);

	public ArrayList<BurnerDetails> deleteBurners(ArrayList<String> var1);
}
