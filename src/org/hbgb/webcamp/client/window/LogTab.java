/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.logging.client.HasWidgetsLogHandler
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.user.client.ui.Composite
 * com.google.gwt.user.client.ui.HasWidgets
 * com.google.gwt.user.client.ui.VerticalPanel
 * com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.window;

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.logging.client.HasWidgetsLogHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class LogTab extends Composite
{
	private static final Logger log = Logger.getLogger("");
	private static UiBinder<Widget, LogTab> binder = (UiBinder) GWT
			.create((Class) LogTabBinder.class);
	@UiField
	VerticalPanel logArea;

	public LogTab()
	{
		this.initWidget(binder.createAndBindUi(this));
		log.addHandler(new HasWidgetsLogHandler(this.logArea));
	}

	static interface LogTabBinder extends UiBinder<Widget, LogTab>
	{
	}

}
