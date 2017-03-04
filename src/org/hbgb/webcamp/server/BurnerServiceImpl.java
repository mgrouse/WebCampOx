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

import org.hbgb.webcamp.client.async.BurnerService;
import org.hbgb.webcamp.shared.Burner;
import org.hbgb.webcamp.shared.BurnerDetails;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class BurnerServiceImpl extends RemoteServiceServlet implements BurnerService
{

	public BurnerServiceImpl()
	{

	}

	@Override
	public Burner getBurnerByKey(String encoded)
	{
		Burner burner = null;
		PersistenceManager pm = getPM();
		try
		{
			burner = pm.getObjectById(Burner.class, encoded);
			burner = pm.detachCopy(burner);

		}
		finally
		{
			pm.close();
		}
		return burner;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Burner getBurnerByEmail(String email)
	{
		Burner burner = null;
		PersistenceManager pm = getPM();

		Query q = pm.newQuery(Burner.class);
		q.setFilter("email == emailParam");
		q.declareParameters("String emailParam");

		List<Burner> entries;
		try
		{
			entries = (List<Burner>) q.execute(email);
			if (!entries.isEmpty())
			{
				burner = entries.get(0);
				burner = pm.detachCopy(burner);
			}
		}
		finally
		{
			pm.close();
		}
		return burner;
	}

	@Override
	public ArrayList<BurnerDetails> getBurnerDetails()
	{
		ArrayList<BurnerDetails> details = new ArrayList<>();

		List<Burner> burners = getBurners();

		for (Burner burner : burners)
		{
			details.add(burner2Details(burner));
		}

		return details;
	}

	@Override
	public Burner addBurner(Burner burner)
	{
		PersistenceManager pm = this.getPM();
		try
		{
			pm.makePersistent(burner);
			burner = pm.detachCopy(burner);

		}
		finally
		{
			pm.close();
		}
		return burner;
	}

	@Override
	public Burner updateBurner(Burner burner)
	{
		return this.addBurner(burner);
	}

	@Override
	public Boolean deleteBurner(String encoded)
	{
		PersistenceManager pm = this.getPM();
		try
		{
			Burner burner = pm.getObjectById(Burner.class, encoded);
			pm.deletePersistent(burner);

		}
		finally
		{
			pm.close();
		}
		return true;
	}

	@Override
	public ArrayList<BurnerDetails> deleteBurners(ArrayList<String> encodedStrings)
	{
		for (String encoded : encodedStrings)
		{
			this.deleteBurner(encoded);
		}
		return getBurnerDetails();
	}

	private List<Burner> getBurners()
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(Burner.class);
		query.setOrdering("email ASC");

		@SuppressWarnings("unchecked")
		List<Burner> entries = (List<Burner>) query.execute();

		return entries;
	}

	private BurnerDetails burner2Details(Burner b)
	{
		return new BurnerDetails(b.getEncodedKey(), b.getDemographics().getFullName(), b.getEmail());
	}

	private PersistenceManager getPM()
	{
		return PMF.get().getPersistenceManager();
	}
}
