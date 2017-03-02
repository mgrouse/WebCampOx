/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.appengine.api.datastore.Text
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
public class HealerSheetInfoBlock
implements Serializable,
PersistenceCapable {
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
    @Persistent
    private String email = "";
    @Persistent
    private String sessionLength = "";
    @Persistent
    private String modality1 = "";
    @Persistent
    private String modality2 = "";
    @Persistent
    private String modality3 = "";
    @Persistent
    private String modality4 = "";
    @Persistent
    private Text bio = new Text("");
    protected transient StateManager jdoStateManager;
    protected transient byte jdoFlags;
    private static final byte[] jdoFieldFlags;
    private static final Class jdoPersistenceCapableSuperclass;
    private static final Class[] jdoFieldTypes;
    private static final String[] jdoFieldNames;
    private static final int jdoInheritedFieldCount;
    private static final long serialVersionUID = -5012197592698151104L;

    public String getEncodedKey() {
        return HealerSheetInfoBlock.jdoGetencodedKey(this);
    }

    public void setEncodedKey(String encodedKey) {
        HealerSheetInfoBlock.jdoSetencodedKey(this, encodedKey);
    }

    public String getEmail() {
        return HealerSheetInfoBlock.jdoGetemail(this);
    }

    public void setEmail(String email) {
        HealerSheetInfoBlock.jdoSetemail(this, email);
    }

    public String getModality1() {
        return HealerSheetInfoBlock.jdoGetmodality1(this);
    }

    public String getSessionLength() {
        return HealerSheetInfoBlock.jdoGetsessionLength(this);
    }

    public void setSessionLength(String sessionLength) {
        HealerSheetInfoBlock.jdoSetsessionLength(this, sessionLength);
    }

    public void setModality1(String modality1) {
        HealerSheetInfoBlock.jdoSetmodality1(this, modality1);
    }

    public String getModality2() {
        return HealerSheetInfoBlock.jdoGetmodality2(this);
    }

    public void setModality2(String modality2) {
        HealerSheetInfoBlock.jdoSetmodality2(this, modality2);
    }

    public String getModality3() {
        return HealerSheetInfoBlock.jdoGetmodality3(this);
    }

    public void setModality3(String modality3) {
        HealerSheetInfoBlock.jdoSetmodality3(this, modality3);
    }

    public String getModality4() {
        return HealerSheetInfoBlock.jdoGetmodality4(this);
    }

    public void setModality4(String modality4) {
        HealerSheetInfoBlock.jdoSetmodality4(this, modality4);
    }

    public String getBio() {
        return HealerSheetInfoBlock.jdoGetbio(this).getValue();
    }

    public void setBio(String bio) {
        HealerSheetInfoBlock.jdoSetbio(this, new Text(bio));
    }

    static {
        jdoFieldNames = HealerSheetInfoBlock.__jdoFieldNamesInit();
        jdoFieldTypes = HealerSheetInfoBlock.__jdoFieldTypesInit();
        jdoFieldFlags = HealerSheetInfoBlock.__jdoFieldFlagsInit();
        jdoInheritedFieldCount = HealerSheetInfoBlock.__jdoGetInheritedFieldCount();
        jdoPersistenceCapableSuperclass = HealerSheetInfoBlock.__jdoPersistenceCapableSuperclassInit();
        JDOImplHelper.registerClass((Class)HealerSheetInfoBlock.___jdo$loadClass("org.hbgb.webcamp.shared.HealerSheetInfoBlock"), (String[])jdoFieldNames, (Class[])jdoFieldTypes, (byte[])jdoFieldFlags, (Class)jdoPersistenceCapableSuperclass, (PersistenceCapable)new HealerSheetInfoBlock());
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
        HealerSheetInfoBlock result = new HealerSheetInfoBlock();
        result.jdoFlags = 1;
        result.jdoStateManager = sm;
        return result;
    }

    public PersistenceCapable jdoNewInstance(StateManager sm, Object obj) {
        HealerSheetInfoBlock result = new HealerSheetInfoBlock();
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
                this.bio = (Text)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
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
                this.modality1 = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 4: {
                this.modality2 = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 5: {
                this.modality3 = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 6: {
                this.modality4 = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 7: {
                this.sessionLength = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
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
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.bio);
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
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.modality1);
                return;
            }
            case 4: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.modality2);
                return;
            }
            case 5: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.modality3);
                return;
            }
            case 6: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.modality4);
                return;
            }
            case 7: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.sessionLength);
                return;
            }
        }
        throw new IllegalArgumentException(new StringBuffer("out of field index :").append(index).toString());
    }

    protected final void jdoCopyField(HealerSheetInfoBlock obj, int index) {
        switch (index) {
            case 0: {
                this.bio = obj.bio;
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
                this.modality1 = obj.modality1;
                return;
            }
            case 4: {
                this.modality2 = obj.modality2;
                return;
            }
            case 5: {
                this.modality3 = obj.modality3;
                return;
            }
            case 6: {
                this.modality4 = obj.modality4;
                return;
            }
            case 7: {
                this.sessionLength = obj.sessionLength;
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
        if (!(obj instanceof HealerSheetInfoBlock)) {
            throw new IllegalArgumentException("object is not an object of type org.hbgb.webcamp.shared.HealerSheetInfoBlock");
        }
        HealerSheetInfoBlock other = (HealerSheetInfoBlock)obj;
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
        return new String[]{"bio", "email", "encodedKey", "modality1", "modality2", "modality3", "modality4", "sessionLength"};
    }

    private static final Class[] __jdoFieldTypesInit() {
        return new Class[]{HealerSheetInfoBlock.___jdo$loadClass("com.google.appengine.api.datastore.Text"), HealerSheetInfoBlock.___jdo$loadClass("java.lang.String"), HealerSheetInfoBlock.___jdo$loadClass("java.lang.String"), HealerSheetInfoBlock.___jdo$loadClass("java.lang.String"), HealerSheetInfoBlock.___jdo$loadClass("java.lang.String"), HealerSheetInfoBlock.___jdo$loadClass("java.lang.String"), HealerSheetInfoBlock.___jdo$loadClass("java.lang.String"), HealerSheetInfoBlock.___jdo$loadClass("java.lang.String")};
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
        HealerSheetInfoBlock o = (HealerSheetInfoBlock)super.clone();
        o.jdoFlags = 0;
        o.jdoStateManager = null;
        return o;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        this.jdoPreSerialize();
        out.defaultWriteObject();
    }

    private static Text jdoGetbio(HealerSheetInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.bio;
        if (objPC.jdoStateManager == null) return objPC.bio;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 0)) return objPC.bio;
        return (Text)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 0, (Object)objPC.bio);
    }

    private static void jdoSetbio(HealerSheetInfoBlock objPC, Text val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 0, (Object)objPC.bio, (Object)val);
            return;
        }
        objPC.bio = val;
    }

    private static String jdoGetemail(HealerSheetInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.email;
        if (objPC.jdoStateManager == null) return objPC.email;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 1)) return objPC.email;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 1, objPC.email);
    }

    private static void jdoSetemail(HealerSheetInfoBlock objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 1, objPC.email, val);
            return;
        }
        objPC.email = val;
    }

    private static String jdoGetencodedKey(HealerSheetInfoBlock objPC) {
        return objPC.encodedKey;
    }

    private static void jdoSetencodedKey(HealerSheetInfoBlock objPC, String val) {
        if (objPC.jdoStateManager == null) {
            objPC.encodedKey = val;
            return;
        }
        objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 2, objPC.encodedKey, val);
    }

    private static String jdoGetmodality1(HealerSheetInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.modality1;
        if (objPC.jdoStateManager == null) return objPC.modality1;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 3)) return objPC.modality1;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 3, objPC.modality1);
    }

    private static void jdoSetmodality1(HealerSheetInfoBlock objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 3, objPC.modality1, val);
            return;
        }
        objPC.modality1 = val;
    }

    private static String jdoGetmodality2(HealerSheetInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.modality2;
        if (objPC.jdoStateManager == null) return objPC.modality2;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 4)) return objPC.modality2;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 4, objPC.modality2);
    }

    private static void jdoSetmodality2(HealerSheetInfoBlock objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 4, objPC.modality2, val);
            return;
        }
        objPC.modality2 = val;
    }

    private static String jdoGetmodality3(HealerSheetInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.modality3;
        if (objPC.jdoStateManager == null) return objPC.modality3;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 5)) return objPC.modality3;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 5, objPC.modality3);
    }

    private static void jdoSetmodality3(HealerSheetInfoBlock objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 5, objPC.modality3, val);
            return;
        }
        objPC.modality3 = val;
    }

    private static String jdoGetmodality4(HealerSheetInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.modality4;
        if (objPC.jdoStateManager == null) return objPC.modality4;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 6)) return objPC.modality4;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 6, objPC.modality4);
    }

    private static void jdoSetmodality4(HealerSheetInfoBlock objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 6, objPC.modality4, val);
            return;
        }
        objPC.modality4 = val;
    }

    private static String jdoGetsessionLength(HealerSheetInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.sessionLength;
        if (objPC.jdoStateManager == null) return objPC.sessionLength;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 7)) return objPC.sessionLength;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 7, objPC.sessionLength);
    }

    private static void jdoSetsessionLength(HealerSheetInfoBlock objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 7, objPC.sessionLength, val);
            return;
        }
        objPC.sessionLength = val;
    }
}

