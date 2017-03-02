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
import org.hbgb.webcamp.shared.enums.Committee;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.APPLICATION)
public class HeeBeeHistoryRecord
implements Serializable,
PersistenceCapable {
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
    @Persistent
    private String email;
    @Persistent
    private Integer year;
    @Persistent
    private Committee committee;
    @Persistent
    private Boolean wasGoodOnCommittee;
    @Persistent
    private Boolean wasEarlyTeam;
    @Persistent
    private Boolean wasStrikeTeam;
    @Persistent
    private String notes;
    protected transient StateManager jdoStateManager;
    protected transient byte jdoFlags;
    private static final byte[] jdoFieldFlags;
    private static final Class jdoPersistenceCapableSuperclass;
    private static final Class[] jdoFieldTypes;
    private static final String[] jdoFieldNames;
    private static final int jdoInheritedFieldCount;
    private static final long serialVersionUID = -733379979366992563L;

    static {
        jdoFieldNames = HeeBeeHistoryRecord.__jdoFieldNamesInit();
        jdoFieldTypes = HeeBeeHistoryRecord.__jdoFieldTypesInit();
        jdoFieldFlags = HeeBeeHistoryRecord.__jdoFieldFlagsInit();
        jdoInheritedFieldCount = HeeBeeHistoryRecord.__jdoGetInheritedFieldCount();
        jdoPersistenceCapableSuperclass = HeeBeeHistoryRecord.__jdoPersistenceCapableSuperclassInit();
        JDOImplHelper.registerClass((Class)HeeBeeHistoryRecord.___jdo$loadClass("org.hbgb.webcamp.shared.HeeBeeHistoryRecord"), (String[])jdoFieldNames, (Class[])jdoFieldTypes, (byte[])jdoFieldFlags, (Class)jdoPersistenceCapableSuperclass, (PersistenceCapable)new HeeBeeHistoryRecord());
    }

    public void jdoCopyKeyFieldsFromObjectId(PersistenceCapable.ObjectIdFieldConsumer fc, Object oid) {
        if (fc == null) {
            throw new IllegalArgumentException("ObjectIdFieldConsumer is null");
        }
        if (!(oid instanceof StringIdentity)) {
            throw new ClassCastException("oid is not instanceof javax.jdo.identity.StringIdentity");
        }
        StringIdentity o = (StringIdentity)oid;
        fc.storeStringField(2, o.getKey());
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
        HeeBeeHistoryRecord result = new HeeBeeHistoryRecord();
        result.jdoFlags = 1;
        result.jdoStateManager = sm;
        return result;
    }

    public PersistenceCapable jdoNewInstance(StateManager sm, Object obj) {
        HeeBeeHistoryRecord result = new HeeBeeHistoryRecord();
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
                this.committee = (Committee)((Object)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index));
                return;
            }
            case 1: {
                this.email = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 2: {
                this.encodedKey = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 3: {
                this.notes = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 4: {
                this.wasEarlyTeam = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 5: {
                this.wasGoodOnCommittee = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 6: {
                this.wasStrikeTeam = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 7: {
                this.year = (Integer)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
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
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.committee);
                return;
            }
            case 1: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.email);
                return;
            }
            case 2: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.encodedKey);
                return;
            }
            case 3: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.notes);
                return;
            }
            case 4: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.wasEarlyTeam);
                return;
            }
            case 5: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.wasGoodOnCommittee);
                return;
            }
            case 6: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.wasStrikeTeam);
                return;
            }
            case 7: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.year);
                return;
            }
        }
        throw new IllegalArgumentException(new StringBuffer("out of field index :").append(index).toString());
    }

    protected final void jdoCopyField(HeeBeeHistoryRecord obj, int index) {
        switch (index) {
            case 0: {
                this.committee = obj.committee;
                return;
            }
            case 1: {
                this.email = obj.email;
                return;
            }
            case 2: {
                this.encodedKey = obj.encodedKey;
                return;
            }
            case 3: {
                this.notes = obj.notes;
                return;
            }
            case 4: {
                this.wasEarlyTeam = obj.wasEarlyTeam;
                return;
            }
            case 5: {
                this.wasGoodOnCommittee = obj.wasGoodOnCommittee;
                return;
            }
            case 6: {
                this.wasStrikeTeam = obj.wasStrikeTeam;
                return;
            }
            case 7: {
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
        if (!(obj instanceof HeeBeeHistoryRecord)) {
            throw new IllegalArgumentException("object is not an object of type org.hbgb.webcamp.shared.HeeBeeHistoryRecord");
        }
        HeeBeeHistoryRecord other = (HeeBeeHistoryRecord)obj;
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
        return new String[]{"committee", "email", "encodedKey", "notes", "wasEarlyTeam", "wasGoodOnCommittee", "wasStrikeTeam", "year"};
    }

    private static final Class[] __jdoFieldTypesInit() {
        return new Class[]{HeeBeeHistoryRecord.___jdo$loadClass("org.hbgb.webcamp.shared.enums.Committee"), HeeBeeHistoryRecord.___jdo$loadClass("java.lang.String"), HeeBeeHistoryRecord.___jdo$loadClass("java.lang.String"), HeeBeeHistoryRecord.___jdo$loadClass("java.lang.String"), HeeBeeHistoryRecord.___jdo$loadClass("java.lang.Boolean"), HeeBeeHistoryRecord.___jdo$loadClass("java.lang.Boolean"), HeeBeeHistoryRecord.___jdo$loadClass("java.lang.Boolean"), HeeBeeHistoryRecord.___jdo$loadClass("java.lang.Integer")};
    }

    private static final byte[] __jdoFieldFlagsInit() {
        return new byte[]{21, 21, 24, 21, 21, 21, 21, 21};
    }

    protected static int __jdoGetInheritedFieldCount() {
        return 0;
    }

    protected static int jdoGetManagedFieldCount() {
        return 8;
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
        HeeBeeHistoryRecord o = (HeeBeeHistoryRecord)super.clone();
        o.jdoFlags = 0;
        o.jdoStateManager = null;
        return o;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        this.jdoPreSerialize();
        out.defaultWriteObject();
    }

    private static Committee jdoGetcommittee(HeeBeeHistoryRecord objPC) {
        if (objPC.jdoFlags <= 0) return objPC.committee;
        if (objPC.jdoStateManager == null) return objPC.committee;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 0)) return objPC.committee;
        return (Committee)((Object)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 0, (Object)objPC.committee));
    }

    private static void jdoSetcommittee(HeeBeeHistoryRecord objPC, Committee val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 0, (Object)objPC.committee, (Object)val);
            return;
        }
        objPC.committee = val;
    }

    private static String jdoGetemail(HeeBeeHistoryRecord objPC) {
        if (objPC.jdoFlags <= 0) return objPC.email;
        if (objPC.jdoStateManager == null) return objPC.email;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 1)) return objPC.email;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 1, objPC.email);
    }

    private static void jdoSetemail(HeeBeeHistoryRecord objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 1, objPC.email, val);
            return;
        }
        objPC.email = val;
    }

    private static String jdoGetencodedKey(HeeBeeHistoryRecord objPC) {
        return objPC.encodedKey;
    }

    private static void jdoSetencodedKey(HeeBeeHistoryRecord objPC, String val) {
        if (objPC.jdoStateManager == null) {
            objPC.encodedKey = val;
            return;
        }
        objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 2, objPC.encodedKey, val);
    }

    private static String jdoGetnotes(HeeBeeHistoryRecord objPC) {
        if (objPC.jdoFlags <= 0) return objPC.notes;
        if (objPC.jdoStateManager == null) return objPC.notes;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 3)) return objPC.notes;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 3, objPC.notes);
    }

    private static void jdoSetnotes(HeeBeeHistoryRecord objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 3, objPC.notes, val);
            return;
        }
        objPC.notes = val;
    }

    private static Boolean jdoGetwasEarlyTeam(HeeBeeHistoryRecord objPC) {
        if (objPC.jdoFlags <= 0) return objPC.wasEarlyTeam;
        if (objPC.jdoStateManager == null) return objPC.wasEarlyTeam;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 4)) return objPC.wasEarlyTeam;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 4, (Object)objPC.wasEarlyTeam);
    }

    private static void jdoSetwasEarlyTeam(HeeBeeHistoryRecord objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 4, (Object)objPC.wasEarlyTeam, (Object)val);
            return;
        }
        objPC.wasEarlyTeam = val;
    }

    private static Boolean jdoGetwasGoodOnCommittee(HeeBeeHistoryRecord objPC) {
        if (objPC.jdoFlags <= 0) return objPC.wasGoodOnCommittee;
        if (objPC.jdoStateManager == null) return objPC.wasGoodOnCommittee;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 5)) return objPC.wasGoodOnCommittee;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 5, (Object)objPC.wasGoodOnCommittee);
    }

    private static void jdoSetwasGoodOnCommittee(HeeBeeHistoryRecord objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 5, (Object)objPC.wasGoodOnCommittee, (Object)val);
            return;
        }
        objPC.wasGoodOnCommittee = val;
    }

    private static Boolean jdoGetwasStrikeTeam(HeeBeeHistoryRecord objPC) {
        if (objPC.jdoFlags <= 0) return objPC.wasStrikeTeam;
        if (objPC.jdoStateManager == null) return objPC.wasStrikeTeam;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 6)) return objPC.wasStrikeTeam;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 6, (Object)objPC.wasStrikeTeam);
    }

    private static void jdoSetwasStrikeTeam(HeeBeeHistoryRecord objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 6, (Object)objPC.wasStrikeTeam, (Object)val);
            return;
        }
        objPC.wasStrikeTeam = val;
    }

    private static Integer jdoGetyear(HeeBeeHistoryRecord objPC) {
        if (objPC.jdoFlags <= 0) return objPC.year;
        if (objPC.jdoStateManager == null) return objPC.year;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 7)) return objPC.year;
        return (Integer)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 7, (Object)objPC.year);
    }

    private static void jdoSetyear(HeeBeeHistoryRecord objPC, Integer val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 7, (Object)objPC.year, (Object)val);
            return;
        }
        objPC.year = val;
    }
}

