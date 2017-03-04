/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.server.rpc.RemoteServiceServlet
 * javax.jdo.PersistenceManager javax.jdo.Query
 */
package org.hbgb.webcamp.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.hbgb.webcamp.client.async.HbgbAppUserService;
import org.hbgb.webcamp.shared.HbgbUser;
import org.hbgb.webcamp.shared.HbgbUserDetails;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class HbgbAppUserServiceImpl extends RemoteServiceServlet implements HbgbAppUserService
{

	public HbgbAppUserServiceImpl()
	{

	}

	private PersistenceManager getPM()
	{
		return PMF.get().getPersistenceManager();
	}

	@Override
	public HbgbUser addHbgbUser(HbgbUser user)
	{
		PersistenceManager pm = this.getPM();
		HbgbUser retVal = null;
		try
		{
			retVal = getHbgbUserByEmail(user.getEmailAddress());
			if (retVal == null)
			{
				retVal = pm.makePersistent(user);
			}
		}
		finally
		{
			pm.close();
		}

		return retVal;
	}

	@Override
	public Boolean updateHbgbUser(HbgbUser hbgbUser)
	{
		PersistenceManager pm = this.getPM();
		try
		{
			pm.makePersistent(hbgbUser);

		}
		finally
		{
			pm.close();
		}
		return true;
	}

	@Override
	public Boolean deleteUser(String encoded)
	{
		PersistenceManager pm = this.getPM();
		try
		{
			HbgbUser user = pm.getObjectById(HbgbUser.class, encoded);
			pm.deletePersistent(user);

		}
		finally
		{
			pm.close();
		}
		return true;
	}

	@Override
	public ArrayList<HbgbUserDetails> deleteUsers(ArrayList<String> encodedSttrings)
	{
		for (String encoded : encodedSttrings)
		{
			this.deleteUser(encoded);
		}
		return this.getHbgbUserDetails();
	}

	@Override
	public ArrayList<HbgbUserDetails> removeUsersFromEarlyTeam(ArrayList<String> encodedStrings)
	{
		for (String key : encodedStrings)
		{
			HbgbUser currentUser = this.getHbgbUser(key);
			currentUser.setIsEarlyTeam(false);
			this.updateHbgbUser(currentUser);
		}
		return this.getEarlyTeamDetails();
	}

	@Override
	public HbgbUser getHbgbUser(String encodedKey)
	{
		HbgbUser user = null;
		PersistenceManager pm = this.getPM();
		try
		{
			user = pm.getObjectById(HbgbUser.class, encodedKey);

		}
		finally
		{
			pm.close();
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HbgbUser getHbgbUserByEmail(String email)
	{
		HbgbUser user = null;
		PersistenceManager pm = getPM();

		Query q = pm.newQuery(HbgbUser.class);
		q.setFilter("emailAddress == emailParam");
		q.declareParameters("String emailParam");

		try
		{
			List<HbgbUser> results = (List<HbgbUser>) q.execute(email);
			if (results.size() != 1)
			{
				// throw a fit: too many/few results
			}
			else
			{
				user = results.get(0);
			}
		}
		finally
		{
			q.closeAll();
		}

		return user;
	}

	@Override
	public ArrayList<HbgbUserDetails> getHbgbUserDetails()
	{
		ArrayList<HbgbUserDetails> hbgbUserDetails = new ArrayList<>();
		List<HbgbUser> users = this.getHbgbUsers();
		for (HbgbUser user : users)
		{
			hbgbUserDetails.add(this.hbgbUser2Details(user));
		}
		return hbgbUserDetails;
	}

	private List<HbgbUser> getHbgbUsers()
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(HbgbUser.class);
		query.setOrdering("lastName ASC");

		@SuppressWarnings("unchecked")
		List<HbgbUser> entries = (List<HbgbUser>) query.execute();

		return entries;
	}

	private List<HbgbUser> getEarlyTeam()
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query query = pm.newQuery(HbgbUser.class);
		query.setFilter("isEarlyTeam == true");
		query.setOrdering("lastName ASC");

		@SuppressWarnings("unchecked")
		List<HbgbUser> entries = (List<HbgbUser>) query.execute();

		return entries;
	}

	private HbgbUserDetails hbgbUser2Details(HbgbUser u)
	{
		return new HbgbUserDetails(u.getKey(), u.getFullName());
	}

	@Override
	public ArrayList<HbgbUserDetails> getEarlyTeamDetails()
	{
		ArrayList<HbgbUserDetails> earlyTeamDetails = new ArrayList<>();
		List<HbgbUser> users = this.getEarlyTeam();
		for (HbgbUser user : users)
		{
			earlyTeamDetails.add(this.hbgbUser2Details(user));
		}
		return earlyTeamDetails;
	}
}
