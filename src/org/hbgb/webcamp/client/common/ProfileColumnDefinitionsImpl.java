/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.user.client.ui.CheckBox
 * com.google.gwt.user.client.ui.HTML com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.common;

import java.util.ArrayList;

import org.hbgb.webcamp.shared.ProfileDetails;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class ProfileColumnDefinitionsImpl extends ArrayList<ColumnDefinition<ProfileDetails>>
{
	private static ProfileColumnDefinitionsImpl instance = null;

	public static ProfileColumnDefinitionsImpl getInstance()
	{
		if (instance != null)
			return instance;
		instance = new ProfileColumnDefinitionsImpl();
		return instance;
	}

	protected ProfileColumnDefinitionsImpl()
	{
		this.add(new ColumnDefinition<ProfileDetails>()
		{

			@Override
			public Widget render(ProfileDetails c)
			{
				return new CheckBox();
			}

			@Override
			public boolean isSelectable()
			{
				return true;
			}
		});
		this.add(new ColumnDefinition<ProfileDetails>()
		{

			@Override
			public Widget render(ProfileDetails c)
			{
				return new HTML(c.getDisplayName());
			}

			@Override
			public boolean isClickable()
			{
				return true;
			}
		});
	}

}
