/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.event.shared.SimpleEventBus
 */
package org.hbgb.webcamp.client.event;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;

public class SingletonEventBus
{
	private static final SimpleEventBus INSTANCE = GWT.create(SimpleEventBus.class);

	private SingletonEventBus()
	{}

	public static SimpleEventBus get()
	{
		return INSTANCE;
	}
}
