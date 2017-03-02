/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.appengine.api.blobstore.BlobKey
 *  com.google.appengine.api.blobstore.BlobstoreService
 *  com.google.appengine.api.blobstore.BlobstoreServiceFactory
 *  com.google.gwt.user.server.rpc.RemoteServiceServlet
 *  javax.jdo.PersistenceManager
 *  javax.jdo.Query
 */
package org.hbgb.webcamp.server;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import org.hbgb.webcamp.client.async.UploadedPhotoService;
import org.hbgb.webcamp.server.PMF;
import org.hbgb.webcamp.shared.UploadedPhoto;

public class UploadedPhotoServiceImpl
extends RemoteServiceServlet
implements UploadedPhotoService {
    @Override
    public UploadedPhoto getUploadedPhoto(String encoded) {
        UploadedPhoto photo = null;
        PersistenceManager pm = this.getPM();
        try {
            photo = (UploadedPhoto)pm.getObjectById((Class)UploadedPhoto.class, (Object)encoded);
            photo = (UploadedPhoto)pm.detachCopy((Object)photo);
            return photo;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public UploadedPhoto addUploadedPhoto(UploadedPhoto photo) {
        PersistenceManager pm = this.getPM();
        try {
            pm.makePersistent((Object)photo);
            photo = (UploadedPhoto)pm.detachCopy((Object)photo);
            return photo;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public Boolean deleteUploadedPhotoByKey(String encoded) {
        BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
        PersistenceManager pm = this.getPM();
        try {
            UploadedPhoto photo = (UploadedPhoto)pm.getObjectById((Class)UploadedPhoto.class, (Object)encoded);
            blobstoreService.delete(new BlobKey[]{photo.getBlobKey()});
            pm.deletePersistent((Object)photo);
            return true;
        }
        finally {
            pm.close();
        }
    }

    private UploadedPhoto findUploadedPhotoByURL(String url) {
        UploadedPhoto photo = null;
        PersistenceManager pm = this.getPM();
        Query q = pm.newQuery((Class)UploadedPhoto.class);
        q.setFilter("imageURL == urlParam");
        q.declareParameters("String urlParam");
        try {
            List results = (List)q.execute((Object)url);
            if (results.isEmpty()) return photo;
            photo = (UploadedPhoto)results.get(0);
            return photo;
        }
        finally {
            q.closeAll();
        }
    }

    @Override
    public Boolean deleteUploadedPhotoByURL(String url) {
        UploadedPhoto photo = this.findUploadedPhotoByURL(url);
        return this.deleteUploadedPhotoByKey(photo.getEncodedKey());
    }

    private PersistenceManager getPM() {
        return PMF.get().getPersistenceManager();
    }
}

