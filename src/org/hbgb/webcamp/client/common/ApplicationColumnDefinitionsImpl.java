/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.user.client.ui.CheckBox
 * com.google.gwt.user.client.ui.HTML com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.common;

import java.util.ArrayList;

import org.hbgb.webcamp.shared.ApplicationDetails;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationColumnDefinitionsImpl extends ArrayList<ColumnDefinition<ApplicationDetails>>
{
	private static ApplicationColumnDefinitionsImpl instance = null;

	public static ApplicationColumnDefinitionsImpl getInstance()
	{
		if (instance != null)
			return instance;
		instance = new ApplicationColumnDefinitionsImpl();
		return instance;
	}

	protected ApplicationColumnDefinitionsImpl()
	{
		this.add(new ColumnDefinition<ApplicationDetails>()
		{

			@Override
			public Widget render(ApplicationDetails c)
			{
				return new CheckBox();
			}

			@Override
			public boolean isSelectable()
			{
				return true;
			}
		});
		this.add(new ColumnDefinition<ApplicationDetails>()
		{

			@Override
			public Widget render(ApplicationDetails c)
			{
				return new HTML(c.getStatus());
			}

			@Override
			public boolean isClickable()
			{
				return true;
			}
		});
		this.add(new ColumnDefinition<ApplicationDetails>()
		{

			@Override
			public Widget render(ApplicationDetails c)
			{
				return new HTML(c.getDisplayName());
			}

			@Override
			public boolean isClickable()
			{
				return true;
			}
		});
		this.add(new ColumnDefinition<ApplicationDetails>()
		{

			@Override
			public Widget render(ApplicationDetails c)
			{
				return new HTML(c.getPlayaName());
			}

			@Override
			public boolean isClickable()
			{
				return true;
			}
		});
		this.add(new ColumnDefinition<ApplicationDetails>()
		{

			@Override
			public Widget render(ApplicationDetails c)
			{
				return new HTML(c.getEmail());
			}

			@Override
			public boolean isClickable()
			{
				return true;
			}
		});
		this.add(new ColumnDefinition<ApplicationDetails>()
		{

			@Override
			public Widget render(ApplicationDetails c)
			{
				return new HTML(c.getCommittee());
			}

			@Override
			public boolean isClickable()
			{
				return true;
			}
		});
		this.add(new ColumnDefinition<ApplicationDetails>()
		{

			@Override
			public Widget render(ApplicationDetails c)
			{
				return new HTML(c.getDiet());
			}

			@Override
			public boolean isClickable()
			{
				return true;
			}
		});
		this.add(new ColumnDefinition<ApplicationDetails>()
		{

			@Override
			public Widget render(ApplicationDetails c)
			{
				return new HTML(c.getInvoiced());
			}

			@Override
			public boolean isClickable()
			{
				return true;
			}
		});
		this.add(new ColumnDefinition<ApplicationDetails>()
		{

			@Override
			public Widget render(ApplicationDetails c)
			{
				return new HTML(c.getPaid());
			}

			@Override
			public boolean isClickable()
			{
				return true;
			}
		});
		this.add(new ColumnDefinition<ApplicationDetails>()
		{

			@Override
			public Widget render(ApplicationDetails c)
			{
				return new HTML(c.getTicket());
			}

			@Override
			public boolean isClickable()
			{
				return true;
			}
		});
	}

}
