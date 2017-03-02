/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.rpc.AsyncCallback
 */
package org.hbgb.webcamp.client.async;

import com.google.gwt.user.client.rpc.AsyncCallback;
import org.hbgb.webcamp.shared.UploadedPhoto;

public interface UploadedPhotoServiceAsync {
    public void getUploadedPhoto(String var1, AsyncCallback<UploadedPhoto> var2);

    public void addUploadedPhoto(UploadedPhoto var1, AsyncCallback<UploadedPhoto> var2);

    public void deleteUploadedPhotoByKey(String var1, AsyncCallback<Boolean> var2);

    public void deleteUploadedPhotoByURL(String var1, AsyncCallback<Boolean> var2);
}

