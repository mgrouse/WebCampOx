/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.core.client.GWT
 */
package org.hbgb.webcamp.client.async;

import com.google.gwt.core.client.GWT;
import org.hbgb.webcamp.client.async.ApplicationService;
import org.hbgb.webcamp.client.async.ApplicationServiceAsync;
import org.hbgb.webcamp.client.async.BlobStoreUploadURLService;
import org.hbgb.webcamp.client.async.BlobStoreUploadURLServiceAsync;
import org.hbgb.webcamp.client.async.EmailService;
import org.hbgb.webcamp.client.async.EmailServiceAsync;
import org.hbgb.webcamp.client.async.HbgbAppUserService;
import org.hbgb.webcamp.client.async.HbgbAppUserServiceAsync;
import org.hbgb.webcamp.client.async.HealerSheetService;
import org.hbgb.webcamp.client.async.HealerSheetServiceAsync;
import org.hbgb.webcamp.client.async.LoginService;
import org.hbgb.webcamp.client.async.LoginServiceAsync;

public class AsyncServiceFinder {
    private static ApplicationServiceAsync applicationService;
    private static HealerSheetServiceAsync healerSheetService;
    private static EmailServiceAsync emailService;
    private static BlobStoreUploadURLServiceAsync blobstoreURLService;
    private static LoginServiceAsync loginService;
    private static HbgbAppUserServiceAsync usrService;

    private AsyncServiceFinder() {
    }

    public static ApplicationServiceAsync getApplicationService() {
        if (applicationService != null) return applicationService;
        applicationService = (ApplicationServiceAsync)GWT.create((Class)ApplicationService.class);
        return applicationService;
    }

    public static HealerSheetServiceAsync getHealerSheetService() {
        if (healerSheetService != null) return healerSheetService;
        healerSheetService = (HealerSheetServiceAsync)GWT.create((Class)HealerSheetService.class);
        return healerSheetService;
    }

    public static EmailServiceAsync getEmailService() {
        if (emailService != null) return emailService;
        emailService = (EmailServiceAsync)GWT.create((Class)EmailService.class);
        return emailService;
    }

    public static BlobStoreUploadURLServiceAsync getBlobStoreUploadURLService() {
        if (blobstoreURLService != null) return blobstoreURLService;
        blobstoreURLService = (BlobStoreUploadURLServiceAsync)GWT.create((Class)BlobStoreUploadURLService.class);
        return blobstoreURLService;
    }

    public static LoginServiceAsync getLoginService() {
        if (loginService != null) return loginService;
        loginService = (LoginServiceAsync)GWT.create((Class)LoginService.class);
        return loginService;
    }

    public static HbgbAppUserServiceAsync getHbgbUserService() {
        if (usrService != null) return usrService;
        usrService = (HbgbAppUserServiceAsync)GWT.create((Class)HbgbAppUserService.class);
        return usrService;
    }
}

