/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.server.rpc.RemoteServiceServlet
 *  javax.jdo.PersistenceManager
 */
package org.hbgb.webcamp.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import javax.jdo.PersistenceManager;
import org.hbgb.webcamp.client.async.LoginService;
import org.hbgb.webcamp.server.HbgbAppUserServiceImpl;
import org.hbgb.webcamp.server.PMF;
import org.hbgb.webcamp.shared.HbgbUser;

public class LoginServiceImpl
extends RemoteServiceServlet
implements LoginService {
    @Override
    public HbgbUser authenticate(String email, String password) {
        HbgbAppUserServiceImpl userSvc = new HbgbAppUserServiceImpl();
        HbgbUser user = userSvc.getHbgbUserByEmail(email);
        if (user == null) return null;
        if (user.isPassword(password) == false) return null;
        return user;
    }

    private PersistenceManager getPM() {
        return PMF.get().getPersistenceManager();
    }
}

