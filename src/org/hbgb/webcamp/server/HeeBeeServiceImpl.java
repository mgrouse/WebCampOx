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
import org.hbgb.webcamp.client.async.HeeBeeService;
import org.hbgb.webcamp.server.PMF;
import org.hbgb.webcamp.shared.Demographics;
import org.hbgb.webcamp.shared.HeeBee;
import org.hbgb.webcamp.shared.HeeBeeDetails;

public class HeeBeeServiceImpl
extends RemoteServiceServlet
implements HeeBeeService {
    @Override
    public HeeBee getHeeBee(String encoded) {
        HeeBee heebee = null;
        PersistenceManager pm = this.getPM();
        try {
            heebee = (HeeBee)pm.getObjectById((Class)HeeBee.class, (Object)encoded);
            heebee = (HeeBee)pm.detachCopy((Object)heebee);
            return heebee;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public ArrayList<HeeBeeDetails> getHeeBeeDetails() {
        ArrayList<HeeBeeDetails> details = new ArrayList<HeeBeeDetails>();
        List<HeeBee> heebees = this.getHeeBees();
        for (HeeBee hb : heebees) {
            details.add(this.heeBee2Details(hb));
        }
        return details;
    }

    @Override
    public HeeBee addHeeBee(HeeBee heebee) {
        PersistenceManager pm = this.getPM();
        try {
            pm.makePersistent((Object)heebee);
            heebee = (HeeBee)pm.detachCopy((Object)heebee);
            return heebee;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public HeeBee updateHeeBee(HeeBee heebee) {
        return this.addHeeBee(heebee);
    }

    @Override
    public Boolean deleteHeeBee(String encoded) {
        PersistenceManager pm = this.getPM();
        try {
            HeeBee hb = (HeeBee)pm.getObjectById((Class)HeeBee.class, (Object)encoded);
            pm.deletePersistent((Object)hb);
            return true;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public ArrayList<HeeBeeDetails> deleteHeeBees(ArrayList<String> encodedStrings) {
        for (String encoded : encodedStrings) {
            this.deleteHeeBee(encoded);
        }
        return this.getHeeBeeDetails();
    }

    private List<HeeBee> getHeeBees() {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery((Class)HeeBee.class);
        query.setOrdering("email ASC");
        return (List)query.execute();
    }

    private HeeBeeDetails heeBee2Details(HeeBee h) {
        return new HeeBeeDetails(h.getEncodedKey(), h.getDemographics().getFullName(), h.getEmail());
    }

    private PersistenceManager getPM() {
        return PMF.get().getPersistenceManager();
    }
}

