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

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class EditShelterInfoViewImpl extends AbstractPartView implements IEditShelterInfoView
{
	private static UiBinder<Widget, EditShelterInfoViewImpl> binder =  GWT
			.create( EditShelterInfoViewImplBinder.class);
	@UiField
	CheckBox hasRv;
	@UiField
	TextArea rvInfo;
	@UiField
	CheckBox isInDormTent;
	@UiField
	CheckBox hasStructure;
	@UiField
	TextArea structureInfo;

	public EditShelterInfoViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
		this.expand();
	}

	@Override
	public void setHasRv(Boolean bool)
	{
		this.hasRv.setValue(bool, false);
	}

	@Override
	public Boolean getHasRv()
	{
		return this.hasRv.getValue();
	}

	@Override
	public void setRvInfoText(String text)
	{
		this.rvInfo.setText(text);
	}

	@Override
	public String getRvInfoText()
	{
		return this.rvInfo.getText();
	}

	@Override
	public void setIsInDormTent(Boolean bool)
	{
		this.isInDormTent.setValue(bool, false);
	}

	@Override
	public Boolean getIsInDormTent()
	{
		return this.isInDormTent.getValue();
	}

	@Override
	public void setHasStructure(Boolean bool)
	{
		this.hasStructure.setValue(bool, false);
	}

	@Override
	public Boolean getHasStructure()
	{
		return this.hasStructure.getValue();
	}

	@Override
	public void setStructureInfoText(String text)
	{
		this.structureInfo.setText(text);
	}

	@Override
	public String getStructureInfoText()
	{
		return this.structureInfo.getText();
	}

	@UiTemplate(value = "EditShelterInfoView.ui.xml")
	static interface EditShelterInfoViewImplBinder extends UiBinder<Widget, EditShelterInfoViewImpl>
	{
	}

}
