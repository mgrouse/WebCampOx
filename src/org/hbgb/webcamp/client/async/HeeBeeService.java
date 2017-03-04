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
import org.hbgb.webcamp.shared.HeeBee;
import org.hbgb.webcamp.shared.HeeBeeDetails;

@RemoteServiceRelativePath(value = "applicationService")
public interface HeeBeeService extends RemoteService
{
	public HeeBee getHeeBee(String var1);

	public ArrayList<HeeBeeDetails> getHeeBeeDetails();

	public HeeBee addHeeBee(HeeBee var1);

	public HeeBee updateHeeBee(HeeBee var1);

	public Boolean deleteHeeBee(String var1);

	public ArrayList<HeeBeeDetails> deleteHeeBees(ArrayList<String> var1);
}
