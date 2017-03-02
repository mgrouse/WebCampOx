/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.appengine.api.blobstore.BlobstoreService
 *  com.google.appengine.api.blobstore.BlobstoreServiceFactory
 *  com.google.gwt.user.server.rpc.RemoteServiceServlet
 */
package org.hbgb.webcamp.server;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.hbgb.webcamp.client.async.BlobStoreUploadURLService;

public class BlobStoreUploadURLServiceImpl
extends RemoteServiceServlet
implements BlobStoreUploadURLService {
    @Override
    public String getBlobstoreUploadUrl() {
        BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
        return blobstoreService.createUploadUrl("/webcamp/upload");
    }
}

