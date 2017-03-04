/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.rpc.AsyncCallback
 */
package org.hbgb.webcamp.client.async;

import java.util.ArrayList;

import org.hbgb.webcamp.shared.Profile;
import org.hbgb.webcamp.shared.ProfileDetails;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ProfileServiceAsync
{
	public void getProfile(String var1, AsyncCallback<Profile> var2);

	public void getProfileDetails(AsyncCallback<ArrayList<ProfileDetails>> var1);

	public void addProfile(Profile var1, AsyncCallback<Profile> var2);

	public void updateProfile(Profile var1, AsyncCallback<Profile> var2);

	public void deleteProfile(String var1, AsyncCallback<Boolean> var2);

	public void deleteProfiles(ArrayList<String> var1, AsyncCallback<ArrayList<ProfileDetails>> var2);
}
