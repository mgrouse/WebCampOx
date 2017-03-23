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

public class EditApplicationInfoViewImpl extends AbstractPartView implements IEditApplicationInfoView
{
	private static final String IMAGE_NOT_AVAIALABLE = "http://storage.googleapis.com/hbgbwebcamp.appspot.com/PhotoNotAvailable.jpg";

	@UiTemplate(value = "EditApplicationInfoView.ui.xml")
	static interface EditApplicationInfoViewImplBinder extends UiBinder<Widget, EditApplicationInfoViewImpl>
	{}

	private static UiBinder<Widget, EditApplicationInfoViewImpl> binder = GWT.create(EditApplicationInfoViewImplBinder.class);

	@UiField
	ApplicationStatusListBox applicationStatus;

	@UiField
	Image currentImage;

	public EditApplicationInfoViewImpl()
	{
		initWidget(binder.createAndBindUi(this));
		expand();
	}

	@Override
	public void setApplicationStatus(ApplicationStatus s)
	{
		applicationStatus.setSelectedValue(s);
	}

	@Override
	public ApplicationStatus getApplicationStatus()
	{
		return applicationStatus.getSelectedEnumValue();
	}

	@Override
	public void setImageURL(String imageURL)
	{
		if (imageURL != null && !imageURL.isEmpty())
		{
			currentImage.setUrl(imageURL);
		}
		else
		{
			currentImage.setUrl(IMAGE_NOT_AVAIALABLE);
		}
	}

	@Override
	public String getImageURL()
	{
		return currentImage.getUrl();
	}

}
