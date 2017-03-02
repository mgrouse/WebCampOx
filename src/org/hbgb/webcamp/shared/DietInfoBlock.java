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
import org.hbgb.webcamp.shared.enums.DietType;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.APPLICATION)
public class DietInfoBlock
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
    private DietType dietType;
    @Persistent
    private Boolean isGlutenFree = false;
    @Persistent
    private Text dietaryRestrictions = new Text("");
    protected transient StateManager jdoStateManager;
    protected transient byte jdoFlags;
    private static final byte[] jdoFieldFlags;
    private static final Class jdoPersistenceCapableSuperclass;
    private static final Class[] jdoFieldTypes;
    private static final String[] jdoFieldNames;
    private static final int jdoInheritedFieldCount;
    private static final long serialVersionUID = -3856788466305014719L;

    public DietInfoBlock() {
    }

    public DietInfoBlock(String emailText) {
        this.setEmail(emailText);
    }

    public DietInfoBlock(String Email, DietInfoBlock source) {
        if (source != null) {
            this.setEmail(source.getEmail());
            this.setIsProfile(source.getIsProfile());
            this.setDietType(source.getDietType());
            this.setIsGlutenFree(source.isGlutenFree);
            this.setDietaryRestrictions(source.getDietaryRestrictions());
            return;
        }
        this.setEmail(this.email);
    }

    public String getEncodedKey() {
        return DietInfoBlock.jdoGetencodedKey(this);
    }

    public void setEncodedKey(String encodedKey) {
        DietInfoBlock.jdoSetencodedKey(this, encodedKey);
    }

    public String getEmail() {
        return DietInfoBlock.jdoGetemail(this);
    }

    public void setEmail(String email) {
        DietInfoBlock.jdoSetemail(this, email);
    }

    public Boolean getIsProfile() {
        return DietInfoBlock.jdoGetisProfile(this);
    }

    public void setIsProfile(Boolean isProfile) {
        DietInfoBlock.jdoSetisProfile(this, isProfile);
    }

    public DietType getDietType() {
        return DietInfoBlock.jdoGetdietType(this);
    }

    public void setDietType(DietType dietType) {
        DietInfoBlock.jdoSetdietType(this, dietType);
    }

    public Boolean getIsGlutenFree() {
        return DietInfoBlock.jdoGetisGlutenFree(this);
    }

    public void setIsGlutenFree(Boolean isGlutenFree) {
        DietInfoBlock.jdoSetisGlutenFree(this, isGlutenFree);
    }

    public String getDietaryRestrictions() {
        return DietInfoBlock.jdoGetdietaryRestrictions(this).getValue();
    }

    public void setDietaryRestrictions(String dietaryRestrictions) {
        DietInfoBlock.jdoSetdietaryRestrictions(this, new Text(dietaryRestrictions));
    }

    static {
        jdoFieldNames = DietInfoBlock.__jdoFieldNamesInit();
        jdoFieldTypes = DietInfoBlock.__jdoFieldTypesInit();
        jdoFieldFlags = DietInfoBlock.__jdoFieldFlagsInit();
        jdoInheritedFieldCount = DietInfoBlock.__jdoGetInheritedFieldCount();
        jdoPersistenceCapableSuperclass = DietInfoBlock.__jdoPersistenceCapableSuperclassInit();
        JDOImplHelper.registerClass((Class)DietInfoBlock.___jdo$loadClass("org.hbgb.webcamp.shared.DietInfoBlock"), (String[])jdoFieldNames, (Class[])jdoFieldTypes, (byte[])jdoFieldFlags, (Class)jdoPersistenceCapableSuperclass, (PersistenceCapable)new DietInfoBlock());
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
        DietInfoBlock result = new DietInfoBlock();
        result.jdoFlags = 1;
        result.jdoStateManager = sm;
        return result;
    }

    public PersistenceCapable jdoNewInstance(StateManager sm, Object obj) {
        DietInfoBlock result = new DietInfoBlock();
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
                this.dietType = (DietType)((Object)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index));
                return;
            }
            case 1: {
                this.dietaryRestrictions = (Text)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
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
                this.isGlutenFree = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 5: {
                this.isProfile = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
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
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.dietType);
                return;
            }
            case 1: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.dietaryRestrictions);
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
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.isGlutenFree);
                return;
            }
            case 5: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.isProfile);
                return;
            }
        }
        throw new IllegalArgumentException(new StringBuffer("out of field index :").append(index).toString());
    }

    protected final void jdoCopyField(DietInfoBlock obj, int index) {
        switch (index) {
            case 0: {
                this.dietType = obj.dietType;
                return;
            }
            case 1: {
                this.dietaryRestrictions = obj.dietaryRestrictions;
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
                this.isGlutenFree = obj.isGlutenFree;
                return;
            }
            case 5: {
                this.isProfile = obj.isProfile;
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
        if (!(obj instanceof DietInfoBlock)) {
            throw new IllegalArgumentException("object is not an object of type org.hbgb.webcamp.shared.DietInfoBlock");
        }
        DietInfoBlock other = (DietInfoBlock)obj;
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
        return new String[]{"dietType", "dietaryRestrictions", "email", "encodedKey", "isGlutenFree", "isProfile"};
    }

    private static final Class[] __jdoFieldTypesInit() {
        return new Class[]{DietInfoBlock.___jdo$loadClass("org.hbgb.webcamp.shared.enums.DietType"), DietInfoBlock.___jdo$loadClass("com.google.appengine.api.datastore.Text"), DietInfoBlock.___jdo$loadClass("java.lang.String"), DietInfoBlock.___jdo$loadClass("java.lang.String"), DietInfoBlock.___jdo$loadClass("java.lang.Boolean"), DietInfoBlock.___jdo$loadClass("java.lang.Boolean")};
    }

    private static final byte[] __jdoFieldFlagsInit() {
        return new byte[]{21, 21, 21, 24, 21, 21};
    }

    protected static int __jdoGetInheritedFieldCount() {
        return 0;
    }

    protected static int jdoGetManagedFieldCount() {
        return 6;
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
        DietInfoBlock o = (DietInfoBlock)super.clone();
        o.jdoFlags = 0;
        o.jdoStateManager = null;
        return o;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        this.jdoPreSerialize();
        out.defaultWriteObject();
    }

    private static DietType jdoGetdietType(DietInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.dietType;
        if (objPC.jdoStateManager == null) return objPC.dietType;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 0)) return objPC.dietType;
        return (DietType)((Object)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 0, (Object)objPC.dietType));
    }

    private static void jdoSetdietType(DietInfoBlock objPC, DietType val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 0, (Object)objPC.dietType, (Object)val);
            return;
        }
        objPC.dietType = val;
    }

    private static Text jdoGetdietaryRestrictions(DietInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.dietaryRestrictions;
        if (objPC.jdoStateManager == null) return objPC.dietaryRestrictions;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 1)) return objPC.dietaryRestrictions;
        return (Text)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 1, (Object)objPC.dietaryRestrictions);
    }

    private static void jdoSetdietaryRestrictions(DietInfoBlock objPC, Text val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 1, (Object)objPC.dietaryRestrictions, (Object)val);
            return;
        }
        objPC.dietaryRestrictions = val;
    }

    private static String jdoGetemail(DietInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.email;
        if (objPC.jdoStateManager == null) return objPC.email;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 2)) return objPC.email;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 2, objPC.email);
    }

    private static void jdoSetemail(DietInfoBlock objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 2, objPC.email, val);
            return;
        }
        objPC.email = val;
    }

    private static String jdoGetencodedKey(DietInfoBlock objPC) {
        return objPC.encodedKey;
    }

    private static void jdoSetencodedKey(DietInfoBlock objPC, String val) {
        if (objPC.jdoStateManager == null) {
            objPC.encodedKey = val;
            return;
        }
        objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 3, objPC.encodedKey, val);
    }

    private static Boolean jdoGetisGlutenFree(DietInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.isGlutenFree;
        if (objPC.jdoStateManager == null) return objPC.isGlutenFree;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 4)) return objPC.isGlutenFree;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 4, (Object)objPC.isGlutenFree);
    }

    private static void jdoSetisGlutenFree(DietInfoBlock objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 4, (Object)objPC.isGlutenFree, (Object)val);
            return;
        }
        objPC.isGlutenFree = val;
    }

    private static Boolean jdoGetisProfile(DietInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.isProfile;
        if (objPC.jdoStateManager == null) return objPC.isProfile;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 5)) return objPC.isProfile;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 5, (Object)objPC.isProfile);
    }

    private static void jdoSetisProfile(DietInfoBlock objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 5, (Object)objPC.isProfile, (Object)val);
            return;
        }
        objPC.isProfile = val;
    }
}

