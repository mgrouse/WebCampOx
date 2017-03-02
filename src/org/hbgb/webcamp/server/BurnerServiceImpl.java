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
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import org.hbgb.webcamp.client.async.BurnerService;
import org.hbgb.webcamp.server.PMF;
import org.hbgb.webcamp.shared.Burner;
import org.hbgb.webcamp.shared.BurnerDetails;
import org.hbgb.webcamp.shared.Demographics;

public class BurnerServiceImpl
extends RemoteServiceServlet
implements BurnerService {
    @Override
    public Burner getBurnerByKey(String encoded) {
        Burner burner = null;
        PersistenceManager pm = this.getPM();
        try {
            burner = (Burner)pm.getObjectById((Class)Burner.class, (Object)encoded);
            burner = (Burner)pm.detachCopy((Object)burner);
            return burner;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public Burner getBurnerByEmail(String email) {
        Burner burner = null;
        PersistenceManager pm = this.getPM();
        Query q = pm.newQuery((Class)Burner.class);
        q.setFilter("email == emailParam");
        q.declareParameters("String emailParam");
        try {
            List results = (List)q.execute((Object)email);
            if (results.isEmpty()) return burner;
            burner = (Burner)results.get(0);
            burner = (Burner)pm.detachCopy((Object)burner);
            return burner;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public ArrayList<BurnerDetails> getBurnerDetails() {
        ArrayList<BurnerDetails> details = new ArrayList<BurnerDetails>();
        List<Burner> burners = this.getBurners();
        for (Burner burner : burners) {
            details.add(this.burner2Details(burner));
        }
        return details;
    }

    @Override
    public Burner addBurner(Burner burner) {
        PersistenceManager pm = this.getPM();
        try {
            pm.makePersistent((Object)burner);
            burner = (Burner)pm.detachCopy((Object)burner);
            return burner;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public Burner updateBurner(Burner burner) {
        return this.addBurner(burner);
    }

    @Override
    public Boolean deleteBurner(String encoded) {
        PersistenceManager pm = this.getPM();
        try {
            Burner burner = (Burner)pm.getObjectById((Class)Burner.class, (Object)encoded);
            pm.deletePersistent((Object)burner);
            return true;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public ArrayList<BurnerDetails> deleteBurners(ArrayList<String> encodedStrings) {
        for (String encoded : encodedStrings) {
            this.deleteBurner(encoded);
        }
        return this.getBurnerDetails();
    }

    private List<Burner> getBurners() {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery((Class)Burner.class);
        query.setOrdering("email ASC");
        return (List)query.execute();
    }

    private BurnerDetails burner2Details(Burner b) {
        return new BurnerDetails(b.getEncodedKey(), b.getDemographics().getFullName(), b.getEmail());
    }

    private PersistenceManager getPM() {
        return PMF.get().getPersistenceManager();
    }
}

