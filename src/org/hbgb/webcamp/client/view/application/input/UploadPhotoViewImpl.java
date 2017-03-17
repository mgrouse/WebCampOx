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
import org.hbgb.webcamp.client.presenter.ISequentialPresenter;
import org.hbgb.webcamp.client.view.AbstractView;
import org.hbgb.webcamp.client.view.ISequentialView;
import org.hbgb.webcamp.client.view.IView;
import org.hbgb.webcamp.client.widget.MessagesWidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class UploadPhotoViewImpl extends AbstractView implements UploadPhotoView, ISequentialView, IView
{
	private static final String IMAGE_NOT_AVAIALABLE = "http://storage.googleapis.com/hbgbwebcamp.appspot.com/PhotoNotAvailable.jpg";

	@UiTemplate(value = "UploadPhotoView.ui.xml")
	static interface PictureUploadViewImplBinder extends UiBinder<Widget, UploadPhotoViewImpl>
	{}

	private static UiBinder<Widget, UploadPhotoViewImpl> binder = GWT.create(PictureUploadViewImplBinder.class);

	BlobStoreUploadURLServiceAsync imageServ;

	@UiField
	MessagesWidget messages;

	@UiField
	Button uploadButton;

	@UiField
	FormPanel uploadForm;

	@UiField
	FileUpload uploadField;

	@UiField
	Image currentImage;

	private ISequentialPresenter presenter;

	public UploadPhotoViewImpl()
	{
		initWidget(binder.createAndBindUi(this));
		imageServ = AsyncServiceFinder.getBlobStoreUploadURLService();
		uploadField.setName("image");
		startNewBlobstoreSession();
		uploadForm.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler()
		{

			@Override
			public void onSubmitComplete(FormPanel.SubmitCompleteEvent event)
			{
				String imageUrl = event.getResults();
				setImageURL(imageUrl);
				uploadForm.reset();
				startNewBlobstoreSession();
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
				uploadForm.setAction(result);
				uploadForm.setEncoding("multipart/form-data");
				uploadForm.setMethod("post");
				uploadButton.setText("Upload");
				uploadButton.setEnabled(true);
			}

			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("RPC Failure: " + caught.getMessage());
			}
		});
	}

	@UiHandler(value = { "uploadButton" })
	void onSubmit(ClickEvent e)
	{
		uploadButton.setText("Loading...");
		uploadButton.setEnabled(false);
		uploadForm.submit();
	}

	@UiHandler(value = { "nextButton" })
	void onNext(ClickEvent e)
	{
		presenter.onNextButtonClicked();
	}

	@Override
	public void setPresenter(ISequentialPresenter sp)
	{
		presenter = sp;
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
			currentImage.setUrl("http://storage.googleapis.com/hbgbwebcamp.appspot.com/PhotoNotAvailable.jpg");
		}
	}

	@Override
	public String getImageURL()
	{
		return this.currentImage.getUrl();
	}

	@Override
	public void addMessage(String var1)
	{

	}

	@Override
	public void setNextButtonActive(boolean var1)
	{

	}

}
