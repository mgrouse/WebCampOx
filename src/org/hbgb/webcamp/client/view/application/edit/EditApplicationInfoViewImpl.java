/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiTemplate com.google.gwt.user.client.ui.Image
 * com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application.edit;

import org.hbgb.webcamp.client.widget.ApplicationStatusListBox;
import org.hbgb.webcamp.shared.enums.ApplicationStatus;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class EditApplicationInfoViewImpl extends AbstractPartView
		implements IEditApplicationInfoView
{
	private static final String IMAGE_NOT_AVAIALABLE = "http://storage.googleapis.com/hbgbwebcamp.appspot.com/PhotoNotAvailable.jpg";
	private static UiBinder<Widget, EditApplicationInfoViewImpl> binder = (UiBinder) GWT
			.create((Class) EditApplicationInfoViewImplBinder.class);
	@UiField
	ApplicationStatusListBox applicationStatus;
	@UiField
	Image currentImage;

	public EditApplicationInfoViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
		this.expand();
	}

	@Override
	public void setApplicationStatus(ApplicationStatus s)
	{
		this.applicationStatus.setSelectedValue(s);
	}

	@Override
	public ApplicationStatus getApplicationStatus()
	{
		return this.applicationStatus.getSelectedValue();
	}

	@Override
	public void setImageURL(String imageURL)
	{
		if (imageURL != null && !imageURL.isEmpty())
		{
			this.currentImage.setUrl(imageURL);
			return;
		}
		this.currentImage.setUrl(
				"http://storage.googleapis.com/hbgbwebcamp.appspot.com/PhotoNotAvailable.jpg");
	}

	@Override
	public String getImageURL()
	{
		return this.currentImage.getUrl();
	}

	@UiTemplate(value = "EditApplicationInfoView.ui.xml")
	static interface EditApplicationInfoViewImplBinder
			extends UiBinder<Widget, EditApplicationInfoViewImpl>
	{
	}

}
