/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.appengine.api.blobstore.BlobKey
 *  com.google.appengine.api.blobstore.BlobstoreService
 *  com.google.appengine.api.blobstore.BlobstoreServiceFactory
 *  com.google.appengine.api.images.ImagesService
 *  com.google.appengine.api.images.ImagesServiceFactory
 *  com.google.appengine.api.images.ServingUrlOptions
 *  com.google.appengine.api.images.ServingUrlOptions$Builder
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package org.hbgb.webcamp.server;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hbgb.webcamp.server.UploadedPhotoServiceImpl;
import org.hbgb.webcamp.shared.UploadedPhoto;

public class BlobStoreUploadServlet
extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Map blobs = this.blobstoreService.getUploads(req);
        List blobKeyList = (List)blobs.get("image");
        if (blobKeyList.isEmpty()) return;
        ImagesService imagesService = ImagesServiceFactory.getImagesService();
        ServingUrlOptions options = ServingUrlOptions.Builder.withBlobKey((BlobKey)((BlobKey)blobKeyList.get(0)));
        String imageUrl = imagesService.getServingUrl(options);
        UploadedPhotoServiceImpl photoServ = new UploadedPhotoServiceImpl();
        UploadedPhoto photo = new UploadedPhoto();
        photo.setCreated(new Date());
        photo.setBlobKey((BlobKey)blobKeyList.get(0));
        photo.setImageURL(imageUrl);
        photoServ.addUploadedPhoto(photo);
        res.sendRedirect("/webcamp/upload?imageUrl=" + imageUrl);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imageUrl = req.getParameter("imageUrl");
        resp.setHeader("Content-Type", "text/html");
        resp.getWriter().println(imageUrl);
    }
}

