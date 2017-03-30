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
package org.hbgb.webcamp.client.widget;

import org.hbgb.webcamp.client.WebCampResource;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Michael
 *
 */

public class LoadingPopup extends PopupPanel implements IProgress
{

	public LoadingPopup()
	{
		final Image ajaxImage = new Image(WebCampResource.INSTANCE.loading());
		final Grid grid = new Grid(1, 2);
		final FlowPanel container = new FlowPanel();
		grid.setWidget(0, 0, ajaxImage);
		grid.setText(0, 1, "Loading...");
		container.add(grid);
		add(container);
	}

	@Override
	public Widget asWidget()
	{
		return this;
	}

	@Override
	public void stop()
	{
		hide();
	}

	@Override
	public void go()
	{
		center();
		show();
	}

}
