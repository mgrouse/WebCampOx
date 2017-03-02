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
import org.hbgb.webcamp.client.async.ProfileService;
import org.hbgb.webcamp.server.PMF;
import org.hbgb.webcamp.shared.Demographics;
import org.hbgb.webcamp.shared.HeeBee;
import org.hbgb.webcamp.shared.Profile;
import org.hbgb.webcamp.shared.ProfileDetails;

public class ProfileServiceImpl
extends RemoteServiceServlet
implements ProfileService {
    @Override
    public Profile getProfile(String encoded) {
        Profile profile = null;
        PersistenceManager pm = this.getPM();
        try {
            profile = (Profile)pm.getObjectById((Class)Profile.class, (Object)encoded);
            return profile;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public ArrayList<ProfileDetails> getProfileDetails() {
        ArrayList<ProfileDetails> details = new ArrayList<ProfileDetails>();
        List<Profile> profiles = this.getProfiles();
        for (Profile profile : profiles) {
            details.add(this.profile2Details(profile));
        }
        return details;
    }

    @Override
    public Profile addProfile(Profile profile) {
        PersistenceManager pm = this.getPM();
        try {
            pm.makePersistent((Object)profile);
            return profile;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public Profile updateProfile(Profile profile) {
        return this.addProfile(profile);
    }

    @Override
    public Boolean deleteProfile(String encoded) {
        PersistenceManager pm = this.getPM();
        try {
            Profile profile = (Profile)pm.getObjectById((Class)Profile.class, (Object)encoded);
            pm.deletePersistent((Object)profile);
            return true;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public ArrayList<ProfileDetails> deleteProfiles(ArrayList<String> encodedStrings) {
        for (String encoded : encodedStrings) {
            this.deleteProfile(encoded);
        }
        return this.getProfileDetails();
    }

    private List<Profile> getProfiles() {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery((Class)Profile.class);
        query.setOrdering("email ASC");
        return (List)query.execute();
    }

    private ProfileDetails profile2Details(Profile p) {
        return new ProfileDetails(p.getEncodedKey(), p.getHeebee().getDemographics().getFullName(), p.getEmail());
    }

    private PersistenceManager getPM() {
        return PMF.get().getPersistenceManager();
    }
}

