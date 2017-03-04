/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.common;

import java.util.ArrayList;
import java.util.List;

import org.hbgb.webcamp.shared.ApplicationDetails;

public class ApplicationColumnDefinitionsFactory<T>
{
	public static List<ColumnDefinition<ApplicationDetails>> getApplicationColumnDefinitions()
	{
		return ApplicationColumnDefinitionsImpl.getInstance();
	}

	public static List<ColumnDefinition<ApplicationDetails>> getTestApplicationColumnDefinitions()
	{
		return new ArrayList<ColumnDefinition<ApplicationDetails>>();
	}
}
