/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.server.rpc.RemoteServiceServlet
 * javax.jdo.PersistenceManager
 */
package org.hbgb.webcamp.server;

import javax.jdo.PersistenceManager;

import org.hbgb.webcamp.client.async.LoginService;
import org.hbgb.webcamp.shared.HbgbUser;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService
{
	@Override
	public HbgbUser authenticate(String email, String password)
	{
		HbgbUser retVal = null;

		HbgbAppUserServiceImpl userSvc = new HbgbAppUserServiceImpl();

		HbgbUser user = userSvc.getHbgbUserByEmail(email);

		if ((user != null) && (user.getPassword().contentEquals(password)))
		{
			retVal = user;
		}

		return retVal;
	}

	@SuppressWarnings("unused")
	private PersistenceManager getPM()
	{
		return PMF.get().getPersistenceManager();
	}
}
