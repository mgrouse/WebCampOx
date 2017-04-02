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
 * com.google.gwt.user.client.ui.TextBox com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application;

import java.util.List;

import org.hbgb.webcamp.client.common.ColumnDefinition;
import org.hbgb.webcamp.shared.ApplicationDetails;
import org.hbgb.webcamp.shared.enums.ApplicationStatus;
import org.hbgb.webcamp.shared.enums.Committee;

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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationListViewImpl<T> extends Composite implements ApplicationListView<T>
{
	@SuppressWarnings("rawtypes")
	@UiTemplate(value = "ApplicationListView.ui.xml")
	static interface ApplicationViewUiBinder extends UiBinder<Widget, ApplicationListViewImpl>
	{}

	private static ApplicationViewUiBinder uiBinder = GWT.create(ApplicationViewUiBinder.class);

	@UiField
	TextBox totalApps;
	@UiField
	TextBox newApps;
	@UiField
	TextBox acceptedApps;
	@UiField
	TextBox invoicedApps;
	@UiField
	TextBox paidApps;
	@UiField
	TextBox ticketApps;
	@UiField
	TextBox faerieApps;
	@UiField
	TextBox healerApps;
	@UiField
	TextBox infraApps;
	@UiField
	TextBox kitchenApps;
	@UiField
	FlexTable table;
	private ApplicationListView.Presenter<T> presenter;
	private List<ColumnDefinition<T>> columnDefinitions;
	private List<T> rowData;

	public ApplicationListViewImpl()
	{
		this.initWidget(uiBinder.createAndBindUi(this));
		this.table.setBorderWidth(1);
		this.table.setCellPadding(5);
	}

	@Override
	public void setPresenter(ApplicationListView.Presenter<T> presenter)
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
		Integer kitchen;
		Integer infra = kitchen = Integer.valueOf(0);
		Integer healer = kitchen;
		Integer faerie = kitchen;
		Integer acceptedTicket = kitchen;
		Integer paid = kitchen;
		Integer invoiced = kitchen;
		Integer accepted = kitchen;
		Integer newApps = kitchen;
		Integer total = kitchen;
		this.table.removeAllRows();
		this.rowData = rowData;
		this.table.setWidget(0, 1, new HTML("Status"));
		this.table.setWidget(0, 2, new HTML("First & Last Name"));
		this.table.setWidget(0, 3, new HTML("Playa Name"));
		this.table.setWidget(0, 4, new HTML("Email"));
		this.table.setWidget(0, 5, new HTML("Committee"));
		this.table.setWidget(0, 6, new HTML("Diet"));
		this.table.setWidget(0, 7, new HTML("Invoiced"));
		this.table.setWidget(0, 8, new HTML("Paid"));
		this.table.setWidget(0, 9, new HTML("ticket"));
		total = rowData.size();
		int i = 0;
		while (i < rowData.size())
		{
			T t = rowData.get(i);
			int j = 0;
			while (j < this.columnDefinitions.size())
			{
				ColumnDefinition<T> columnDefinition = this.columnDefinitions.get(j);
				this.table.setWidget(i + 1, j, columnDefinition.render(t));
				++j;
			}
			ApplicationDetails ad = (ApplicationDetails) t;
			if (ad.getStatus().equals(ApplicationStatus.ACCEPTED.toString()))
			{
				accepted = accepted + 1;
				if (ad.getCommittee().equals(Committee.Faeries.toString()))
				{
					faerie = faerie + 1;
				}
				if (ad.getCommittee().equals(Committee.Healers.toString()))
				{
					healer = healer + 1;
				}
				if (ad.getCommittee().equals(Committee.Infrastructure.toString()))
				{
					infra = infra + 1;
				}
				if (ad.getCommittee().equals(Committee.Kitchen.toString()))
				{
					kitchen = kitchen + 1;
				}
				if (ad.getTicket().equals("true"))
				{
					acceptedTicket = acceptedTicket + 1;
				}
			}
			if (ad.getStatus().equals(ApplicationStatus.NEW.toString()))
			{
				newApps = newApps + 1;
			}
			if (ad.getInvoiced().equals("true"))
			{
				invoiced = invoiced + 1;
			}
			if (ad.getPaid().equals("true"))
			{
				paid = paid + 1;
			}
			++i;
		}
		this.setTotalApps(total.toString());
		this.setNewApps(newApps.toString());
		this.setAcceptedApps(accepted.toString());
		this.setTicketApps(acceptedTicket.toString());
		this.setInvoicedApps(invoiced.toString());
		this.setPaidApps(paid.toString());
		this.setFaerieApps(faerie.toString());
		this.setHealerApps(healer.toString());
		this.setInfraApps(infra.toString());
		this.setKitchenApps(kitchen.toString());
	}

	void onAddButtonClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		this.presenter.onAddButtonClicked();
	}

	void onDeleteButtonClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		this.presenter.onDeleteButtonClicked();
	}

	@UiHandler(value = { "table" })
	void onTableClicked(ClickEvent event)
	{
		if (this.presenter == null)
			return;
		HTMLTable.Cell cell = this.table.getCellForEvent(event);
		if (cell == null)
			return;
		if (this.shouldFireClickEvent(cell))
		{
			this.presenter.onItemClicked(this.rowData.get(cell.getRowIndex() - 1));
		}
		if (!this.shouldFireSelectEvent(cell))
			return;
		this.presenter.onItemSelected(this.rowData.get(cell.getRowIndex() - 1));
	}

	private boolean shouldFireClickEvent(HTMLTable.Cell cell)
	{
		boolean shouldFireClickEvent = false;
		if (cell == null)
			return shouldFireClickEvent;
		if (cell.getRowIndex() == 0)
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
		if (cell.getRowIndex() == 0)
			return shouldFireSelectEvent;
		ColumnDefinition<T> columnDefinition = this.columnDefinitions.get(cell.getCellIndex());
		if (columnDefinition == null)
			return shouldFireSelectEvent;
		return columnDefinition.isSelectable();
	}

	public void setTotalApps(String totalApps)
	{
		this.totalApps.setValue(totalApps);
	}

	public void setNewApps(String newApps)
	{
		this.newApps.setValue(newApps);
	}

	public void setAcceptedApps(String acceptedApps)
	{
		this.acceptedApps.setValue(acceptedApps);
	}

	public void setInvoicedApps(String invoicedApps)
	{
		this.invoicedApps.setValue(invoicedApps);
	}

	public void setPaidApps(String paidApps)
	{
		this.paidApps.setValue(paidApps);
	}

	public void setFaerieApps(String faerieApps)
	{
		this.faerieApps.setValue(faerieApps);
	}

	public void setHealerApps(String healerApps)
	{
		this.healerApps.setValue(healerApps);
	}

	public void setInfraApps(String infraApps)
	{
		this.infraApps.setValue(infraApps);
	}

	public void setKitchenApps(String kitchenApps)
	{
		this.kitchenApps.setValue(kitchenApps);
	}

	public void setTicketApps(String ticketApps)
	{
		this.ticketApps.setValue(ticketApps);
	}

	@Override
	public Widget asWidget()
	{
		return this;
	}

	@Override
	public void clear()
	{
		this.table.removeAllRows();
	}

}
