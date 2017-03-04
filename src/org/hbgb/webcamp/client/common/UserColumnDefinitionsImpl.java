/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.user.client.ui.CheckBox
 * com.google.gwt.user.client.ui.HTML com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.common;

import java.util.ArrayList;

import org.hbgb.webcamp.shared.HbgbUserDetails;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

@SuppressWarnings("serial")
public class UserColumnDefinitionsImpl extends ArrayList<ColumnDefinition<HbgbUserDetails>>
{
	private static UserColumnDefinitionsImpl instance = null;

	public static UserColumnDefinitionsImpl getInstance()
	{
		if (instance != null)
			return instance;
		instance = new UserColumnDefinitionsImpl();
		return instance;
	}

	protected UserColumnDefinitionsImpl()
	{
		this.add(new ColumnDefinition<HbgbUserDetails>()
		{

			@Override
			public Widget render(HbgbUserDetails c)
			{
				return new CheckBox();
			}

			@Override
			public boolean isSelectable()
			{
				return true;
			}
		});
		this.add(new ColumnDefinition<HbgbUserDetails>()
		{

			@Override
			public Widget render(HbgbUserDetails c)
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
