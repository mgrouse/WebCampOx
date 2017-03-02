/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.rpc.IsSerializable
 *  javax.jdo.JDOFatalInternalException
 *  javax.jdo.PersistenceManager
 *  javax.jdo.annotations.Extension
 *  javax.jdo.annotations.IdGeneratorStrategy
 *  javax.jdo.annotations.IdentityType
 *  javax.jdo.annotations.PersistenceCapable
 *  javax.jdo.annotations.Persistent
 *  javax.jdo.annotations.PrimaryKey
 *  javax.jdo.identity.StringIdentity
 *  javax.jdo.spi.JDOImplHelper
 *  javax.jdo.spi.PersistenceCapable
 *  javax.jdo.spi.PersistenceCapable$ObjectIdFieldConsumer
 *  javax.jdo.spi.PersistenceCapable$ObjectIdFieldSupplier
 *  javax.jdo.spi.StateManager
 */
package org.hbgb.webcamp.shared;

import com.google.gwt.user.client.rpc.IsSerializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import javax.jdo.JDOFatalInternalException;
import javax.jdo.PersistenceManager;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.identity.StringIdentity;
import javax.jdo.spi.JDOImplHelper;
import javax.jdo.spi.PersistenceCapable;
import javax.jdo.spi.StateManager;
import org.hbgb.webcamp.shared.Burner;
import org.hbgb.webcamp.shared.CommitteeInfoBlock;
import org.hbgb.webcamp.shared.DietInfoBlock;
import org.hbgb.webcamp.shared.LogisticsInfoBlock;
import org.hbgb.webcamp.shared.OfficeUse;
import org.hbgb.webcamp.shared.PaymentInfoBlock;
import org.hbgb.webcamp.shared.ShelterInfoBlock;
import org.hbgb.webcamp.shared.VettingInfoBlock;
import org.hbgb.webcamp.shared.enums.ApplicationStatus;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Application
implements Serializable,
IsSerializable,
PersistenceCapable {
    private static final int THIS_YEAR = 2017;
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
    @Persistent
    private String email = "";
    @Persistent
    private Date created;
    @Persistent
    private Date edited;
    @Persistent
    private int year;
    @Persistent
    private String imageURL = "";
    @Persistent
    private ApplicationStatus status;
    @Persistent
    private Burner applicant;
    @Persistent
    private PaymentInfoBlock paymentInfoBlock;
    @Persistent
    private CommitteeInfoBlock committeeInfoBlock;
    @Persistent
    private LogisticsInfoBlock logisticsInfoBlock;
    @Persistent
    private ShelterInfoBlock shelterInfoBlock;
    @Persistent
    private DietInfoBlock dietInfoBlock;
    @Persistent
    private VettingInfoBlock vettingInfoBlock;
    @Persistent
    private OfficeUse officeUse;
    protected transient StateManager jdoStateManager;
    protected transient byte jdoFlags;
    private static final byte[] jdoFieldFlags;
    private static final Class jdoPersistenceCapableSuperclass;
    private static final Class[] jdoFieldTypes;
    private static final String[] jdoFieldNames;
    private static final int jdoInheritedFieldCount;
    private static final long serialVersionUID = 7185032782982934789L;

    public Application() {
    }

    public Application(String emailText) {
        this.email = emailText;
        this.created = new Date();
        this.edited = null;
        this.year = 2017;
        this.status = ApplicationStatus.NEW;
        this.applicant = new Burner(emailText);
        this.paymentInfoBlock = new PaymentInfoBlock(emailText);
        this.committeeInfoBlock = new CommitteeInfoBlock(emailText);
        this.logisticsInfoBlock = new LogisticsInfoBlock(emailText);
        this.shelterInfoBlock = new ShelterInfoBlock(emailText);
        this.dietInfoBlock = new DietInfoBlock(emailText);
        this.vettingInfoBlock = null;
        this.officeUse = null;
    }

    public Application(Application source) {
        this.created = new Date();
        this.edited = null;
        this.year = 2017;
        this.status = ApplicationStatus.NEW;
        if (source == null) return;
        this.setImageURL(source.getImageURL());
        this.email = source.getEmail();
        this.paymentInfoBlock = new PaymentInfoBlock(this.email, source.getPaymentInfoBlock());
        this.committeeInfoBlock = new CommitteeInfoBlock(this.email, source.getCommitteeInfoBlock());
        this.logisticsInfoBlock = new LogisticsInfoBlock(this.email);
        this.shelterInfoBlock = new ShelterInfoBlock(this.email, source.getShelterInfoBlock());
        this.dietInfoBlock = new DietInfoBlock(this.email, source.getDietInfoBlock());
        this.applicant = new Burner(this.email, source.getApplicant());
    }

    public String getEncodedKey() {
        return Application.jdoGetencodedKey(this);
    }

    public void setEncodedKey(String encodedKey) {
        Application.jdoSetencodedKey(this, encodedKey);
    }

    public String getEmail() {
        return Application.jdoGetemail(this);
    }

    public void setEmail(String email) {
        Application.jdoSetemail(this, email);
    }

    public Date getCreated() {
        return Application.jdoGetcreated(this);
    }

    public void setCreated(Date created) {
        Application.jdoSetcreated(this, created);
    }

    public Date getEdited() {
        return Application.jdoGetedited(this);
    }

    public void setEdited(Date edited) {
        Application.jdoSetedited(this, edited);
    }

    public int getYear() {
        return Application.jdoGetyear(this);
    }

    public void setYear(int year) {
        Application.jdoSetyear(this, year);
    }

    public ApplicationStatus getStatus() {
        return Application.jdoGetstatus(this);
    }

    public void setStatus(ApplicationStatus status) {
        Application.jdoSetstatus(this, status);
    }

    public Burner getApplicant() {
        return Application.jdoGetapplicant(this);
    }

    public void setApplicant(Burner applicant) {
        Application.jdoSetapplicant(this, applicant);
    }

    public PaymentInfoBlock getPaymentInfoBlock() {
        return Application.jdoGetpaymentInfoBlock(this);
    }

    public void setPaymentInfoBlock(PaymentInfoBlock payment) {
        Application.jdoSetpaymentInfoBlock(this, payment);
    }

    public CommitteeInfoBlock getCommitteeInfoBlock() {
        return Application.jdoGetcommitteeInfoBlock(this);
    }

    public void setCommitteeInfoBlock(CommitteeInfoBlock commitee) {
        Application.jdoSetcommitteeInfoBlock(this, commitee);
    }

    public LogisticsInfoBlock getLogisticsInfoBlock() {
        return Application.jdoGetlogisticsInfoBlock(this);
    }

    public void setLogisticsInfoBlock(LogisticsInfoBlock logisticsInfoBlock) {
        Application.jdoSetlogisticsInfoBlock(this, logisticsInfoBlock);
    }

    public ShelterInfoBlock getShelterInfoBlock() {
        return Application.jdoGetshelterInfoBlock(this);
    }

    public void setShelterInfoBlock(ShelterInfoBlock shelterInfoBlock) {
        Application.jdoSetshelterInfoBlock(this, shelterInfoBlock);
    }

    public DietInfoBlock getDietInfoBlock() {
        return Application.jdoGetdietInfoBlock(this);
    }

    public void setDietInfoBlock(DietInfoBlock dietInfoBlock) {
        Application.jdoSetdietInfoBlock(this, dietInfoBlock);
    }

    public VettingInfoBlock getVettingInfoBlock() {
        return Application.jdoGetvettingInfoBlock(this);
    }

    public void setVettingInfoBlock(VettingInfoBlock vettingInfoBlock) {
        Application.jdoSetvettingInfoBlock(this, vettingInfoBlock);
    }

    public OfficeUse getOfficeUse() {
        return Application.jdoGetofficeUse(this);
    }

    public void setOfficeUse(OfficeUse officeUse) {
        Application.jdoSetofficeUse(this, officeUse);
    }

    public String getImageURL() {
        return Application.jdoGetimageURL(this);
    }

    public void setImageURL(String imageURL) {
        Application.jdoSetimageURL(this, imageURL);
    }

    static {
        jdoFieldNames = Application.__jdoFieldNamesInit();
        jdoFieldTypes = Application.__jdoFieldTypesInit();
        jdoFieldFlags = Application.__jdoFieldFlagsInit();
        jdoInheritedFieldCount = Application.__jdoGetInheritedFieldCount();
        jdoPersistenceCapableSuperclass = Application.__jdoPersistenceCapableSuperclassInit();
        JDOImplHelper.registerClass((Class)Application.___jdo$loadClass("org.hbgb.webcamp.shared.Application"), (String[])jdoFieldNames, (Class[])jdoFieldTypes, (byte[])jdoFieldFlags, (Class)jdoPersistenceCapableSuperclass, (PersistenceCapable)new Application());
    }

    public void jdoCopyKeyFieldsFromObjectId(PersistenceCapable.ObjectIdFieldConsumer fc, Object oid) {
        if (fc == null) {
            throw new IllegalArgumentException("ObjectIdFieldConsumer is null");
        }
        if (!(oid instanceof StringIdentity)) {
            throw new ClassCastException("oid is not instanceof javax.jdo.identity.StringIdentity");
        }
        StringIdentity o = (StringIdentity)oid;
        fc.storeStringField(6, o.getKey());
    }

    protected void jdoCopyKeyFieldsFromObjectId(Object oid) {
        if (!(oid instanceof StringIdentity)) {
            throw new ClassCastException("key class is not javax.jdo.identity.StringIdentity or null");
        }
        StringIdentity o = (StringIdentity)oid;
        this.encodedKey = o.getKey();
    }

    public void jdoCopyKeyFieldsToObjectId(Object oid) {
        throw new JDOFatalInternalException("It's illegal to call jdoCopyKeyFieldsToObjectId for a class with SingleFieldIdentity.");
    }

    public void jdoCopyKeyFieldsToObjectId(PersistenceCapable.ObjectIdFieldSupplier fs, Object paramObject) {
        throw new JDOFatalInternalException("It's illegal to call jdoCopyKeyFieldsToObjectId for a class with SingleFieldIdentity.");
    }

    public final Object jdoGetObjectId() {
        if (this.jdoStateManager == null) return null;
        return this.jdoStateManager.getObjectId((PersistenceCapable)this);
    }

    public final Object jdoGetVersion() {
        if (this.jdoStateManager == null) return null;
        return this.jdoStateManager.getVersion((PersistenceCapable)this);
    }

    protected final void jdoPreSerialize() {
        if (this.jdoStateManager == null) return;
        this.jdoStateManager.preSerialize((PersistenceCapable)this);
    }

    public final PersistenceManager jdoGetPersistenceManager() {
        if (this.jdoStateManager == null) return null;
        PersistenceManager persistenceManager = this.jdoStateManager.getPersistenceManager((PersistenceCapable)this);
        return persistenceManager;
    }

    public final Object jdoGetTransactionalObjectId() {
        if (this.jdoStateManager == null) return null;
        Object object = this.jdoStateManager.getTransactionalObjectId((PersistenceCapable)this);
        return object;
    }

    public final boolean jdoIsDeleted() {
        if (this.jdoStateManager == null) return false;
        boolean bl = this.jdoStateManager.isDeleted((PersistenceCapable)this);
        return bl;
    }

    public final boolean jdoIsDirty() {
        if (this.jdoStateManager == null) return false;
        return this.jdoStateManager.isDirty((PersistenceCapable)this);
    }

    public final boolean jdoIsNew() {
        if (this.jdoStateManager == null) return false;
        boolean bl = this.jdoStateManager.isNew((PersistenceCapable)this);
        return bl;
    }

    public final boolean jdoIsPersistent() {
        if (this.jdoStateManager == null) return false;
        boolean bl = this.jdoStateManager.isPersistent((PersistenceCapable)this);
        return bl;
    }

    public final boolean jdoIsTransactional() {
        if (this.jdoStateManager == null) return false;
        boolean bl = this.jdoStateManager.isTransactional((PersistenceCapable)this);
        return bl;
    }

    public void jdoMakeDirty(String fieldName) {
        if (this.jdoStateManager == null) return;
        this.jdoStateManager.makeDirty((PersistenceCapable)this, fieldName);
    }

    public Object jdoNewObjectIdInstance() {
        return new StringIdentity(this.getClass(), this.encodedKey);
    }

    public Object jdoNewObjectIdInstance(Object key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        if (key instanceof String) return new StringIdentity(this.getClass(), (String)key);
        return new StringIdentity(this.getClass(), (String)key);
    }

    public final void jdoProvideFields(int[] indices) {
        if (indices == null) {
            throw new IllegalArgumentException("argment is null");
        }
        int i = indices.length - 1;
        if (i < 0) return;
        do {
            this.jdoProvideField(indices[i]);
        } while (--i >= 0);
    }

    public final void jdoReplaceFields(int[] indices) {
        if (indices == null) {
            throw new IllegalArgumentException("argument is null");
        }
        int i = indices.length;
        if (i <= 0) return;
        int j = 0;
        do {
            this.jdoReplaceField(indices[j]);
        } while (++j < i);
    }

    public final void jdoReplaceFlags() {
        if (this.jdoStateManager == null) return;
        this.jdoFlags = this.jdoStateManager.replacingFlags((PersistenceCapable)this);
    }

    public final synchronized void jdoReplaceStateManager(StateManager sm) {
        if (this.jdoStateManager != null) {
            this.jdoStateManager = this.jdoStateManager.replacingStateManager((PersistenceCapable)this, sm);
            return;
        }
        JDOImplHelper.checkAuthorizedStateManager((StateManager)sm);
        this.jdoStateManager = sm;
        this.jdoFlags = 1;
    }

    public boolean jdoIsDetached() {
        return false;
    }

    public PersistenceCapable jdoNewInstance(StateManager sm) {
        Application result = new Application();
        result.jdoFlags = 1;
        result.jdoStateManager = sm;
        return result;
    }

    public PersistenceCapable jdoNewInstance(StateManager sm, Object obj) {
        Application result = new Application();
        result.jdoFlags = 1;
        result.jdoStateManager = sm;
        result.jdoCopyKeyFieldsFromObjectId(obj);
        return result;
    }

    public void jdoReplaceField(int index) {
        if (this.jdoStateManager == null) {
            throw new IllegalStateException("state manager is null");
        }
        switch (index) {
            case 0: {
                this.applicant = (Burner)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 1: {
                this.committeeInfoBlock = (CommitteeInfoBlock)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 2: {
                this.created = (Date)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 3: {
                this.dietInfoBlock = (DietInfoBlock)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 4: {
                this.edited = (Date)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 5: {
                this.email = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 6: {
                this.encodedKey = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 7: {
                this.imageURL = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 8: {
                this.logisticsInfoBlock = (LogisticsInfoBlock)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 9: {
                this.officeUse = (OfficeUse)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 10: {
                this.paymentInfoBlock = (PaymentInfoBlock)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 11: {
                this.shelterInfoBlock = (ShelterInfoBlock)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 12: {
                this.status = (ApplicationStatus)((Object)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index));
                return;
            }
            case 13: {
                this.vettingInfoBlock = (VettingInfoBlock)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 14: {
                this.year = this.jdoStateManager.replacingIntField((PersistenceCapable)this, index);
                return;
            }
        }
        throw new IllegalArgumentException(new StringBuffer("out of field index :").append(index).toString());
    }

    public void jdoProvideField(int index) {
        if (this.jdoStateManager == null) {
            throw new IllegalStateException("state manager is null");
        }
        switch (index) {
            case 0: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.applicant);
                return;
            }
            case 1: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.committeeInfoBlock);
                return;
            }
            case 2: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.created);
                return;
            }
            case 3: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.dietInfoBlock);
                return;
            }
            case 4: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.edited);
                return;
            }
            case 5: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.email);
                return;
            }
            case 6: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.encodedKey);
                return;
            }
            case 7: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.imageURL);
                return;
            }
            case 8: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.logisticsInfoBlock);
                return;
            }
            case 9: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.officeUse);
                return;
            }
            case 10: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.paymentInfoBlock);
                return;
            }
            case 11: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.shelterInfoBlock);
                return;
            }
            case 12: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.status);
                return;
            }
            case 13: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.vettingInfoBlock);
                return;
            }
            case 14: {
                this.jdoStateManager.providedIntField((PersistenceCapable)this, index, this.year);
                return;
            }
        }
        throw new IllegalArgumentException(new StringBuffer("out of field index :").append(index).toString());
    }

    protected final void jdoCopyField(Application obj, int index) {
        switch (index) {
            case 0: {
                this.applicant = obj.applicant;
                return;
            }
            case 1: {
                this.committeeInfoBlock = obj.committeeInfoBlock;
                return;
            }
            case 2: {
                this.created = obj.created;
                return;
            }
            case 3: {
                this.dietInfoBlock = obj.dietInfoBlock;
                return;
            }
            case 4: {
                this.edited = obj.edited;
                return;
            }
            case 5: {
                this.email = obj.email;
                return;
            }
            case 6: {
                this.encodedKey = obj.encodedKey;
                return;
            }
            case 7: {
                this.imageURL = obj.imageURL;
                return;
            }
            case 8: {
                this.logisticsInfoBlock = obj.logisticsInfoBlock;
                return;
            }
            case 9: {
                this.officeUse = obj.officeUse;
                return;
            }
            case 10: {
                this.paymentInfoBlock = obj.paymentInfoBlock;
                return;
            }
            case 11: {
                this.shelterInfoBlock = obj.shelterInfoBlock;
                return;
            }
            case 12: {
                this.status = obj.status;
                return;
            }
            case 13: {
                this.vettingInfoBlock = obj.vettingInfoBlock;
                return;
            }
            case 14: {
                this.year = obj.year;
                return;
            }
        }
        throw new IllegalArgumentException(new StringBuffer("out of field index :").append(index).toString());
    }

    public void jdoCopyFields(Object obj, int[] indices) {
        if (this.jdoStateManager == null) {
            throw new IllegalStateException("state manager is null");
        }
        if (indices == null) {
            throw new IllegalStateException("fieldNumbers is null");
        }
        if (!(obj instanceof Application)) {
            throw new IllegalArgumentException("object is not an object of type org.hbgb.webcamp.shared.Application");
        }
        Application other = (Application)obj;
        if (this.jdoStateManager != other.jdoStateManager) {
            throw new IllegalArgumentException("state managers do not match");
        }
        int i = indices.length - 1;
        if (i < 0) return;
        do {
            this.jdoCopyField(other, indices[i]);
        } while (--i >= 0);
    }

    private static final String[] __jdoFieldNamesInit() {
        return new String[]{"applicant", "committeeInfoBlock", "created", "dietInfoBlock", "edited", "email", "encodedKey", "imageURL", "logisticsInfoBlock", "officeUse", "paymentInfoBlock", "shelterInfoBlock", "status", "vettingInfoBlock", "year"};
    }

    private static final Class[] __jdoFieldTypesInit() {
        return new Class[]{Application.___jdo$loadClass("org.hbgb.webcamp.shared.Burner"), Application.___jdo$loadClass("org.hbgb.webcamp.shared.CommitteeInfoBlock"), Application.___jdo$loadClass("java.util.Date"), Application.___jdo$loadClass("org.hbgb.webcamp.shared.DietInfoBlock"), Application.___jdo$loadClass("java.util.Date"), Application.___jdo$loadClass("java.lang.String"), Application.___jdo$loadClass("java.lang.String"), Application.___jdo$loadClass("java.lang.String"), Application.___jdo$loadClass("org.hbgb.webcamp.shared.LogisticsInfoBlock"), Application.___jdo$loadClass("org.hbgb.webcamp.shared.OfficeUse"), Application.___jdo$loadClass("org.hbgb.webcamp.shared.PaymentInfoBlock"), Application.___jdo$loadClass("org.hbgb.webcamp.shared.ShelterInfoBlock"), Application.___jdo$loadClass("org.hbgb.webcamp.shared.enums.ApplicationStatus"), Application.___jdo$loadClass("org.hbgb.webcamp.shared.VettingInfoBlock"), Integer.TYPE};
    }

    private static final byte[] __jdoFieldFlagsInit() {
        return new byte[]{26, 26, 21, 26, 21, 21, 24, 21, 26, 26, 26, 26, 21, 26, 21};
    }

    protected static int __jdoGetInheritedFieldCount() {
        return 0;
    }

    protected static int jdoGetManagedFieldCount() {
        return 15;
    }

    private static Class __jdoPersistenceCapableSuperclassInit() {
        return null;
    }

    public static Class ___jdo$loadClass(String className) {
        try {
            return Class.forName(className);
        }
        catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private Object jdoSuperClone() throws CloneNotSupportedException {
        Application o = (Application)super.clone();
        o.jdoFlags = 0;
        o.jdoStateManager = null;
        return o;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        this.jdoPreSerialize();
        out.defaultWriteObject();
    }

    private static Burner jdoGetapplicant(Application objPC) {
        if (objPC.jdoStateManager == null) return objPC.applicant;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 0)) return objPC.applicant;
        return (Burner)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 0, (Object)objPC.applicant);
    }

    private static void jdoSetapplicant(Application objPC, Burner val) {
        if (objPC.jdoStateManager == null) {
            objPC.applicant = val;
            return;
        }
        objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 0, (Object)objPC.applicant, (Object)val);
    }

    private static CommitteeInfoBlock jdoGetcommitteeInfoBlock(Application objPC) {
        if (objPC.jdoStateManager == null) return objPC.committeeInfoBlock;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 1)) return objPC.committeeInfoBlock;
        return (CommitteeInfoBlock)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 1, (Object)objPC.committeeInfoBlock);
    }

    private static void jdoSetcommitteeInfoBlock(Application objPC, CommitteeInfoBlock val) {
        if (objPC.jdoStateManager == null) {
            objPC.committeeInfoBlock = val;
            return;
        }
        objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 1, (Object)objPC.committeeInfoBlock, (Object)val);
    }

    private static Date jdoGetcreated(Application objPC) {
        if (objPC.jdoFlags <= 0) return objPC.created;
        if (objPC.jdoStateManager == null) return objPC.created;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 2)) return objPC.created;
        return (Date)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 2, (Object)objPC.created);
    }

    private static void jdoSetcreated(Application objPC, Date val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 2, (Object)objPC.created, (Object)val);
            return;
        }
        objPC.created = val;
    }

    private static DietInfoBlock jdoGetdietInfoBlock(Application objPC) {
        if (objPC.jdoStateManager == null) return objPC.dietInfoBlock;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 3)) return objPC.dietInfoBlock;
        return (DietInfoBlock)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 3, (Object)objPC.dietInfoBlock);
    }

    private static void jdoSetdietInfoBlock(Application objPC, DietInfoBlock val) {
        if (objPC.jdoStateManager == null) {
            objPC.dietInfoBlock = val;
            return;
        }
        objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 3, (Object)objPC.dietInfoBlock, (Object)val);
    }

    private static Date jdoGetedited(Application objPC) {
        if (objPC.jdoFlags <= 0) return objPC.edited;
        if (objPC.jdoStateManager == null) return objPC.edited;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 4)) return objPC.edited;
        return (Date)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 4, (Object)objPC.edited);
    }

    private static void jdoSetedited(Application objPC, Date val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 4, (Object)objPC.edited, (Object)val);
            return;
        }
        objPC.edited = val;
    }

    private static String jdoGetemail(Application objPC) {
        if (objPC.jdoFlags <= 0) return objPC.email;
        if (objPC.jdoStateManager == null) return objPC.email;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 5)) return objPC.email;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 5, objPC.email);
    }

    private static void jdoSetemail(Application objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 5, objPC.email, val);
            return;
        }
        objPC.email = val;
    }

    private static String jdoGetencodedKey(Application objPC) {
        return objPC.encodedKey;
    }

    private static void jdoSetencodedKey(Application objPC, String val) {
        if (objPC.jdoStateManager == null) {
            objPC.encodedKey = val;
            return;
        }
        objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 6, objPC.encodedKey, val);
    }

    private static String jdoGetimageURL(Application objPC) {
        if (objPC.jdoFlags <= 0) return objPC.imageURL;
        if (objPC.jdoStateManager == null) return objPC.imageURL;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 7)) return objPC.imageURL;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 7, objPC.imageURL);
    }

    private static void jdoSetimageURL(Application objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 7, objPC.imageURL, val);
            return;
        }
        objPC.imageURL = val;
    }

    private static LogisticsInfoBlock jdoGetlogisticsInfoBlock(Application objPC) {
        if (objPC.jdoStateManager == null) return objPC.logisticsInfoBlock;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 8)) return objPC.logisticsInfoBlock;
        return (LogisticsInfoBlock)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 8, (Object)objPC.logisticsInfoBlock);
    }

    private static void jdoSetlogisticsInfoBlock(Application objPC, LogisticsInfoBlock val) {
        if (objPC.jdoStateManager == null) {
            objPC.logisticsInfoBlock = val;
            return;
        }
        objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 8, (Object)objPC.logisticsInfoBlock, (Object)val);
    }

    private static OfficeUse jdoGetofficeUse(Application objPC) {
        if (objPC.jdoStateManager == null) return objPC.officeUse;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 9)) return objPC.officeUse;
        return (OfficeUse)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 9, (Object)objPC.officeUse);
    }

    private static void jdoSetofficeUse(Application objPC, OfficeUse val) {
        if (objPC.jdoStateManager == null) {
            objPC.officeUse = val;
            return;
        }
        objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 9, (Object)objPC.officeUse, (Object)val);
    }

    private static PaymentInfoBlock jdoGetpaymentInfoBlock(Application objPC) {
        if (objPC.jdoStateManager == null) return objPC.paymentInfoBlock;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 10)) return objPC.paymentInfoBlock;
        return (PaymentInfoBlock)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 10, (Object)objPC.paymentInfoBlock);
    }

    private static void jdoSetpaymentInfoBlock(Application objPC, PaymentInfoBlock val) {
        if (objPC.jdoStateManager == null) {
            objPC.paymentInfoBlock = val;
            return;
        }
        objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 10, (Object)objPC.paymentInfoBlock, (Object)val);
    }

    private static ShelterInfoBlock jdoGetshelterInfoBlock(Application objPC) {
        if (objPC.jdoStateManager == null) return objPC.shelterInfoBlock;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 11)) return objPC.shelterInfoBlock;
        return (ShelterInfoBlock)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 11, (Object)objPC.shelterInfoBlock);
    }

    private static void jdoSetshelterInfoBlock(Application objPC, ShelterInfoBlock val) {
        if (objPC.jdoStateManager == null) {
            objPC.shelterInfoBlock = val;
            return;
        }
        objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 11, (Object)objPC.shelterInfoBlock, (Object)val);
    }

    private static ApplicationStatus jdoGetstatus(Application objPC) {
        if (objPC.jdoFlags <= 0) return objPC.status;
        if (objPC.jdoStateManager == null) return objPC.status;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 12)) return objPC.status;
        return (ApplicationStatus)((Object)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 12, (Object)objPC.status));
    }

    private static void jdoSetstatus(Application objPC, ApplicationStatus val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 12, (Object)objPC.status, (Object)val);
            return;
        }
        objPC.status = val;
    }

    private static VettingInfoBlock jdoGetvettingInfoBlock(Application objPC) {
        if (objPC.jdoStateManager == null) return objPC.vettingInfoBlock;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 13)) return objPC.vettingInfoBlock;
        return (VettingInfoBlock)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 13, (Object)objPC.vettingInfoBlock);
    }

    private static void jdoSetvettingInfoBlock(Application objPC, VettingInfoBlock val) {
        if (objPC.jdoStateManager == null) {
            objPC.vettingInfoBlock = val;
            return;
        }
        objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 13, (Object)objPC.vettingInfoBlock, (Object)val);
    }

    private static int jdoGetyear(Application objPC) {
        if (objPC.jdoFlags <= 0) return objPC.year;
        if (objPC.jdoStateManager == null) return objPC.year;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 14)) return objPC.year;
        return objPC.jdoStateManager.getIntField((PersistenceCapable)objPC, 14, objPC.year);
    }

    private static void jdoSetyear(Application objPC, int val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setIntField((PersistenceCapable)objPC, 14, objPC.year, val);
            return;
        }
        objPC.year = val;
    }
}

