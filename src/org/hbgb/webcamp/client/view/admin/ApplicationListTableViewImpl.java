/*
 * This is an unpublished work protected by the United States copyright laws and
 * is proprietary to Michael A. Grouse. Disclosure, copying, reproduction,
 * merger translation, modification, enhancement or use by anyone other than
 * authorized employees or licensees of Michael A. Grouse without prior written
 * consent of Michael A. Grouse is prohibited.
 *
 * Copyright (C) 1992 - 2017 Michael A. Grouse, All Rights Reserved.
 *
 * This copyright notice should not be construed as evidence of publication.
 */
package org.hbgb.webcamp.client.view.admin;

import java.util.List;

import org.hbgb.webcamp.client.view.AbstractView;
import org.hbgb.webcamp.shared.ApplicationRow;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Michael
 *
 */
public class ApplicationListTableViewImpl extends AbstractView implements ApplicationListTableView
{
	static final String EMPTY_TABLE_MSG = "No Data to Display";

	@UiTemplate(value = "ApplicationListTableView.ui.xml")
	static interface ApplicationListTableViewUiBinder
			extends UiBinder<Widget, ApplicationListTableViewImpl>
	{}

	private static ApplicationListTableViewUiBinder uiBinder = GWT
			.create(ApplicationListTableViewUiBinder.class);

	@UiField(provided = true)
	DataGrid<ApplicationRow> appTable = new DataGrid<>();

	public ApplicationListTableViewImpl()
	{
		createDataGrid();

		initWidget(uiBinder.createAndBindUi(this));

	}

	@Override
	public void setPresenter()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void clear()
	{

	}

	@Override
	public void setRowData(List<ApplicationRow> list)
	{
		// TODO Auto-generated method stub

	}

	public void createDataGrid()
	{

		// Create a DataGrid.
		// appTable = new DataGrid<>();
		appTable.setWidth("100%");
		appTable.setAutoHeaderRefreshDisabled(true);

		// blank message
		// setBlankMessage(grid);
		appTable.setEmptyTableWidget(new Label("EMPTY_TABLE_MSG"));

		// key provider

		// selection model

		// Headers

		// Columns

	}

	private void setBlankMessage(DataGrid<ApplicationRow> grid)
	{
		// Set the message to display when the table is empty.
		grid.setEmptyTableWidget(new Label("EMPTY_TABLE_MSG"));
	}

}
