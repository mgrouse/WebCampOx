/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.common;

import java.util.ArrayList;
import java.util.List;

public class SelectionModel<T>
{
	List<T> selectedItems = new ArrayList<T>();

	public List<T> getSelectedItems()
	{
		return this.selectedItems;
	}

	public void addSelection(T item)
	{
		this.selectedItems.add(item);
	}

	public void removeSelection(T item)
	{
		this.selectedItems.remove(item);
	}

	public boolean isSelected(T item)
	{
		return this.selectedItems.contains(item);
	}

	public void clearSelections()
	{
		this.selectedItems.clear();
	}
}
