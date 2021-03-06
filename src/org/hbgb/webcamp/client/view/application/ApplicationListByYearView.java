/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.client.view.application;

import java.util.List;

import org.hbgb.webcamp.client.common.ColumnDefinition;
import org.hbgb.webcamp.client.view.IView;

public interface ApplicationListByYearView<T> extends IView
{
	public void setPresenter(Presenter<T> var1);

	public void setColumnDefinitions(List<ColumnDefinition<T>> var1);

	public void setRowData(List<T> var1);

	public int getYearValue();

	public static interface Presenter<T>
	{
		public void onAddButtonClicked();

		public void onDeleteButtonClicked();

		public void onRefreshButtonClicked();

		public void onItemClicked(T var1);

		public void onItemSelected(T var1);
	}

}
