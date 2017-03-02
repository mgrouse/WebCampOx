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
import org.hbgb.webcamp.client.async.HbgbAppUserService;
import org.hbgb.webcamp.server.PMF;
import org.hbgb.webcamp.shared.HbgbUser;
import org.hbgb.webcamp.shared.HbgbUserDetails;

public class HbgbAppUserServiceImpl
extends RemoteServiceServlet
implements HbgbAppUserService {
    private static final String HEE_BEE_DOMAIN = "heebeegeebeehealers.org";

    private PersistenceManager getPM() {
        return PMF.get().getPersistenceManager();
    }

    @Override
    public HbgbUser addHbgbUser(HbgbUser user) {
        PersistenceManager pm = this.getPM();
        HbgbUser retVal = null;
        try {
            retVal = this.getHbgbUserByEmail(user.getEmailAddress());
            if (retVal != null) return retVal;
            retVal = (HbgbUser)pm.makePersistent((Object)user);
            return retVal;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public Boolean updateHbgbUser(HbgbUser hbgbUser) {
        PersistenceManager pm = this.getPM();
        try {
            pm.makePersistent((Object)hbgbUser);
            return true;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public Boolean deleteUser(String encoded) {
        PersistenceManager pm = this.getPM();
        try {
            HbgbUser user = (HbgbUser)pm.getObjectById((Class)HbgbUser.class, (Object)encoded);
            pm.deletePersistent((Object)user);
            return true;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public ArrayList<HbgbUserDetails> deleteUsers(ArrayList<String> encodedSttrings) {
        for (String encoded : encodedSttrings) {
            this.deleteUser(encoded);
        }
        return this.getHbgbUserDetails();
    }

    @Override
    public ArrayList<HbgbUserDetails> removeUsersFromEarlyTeam(ArrayList<String> encodedStrings) {
        for (String key : encodedStrings) {
            HbgbUser currentUser = this.getHbgbUser(key);
            currentUser.setIsEarlyTeam(false);
            this.updateHbgbUser(currentUser);
        }
        return this.getEarlyTeamDetails();
    }

    @Override
    public HbgbUser getHbgbUser(String encodedKey) {
        HbgbUser user = null;
        PersistenceManager pm = this.getPM();
        try {
            user = (HbgbUser)pm.getObjectById((Class)HbgbUser.class, (Object)encodedKey);
            return user;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public HbgbUser getHbgbUserByEmail(String email) {
        HbgbUser user = null;
        PersistenceManager pm = this.getPM();
        Query q = pm.newQuery((Class)HbgbUser.class);
        q.setFilter("emailAddress == emailParam");
        q.declareParameters("String emailParam");
        try {
            List results = (List)q.execute((Object)email);
            if (results.size() > 1) return user;
            if (results.size() != 1) return user;
            user = (HbgbUser)results.get(0);
            return user;
        }
        finally {
            q.closeAll();
        }
    }

    @Override
    public ArrayList<HbgbUserDetails> getHbgbUserDetails() {
        ArrayList<HbgbUserDetails> hbgbUserDetails = new ArrayList<HbgbUserDetails>();
        List<HbgbUser> users = this.getHbgbUsers();
        for (HbgbUser user : users) {
            hbgbUserDetails.add(this.hbgbUser2Details(user));
        }
        return hbgbUserDetails;
    }

    private List<HbgbUser> getHbgbUsers() {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery((Class)HbgbUser.class);
        query.setOrdering("lastName ASC");
        return (List)query.execute();
    }

    private List<HbgbUser> getEarlyTeam() {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery((Class)HbgbUser.class);
        query.setFilter("isEarlyTeam == true");
        query.setOrdering("lastName ASC");
        return (List)query.execute();
    }

    private HbgbUserDetails hbgbUser2Details(HbgbUser u) {
        return new HbgbUserDetails(u.getKey(), u.getDisplayName());
    }

    @Override
    public ArrayList<HbgbUserDetails> getEarlyTeamDetails() {
        ArrayList<HbgbUserDetails> earlyTeamDetails = new ArrayList<HbgbUserDetails>();
        List<HbgbUser> users = this.getEarlyTeam();
        for (HbgbUser user : users) {
            earlyTeamDetails.add(this.hbgbUser2Details(user));
        }
        return earlyTeamDetails;
    }
}

