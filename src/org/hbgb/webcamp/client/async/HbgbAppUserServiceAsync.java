/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.rpc.AsyncCallback
 */
package org.hbgb.webcamp.client.async;

import java.util.ArrayList;

import org.hbgb.webcamp.shared.HbgbUser;
import org.hbgb.webcamp.shared.HbgbUserDetails;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HbgbAppUserServiceAsync
{
	public void addHbgbUser(HbgbUser var1, AsyncCallback<HbgbUser> var2);

	public void deleteUser(String var1, AsyncCallback<Boolean> var2);

	public void deleteUsers(ArrayList<String> var1, AsyncCallback<ArrayList<HbgbUserDetails>> var2);

	public void removeUsersFromEarlyTeam(ArrayList<String> var1, AsyncCallback<ArrayList<HbgbUserDetails>> var2);

	public void getHbgbUserDetails(AsyncCallback<ArrayList<HbgbUserDetails>> var1);

	public void getEarlyTeamDetails(AsyncCallback<ArrayList<HbgbUserDetails>> var1);

	public void getHbgbUser(String var1, AsyncCallback<HbgbUser> var2);

	public void getHbgbUserByEmail(String var1, AsyncCallback<HbgbUser> var2);

	public void updateHbgbUser(HbgbUser var1, AsyncCallback<Boolean> var2);
}
