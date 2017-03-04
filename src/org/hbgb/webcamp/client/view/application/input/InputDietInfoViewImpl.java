/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.dom.client.Style com.google.gwt.event.dom.client.ClickEvent
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiHandler
 * com.google.gwt.uibinder.client.UiTemplate com.google.gwt.user.client.Element
 * com.google.gwt.user.client.ui.CheckBox
 * com.google.gwt.user.client.ui.HTMLPanel com.google.gwt.user.client.ui.Label
 * com.google.gwt.user.client.ui.TextArea com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.AbstractView;
import org.hbgb.webcamp.client.widget.DietListBox;
import org.hbgb.webcamp.shared.enums.DietType;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class InputDietInfoViewImpl extends AbstractView implements InputDietInfoView
{

	@UiTemplate(value = "InputDietInfoView.ui.xml")
	static interface EditDietInfoViewImplBinder extends UiBinder<Widget, InputDietInfoViewImpl>
	{
	}

	private static UiBinder<Widget, InputDietInfoViewImpl> binder =  GWT
			.create( EditDietInfoViewImplBinder.class);

	@UiField
	HTMLPanel verifyWarning;

	@UiField
	Label dietLabel;

	@UiField
	DietListBox dietType;

	@UiField
	CheckBox isGlutenFree;

	@UiField
	TextArea dietaryRestrictions;

	private SequentialPresenterI presenter;

	public InputDietInfoViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
		this.verifyWarning.setVisible(false);
		this.dietaryRestrictions.getElement().setAttribute("maxlength", "250");
	}

	@Override
	public void setPresenter(SequentialPresenterI presenter)
	{
		this.presenter = presenter;
	}

	@UiHandler(value = { "nextButton" })
	void onNextButtonClicked(ClickEvent event)
	{
		if (this.isFormComplete() == false)
			return;
		if (this.presenter == null)
			return;
		this.presenter.onNextButtonClicked();
	}

	@Override
	public void setDietType(DietType type)
	{
		this.dietType.setSelectedValue(type);
	}

	@Override
	public DietType getDietType()
	{
		return this.dietType.getSelectedValue();
	}

	@Override
	public void setIsGlutenFree(Boolean bool)
	{
		this.isGlutenFree.setValue(bool, false);
	}

	@Override
	public Boolean getIsGlutenFree()
	{
		return this.isGlutenFree.getValue();
	}

	@Override
	public void setDietaryRestrictions(String text)
	{
		this.dietaryRestrictions.setValue(text, false);
	}

	@Override
	public String getDietaryRestrictions()
	{
		return this.dietaryRestrictions.getText();
	}

	@Override
	protected Boolean isFormComplete()
	{
		Boolean retVal = true;
		DietType dt = this.getDietType();
		if (dt != null)
			return retVal;
		retVal = false;
		this.dietLabel.getElement().getStyle().setColor("red");
		this.verifyWarning.setVisible(true);
		return retVal;
	}

}
