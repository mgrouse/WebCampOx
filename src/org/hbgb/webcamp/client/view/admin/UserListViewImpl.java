/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.event.dom.client.ClickEvent
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiHandler
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.Button com.google.gwt.user.client.ui.FlexTable
 * com.google.gwt.user.client.ui.HTMLTable
 * com.google.gwt.user.client.ui.HTMLTable$Cell
 * com.google.gwt.user.client.ui.VerticalPanel
 * com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.admin;

import java.util.List;

import org.hbgb.webcamp.client.common.ColumnDefinition;
import org.hbgb.webcamp.client.view.AbstractView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class UserListViewImpl<T> extends AbstractView implements UserListView<T>
{
	@UiTemplate(value = "UserListView.ui.xml")
	static interface UserViewUiBinder extends UiBinder<Widget, UserListViewImpl>
	{
	}

	private static UserViewUiBinder uiBinder = (UserViewUiBinder) GWT
			.create(UserViewUiBinder.class);

	@UiField
	VerticalPanel vPanel;

	@UiField
	FlexTable userTable;

	@UiField
	Button addButton;

	@UiField
	Button deleteButton;

	@UiField
	Button refreshButton;

	private UserListView.Presenter<T> presenter;
	private List<ColumnDefinition<T>> columnDefinitions;
	private List<T> rowData;

	public UserListViewImpl()
	{
		this.initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(UserListView.Presenter<T> presenter)
	{
		this.presenter = presenter;
	}

	@Override
	public void setColumnDefinitions(List<ColumnDefinition<T>> columnDefinitions)
	{
		this.columnDefinitions = columnDefinitions;
	}

	@Override
	public void setRowData(List<T> rowData)
	{
		this.userTable.removeAllRows();
		this.rowData = rowData;
		int i = 0;
		while (i < rowData.size())
		{
			T t = rowData.get(i);
			int j = 0;
			while (j < this.columnDefinitions.size())
			{
				ColumnDefinition<T> columnDefinition = this.columnDefinitions.get(j);
				this.userTable.setWidget(i, j, columnDefinition.render(t));
				++j;
			}
			++i;
		}
	}

	@UiHandler(value = { "addButton" })
	void onAddButtonClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		this.presenter.onAddButtonClicked();
	}

	@UiHandler(value = { "deleteButton" })
	void onDeleteButtonClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		this.presenter.onDeleteButtonClicked();
	}

	@UiHandler(value = { "refreshButton" })
	void onRefreshButtonClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		this.presenter.onRefreshButtonClicked();
	}

	@UiHandler(value = { "userTable" })
	void onTableClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		HTMLTable.Cell cell = this.userTable.getCellForEvent(event);
		if (cell == null)
			return;
		if (this.shouldFireClickEvent(cell))
		{
			this.presenter.onItemClicked(this.rowData.get(cell.getRowIndex()));
		}
		if (!this.shouldFireSelectEvent(cell))
			return;
		this.presenter.onItemSelected(this.rowData.get(cell.getRowIndex()));
	}

	private boolean shouldFireClickEvent(HTMLTable.Cell cell)
	{
		boolean shouldFireClickEvent = false;
		if (cell == null)
			return shouldFireClickEvent;
		ColumnDefinition<T> columnDefinition = this.columnDefinitions.get(cell.getCellIndex());
		if (columnDefinition == null)
			return shouldFireClickEvent;
		return columnDefinition.isClickable();
	}

	private boolean shouldFireSelectEvent(HTMLTable.Cell cell)
	{
		boolean shouldFireSelectEvent = false;
		if (cell == null)
			return shouldFireSelectEvent;
		ColumnDefinition<T> columnDefinition = this.columnDefinitions.get(cell.getCellIndex());
		if (columnDefinition == null)
			return shouldFireSelectEvent;
		return columnDefinition.isSelectable();
	}

}
