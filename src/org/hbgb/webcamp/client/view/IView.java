/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view;

import com.google.gwt.user.client.ui.Widget;
import org.hbgb.webcamp.shared.enums.SecurityRole;

public interface IView
{
	public Widget asWidget();

	public void clear();

	public void setVisibility(SecurityRole var1);
}
