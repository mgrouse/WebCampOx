/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.appengine.api.blobstore.BlobKey
 * com.google.appengine.api.blobstore.BlobstoreService
 * com.google.appengine.api.blobstore.BlobstoreServiceFactory
 * com.google.gwt.user.server.rpc.RemoteServiceServlet
 * javax.jdo.PersistenceManager javax.jdo.Query
 */
package org.hbgb.webcamp.server;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.hbgb.webcamp.client.async.UploadedPhotoService;
import org.hbgb.webcamp.shared.UploadedPhoto;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class UploadedPhotoServiceImpl extends RemoteServiceServlet implements UploadedPhotoService
{
	@Override
	public UploadedPhoto getUploadedPhoto(String encoded)
	{
		UploadedPhoto photo = null;
		PersistenceManager pm = getPM();
		try
		{
			photo = pm.getObjectById(UploadedPhoto.class, encoded);

			photo = pm.detachCopy(photo);
		}
		finally
		{
			pm.close();
		}

		return photo;
	}

	@Override
	public UploadedPhoto addUploadedPhoto(UploadedPhoto photo)
	{
		PersistenceManager pm = getPM();

		// may need to ensure uniqueness in case our process led to dupe
		// blobstore URLs?
		// UploadedPhoto test = getUploadedPhotoByURL(photo.getImageURL());

		try
		{
			pm.makePersistent(photo);
			photo = pm.detachCopy(photo);
		}
		finally
		{
			pm.close();
		}

		return photo;
	}

	@Override
	public Boolean deleteUploadedPhotoByKey(String encoded)
	{
		BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
		PersistenceManager pm = getPM();
		try
		{
			UploadedPhoto photo = pm.getObjectById(UploadedPhoto.class, encoded);

			// delete blobkey first
			blobstoreService.delete(photo.getBlobKey());

			pm.deletePersistent(photo);
		}
		finally
		{
			pm.close();
		}
		return true;
	}

	private UploadedPhoto findUploadedPhotoByURL(String url)
	{
		UploadedPhoto photo = null;
		PersistenceManager pm = getPM();

		Query q = pm.newQuery(UploadedPhoto.class);
		q.setFilter("imageURL == urlParam");
		q.declareParameters("String urlParam");

		try
		{
			@SuppressWarnings("unchecked")
			List<UploadedPhoto> results = (List<UploadedPhoto>) q.execute(url);
			if (!results.isEmpty())
			{
				photo = results.get(0);
			}
		}
		finally
		{
			q.closeAll();
		}

		return photo;
	}

	@Override
	public Boolean deleteUploadedPhotoByURL(String url)
	{
		UploadedPhoto photo = this.findUploadedPhotoByURL(url);
		return this.deleteUploadedPhotoByKey(photo.getEncodedKey());
	}

	private PersistenceManager getPM()
	{
		return PMF.get().getPersistenceManager();
	}
}
