/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.TextArea com.google.gwt.user.client.ui.TextBox
 * com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application.edit;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class EditHealerSheetInfoBlockViewImpl extends AbstractPartView implements IEditHealerSheetInfoView
{
	private static UiBinder<Widget, EditHealerSheetInfoBlockViewImpl> binder = GWT.create(EditHealerSheetInfoBlockViewImplBinder.class);

	@UiField
	TextBox sessionLength;

	@UiField
	TextBox modality1;

	@UiField
	TextBox modality2;

	@UiField
	TextBox modality3;

	@UiField
	TextBox modality4;

	@UiField
	TextArea bioBox;

	public EditHealerSheetInfoBlockViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
		this.expand();
	}

	@Override
	public void setSessionLength(String text)
	{
		this.sessionLength.setText(text);
	}

	@Override
	public String getSessionLength()
	{
		return this.sessionLength.getText();
	}

	@Override
	public void setModality1(String text)
	{
		this.modality1.setText(text);
	}

	@Override
	public String getModality1()
	{
		return this.modality1.getText();
	}

	@Override
	public void setModality2(String text)
	{
		this.modality2.setText(text);
	}

	@Override
	public String getModality2()
	{
		return this.modality2.getText();
	}

	@Override
	public void setModality3(String text)
	{
		this.modality3.setText(text);
	}

	@Override
	public String getModality3()
	{
		return this.modality3.getText();
	}

	@Override
	public void setModality4(String text)
	{
		this.modality4.setText(text);
	}

	@Override
	public String getModality4()
	{
		return this.modality4.getText();
	}

	@Override
	public void setBioBox(String text)
	{
		this.bioBox.setValue(text, false);
	}

	@Override
	public String getBioBox()
	{
		return this.bioBox.getText();
	}

	@Override
	public void clear()
	{
		this.setSessionLength("");
		this.setModality1("");
		this.setModality2("");
		this.setModality3("");
		this.setModality4("");
	}

	@UiTemplate(value = "EditHealerSheetInfoView.ui.xml")
	static interface EditHealerSheetInfoBlockViewImplBinder extends UiBinder<Widget, EditHealerSheetInfoBlockViewImpl>
	{}

}
