/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
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

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
import org.hbgb.webcamp.shared.CommitteeInfoBlock;
import org.hbgb.webcamp.shared.DietInfoBlock;
import org.hbgb.webcamp.shared.HeeBee;
import org.hbgb.webcamp.shared.LogisticsInfoBlock;
import org.hbgb.webcamp.shared.OfficeUse;
import org.hbgb.webcamp.shared.ShelterInfoBlock;
import org.hbgb.webcamp.shared.VettingInfoBlock;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Profile
implements Serializable,
PersistenceCapable {
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
    @Persistent
    private String email;
    @Persistent
    private HeeBee heebee;
    @Persistent
    private CommitteeInfoBlock commitee;
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
    private static final long serialVersionUID = -6405557444463064046L;

    public String getEncodedKey() {
        return Profile.jdoGetencodedKey(this);
    }

    public void setEncodedKey(String encodedKey) {
        Profile.jdoSetencodedKey(this, encodedKey);
    }

    public String getEmail() {
        return Profile.jdoGetemail(this);
    }

    public void setEmail(String email) {
        Profile.jdoSetemail(this, email);
    }

    public HeeBee getHeebee() {
        return Profile.jdoGetheebee(this);
    }

    public void setHeebee(HeeBee heebee) {
        Profile.jdoSetheebee(this, heebee);
    }

    public CommitteeInfoBlock getCommitee() {
        return Profile.jdoGetcommitee(this);
    }

    public void setCommitee(CommitteeInfoBlock commitee) {
        Profile.jdoSetcommitee(this, commitee);
    }

    public LogisticsInfoBlock getLogisticsInfoBlock() {
        return Profile.jdoGetlogisticsInfoBlock(this);
    }

    public void setLogisticsInfoBlock(LogisticsInfoBlock logisticsInfoBlock) {
        Profile.jdoSetlogisticsInfoBlock(this, logisticsInfoBlock);
    }

    public ShelterInfoBlock getShelterInfoBlock() {
        return Profile.jdoGetshelterInfoBlock(this);
    }

    public void setShelterInfoBlock(ShelterInfoBlock shelterInfoBlock) {
        Profile.jdoSetshelterInfoBlock(this, shelterInfoBlock);
    }

    public DietInfoBlock getDietInfoBlock() {
        return Profile.jdoGetdietInfoBlock(this);
    }

    public void setDietInfoBlock(DietInfoBlock dietInfoBlock) {
        Profile.jdoSetdietInfoBlock(this, dietInfoBlock);
    }

    public VettingInfoBlock getVettingInfoBlock() {
        return Profile.jdoGetvettingInfoBlock(this);
    }

    public void setVettingInfoBlock(VettingInfoBlock vettingInfoBlock) {
        Profile.jdoSetvettingInfoBlock(this, vettingInfoBlock);
    }

    public OfficeUse getOfficeUse() {
        return Profile.jdoGetofficeUse(this);
    }

    public void setOfficeUse(OfficeUse officeUse) {
        Profile.jdoSetofficeUse(this, officeUse);
    }

    static {
        jdoFieldNames = Profile.__jdoFieldNamesInit();
        jdoFieldTypes = Profile.__jdoFieldTypesInit();
        jdoFieldFlags = Profile.__jdoFieldFlagsInit();
        jdoInheritedFieldCount = Profile.__jdoGetInheritedFieldCount();
        jdoPersistenceCapableSuperclass = Profile.__jdoPersistenceCapableSuperclassInit();
        JDOImplHelper.registerClass((Class)Profile.___jdo$loadClass("org.hbgb.webcamp.shared.Profile"), (String[])jdoFieldNames, (Class[])jdoFieldTypes, (byte[])jdoFieldFlags, (Class)jdoPersistenceCapableSuperclass, (PersistenceCapable)new Profile());
    }

    public void jdoCopyKeyFieldsFromObjectId(PersistenceCapable.ObjectIdFieldConsumer fc, Object oid) {
        if (fc == null) {
            throw new IllegalArgumentException("ObjectIdFieldConsumer is null");
        }
        if (!(oid instanceof StringIdentity)) {
            throw new ClassCastException("oid is not instanceof javax.jdo.identity.StringIdentity");
        }
        StringIdentity o = (StringIdentity)oid;
        fc.storeStringField(3, o.getKey());
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
        Profile result = new Profile();
        result.jdoFlags = 1;
        result.jdoStateManager = sm;
        return result;
    }

    public PersistenceCapable jdoNewInstance(StateManager sm, Object obj) {
        Profile result = new Profile();
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
                this.commitee = (CommitteeInfoBlock)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 1: {
                this.dietInfoBlock = (DietInfoBlock)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 2: {
                this.email = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 3: {
                this.encodedKey = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 4: {
                this.heebee = (HeeBee)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 5: {
                this.logisticsInfoBlock = (LogisticsInfoBlock)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 6: {
                this.officeUse = (OfficeUse)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 7: {
                this.shelterInfoBlock = (ShelterInfoBlock)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 8: {
                this.vettingInfoBlock = (VettingInfoBlock)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
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
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.commitee);
                return;
            }
            case 1: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.dietInfoBlock);
                return;
            }
            case 2: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.email);
                return;
            }
            case 3: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.encodedKey);
                return;
            }
            case 4: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.heebee);
                return;
            }
            case 5: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.logisticsInfoBlock);
                return;
            }
            case 6: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.officeUse);
                return;
            }
            case 7: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.shelterInfoBlock);
                return;
            }
            case 8: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.vettingInfoBlock);
                return;
            }
        }
        throw new IllegalArgumentException(new StringBuffer("out of field index :").append(index).toString());
    }

    protected final void jdoCopyField(Profile obj, int index) {
        switch (index) {
            case 0: {
                this.commitee = obj.commitee;
                return;
            }
            case 1: {
                this.dietInfoBlock = obj.dietInfoBlock;
                return;
            }
            case 2: {
                this.email = obj.email;
                return;
            }
            case 3: {
                this.encodedKey = obj.encodedKey;
                return;
            }
            case 4: {
                this.heebee = obj.heebee;
                return;
            }
            case 5: {
                this.logisticsInfoBlock = obj.logisticsInfoBlock;
                return;
            }
            case 6: {
                this.officeUse = obj.officeUse;
                return;
            }
            case 7: {
                this.shelterInfoBlock = obj.shelterInfoBlock;
                return;
            }
            case 8: {
                this.vettingInfoBlock = obj.vettingInfoBlock;
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
        if (!(obj instanceof Profile)) {
            throw new IllegalArgumentException("object is not an object of type org.hbgb.webcamp.shared.Profile");
        }
        Profile other = (Profile)obj;
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
        return new String[]{"commitee", "dietInfoBlock", "email", "encodedKey", "heebee", "logisticsInfoBlock", "officeUse", "shelterInfoBlock", "vettingInfoBlock"};
    }

    private static final Class[] __jdoFieldTypesInit() {
        return new Class[]{Profile.___jdo$loadClass("org.hbgb.webcamp.shared.CommitteeInfoBlock"), Profile.___jdo$loadClass("org.hbgb.webcamp.shared.DietInfoBlock"), Profile.___jdo$loadClass("java.lang.String"), Profile.___jdo$loadClass("java.lang.String"), Profile.___jdo$loadClass("org.hbgb.webcamp.shared.HeeBee"), Profile.___jdo$loadClass("org.hbgb.webcamp.shared.LogisticsInfoBlock"), Profile.___jdo$loadClass("org.hbgb.webcamp.shared.OfficeUse"), Profile.___jdo$loadClass("org.hbgb.webcamp.shared.ShelterInfoBlock"), Profile.___jdo$loadClass("org.hbgb.webcamp.shared.VettingInfoBlock")};
    }

    private static final byte[] __jdoFieldFlagsInit() {
        return new byte[]{26, 26, 21, 24, 26, 26, 26, 26, 26};
    }

    protected static int __jdoGetInheritedFieldCount() {
        return 0;
    }

    protected static int jdoGetManagedFieldCount() {
        return 9;
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
        Profile o = (Profile)super.clone();
        o.jdoFlags = 0;
        o.jdoStateManager = null;
        return o;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        this.jdoPreSerialize();
        out.defaultWriteObject();
    }

    private static CommitteeInfoBlock jdoGetcommitee(Profile objPC) {
        if (objPC.jdoStateManager == null) return objPC.commitee;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 0)) return objPC.commitee;
        return (CommitteeInfoBlock)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 0, (Object)objPC.commitee);
    }

    private static void jdoSetcommitee(Profile objPC, CommitteeInfoBlock val) {
        if (objPC.jdoStateManager == null) {
            objPC.commitee = val;
            return;
        }
        objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 0, (Object)objPC.commitee, (Object)val);
    }

    private static DietInfoBlock jdoGetdietInfoBlock(Profile objPC) {
        if (objPC.jdoStateManager == null) return objPC.dietInfoBlock;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 1)) return objPC.dietInfoBlock;
        return (DietInfoBlock)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 1, (Object)objPC.dietInfoBlock);
    }

    private static void jdoSetdietInfoBlock(Profile objPC, DietInfoBlock val) {
        if (objPC.jdoStateManager == null) {
            objPC.dietInfoBlock = val;
            return;
        }
        objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 1, (Object)objPC.dietInfoBlock, (Object)val);
    }

    private static String jdoGetemail(Profile objPC) {
        if (objPC.jdoFlags <= 0) return objPC.email;
        if (objPC.jdoStateManager == null) return objPC.email;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 2)) return objPC.email;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 2, objPC.email);
    }

    private static void jdoSetemail(Profile objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 2, objPC.email, val);
            return;
        }
        objPC.email = val;
    }

    private static String jdoGetencodedKey(Profile objPC) {
        return objPC.encodedKey;
    }

    private static void jdoSetencodedKey(Profile objPC, String val) {
        if (objPC.jdoStateManager == null) {
            objPC.encodedKey = val;
            return;
        }
        objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 3, objPC.encodedKey, val);
    }

    private static HeeBee jdoGetheebee(Profile objPC) {
        if (objPC.jdoStateManager == null) return objPC.heebee;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 4)) return objPC.heebee;
        return (HeeBee)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 4, (Object)objPC.heebee);
    }

    private static void jdoSetheebee(Profile objPC, HeeBee val) {
        if (objPC.jdoStateManager == null) {
            objPC.heebee = val;
            return;
        }
        objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 4, (Object)objPC.heebee, (Object)val);
    }

    private static LogisticsInfoBlock jdoGetlogisticsInfoBlock(Profile objPC) {
        if (objPC.jdoStateManager == null) return objPC.logisticsInfoBlock;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 5)) return objPC.logisticsInfoBlock;
        return (LogisticsInfoBlock)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 5, (Object)objPC.logisticsInfoBlock);
    }

    private static void jdoSetlogisticsInfoBlock(Profile objPC, LogisticsInfoBlock val) {
        if (objPC.jdoStateManager == null) {
            objPC.logisticsInfoBlock = val;
            return;
        }
        objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 5, (Object)objPC.logisticsInfoBlock, (Object)val);
    }

    private static OfficeUse jdoGetofficeUse(Profile objPC) {
        if (objPC.jdoStateManager == null) return objPC.officeUse;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 6)) return objPC.officeUse;
        return (OfficeUse)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 6, (Object)objPC.officeUse);
    }

    private static void jdoSetofficeUse(Profile objPC, OfficeUse val) {
        if (objPC.jdoStateManager == null) {
            objPC.officeUse = val;
            return;
        }
        objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 6, (Object)objPC.officeUse, (Object)val);
    }

    private static ShelterInfoBlock jdoGetshelterInfoBlock(Profile objPC) {
        if (objPC.jdoStateManager == null) return objPC.shelterInfoBlock;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 7)) return objPC.shelterInfoBlock;
        return (ShelterInfoBlock)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 7, (Object)objPC.shelterInfoBlock);
    }

    private static void jdoSetshelterInfoBlock(Profile objPC, ShelterInfoBlock val) {
        if (objPC.jdoStateManager == null) {
            objPC.shelterInfoBlock = val;
            return;
        }
        objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 7, (Object)objPC.shelterInfoBlock, (Object)val);
    }

    private static VettingInfoBlock jdoGetvettingInfoBlock(Profile objPC) {
        if (objPC.jdoStateManager == null) return objPC.vettingInfoBlock;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 8)) return objPC.vettingInfoBlock;
        return (VettingInfoBlock)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 8, (Object)objPC.vettingInfoBlock);
    }

    private static void jdoSetvettingInfoBlock(Profile objPC, VettingInfoBlock val) {
        if (objPC.jdoStateManager == null) {
            objPC.vettingInfoBlock = val;
            return;
        }
        objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 8, (Object)objPC.vettingInfoBlock, (Object)val);
    }
}

