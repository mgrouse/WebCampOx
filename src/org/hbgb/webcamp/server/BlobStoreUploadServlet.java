/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.appengine.api.blobstore.BlobKey
 * com.google.appengine.api.blobstore.BlobstoreService
 * com.google.appengine.api.blobstore.BlobstoreServiceFactory
 * com.google.appengine.api.images.ImagesService
 * com.google.appengine.api.images.ImagesServiceFactory
 * com.google.appengine.api.images.ServingUrlOptions
 * com.google.appengine.api.images.ServingUrlOptions$Builder
 * javax.servlet.ServletException javax.servlet.http.HttpServlet
 * javax.servlet.http.HttpServletRequest javax.servlet.http.HttpServletResponse
 */
package org.hbgb.webcamp.server;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hbgb.webcamp.client.async.UploadedPhotoService;
import org.hbgb.webcamp.shared.UploadedPhoto;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;

@SuppressWarnings("serial")
public class BlobStoreUploadServlet extends HttpServlet
{
	// private static final Logger log =
	// Logger.getLogger(UploadServlet.class.getName());
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
		List<BlobKey> blobKeyList = blobs.get("image");

		if (blobKeyList.isEmpty())
		{
			// Uh ... something went really wrong here
		}
		else
		{
			ImagesService imagesService = ImagesServiceFactory.getImagesService();

			ServingUrlOptions options = ServingUrlOptions.Builder.withBlobKey(blobKeyList.get(0));

			// Get the image serving URL
			String imageUrl = imagesService.getServingUrl(options);

			// Create the UserPhoto object using the Service
			UploadedPhotoService photoServ = new UploadedPhotoServiceImpl();

			UploadedPhoto photo = new UploadedPhoto();
			photo.setCreated(new Date());
			photo.setBlobKey(blobKeyList.get(0));
			photo.setImageURL(imageUrl);

			photoServ.addUploadedPhoto(photo);

			res.sendRedirect("/hbgbwebcamp/upload?imageUrl=" + imageUrl);

		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{

		String imageUrl = req.getParameter("imageUrl");
		resp.setHeader("Content-Type", "text/html");

		// This is a bit hacky, but it'll work. We'll use this key in an Async
		// service to
		// fetch the image and image information
		resp.getWriter().println(imageUrl);
	}
}
