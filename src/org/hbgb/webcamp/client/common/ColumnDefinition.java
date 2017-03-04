/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.common;

import com.google.gwt.user.client.ui.Widget;

public abstract class ColumnDefinition<T>
{
	public abstract Widget render(T var1);

	public boolean isClickable()
	{
		return false;
	}

	public boolean isSelectable()
	{
		return false;
	}
}
