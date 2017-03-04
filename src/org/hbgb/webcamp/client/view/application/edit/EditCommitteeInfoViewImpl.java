/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.CheckBox com.google.gwt.user.client.ui.TextArea
 * com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application.edit;

import org.hbgb.webcamp.client.widget.CommitteeListBox;
import org.hbgb.webcamp.shared.enums.Committee;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class EditCommitteeInfoViewImpl extends AbstractPartView implements IEditCommitteeInfoView
{

	@UiTemplate(value = "EditCommitteeInfoView.ui.xml")
	static interface EditCommitteeInfoViewImplBinder
			extends UiBinder<Widget, EditCommitteeInfoViewImpl>
	{
	}

	private static UiBinder<Widget, EditCommitteeInfoViewImpl> binder =  GWT
			.create(EditCommitteeInfoViewImplBinder.class);

	@UiField
	CommitteeListBox committee1;

	@UiField
	TextArea reason1;

	@UiField
	CommitteeListBox committee2;

	@UiField
	TextArea reason2;

	@UiField
	CommitteeListBox assignedCommittee;

	@UiField
	CheckBox isAssignedLead;

	public EditCommitteeInfoViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
		this.expand();
	}

	@Override
	public void setCommittee1(Committee c)
	{
		this.committee1.setSelectedValue(c);
	}

	@Override
	public Committee getCommittee1()
	{
		return this.committee1.getSelectedValue();
	}

	@Override
	public void setReason1(String text)
	{
		this.reason1.setValue(text, false);
	}

	@Override
	public String getReason1()
	{
		return this.reason1.getText();
	}

	@Override
	public void setCommittee2(Committee c)
	{
		this.committee2.setSelectedValue(c);
	}

	@Override
	public Committee getCommittee2()
	{
		return this.committee2.getSelectedValue();
	}

	@Override
	public void setReason2(String text)
	{
		this.reason2.setValue(text, false);
	}

	@Override
	public String getReason2()
	{
		return this.reason2.getText();
	}

	@Override
	public void setAssignedCommittee(Committee c)
	{
		this.assignedCommittee.setSelectedValue(c);
	}

	@Override
	public Committee getAssignedCommittee()
	{
		return this.assignedCommittee.getSelectedValue();
	}

	@Override
	public void setIsAssignedLead(Boolean bool)
	{
		this.isAssignedLead.setValue(bool, false);
	}

	@Override
	public Boolean getIsAssignedLead()
	{
		return this.isAssignedLead.getValue();
	}

	@Override
	public void clear()
	{
	}

}
