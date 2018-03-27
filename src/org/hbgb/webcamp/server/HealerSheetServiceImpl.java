/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.server.rpc.RemoteServiceServlet
 * javax.jdo.PersistenceManager javax.jdo.Query
 */
package org.hbgb.webcamp.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.hbgb.webcamp.client.async.HealerSheetService;
import org.hbgb.webcamp.shared.Application;
import org.hbgb.webcamp.shared.Burner;
import org.hbgb.webcamp.shared.Demographics;
import org.hbgb.webcamp.shared.HealerSheetDetails;
import org.hbgb.webcamp.shared.HealerSheetInfoBlock;
import org.hbgb.webcamp.shared.enums.Circle;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class HealerSheetServiceImpl extends RemoteServiceServlet implements HealerSheetService
{

	public HealerSheetServiceImpl()
	{

	}

	private PersistenceManager getPM()
	{
		return PMF.get().getPersistenceManager();
	}

	@Override
	public HealerSheetInfoBlock getHealerSheetInfoBlock(String encoded)
	{
		HealerSheetInfoBlock block = null;
		PersistenceManager pm = this.getPM();
		try
		{
			block = pm.getObjectById(HealerSheetInfoBlock.class, encoded);
			block = pm.detachCopy(block);

		}
		finally
		{
			pm.close();
		}
		return block;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HealerSheetInfoBlock> getAllHealerSheetInfoBlocks()
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(HealerSheetInfoBlock.class);

		query.setOrdering("email ASC");

		List<HealerSheetInfoBlock> entries = null;

		try
		{
			entries = (List<HealerSheetInfoBlock>) query.execute();
		}
		catch (Exception e)
		{
			// String text = e.getMessage();
		}

		return entries;
	}

	@Override
	public HealerSheetInfoBlock getHealerSheetInfoBlockByEmail(String email, Boolean create)
	{
		HealerSheetInfoBlock block = this.getHealerSheetInfoBlockByEmail(email);
		if (block != null)
			return this.addHealerSheetInfoBlock(block);
		block = new HealerSheetInfoBlock();
		block.setEmail(email);
		return this.addHealerSheetInfoBlock(block);
	}

	private HealerSheetInfoBlock getHealerSheetInfoBlockByEmail(String email)
	{
		HealerSheetInfoBlock block = null;
		PersistenceManager pm = getPM();

		Query q = pm.newQuery(HealerSheetInfoBlock.class);
		q.setFilter("email == emailParam");
		q.declareParameters("String emailParam");

		try
		{
			@SuppressWarnings("unchecked")
			List<HealerSheetInfoBlock> results = (List<HealerSheetInfoBlock>) q.execute(email);
			if (!results.isEmpty())
			{
				block = results.get(0);
			}
		}
		finally
		{
			q.closeAll();
		}

		return block;
	}

	@Override
	public HealerSheetInfoBlock addHealerSheetInfoBlock(HealerSheetInfoBlock block)
	{
		HealerSheetInfoBlock retVal = null;

		HealerSheetInfoBlock test = getHealerSheetInfoBlockByEmail(block.getEmail());
		if (null == test)
		{
			PersistenceManager pm = getPM();
			try
			{
				pm.makePersistent(block);
				block = pm.detachCopy(block);
			}
			finally
			{
				pm.close();
			}

			retVal = block;
		}
		else
		{
			retVal = test;
		}
		return retVal;
	}

	@Override
	public Boolean updateHealerSheetInfoBlock(HealerSheetInfoBlock block)
	{
		PersistenceManager pm = getPM();
		try
		{
			HealerSheetInfoBlock dbSheet = pm.getObjectById(HealerSheetInfoBlock.class,
					block.getEncodedKey());

			dbSheet.setBio(block.getBio());

			dbSheet.setSessionLength(block.getSessionLength());

			dbSheet.setModality1(block.getModality1());
			dbSheet.setModality2(block.getModality2());
			dbSheet.setModality3(block.getModality3());
			dbSheet.setModality4(block.getModality4());

			pm.makePersistent(dbSheet);
		}
		finally
		{
			pm.close();
		}

		return true;
	}

	@Override
	public Boolean deleteHealerSheetInfoBlock(String encoded)
	{
		PersistenceManager pm = this.getPM();
		try
		{
			HealerSheetInfoBlock block = pm.getObjectById(HealerSheetInfoBlock.class, encoded);
			pm.deletePersistent(block);
			return true;
		}
		finally
		{
			pm.close();
		}
	}

	@Override
	public List<HealerSheetDetails> getAllHealerSheetDetails()
	{
		ArrayList<HealerSheetDetails> details = new ArrayList<>();
		ApplicationServiceImpl appServ = new ApplicationServiceImpl();
		List<String> healerEmails = appServ.getCommitteeEmails(Circle.Healers);

		HealerSheetInfoBlock hs = null;

		for (String email : healerEmails)
		{
			hs = this.getHealerSheetInfoBlockByEmail(email);
			if (hs != null)
			{
				details.add(HealerSheetInfoBlock2Details(hs));
			}
		}
		Collections.sort(details);
		return details;
	}

	private HealerSheetDetails HealerSheetInfoBlock2Details(HealerSheetInfoBlock hs)
	{
		String encodedKey = hs.getEncodedKey();

		String email = hs.getEmail();
		String sessionLength = hs.getSessionLength();
		String modality1 = hs.getModality1();
		String modality2 = hs.getModality2();
		String modality3 = hs.getModality3();
		String modality4 = hs.getModality4();
		String bio = hs.getBio();

		ApplicationServiceImpl appServ = new ApplicationServiceImpl();

		Application app = appServ.getApplicationByEmail(email);

		String imageURL = "http://storage.googleapis.com/hbgbwebcamp.appspot.com/PhotoNotAvailable.jpg";
		if ((null != app) && (null != app.getImageURL()) && (!app.getImageURL().isEmpty()))
		{
			imageURL = app.getImageURL();
		}

		String playaName = "";

		Burner burner = appServ.getApplicant(app.getEncodedKey());

		if (null != burner)
		{
			Demographics demos = burner.getDemographics();
			if (!demos.getPlayaName().isEmpty())
			{
				playaName = demos.getPlayaName();
			}
			else
			{
				playaName = demos.getFirstName();
			}
		}

		return new HealerSheetDetails(encodedKey, email, playaName, imageURL, sessionLength,
				modality1, modality2, modality3, modality4, bio);
	}
}
