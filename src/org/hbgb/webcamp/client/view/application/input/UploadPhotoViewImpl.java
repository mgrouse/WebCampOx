/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes: com.google.gwt.core.client.GWT
 * com.google.gwt.event.dom.client.ClickEvent
 * com.google.gwt.event.shared.HandlerRegistration
 * com.google.gwt.uibinder.client.UiBinder
 * com.google.gwt.uibinder.client.UiField
 * com.google.gwt.uibinder.client.UiHandler
 * com.google.gwt.uibinder.client.UiTemplate
 * com.google.gwt.user.client.rpc.AsyncCallback
 * com.google.gwt.user.client.ui.Button com.google.gwt.user.client.ui.FileUpload
 * com.google.gwt.user.client.ui.FormPanel
 * com.google.gwt.user.client.ui.FormPanel$SubmitCompleteEvent
 * com.google.gwt.user.client.ui.FormPanel$SubmitCompleteHandler
 * com.google.gwt.user.client.ui.Image com.google.gwt.user.client.ui.Widget
 */
package org.hbgb.webcamp.client.view.application.input;

import org.hbgb.webcamp.client.async.AsyncServiceFinder;
import org.hbgb.webcamp.client.async.BlobStoreUploadURLServiceAsync;
import org.hbgb.webcamp.client.presenter.SequentialPresenterI;
import org.hbgb.webcamp.client.view.AbstractView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class UploadPhotoViewImpl extends AbstractView implements UploadPhotoView
{
	private static final String IMAGE_NOT_AVAIALABLE = "http://storage.googleapis.com/hbgbwebcamp.appspot.com/PhotoNotAvailable.jpg";
	private static UiBinder<Widget, UploadPhotoViewImpl> binder = GWT.create(PictureUploadViewImplBinder.class);
	BlobStoreUploadURLServiceAsync imageServ;
	@UiField
	Button uploadButton;
	@UiField
	FormPanel uploadForm;
	@UiField
	FileUpload uploadField;
	@UiField
	Image currentImage;
	private SequentialPresenterI presenter;

	public UploadPhotoViewImpl()
	{
		this.initWidget(binder.createAndBindUi(this));
		this.imageServ = AsyncServiceFinder.getBlobStoreUploadURLService();
		this.uploadField.setName("image");
		this.startNewBlobstoreSession();
		this.uploadForm.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler()
		{

			@Override
			public void onSubmitComplete(FormPanel.SubmitCompleteEvent event)
			{
				String imageUrl = event.getResults();
				UploadPhotoViewImpl.this.setImageURL(imageUrl);
				UploadPhotoViewImpl.this.uploadForm.reset();
				UploadPhotoViewImpl.this.startNewBlobstoreSession();
			}
		});
	}

	private void startNewBlobstoreSession()
	{
		this.imageServ.getBlobstoreUploadUrl(new AsyncCallback<String>()
		{

			@Override
			public void onSuccess(String result)
			{
				UploadPhotoViewImpl.this.uploadForm.setAction(result);
				UploadPhotoViewImpl.this.uploadForm.setEncoding("multipart/form-data");
				UploadPhotoViewImpl.this.uploadForm.setMethod("post");
				UploadPhotoViewImpl.this.uploadButton.setText("Upload");
				UploadPhotoViewImpl.this.uploadButton.setEnabled(true);
			}

			@Override
			public void onFailure(Throwable caught)
			{}
		});
	}

	@UiHandler(value = { "uploadButton" })
	void onSubmit(ClickEvent e)
	{
		this.uploadButton.setText("Loading...");
		this.uploadButton.setEnabled(false);
		this.uploadForm.submit();
	}

	@UiHandler(value = { "nextButton" })
	void onNext(ClickEvent e)
	{
		this.presenter.onNextButtonClicked();
	}

	@Override
	public void setPresenter(SequentialPresenterI presenter)
	{
		this.presenter = presenter;
	}

	@Override
	public void setImageURL(String imageURL)
	{
		if (imageURL != null && !imageURL.isEmpty())
		{
			this.currentImage.setUrl(imageURL);
			return;
		}
		this.currentImage.setUrl("http://storage.googleapis.com/hbgbwebcamp.appspot.com/PhotoNotAvailable.jpg");
	}

	@Override
	public String getImageURL()
	{
		return this.currentImage.getUrl();
	}

	private void deleteOldImage()
	{
		if (this.currentImage.getUrl() == null)
			return;
		if (this.currentImage.getUrl().isEmpty())
			return;
		this.currentImage.getUrl().equals("http://storage.googleapis.com/hbgbwebcamp.appspot.com/PhotoNotAvailable.jpg");
	}

	@UiTemplate(value = "UploadPhotoView.ui.xml")
	static interface PictureUploadViewImplBinder extends UiBinder<Widget, UploadPhotoViewImpl>
	{}

}
