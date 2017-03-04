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
import org.hbgb.webcamp.shared.HbgbUser;
import org.hbgb.webcamp.shared.HbgbUserDetails;

@RemoteServiceRelativePath(value = "userService")
public interface HbgbAppUserService extends RemoteService
{
	public HbgbUser getHbgbUser(String var1);

	public HbgbUser getHbgbUserByEmail(String var1);

	public ArrayList<HbgbUserDetails> getHbgbUserDetails();

	public ArrayList<HbgbUserDetails> getEarlyTeamDetails();

	public HbgbUser addHbgbUser(HbgbUser var1);

	public Boolean updateHbgbUser(HbgbUser var1);

	public Boolean deleteUser(String var1);

	public ArrayList<HbgbUserDetails> deleteUsers(ArrayList<String> var1);

	public ArrayList<HbgbUserDetails> removeUsersFromEarlyTeam(ArrayList<String> var1);
}
