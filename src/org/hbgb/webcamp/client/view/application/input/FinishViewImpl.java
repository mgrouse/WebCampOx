/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.HTMLPanel com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.presenter.PresenterI;
import org.hbgb.webcamp.client.view.AbstractView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class FinishViewImpl extends AbstractView implements FinishViewI
{
	private static UiBinder<Widget, FinishViewImpl> binder = GWT.create(ExitViewImplBinder.class);

	@UiField
	HTML emailSuccess;

	@UiField
	HTML emailFailure;

	private PresenterI presenter;

	public FinishViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(PresenterI presenter)
	{
		this.presenter = presenter;
	}

	@Override
	public void setSuccessMessageVisability(Boolean visible)
	{
		this.emailSuccess.setVisible(visible.booleanValue());
	}

	@Override
	public void setFailureMessageVisability(Boolean visible)
	{
		this.emailFailure.setVisible(visible.booleanValue());
	}

	@UiTemplate(value = "FinishView.ui.xml")
	static interface ExitViewImplBinder extends UiBinder<Widget, FinishViewImpl>
	{}

}
