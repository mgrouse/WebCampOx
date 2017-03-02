/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.event.shared.EventHandler com.google.gwt.event.shared.GwtEvent
 * com.google.gwt.event.shared.GwtEvent$Type
 */
package org.hbgb.webcamp.client.event.application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gwt.event.shared.GwtEvent;

public class EditApplicationEvent extends GwtEvent<EditApplicationEventHandler>
{
	public static GwtEvent.Type<EditApplicationEventHandler> TYPE = new GwtEvent.Type<>();
	private final String key;
	private final ArrayList<String> list;

	public EditApplicationEvent(String encodedKey, Collection<String> list)
	{
		this.key = encodedKey;
		this.list = new ArrayList<>(list);
	}

	@Override
	public GwtEvent.Type<EditApplicationEventHandler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(EditApplicationEventHandler handler)
	{
		handler.onEditApplication(this);
	}

	public String getKey()
	{
		return this.key;
	}

	public List<String> getKeyList()
	{
		return this.list;
	}
}
