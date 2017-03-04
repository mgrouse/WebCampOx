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

import org.hbgb.webcamp.client.async.HeeBeeService;
import org.hbgb.webcamp.shared.HeeBee;
import org.hbgb.webcamp.shared.HeeBeeDetails;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class HeeBeeServiceImpl extends RemoteServiceServlet implements HeeBeeService
{
	@Override
	public HeeBee getHeeBee(String encoded)
	{
		HeeBee heebee = null;
		PersistenceManager pm = this.getPM();
		try
		{
			heebee = pm.getObjectById(HeeBee.class, encoded);
			heebee = pm.detachCopy(heebee);

		}
		finally
		{
			pm.close();
		}
		return heebee;
	}

	@Override
	public ArrayList<HeeBeeDetails> getHeeBeeDetails()
	{
		ArrayList<HeeBeeDetails> details = new ArrayList<>();

		List<HeeBee> heebees = this.getHeeBees();

		for (HeeBee hb : heebees)
		{
			details.add(this.heeBee2Details(hb));
		}
		return details;
	}

	@Override
	public HeeBee addHeeBee(HeeBee heebee)
	{
		PersistenceManager pm = this.getPM();
		try
		{
			pm.makePersistent(heebee);
			heebee = pm.detachCopy(heebee);
			return heebee;
		}
		finally
		{
			pm.close();
		}
	}

	@Override
	public HeeBee updateHeeBee(HeeBee heebee)
	{
		return this.addHeeBee(heebee);
	}

	@Override
	public Boolean deleteHeeBee(String encoded)
	{
		PersistenceManager pm = this.getPM();
		try
		{
			HeeBee hb = pm.getObjectById(HeeBee.class, encoded);
			pm.deletePersistent(hb);

		}
		finally
		{
			pm.close();
		}
		return true;
	}

	@Override
	public ArrayList<HeeBeeDetails> deleteHeeBees(ArrayList<String> encodedStrings)
	{
		// room for efficiency by opening pm once, delete many, close once?
		for (String encoded : encodedStrings)
		{
			deleteHeeBee(encoded);
		}

		return getHeeBeeDetails();
	}

	private List<HeeBee> getHeeBees()
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(HeeBee.class);
		query.setOrdering("email ASC");

		@SuppressWarnings("unchecked")
		List<HeeBee> entries = (List<HeeBee>) query.execute();

		return entries;
	}

	private HeeBeeDetails heeBee2Details(HeeBee h)
	{
		return new HeeBeeDetails(h.getEncodedKey(), h.getDemographics().getFullName(), h.getEmail());
	}

	private PersistenceManager getPM()
	{
		return PMF.get().getPersistenceManager();
	}
}
