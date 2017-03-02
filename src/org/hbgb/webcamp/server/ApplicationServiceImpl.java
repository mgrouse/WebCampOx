/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.appengine.api.datastore.Text
 *  com.google.gwt.user.server.rpc.RemoteServiceServlet
 *  javax.jdo.PersistenceManager
 *  javax.jdo.Query
 */
package org.hbgb.webcamp.server;

import com.google.appengine.api.datastore.Text;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import org.hbgb.webcamp.client.async.ApplicationService;
import org.hbgb.webcamp.server.PMF;
import org.hbgb.webcamp.shared.Address;
import org.hbgb.webcamp.shared.Application;
import org.hbgb.webcamp.shared.ApplicationDetails;
import org.hbgb.webcamp.shared.Burner;
import org.hbgb.webcamp.shared.CommitteeInfoBlock;
import org.hbgb.webcamp.shared.ContactInfo;
import org.hbgb.webcamp.shared.Demographics;
import org.hbgb.webcamp.shared.DietInfoBlock;
import org.hbgb.webcamp.shared.LogisticsInfoBlock;
import org.hbgb.webcamp.shared.MealsInfo;
import org.hbgb.webcamp.shared.MealsReport;
import org.hbgb.webcamp.shared.PaymentInfoBlock;
import org.hbgb.webcamp.shared.RosterDetails;
import org.hbgb.webcamp.shared.ShelterInfoBlock;
import org.hbgb.webcamp.shared.enums.ApplicationStatus;
import org.hbgb.webcamp.shared.enums.Committee;
import org.hbgb.webcamp.shared.enums.DayOfEvent;
import org.hbgb.webcamp.shared.enums.DietType;
import org.hbgb.webcamp.shared.enums.PlayaTime;

public class ApplicationServiceImpl
extends RemoteServiceServlet
implements ApplicationService {
    private static final int THIS_YEAR = 2017;

    @Override
    public Application getApplication(String encoded) {
        Application application = null;
        PersistenceManager pm = this.getPM();
        try {
            application = (Application)pm.getObjectById((Class)Application.class, (Object)encoded);
            application = (Application)pm.detachCopy((Object)application);
            return application;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public String findApplicationKeyByEmail(String email) {
        String retVal = null;
        Application app = this.getApplicationByEmail(email);
        if (app == null) return retVal;
        return app.getEncodedKey();
    }

    @Override
    public String findApplicationEmailByKey(String encoded) {
        String retVal = null;
        Application app = this.getApplication(encoded);
        if (app == null) return retVal;
        return app.getEmail();
    }

    public Application getApplicationByEmail(String email) {
        Application app = null;
        PersistenceManager pm = this.getPM();
        Query q = pm.newQuery((Class)Application.class);
        q.setFilter("email == emailParam");
        q.declareParameters("String emailParam");
        q.setOrdering("year DESC");
        try {
            List results = (List)q.execute((Object)email);
            if (results.isEmpty()) return app;
            app = (Application)results.get(0);
            app = (Application)pm.detachCopy((Object)app);
            return app;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public MealsReport getMealsReport() {
        ArrayList<MealsInfo> meals = new ArrayList<MealsInfo>();
        List<Application> applications = this.getApplications();
        for (Application app : applications) {
            if (app.getStatus() != ApplicationStatus.ACCEPTED) continue;
            meals.add(this.application2MealsInfo(app));
        }
        MealsReport report = new MealsReport();
        for (MealsInfo mi : meals) {
            report.addMealsInfo(mi);
        }
        return report;
    }

    @Override
    public ArrayList<ApplicationDetails> getApplicationDetails() {
        ArrayList<ApplicationDetails> details = new ArrayList<ApplicationDetails>();
        List<Application> applications = this.getApplications();
        for (Application app : applications) {
            details.add(this.application2Details(app));
        }
        Collections.sort(details);
        return details;
    }

    @Override
    public Application findOrAddApplication(String email) {
        Application retVal = null;
        Application test = this.getApplicationByEmail(email);
        if (test == null) {
            return this.createBlankApplicationByEmail(email);
        }
        if (2017 != test.getYear()) return this.createCopyApplicationForThisYear(test);
        return test;
    }

    private Application createBlankApplicationByEmail(String email) {
        PersistenceManager pm = this.getPM();
        Application app = new Application(email);
        try {
            pm.makePersistent((Object)app);
            app = (Application)pm.detachCopy((Object)app);
            return app;
        }
        finally {
            pm.close();
        }
    }

    private Application createCopyApplicationForThisYear(Application source) {
        PersistenceManager pm = this.getPM();
        Application dbApp = (Application)pm.getObjectById((Class)Application.class, (Object)source.getEncodedKey());
        Application copy = new Application(dbApp);
        try {
            pm.makePersistent((Object)copy);
            copy = (Application)pm.detachCopy((Object)copy);
            return copy;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public Boolean updateApplication(Application app) {
        PersistenceManager pm = this.getPM();
        try {
            Application dbApp = (Application)pm.getObjectById((Class)Application.class, (Object)app.getEncodedKey());
            dbApp.setEdited(new Date());
            dbApp.setStatus(app.getStatus());
            dbApp.setYear(app.getYear());
            dbApp.setImageURL(app.getImageURL());
            pm.makePersistent((Object)dbApp);
            return true;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public Boolean deleteApplication(String encoded) {
        PersistenceManager pm = this.getPM();
        try {
            Application app = (Application)pm.getObjectById((Class)Application.class, (Object)encoded);
            pm.deletePersistent((Object)app);
            return true;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public ArrayList<ApplicationDetails> deleteApplications(ArrayList<String> encodedStrings) {
        for (String encoded : encodedStrings) {
            this.deleteApplication(encoded);
        }
        return this.getApplicationDetails();
    }

    private List<Application> getApplications() {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery((Class)Application.class);
        query.setFilter("year == yearParam");
        query.declareParameters("int yearParam");
        query.setOrdering("status ASC");
        List entries = null;
        try {
            return (List)query.execute((Object)2017);
        }
        catch (Exception e) {
            String string = e.getMessage();
        }
        return entries;
    }

    private List<Application> getApplicationsByStatus(ApplicationStatus status) {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery((Class)Application.class);
        query.setFilter("year == yearParam && status == statusParam");
        query.declareParameters("int yearParam, String statusParam");
        query.setOrdering("status ASC");
        List entries = null;
        try {
            return (List)query.execute((Object)2017, (Object)status.name());
        }
        catch (Exception e) {
            String string = e.getMessage();
        }
        return entries;
    }

    @Override
    public List<String> getCommitteeEmails(Committee com) {
        ArrayList<String> emails = new ArrayList<String>();
        List<Application> entries = this.getApplicationsByStatus(ApplicationStatus.ACCEPTED);
        if (entries == null) return emails;
        for (Application app : entries) {
            CommitteeInfoBlock cib = app.getCommitteeInfoBlock();
            if (cib == null || com != cib.getAssignedCommittee() || app.getEmail() == null || app.getEmail().isEmpty()) continue;
            emails.add(app.getEmail());
        }
        return emails;
    }

    private ApplicationDetails application2Details(Application a) {
        String encodedKey = a.getEncodedKey();
        String status = "NULL";
        if (a.getStatus() != null) {
            status = a.getStatus().toString();
        }
        String displayName = a.getApplicant().getDemographics().getFullName();
        String playaName = a.getApplicant().getDemographics().getPlayaName();
        String committee = "None";
        if (a.getCommitteeInfoBlock().getAssignedCommittee() != null) {
            committee = a.getCommitteeInfoBlock().getAssignedCommittee().toString();
        }
        String ticket = "NULL";
        if (a.getPaymentInfoBlock().getHasTicket() != null) {
            ticket = a.getPaymentInfoBlock().getHasTicket().toString();
        }
        String invoiced = "NULL";
        if (a.getPaymentInfoBlock().getHasBeenInvoiced() != null) {
            invoiced = a.getPaymentInfoBlock().getHasBeenInvoiced().toString();
        }
        String paid = "NULL";
        if (a.getPaymentInfoBlock().getHasPaidDues() != null) {
            paid = a.getPaymentInfoBlock().getHasPaidDues().toString();
        }
        String diet = "NULL";
        if (a.getDietInfoBlock().getDietType() != null) {
            diet = a.getDietInfoBlock().getDietType().toString();
        }
        String email = a.getEmail();
        return new ApplicationDetails(encodedKey, status, displayName, playaName, committee, ticket, invoiced, paid, diet, email);
    }

    private MealsInfo application2MealsInfo(Application a) {
        MealsInfo meals = new MealsInfo();
        meals.setArrivalDate(a.getLogisticsInfoBlock().getArrivalDoE());
        meals.setArrivalTime(a.getLogisticsInfoBlock().getArrivalTime());
        meals.setDepartureDate(a.getLogisticsInfoBlock().getDepartureDoE());
        meals.setDepartureTime(a.getLogisticsInfoBlock().getDepartureTime());
        meals.setDietType(a.getDietInfoBlock().getDietType());
        meals.setIsGlutenFree(a.getDietInfoBlock().getIsGlutenFree());
        meals.setDietaryRestrictions(a.getDietInfoBlock().getDietaryRestrictions());
        return meals;
    }

    private PersistenceManager getPM() {
        return PMF.get().getPersistenceManager();
    }

    @Override
    public CommitteeInfoBlock getApplicantsCommitteeInfoBlock(String encoded) {
        CommitteeInfoBlock cBlock = null;
        Application application = null;
        PersistenceManager pm = this.getPM();
        try {
            application = (Application)pm.getObjectById((Class)Application.class, (Object)encoded);
            cBlock = application.getCommitteeInfoBlock();
            cBlock = (CommitteeInfoBlock)pm.detachCopy((Object)cBlock);
            return cBlock;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public Boolean updateApplicantsCommitteeInfoBlock(CommitteeInfoBlock ciBlock) {
        PersistenceManager pm = this.getPM();
        try {
            pm.makePersistent((Object)ciBlock);
            return true;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public Burner getApplicant(String encoded) {
        Burner b = null;
        Demographics d = null;
        ContactInfo ci = null;
        Address a = null;
        Application application = null;
        PersistenceManager pm = this.getPM();
        try {
            application = (Application)pm.getObjectById((Class)Application.class, (Object)encoded);
            if (application != null) {
                b = application.getApplicant();
                d = b.getDemographics();
                d = (Demographics)pm.detachCopy((Object)d);
                ci = b.getContactInfo();
                if (ci != null) {
                    a = ci.getAddress();
                    a = (Address)pm.detachCopy((Object)a);
                }
                ci = (ContactInfo)pm.detachCopy((Object)ci);
                ci.setAddress(a);
            }
            b = (Burner)pm.detachCopy((Object)b);
            b.setDemographics(d);
            b.setContactInfo(ci);
            return b;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public Boolean updateApplicant(Burner b) {
        PersistenceManager pm = this.getPM();
        try {
            pm.makePersistent((Object)b);
            return true;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public PaymentInfoBlock getApplicantsPaymentInfoBlock(String key) {
        PaymentInfoBlock piBlock = null;
        Application application = null;
        PersistenceManager pm = this.getPM();
        try {
            application = (Application)pm.getObjectById((Class)Application.class, (Object)key);
            piBlock = application.getPaymentInfoBlock();
            piBlock = (PaymentInfoBlock)pm.detachCopy((Object)piBlock);
            return piBlock;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public Boolean updateApplicantsPaymentInfoBlock(PaymentInfoBlock piBlock) {
        PersistenceManager pm = this.getPM();
        try {
            pm.makePersistent((Object)piBlock);
            return true;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public DietInfoBlock getApplicantsDietInfoBlock(String key) {
        DietInfoBlock diBlock = null;
        Application application = null;
        PersistenceManager pm = this.getPM();
        try {
            application = (Application)pm.getObjectById((Class)Application.class, (Object)key);
            diBlock = application.getDietInfoBlock();
            diBlock = (DietInfoBlock)pm.detachCopy((Object)diBlock);
            return diBlock;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public boolean updateApplicantsDietInfoBlock(DietInfoBlock diBlock) {
        PersistenceManager pm = this.getPM();
        try {
            pm.makePersistent((Object)diBlock);
            return true;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public ShelterInfoBlock getApplicantsShelterInfoBlock(String key) {
        ShelterInfoBlock siBlock = null;
        Application application = null;
        PersistenceManager pm = this.getPM();
        try {
            application = (Application)pm.getObjectById((Class)Application.class, (Object)key);
            siBlock = application.getShelterInfoBlock();
            siBlock = (ShelterInfoBlock)pm.detachCopy((Object)siBlock);
            return siBlock;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public boolean updateApplicantsShelterInfoBlock(ShelterInfoBlock shelterInfoBlock) {
        PersistenceManager pm = this.getPM();
        try {
            pm.makePersistent((Object)shelterInfoBlock);
            return true;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public LogisticsInfoBlock getApplicantsLogisticsInfoBlock(String key) {
        LogisticsInfoBlock liBlock = null;
        Application application = null;
        PersistenceManager pm = this.getPM();
        try {
            application = (Application)pm.getObjectById((Class)Application.class, (Object)key);
            liBlock = application.getLogisticsInfoBlock();
            liBlock = (LogisticsInfoBlock)pm.detachCopy((Object)liBlock);
            return liBlock;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public boolean updateApplicantsLogisticsInfoBlock(LogisticsInfoBlock logisticsInfoBlock) {
        PersistenceManager pm = this.getPM();
        try {
            pm.makePersistent((Object)logisticsInfoBlock);
            return true;
        }
        finally {
            pm.close();
        }
    }

    @Override
    public String updateApplicationObjectSchema() {
        return "Not Implemented";
    }

    private List<Application> getAcceptedApplicationsByYear(String year) {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery((Class)Application.class);
        query.setFilter("year == yearParam && status == statusParam");
        query.declareParameters("int yearParam, String statusParam");
        List entries = null;
        try {
            return (List)query.execute((Object)new Integer(year), (Object)"ACCEPTED");
        }
        catch (Exception e) {
            String string = e.getMessage();
        }
        return entries;
    }

    private RosterDetails application2RosterDetails(Application app) {
        String encodedKey = app.getEncodedKey();
        String photoURL = "http://storage.googleapis.com/hbgbwebcamp.appspot.com/PhotoNotAvailable.jpg";
        if (app.getImageURL() != null && !app.getImageURL().isEmpty()) {
            photoURL = app.getImageURL();
        }
        String playaName = "";
        String firstName = "";
        String bio = "";
        Burner dude = app.getApplicant();
        if (dude != null && dude.getDemographics() != null) {
            Demographics demos = dude.getDemographics();
            playaName = demos.getPlayaName();
            firstName = demos.getFirstName();
            bio = demos.getBio().getValue();
        }
        String homeTown = "";
        if (dude != null && dude.getContactInfo() != null && dude.getContactInfo().getAddress() != null) {
            Address add = dude.getContactInfo().getAddress();
            homeTown = String.valueOf(add.getCity()) + ", " + add.getState();
        }
        String committee = "None";
        if (app.getCommitteeInfoBlock() == null) return new RosterDetails(encodedKey, photoURL, playaName, firstName, homeTown, committee, bio);
        if (app.getCommitteeInfoBlock().getAssignedCommittee() == null) return new RosterDetails(encodedKey, photoURL, playaName, firstName, homeTown, committee, bio);
        committee = app.getCommitteeInfoBlock().getAssignedCommittee().toString();
        return new RosterDetails(encodedKey, photoURL, playaName, firstName, homeTown, committee, bio);
    }

    @Override
    public List<RosterDetails> getAcceptedRosterDetailsByYear(String year) {
        ArrayList<RosterDetails> details = new ArrayList<RosterDetails>();
        List<Application> roster = this.getAcceptedApplicationsByYear(year);
        for (Application app : roster) {
            details.add(this.application2RosterDetails(app));
        }
        Collections.sort(details);
        return details;
    }
}

