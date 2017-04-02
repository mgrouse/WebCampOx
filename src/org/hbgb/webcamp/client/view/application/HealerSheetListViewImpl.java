/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.event.dom.client.ClickEvent
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiHandler
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.Composite
 * com.google.gwt.user.client.ui.FlexTable com.google.gwt.user.client.ui.HTML
 * com.google.gwt.user.client.ui.HTMLTable
 * com.google.gwt.user.client.ui.HTMLTable$Cell
 * com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application;

import java.util.List;

import org.hbgb.webcamp.client.common.ColumnDefinition;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.Widget;

public class HealerSheetListViewImpl<T> extends Composite implements HealerSheetListView<T>
{

	@UiTemplate(value = "HealerSheetListView.ui.xml")
	static interface HealerSheetListViewImplBinder extends UiBinder<Widget, HealerSheetListViewImpl>
	{}

	private static UiBinder<Widget, HealerSheetListViewImpl> binder = GWT
			.create(HealerSheetListViewImplBinder.class);

	@UiField
	FlexTable table;

	private HealerSheetListView.Presenter<T> presenter;
	private List<ColumnDefinition<T>> columnDefinitions;
	private List<T> rowData;

	public HealerSheetListViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
		this.table.setBorderWidth(1);
		this.table.setCellPadding(5);
	}

	@Override
	public void setPresenter(HealerSheetListView.Presenter<T> presenter)
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
		this.table.removeAllRows();
		this.rowData = rowData;
		this.table.setWidget(0, 1, new HTML("Photo"));
		this.table.setWidget(0, 2, new HTML("email"));
		this.table.setWidget(0, 3, new HTML("Playa Name"));
		this.table.setWidget(0, 4, new HTML("Session Length"));
		this.table.setWidget(0, 5, new HTML("Modality 1"));
		this.table.setWidget(0, 6, new HTML("Modality 2"));
		this.table.setWidget(0, 7, new HTML("Modality 3"));
		this.table.setWidget(0, 8, new HTML("Modality 4"));
		this.table.setWidget(0, 9, new HTML("Bio"));

		for (int i = 0; i < rowData.size(); ++i)
		{
			T t = rowData.get(i);

			for (int j = 0; j < columnDefinitions.size(); ++j)
			{
				ColumnDefinition<T> columnDefinition = columnDefinitions.get(j);
				table.setWidget(i + 1, j, columnDefinition.render(t));
			}
		}
	}

	@UiHandler(value = { "table" })
	void onTableClicked(ClickEvent event)
	{
		if (presenter != null)
		{
			HTMLTable.Cell cell = table.getCellForEvent(event);

			if (cell != null)
			{
				if (shouldFireClickEvent(cell))
				{
					presenter.onItemClicked(rowData.get(cell.getRowIndex() - 1),
							cell.getCellIndex());
				}

				if (shouldFireSelectEvent(cell))
				{
					presenter.onItemSelected(rowData.get(cell.getRowIndex() - 1));
				}
			}
		}
	}

	private boolean shouldFireClickEvent(HTMLTable.Cell cell)
	{
		boolean shouldFireClickEvent = false;

		if ((cell != null) && (cell.getRowIndex() != 0))
		{
			ColumnDefinition<T> columnDefinition = columnDefinitions.get(cell.getCellIndex());

			if (columnDefinition != null)
			{
				shouldFireClickEvent = columnDefinition.isClickable();
			}
		}

		return shouldFireClickEvent;
	}

	private boolean shouldFireSelectEvent(HTMLTable.Cell cell)
	{
		boolean shouldFireSelectEvent = false;

		if ((cell != null) && (cell.getRowIndex() != 0))
		{
			ColumnDefinition<T> columnDefinition = columnDefinitions.get(cell.getCellIndex());

			if (columnDefinition != null)
			{
				shouldFireSelectEvent = columnDefinition.isSelectable();
			}
		}

		return shouldFireSelectEvent;
	}

	@Override
	public void clear()
	{}

}
