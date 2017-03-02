/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.appengine.api.datastore.Text
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

import com.google.appengine.api.datastore.Text;
import com.google.gwt.user.client.rpc.IsSerializable;
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
public class CommitteeInfoBlock
implements Serializable,
IsSerializable,
PersistenceCapable {
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
    @Persistent
    private String email = "";
    @Persistent
    private Boolean isProfile = false;
    @Persistent
    private Committee committee1;
    @Persistent
    private Text reason1 = new Text("");
    @Persistent
    private Committee committee2;
    @Persistent
    private Text reason2 = new Text("");
    @Persistent
    private Committee assignedCommittee;
    @Persistent
    private Boolean isAssignedLead = false;
    protected transient StateManager jdoStateManager;
    protected transient byte jdoFlags;
    private static final byte[] jdoFieldFlags;
    private static final Class jdoPersistenceCapableSuperclass;
    private static final Class[] jdoFieldTypes;
    private static final String[] jdoFieldNames;
    private static final int jdoInheritedFieldCount;
    private static final long serialVersionUID = 6311816056942698830L;

    public CommitteeInfoBlock() {
    }

    public CommitteeInfoBlock(String emailText) {
        this.setEmail(emailText);
    }

    public CommitteeInfoBlock(String email, CommitteeInfoBlock source) {
        if (source != null) {
            this.setEmail(source.getEmail());
            this.setIsProfile(source.getIsProfile());
            this.setCommittee1(source.getCommittee1());
            this.setReason1(source.getReason1());
            this.setCommittee2(source.getCommittee2());
            this.setReason2(source.getReason2());
            return;
        }
        this.setEmail(email);
    }

    public String getEncodedKey() {
        return CommitteeInfoBlock.jdoGetencodedKey(this);
    }

    public void setEncodedKey(String encodedKey) {
        CommitteeInfoBlock.jdoSetencodedKey(this, encodedKey);
    }

    public String getEmail() {
        return CommitteeInfoBlock.jdoGetemail(this);
    }

    public void setEmail(String email) {
        CommitteeInfoBlock.jdoSetemail(this, email);
    }

    public Boolean getIsProfile() {
        return CommitteeInfoBlock.jdoGetisProfile(this);
    }

    public void setIsProfile(Boolean isProfile) {
        CommitteeInfoBlock.jdoSetisProfile(this, isProfile);
    }

    public Committee getCommittee1() {
        return CommitteeInfoBlock.jdoGetcommittee1(this);
    }

    public void setCommittee1(Committee committee1) {
        CommitteeInfoBlock.jdoSetcommittee1(this, committee1);
    }

    public String getReason1() {
        return CommitteeInfoBlock.jdoGetreason1(this).getValue();
    }

    public void setReason1(String reason1) {
        CommitteeInfoBlock.jdoSetreason1(this, new Text(reason1));
    }

    public Committee getCommittee2() {
        return CommitteeInfoBlock.jdoGetcommittee2(this);
    }

    public void setCommittee2(Committee committee2) {
        CommitteeInfoBlock.jdoSetcommittee2(this, committee2);
    }

    public String getReason2() {
        return CommitteeInfoBlock.jdoGetreason2(this).getValue();
    }

    public void setReason2(String reason2) {
        CommitteeInfoBlock.jdoSetreason2(this, new Text(reason2));
    }

    public Committee getAssignedCommittee() {
        return CommitteeInfoBlock.jdoGetassignedCommittee(this);
    }

    public void setAssignedCommittee(Committee assignedCommittee) {
        CommitteeInfoBlock.jdoSetassignedCommittee(this, assignedCommittee);
    }

    public Boolean getIsAssignedLead() {
        return CommitteeInfoBlock.jdoGetisAssignedLead(this);
    }

    public void setIsAssignedLead(Boolean isAssignedLead) {
        CommitteeInfoBlock.jdoSetisAssignedLead(this, isAssignedLead);
    }

    static {
        jdoFieldNames = CommitteeInfoBlock.__jdoFieldNamesInit();
        jdoFieldTypes = CommitteeInfoBlock.__jdoFieldTypesInit();
        jdoFieldFlags = CommitteeInfoBlock.__jdoFieldFlagsInit();
        jdoInheritedFieldCount = CommitteeInfoBlock.__jdoGetInheritedFieldCount();
        jdoPersistenceCapableSuperclass = CommitteeInfoBlock.__jdoPersistenceCapableSuperclassInit();
        JDOImplHelper.registerClass((Class)CommitteeInfoBlock.___jdo$loadClass("org.hbgb.webcamp.shared.CommitteeInfoBlock"), (String[])jdoFieldNames, (Class[])jdoFieldTypes, (byte[])jdoFieldFlags, (Class)jdoPersistenceCapableSuperclass, (PersistenceCapable)new CommitteeInfoBlock());
    }

    public void jdoCopyKeyFieldsFromObjectId(PersistenceCapable.ObjectIdFieldConsumer fc, Object oid) {
        if (fc == null) {
            throw new IllegalArgumentException("ObjectIdFieldConsumer is null");
        }
        if (!(oid instanceof StringIdentity)) {
            throw new ClassCastException("oid is not instanceof javax.jdo.identity.StringIdentity");
        }
        StringIdentity o = (StringIdentity)oid;
        fc.storeStringField(4, o.getKey());
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
        CommitteeInfoBlock result = new CommitteeInfoBlock();
        result.jdoFlags = 1;
        result.jdoStateManager = sm;
        return result;
    }

    public PersistenceCapable jdoNewInstance(StateManager sm, Object obj) {
        CommitteeInfoBlock result = new CommitteeInfoBlock();
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
                this.assignedCommittee = (Committee)((Object)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index));
                return;
            }
            case 1: {
                this.committee1 = (Committee)((Object)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index));
                return;
            }
            case 2: {
                this.committee2 = (Committee)((Object)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index));
                return;
            }
            case 3: {
                this.email = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 4: {
                this.encodedKey = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 5: {
                this.isAssignedLead = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 6: {
                this.isProfile = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 7: {
                this.reason1 = (Text)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 8: {
                this.reason2 = (Text)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
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
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.assignedCommittee);
                return;
            }
            case 1: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.committee1);
                return;
            }
            case 2: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.committee2);
                return;
            }
            case 3: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.email);
                return;
            }
            case 4: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.encodedKey);
                return;
            }
            case 5: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.isAssignedLead);
                return;
            }
            case 6: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.isProfile);
                return;
            }
            case 7: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.reason1);
                return;
            }
            case 8: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.reason2);
                return;
            }
        }
        throw new IllegalArgumentException(new StringBuffer("out of field index :").append(index).toString());
    }

    protected final void jdoCopyField(CommitteeInfoBlock obj, int index) {
        switch (index) {
            case 0: {
                this.assignedCommittee = obj.assignedCommittee;
                return;
            }
            case 1: {
                this.committee1 = obj.committee1;
                return;
            }
            case 2: {
                this.committee2 = obj.committee2;
                return;
            }
            case 3: {
                this.email = obj.email;
                return;
            }
            case 4: {
                this.encodedKey = obj.encodedKey;
                return;
            }
            case 5: {
                this.isAssignedLead = obj.isAssignedLead;
                return;
            }
            case 6: {
                this.isProfile = obj.isProfile;
                return;
            }
            case 7: {
                this.reason1 = obj.reason1;
                return;
            }
            case 8: {
                this.reason2 = obj.reason2;
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
        if (!(obj instanceof CommitteeInfoBlock)) {
            throw new IllegalArgumentException("object is not an object of type org.hbgb.webcamp.shared.CommitteeInfoBlock");
        }
        CommitteeInfoBlock other = (CommitteeInfoBlock)obj;
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
        return new String[]{"assignedCommittee", "committee1", "committee2", "email", "encodedKey", "isAssignedLead", "isProfile", "reason1", "reason2"};
    }

    private static final Class[] __jdoFieldTypesInit() {
        return new Class[]{CommitteeInfoBlock.___jdo$loadClass("org.hbgb.webcamp.shared.enums.Committee"), CommitteeInfoBlock.___jdo$loadClass("org.hbgb.webcamp.shared.enums.Committee"), CommitteeInfoBlock.___jdo$loadClass("org.hbgb.webcamp.shared.enums.Committee"), CommitteeInfoBlock.___jdo$loadClass("java.lang.String"), CommitteeInfoBlock.___jdo$loadClass("java.lang.String"), CommitteeInfoBlock.___jdo$loadClass("java.lang.Boolean"), CommitteeInfoBlock.___jdo$loadClass("java.lang.Boolean"), CommitteeInfoBlock.___jdo$loadClass("com.google.appengine.api.datastore.Text"), CommitteeInfoBlock.___jdo$loadClass("com.google.appengine.api.datastore.Text")};
    }

    private static final byte[] __jdoFieldFlagsInit() {
        return new byte[]{21, 21, 21, 21, 24, 21, 21, 21, 21};
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
        CommitteeInfoBlock o = (CommitteeInfoBlock)super.clone();
        o.jdoFlags = 0;
        o.jdoStateManager = null;
        return o;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        this.jdoPreSerialize();
        out.defaultWriteObject();
    }

    private static Committee jdoGetassignedCommittee(CommitteeInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.assignedCommittee;
        if (objPC.jdoStateManager == null) return objPC.assignedCommittee;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 0)) return objPC.assignedCommittee;
        return (Committee)((Object)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 0, (Object)objPC.assignedCommittee));
    }

    private static void jdoSetassignedCommittee(CommitteeInfoBlock objPC, Committee val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 0, (Object)objPC.assignedCommittee, (Object)val);
            return;
        }
        objPC.assignedCommittee = val;
    }

    private static Committee jdoGetcommittee1(CommitteeInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.committee1;
        if (objPC.jdoStateManager == null) return objPC.committee1;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 1)) return objPC.committee1;
        return (Committee)((Object)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 1, (Object)objPC.committee1));
    }

    private static void jdoSetcommittee1(CommitteeInfoBlock objPC, Committee val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 1, (Object)objPC.committee1, (Object)val);
            return;
        }
        objPC.committee1 = val;
    }

    private static Committee jdoGetcommittee2(CommitteeInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.committee2;
        if (objPC.jdoStateManager == null) return objPC.committee2;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 2)) return objPC.committee2;
        return (Committee)((Object)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 2, (Object)objPC.committee2));
    }

    private static void jdoSetcommittee2(CommitteeInfoBlock objPC, Committee val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 2, (Object)objPC.committee2, (Object)val);
            return;
        }
        objPC.committee2 = val;
    }

    private static String jdoGetemail(CommitteeInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.email;
        if (objPC.jdoStateManager == null) return objPC.email;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 3)) return objPC.email;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 3, objPC.email);
    }

    private static void jdoSetemail(CommitteeInfoBlock objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 3, objPC.email, val);
            return;
        }
        objPC.email = val;
    }

    private static String jdoGetencodedKey(CommitteeInfoBlock objPC) {
        return objPC.encodedKey;
    }

    private static void jdoSetencodedKey(CommitteeInfoBlock objPC, String val) {
        if (objPC.jdoStateManager == null) {
            objPC.encodedKey = val;
            return;
        }
        objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 4, objPC.encodedKey, val);
    }

    private static Boolean jdoGetisAssignedLead(CommitteeInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.isAssignedLead;
        if (objPC.jdoStateManager == null) return objPC.isAssignedLead;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 5)) return objPC.isAssignedLead;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 5, (Object)objPC.isAssignedLead);
    }

    private static void jdoSetisAssignedLead(CommitteeInfoBlock objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 5, (Object)objPC.isAssignedLead, (Object)val);
            return;
        }
        objPC.isAssignedLead = val;
    }

    private static Boolean jdoGetisProfile(CommitteeInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.isProfile;
        if (objPC.jdoStateManager == null) return objPC.isProfile;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 6)) return objPC.isProfile;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 6, (Object)objPC.isProfile);
    }

    private static void jdoSetisProfile(CommitteeInfoBlock objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 6, (Object)objPC.isProfile, (Object)val);
            return;
        }
        objPC.isProfile = val;
    }

    private static Text jdoGetreason1(CommitteeInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.reason1;
        if (objPC.jdoStateManager == null) return objPC.reason1;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 7)) return objPC.reason1;
        return (Text)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 7, (Object)objPC.reason1);
    }

    private static void jdoSetreason1(CommitteeInfoBlock objPC, Text val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 7, (Object)objPC.reason1, (Object)val);
            return;
        }
        objPC.reason1 = val;
    }

    private static Text jdoGetreason2(CommitteeInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.reason2;
        if (objPC.jdoStateManager == null) return objPC.reason2;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 8)) return objPC.reason2;
        return (Text)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 8, (Object)objPC.reason2);
    }

    private static void jdoSetreason2(CommitteeInfoBlock objPC, Text val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 8, (Object)objPC.reason2, (Object)val);
            return;
        }
        objPC.reason2 = val;
    }
}

