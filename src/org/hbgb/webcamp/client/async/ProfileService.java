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
import org.hbgb.webcamp.shared.Profile;
import org.hbgb.webcamp.shared.ProfileDetails;

@RemoteServiceRelativePath(value = "profileService")
public interface ProfileService extends RemoteService
{
	public Profile getProfile(String var1);

	public ArrayList<ProfileDetails> getProfileDetails();

	public Profile addProfile(Profile var1);

	public Profile updateProfile(Profile var1);

	public Boolean deleteProfile(String var1);

	public ArrayList<ProfileDetails> deleteProfiles(ArrayList<String> var1);
}
