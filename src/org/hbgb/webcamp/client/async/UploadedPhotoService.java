/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.client.rpc.RemoteServiceRelativePath
 */
package org.hbgb.webcamp.client.async;

import org.hbgb.webcamp.shared.UploadedPhoto;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath(value = "uploadedPhotoService")
public interface UploadedPhotoService
{
	public UploadedPhoto getUploadedPhoto(String var1);

	public UploadedPhoto addUploadedPhoto(UploadedPhoto var1);

	public Boolean deleteUploadedPhotoByKey(String var1);

	public Boolean deleteUploadedPhotoByURL(String var1);
}
