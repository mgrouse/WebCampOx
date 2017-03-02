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

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.APPLICATION)
public class ShelterInfoBlock
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
    private Boolean isBringingRv = false;
    @Persistent
    private String rvInfo = "";
    @Persistent
    private Boolean isInDormTent = false;
    @Persistent
    private Boolean hasStructure = false;
    @Persistent
    private Text structureInfo = new Text("");
    protected transient StateManager jdoStateManager;
    protected transient byte jdoFlags;
    private static final byte[] jdoFieldFlags;
    private static final Class jdoPersistenceCapableSuperclass;
    private static final Class[] jdoFieldTypes;
    private static final String[] jdoFieldNames;
    private static final int jdoInheritedFieldCount;
    private static final long serialVersionUID = -29999244622039879L;

    public ShelterInfoBlock() {
    }

    public ShelterInfoBlock(String emailText) {
        this.setEmail(emailText);
    }

    public ShelterInfoBlock(String email, ShelterInfoBlock source) {
        if (source != null) {
            this.setEmail(source.getEmail());
            this.setIsProfile(source.getIsProfile());
            this.setIsBringingRv(source.getIsBringingRv());
            this.setRvInfo(source.getRvInfo());
            this.setIsInDormTent(source.getIsInDormTent());
            this.setHasStructure(source.getHasStructure());
            this.setStructureInfo(source.getStructureInfo());
            return;
        }
        this.setEmail(email);
    }

    public String getEncodedKey() {
        return ShelterInfoBlock.jdoGetencodedKey(this);
    }

    public void setEncodedKey(String encodedKey) {
        ShelterInfoBlock.jdoSetencodedKey(this, encodedKey);
    }

    public String getEmail() {
        return ShelterInfoBlock.jdoGetemail(this);
    }

    public void setEmail(String email) {
        ShelterInfoBlock.jdoSetemail(this, email);
    }

    public Boolean getIsProfile() {
        return ShelterInfoBlock.jdoGetisProfile(this);
    }

    public void setIsProfile(Boolean isProfile) {
        ShelterInfoBlock.jdoSetisProfile(this, isProfile);
    }

    public Boolean getIsBringingRv() {
        return ShelterInfoBlock.jdoGetisBringingRv(this);
    }

    public void setIsBringingRv(Boolean isBringingRv) {
        ShelterInfoBlock.jdoSetisBringingRv(this, isBringingRv);
    }

    public String getRvInfo() {
        return ShelterInfoBlock.jdoGetrvInfo(this);
    }

    public void setRvInfo(String rvInfo) {
        ShelterInfoBlock.jdoSetrvInfo(this, rvInfo);
    }

    public Boolean getIsInDormTent() {
        return ShelterInfoBlock.jdoGetisInDormTent(this);
    }

    public void setIsInDormTent(Boolean isInDormTent) {
        ShelterInfoBlock.jdoSetisInDormTent(this, isInDormTent);
    }

    public String getStructureInfo() {
        return ShelterInfoBlock.jdoGetstructureInfo(this).getValue();
    }

    public void setStructureInfo(String structureInfo) {
        ShelterInfoBlock.jdoSetstructureInfo(this, new Text(structureInfo));
    }

    public Boolean getHasStructure() {
        return ShelterInfoBlock.jdoGethasStructure(this);
    }

    public void setHasStructure(Boolean hasStructure) {
        ShelterInfoBlock.jdoSethasStructure(this, hasStructure);
    }

    static {
        jdoFieldNames = ShelterInfoBlock.__jdoFieldNamesInit();
        jdoFieldTypes = ShelterInfoBlock.__jdoFieldTypesInit();
        jdoFieldFlags = ShelterInfoBlock.__jdoFieldFlagsInit();
        jdoInheritedFieldCount = ShelterInfoBlock.__jdoGetInheritedFieldCount();
        jdoPersistenceCapableSuperclass = ShelterInfoBlock.__jdoPersistenceCapableSuperclassInit();
        JDOImplHelper.registerClass((Class)ShelterInfoBlock.___jdo$loadClass("org.hbgb.webcamp.shared.ShelterInfoBlock"), (String[])jdoFieldNames, (Class[])jdoFieldTypes, (byte[])jdoFieldFlags, (Class)jdoPersistenceCapableSuperclass, (PersistenceCapable)new ShelterInfoBlock());
    }

    public void jdoCopyKeyFieldsFromObjectId(PersistenceCapable.ObjectIdFieldConsumer fc, Object oid) {
        if (fc == null) {
            throw new IllegalArgumentException("ObjectIdFieldConsumer is null");
        }
        if (!(oid instanceof StringIdentity)) {
            throw new ClassCastException("oid is not instanceof javax.jdo.identity.StringIdentity");
        }
        StringIdentity o = (StringIdentity)oid;
        fc.storeStringField(1, o.getKey());
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
        ShelterInfoBlock result = new ShelterInfoBlock();
        result.jdoFlags = 1;
        result.jdoStateManager = sm;
        return result;
    }

    public PersistenceCapable jdoNewInstance(StateManager sm, Object obj) {
        ShelterInfoBlock result = new ShelterInfoBlock();
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
                this.email = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 1: {
                this.encodedKey = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 2: {
                this.hasStructure = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 3: {
                this.isBringingRv = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 4: {
                this.isInDormTent = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 5: {
                this.isProfile = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 6: {
                this.rvInfo = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 7: {
                this.structureInfo = (Text)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
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
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.email);
                return;
            }
            case 1: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.encodedKey);
                return;
            }
            case 2: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.hasStructure);
                return;
            }
            case 3: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.isBringingRv);
                return;
            }
            case 4: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.isInDormTent);
                return;
            }
            case 5: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.isProfile);
                return;
            }
            case 6: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.rvInfo);
                return;
            }
            case 7: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.structureInfo);
                return;
            }
        }
        throw new IllegalArgumentException(new StringBuffer("out of field index :").append(index).toString());
    }

    protected final void jdoCopyField(ShelterInfoBlock obj, int index) {
        switch (index) {
            case 0: {
                this.email = obj.email;
                return;
            }
            case 1: {
                this.encodedKey = obj.encodedKey;
                return;
            }
            case 2: {
                this.hasStructure = obj.hasStructure;
                return;
            }
            case 3: {
                this.isBringingRv = obj.isBringingRv;
                return;
            }
            case 4: {
                this.isInDormTent = obj.isInDormTent;
                return;
            }
            case 5: {
                this.isProfile = obj.isProfile;
                return;
            }
            case 6: {
                this.rvInfo = obj.rvInfo;
                return;
            }
            case 7: {
                this.structureInfo = obj.structureInfo;
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
        if (!(obj instanceof ShelterInfoBlock)) {
            throw new IllegalArgumentException("object is not an object of type org.hbgb.webcamp.shared.ShelterInfoBlock");
        }
        ShelterInfoBlock other = (ShelterInfoBlock)obj;
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
        return new String[]{"email", "encodedKey", "hasStructure", "isBringingRv", "isInDormTent", "isProfile", "rvInfo", "structureInfo"};
    }

    private static final Class[] __jdoFieldTypesInit() {
        return new Class[]{ShelterInfoBlock.___jdo$loadClass("java.lang.String"), ShelterInfoBlock.___jdo$loadClass("java.lang.String"), ShelterInfoBlock.___jdo$loadClass("java.lang.Boolean"), ShelterInfoBlock.___jdo$loadClass("java.lang.Boolean"), ShelterInfoBlock.___jdo$loadClass("java.lang.Boolean"), ShelterInfoBlock.___jdo$loadClass("java.lang.Boolean"), ShelterInfoBlock.___jdo$loadClass("java.lang.String"), ShelterInfoBlock.___jdo$loadClass("com.google.appengine.api.datastore.Text")};
    }

    private static final byte[] __jdoFieldFlagsInit() {
        return new byte[]{21, 24, 21, 21, 21, 21, 21, 21};
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
        ShelterInfoBlock o = (ShelterInfoBlock)super.clone();
        o.jdoFlags = 0;
        o.jdoStateManager = null;
        return o;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        this.jdoPreSerialize();
        out.defaultWriteObject();
    }

    private static String jdoGetemail(ShelterInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.email;
        if (objPC.jdoStateManager == null) return objPC.email;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 0)) return objPC.email;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 0, objPC.email);
    }

    private static void jdoSetemail(ShelterInfoBlock objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 0, objPC.email, val);
            return;
        }
        objPC.email = val;
    }

    private static String jdoGetencodedKey(ShelterInfoBlock objPC) {
        return objPC.encodedKey;
    }

    private static void jdoSetencodedKey(ShelterInfoBlock objPC, String val) {
        if (objPC.jdoStateManager == null) {
            objPC.encodedKey = val;
            return;
        }
        objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 1, objPC.encodedKey, val);
    }

    private static Boolean jdoGethasStructure(ShelterInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.hasStructure;
        if (objPC.jdoStateManager == null) return objPC.hasStructure;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 2)) return objPC.hasStructure;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 2, (Object)objPC.hasStructure);
    }

    private static void jdoSethasStructure(ShelterInfoBlock objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 2, (Object)objPC.hasStructure, (Object)val);
            return;
        }
        objPC.hasStructure = val;
    }

    private static Boolean jdoGetisBringingRv(ShelterInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.isBringingRv;
        if (objPC.jdoStateManager == null) return objPC.isBringingRv;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 3)) return objPC.isBringingRv;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 3, (Object)objPC.isBringingRv);
    }

    private static void jdoSetisBringingRv(ShelterInfoBlock objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 3, (Object)objPC.isBringingRv, (Object)val);
            return;
        }
        objPC.isBringingRv = val;
    }

    private static Boolean jdoGetisInDormTent(ShelterInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.isInDormTent;
        if (objPC.jdoStateManager == null) return objPC.isInDormTent;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 4)) return objPC.isInDormTent;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 4, (Object)objPC.isInDormTent);
    }

    private static void jdoSetisInDormTent(ShelterInfoBlock objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 4, (Object)objPC.isInDormTent, (Object)val);
            return;
        }
        objPC.isInDormTent = val;
    }

    private static Boolean jdoGetisProfile(ShelterInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.isProfile;
        if (objPC.jdoStateManager == null) return objPC.isProfile;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 5)) return objPC.isProfile;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 5, (Object)objPC.isProfile);
    }

    private static void jdoSetisProfile(ShelterInfoBlock objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 5, (Object)objPC.isProfile, (Object)val);
            return;
        }
        objPC.isProfile = val;
    }

    private static String jdoGetrvInfo(ShelterInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.rvInfo;
        if (objPC.jdoStateManager == null) return objPC.rvInfo;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 6)) return objPC.rvInfo;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 6, objPC.rvInfo);
    }

    private static void jdoSetrvInfo(ShelterInfoBlock objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 6, objPC.rvInfo, val);
            return;
        }
        objPC.rvInfo = val;
    }

    private static Text jdoGetstructureInfo(ShelterInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.structureInfo;
        if (objPC.jdoStateManager == null) return objPC.structureInfo;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 7)) return objPC.structureInfo;
        return (Text)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 7, (Object)objPC.structureInfo);
    }

    private static void jdoSetstructureInfo(ShelterInfoBlock objPC, Text val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 7, (Object)objPC.structureInfo, (Object)val);
            return;
        }
        objPC.structureInfo = val;
    }
}

