/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.common;

import java.util.ArrayList;
import java.util.List;

import org.hbgb.webcamp.shared.ProfileDetails;

public class ProfileColumnDefinitionsFactory<T>
{
	public static List<ColumnDefinition<ProfileDetails>> getProfileColumnDefinitions()
	{
		return ProfileColumnDefinitionsImpl.getInstance();
	}

	public static List<ColumnDefinition<ProfileDetails>> getTestProfileColumnDefinitions()
	{
		return new ArrayList<ColumnDefinition<ProfileDetails>>();
	}
}
