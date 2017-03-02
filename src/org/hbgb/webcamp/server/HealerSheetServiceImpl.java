/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.server.rpc.RemoteServiceServlet
 *  javax.jdo.PersistenceManager
 *  javax.jdo.Query
 */
package org.hbgb.webcamp.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import org.hbgb.webcamp.client.async.HealerSheetService;
import org.hbgb.webcamp.server.ApplicationServiceImpl;
import org.hbgb.webcamp.server.PMF;
import org.hbgb.webcamp.shared.Application;
import org.hbgb.webcamp.shared.Burner;
import org.hbgb.webcamp.shared.Demographics;
import org.hbgb.webcamp.shared.HealerSheetDetails;
import org.hbgb.webcamp.shared.HealerSheetInfoBlock;
import org.hbgb.webcamp.shared.enums.Committee;

public class HealerSheetServiceImpl
extends RemoteServiceServlet
implements HealerSheetService {
    private static final int THIS_YEAR = 2016;

    private PersistenceManager getPM() {
        return PMF.get().getPersistenceManager();
    }

    @Override
    public HealerSheetInfoBlock getHealerSheetInfoBlock(String encoded) {
        HealerSheetInfoBlock block = null;
        PersistenceManager pm = this.getPM();
        try {
            block = (HealerSheetInfoBlock)pm.getObjectById((Class)HealerSheetInfoBlock.class, (Object)encoded);
            block = (HealerSheetInfoBlock)pm.detachCopy((Object)block);
            return block;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public List<HealerSheetInfoBlock> getAllHealerSheetInfoBlocks() {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery((Class)HealerSheetInfoBlock.class);
        query.setOrdering("email ASC");
        List hs = null;
        try {
            hs.addAll((List)query.execute());
            return hs;
        }
        catch (Exception e) {
            String string = e.getMessage();
        }
        return hs;
    }

    @Override
    public HealerSheetInfoBlock getHealerSheetInfoBlockByEmail(String email, Boolean create) {
        HealerSheetInfoBlock block = this.getHealerSheetInfoBlockByEmail(email);
        if (block != null) return this.addHealerSheetInfoBlock(block);
        block = new HealerSheetInfoBlock();
        block.setEmail(email);
        return this.addHealerSheetInfoBlock(block);
    }

    private HealerSheetInfoBlock getHealerSheetInfoBlockByEmail(String email) {
        HealerSheetInfoBlock block = null;
        PersistenceManager pm = this.getPM();
        Query q = pm.newQuery((Class)HealerSheetInfoBlock.class);
        q.setFilter("email == emailParam");
        q.declareParameters("String emailParam");
        try {
            List results = (List)q.execute((Object)email);
            if (results.isEmpty()) return block;
            block = (HealerSheetInfoBlock)results.get(0);
            return block;
        }
        finally {
            q.closeAll();
        }
    }

    @Override
    public HealerSheetInfoBlock addHealerSheetInfoBlock(HealerSheetInfoBlock block) {
        HealerSheetInfoBlock retVal = null;
        HealerSheetInfoBlock test = this.getHealerSheetInfoBlockByEmail(block.getEmail());
        if (test != null) {
            return test;
        }
        PersistenceManager pm = this.getPM();
        try {
            pm.makePersistent((Object)block);
            block = (HealerSheetInfoBlock)pm.detachCopy((Object)block);
            return block;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public Boolean updateHealerSheetInfoBlock(HealerSheetInfoBlock block) {
        PersistenceManager pm = this.getPM();
        try {
            HealerSheetInfoBlock dbSheet = (HealerSheetInfoBlock)pm.getObjectById((Class)HealerSheetInfoBlock.class, (Object)block.getEncodedKey());
            dbSheet.setBio(block.getBio());
            dbSheet.setSessionLength(block.getSessionLength());
            dbSheet.setModality1(block.getModality1());
            dbSheet.setModality2(block.getModality2());
            dbSheet.setModality3(block.getModality3());
            dbSheet.setModality4(block.getModality4());
            pm.makePersistent((Object)dbSheet);
            return true;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public Boolean deleteHealerSheetInfoBlock(String encoded) {
        PersistenceManager pm = this.getPM();
        try {
            HealerSheetInfoBlock block = (HealerSheetInfoBlock)pm.getObjectById((Class)HealerSheetInfoBlock.class, (Object)encoded);
            pm.deletePersistent((Object)block);
            return true;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public List<HealerSheetDetails> getAllHealerSheetDetails() {
        ArrayList<HealerSheetDetails> details = new ArrayList<HealerSheetDetails>();
        ApplicationServiceImpl appServ = new ApplicationServiceImpl();
        List<String> healerEmails = appServ.getCommitteeEmails(Committee.Healers);
        HealerSheetInfoBlock hs = null;
        for (String email : healerEmails) {
            hs = this.getHealerSheetInfoBlockByEmail(email);
            if (hs == null) continue;
            details.add(this.HealerSheetInfoBlock2Details(hs));
        }
        Collections.sort(details);
        return details;
    }

    private HealerSheetDetails HealerSheetInfoBlock2Details(HealerSheetInfoBlock hs) {
        Burner burner;
        String encodedKey = hs.getEncodedKey();
        String email = hs.getEmail();
        String sessionLength = hs.getSessionLength();
        String modality1 = hs.getModality1();
        String modality2 = hs.getModality2();
        String modality3 = hs.getModality3();
        String modality4 = hs.getModality4();
        String bio = hs.getBio();
        ApplicationServiceImpl appServ = new ApplicationServiceImpl();
        String playaName = "";
        String encoded = appServ.findApplicationKeyByEmail(email);
        if (encoded != null && (burner = appServ.getApplicant(encoded)) != null && burner.getDemographics() != null) {
            Demographics demos = burner.getDemographics();
            playaName = !demos.getPlayaName().isEmpty() ? demos.getPlayaName() : demos.getFirstName();
        }
        Application app = appServ.getApplication(encoded);
        String imageURL = "http://storage.googleapis.com/hbgbwebcamp.appspot.com/PhotoNotAvailable.jpg";
        if (app == null) return new HealerSheetDetails(encodedKey, email, playaName, imageURL, sessionLength, modality1, modality2, modality3, modality4, bio);
        if (app.getImageURL() == null) return new HealerSheetDetails(encodedKey, email, playaName, imageURL, sessionLength, modality1, modality2, modality3, modality4, bio);
        if (app.getImageURL().isEmpty()) return new HealerSheetDetails(encodedKey, email, playaName, imageURL, sessionLength, modality1, modality2, modality3, modality4, bio);
        imageURL = app.getImageURL();
        return new HealerSheetDetails(encodedKey, email, playaName, imageURL, sessionLength, modality1, modality2, modality3, modality4, bio);
    }
}

