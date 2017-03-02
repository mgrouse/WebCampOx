/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.ui.Composite com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application;

import org.hbgb.webcamp.shared.enums.SecurityRole;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ThankYouViewImpl extends Composite implements ThankYouView
{
	@UiTemplate(value = "ThankYouView.ui.xml")
	static interface ThankYouViewImplBinder extends UiBinder<Widget, ThankYouViewImpl>
	{
	}

	private static UiBinder<Widget, ThankYouViewImpl> binder = (UiBinder) GWT
			.create((Class) ThankYouViewImplBinder.class);

	public ThankYouViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
	}

	@Override
	public Widget asWidget()
	{
		return this;
	}

	@Override
	public void clear()
	{
	}

	@Override
	public void setVisibility(SecurityRole role)
	{
	}

}
