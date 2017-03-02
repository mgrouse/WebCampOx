/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.gwt.user.client.rpc.IsSerializable
 *  javax.jdo.JDODetachedFieldAccessException
 *  javax.jdo.JDOFatalInternalException
 *  javax.jdo.PersistenceManager
 *  javax.jdo.annotations.Extension
 *  javax.jdo.annotations.IdGeneratorStrategy
 *  javax.jdo.annotations.IdentityType
 *  javax.jdo.annotations.Inheritance
 *  javax.jdo.annotations.InheritanceStrategy
 *  javax.jdo.annotations.PersistenceCapable
 *  javax.jdo.annotations.Persistent
 *  javax.jdo.annotations.PrimaryKey
 *  javax.jdo.identity.StringIdentity
 *  javax.jdo.spi.Detachable
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
import java.util.BitSet;
import javax.jdo.JDODetachedFieldAccessException;
import javax.jdo.JDOFatalInternalException;
import javax.jdo.PersistenceManager;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.identity.StringIdentity;
import javax.jdo.spi.Detachable;
import javax.jdo.spi.JDOImplHelper;
import javax.jdo.spi.PersistenceCapable;
import javax.jdo.spi.StateManager;
import org.hbgb.webcamp.shared.ContactInfo;
import org.hbgb.webcamp.shared.Demographics;

@javax.jdo.annotations.PersistenceCapable(detachable="true", identityType=IdentityType.APPLICATION)
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Burner
implements Serializable,
IsSerializable,
Detachable,
PersistenceCapable {
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
    @Persistent
    private String email = "";
    @Persistent
    private Demographics demographics;
    @Persistent
    private ContactInfo contactInfo;
    protected transient StateManager jdoStateManager;
    protected transient byte jdoFlags;
    protected Object[] jdoDetachedState;
    private static final byte[] jdoFieldFlags;
    private static final Class jdoPersistenceCapableSuperclass;
    private static final Class[] jdoFieldTypes;
    private static final String[] jdoFieldNames;
    private static final int jdoInheritedFieldCount;
    private static final long serialVersionUID = -7028802039654463386L;

    public Burner() {
    }

    public Burner(String emailText) {
        this.email = emailText;
        this.demographics = new Demographics(emailText);
        this.contactInfo = new ContactInfo(emailText);
    }

    public Burner(String email, Burner source) {
        if (source != null) {
            this.setEmail(source.getEmail());
            this.setDemographics(new Demographics(source.getEmail(), source.getDemographics()));
            this.setContactInfo(new ContactInfo(source.getEmail(), source.getContactInfo()));
            return;
        }
        this.setEmail(email);
        this.setDemographics(new Demographics(email));
        this.setContactInfo(new ContactInfo(email));
    }

    public String getEncodedKey() {
        return Burner.jdoGetencodedKey(this);
    }

    public void setEncodedKey(String encodedKey) {
        Burner.jdoSetencodedKey(this, encodedKey);
    }

    public String getEmail() {
        return Burner.jdoGetemail(this);
    }

    public void setEmail(String email) {
        Burner.jdoSetemail(this, email);
    }

    public Demographics getDemographics() {
        return Burner.jdoGetdemographics(this);
    }

    public void setDemographics(Demographics demographics) {
        Burner.jdoSetdemographics(this, demographics);
    }

    public ContactInfo getContactInfo() {
        return Burner.jdoGetcontactInfo(this);
    }

    public void setContactInfo(ContactInfo contactInfo) {
        Burner.jdoSetcontactInfo(this, contactInfo);
    }

    static {
        jdoFieldNames = Burner.__jdoFieldNamesInit();
        jdoFieldTypes = Burner.__jdoFieldTypesInit();
        jdoFieldFlags = Burner.__jdoFieldFlagsInit();
        jdoInheritedFieldCount = Burner.__jdoGetInheritedFieldCount();
        jdoPersistenceCapableSuperclass = Burner.__jdoPersistenceCapableSuperclassInit();
        JDOImplHelper.registerClass((Class)Burner.___jdo$loadClass("org.hbgb.webcamp.shared.Burner"), (String[])jdoFieldNames, (Class[])jdoFieldTypes, (byte[])jdoFieldFlags, (Class)jdoPersistenceCapableSuperclass, (PersistenceCapable)new Burner());
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
        if (this.jdoStateManager != null) {
            return this.jdoStateManager.getObjectId((PersistenceCapable)this);
        }
        if (this.jdoIsDetached()) return this.jdoDetachedState[0];
        return null;
    }

    public final Object jdoGetVersion() {
        if (this.jdoStateManager != null) {
            return this.jdoStateManager.getVersion((PersistenceCapable)this);
        }
        if (this.jdoIsDetached()) return this.jdoDetachedState[1];
        return null;
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
        if (this.jdoStateManager != null) {
            return this.jdoStateManager.isDirty((PersistenceCapable)this);
        }
        if (!this.jdoIsDetached()) {
            return false;
        }
        if (((BitSet)this.jdoDetachedState[3]).length() > 0) return true;
        return false;
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
        if (this.jdoStateManager != null) {
            this.jdoStateManager.makeDirty((PersistenceCapable)this, fieldName);
        }
        if (!this.jdoIsDetached()) return;
        if (fieldName == null) return;
        String fldName = null;
        fldName = fieldName.indexOf(46) >= 0 ? fieldName.substring(fieldName.lastIndexOf(46) + 1) : fieldName;
        int i = 0;
        while (i < jdoFieldNames.length) {
            if (jdoFieldNames[i].equals(fldName)) {
                if (!((BitSet)this.jdoDetachedState[2]).get(i + jdoInheritedFieldCount)) throw new JDODetachedFieldAccessException("You have just attempted to access a field/property that hasn't been detached. Please detach it first before performing this operation");
                ((BitSet)this.jdoDetachedState[3]).set(i + jdoInheritedFieldCount);
                return;
            }
            ++i;
        }
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

    public final synchronized void jdoReplaceDetachedState() {
        if (this.jdoStateManager == null) {
            throw new IllegalStateException("state manager is null");
        }
        this.jdoDetachedState = this.jdoStateManager.replacingDetachedState((Detachable)this, this.jdoDetachedState);
    }

    public boolean jdoIsDetached() {
        if (this.jdoStateManager != null) return false;
        if (this.jdoDetachedState == null) return false;
        return true;
    }

    public PersistenceCapable jdoNewInstance(StateManager sm) {
        Burner result = new Burner();
        result.jdoFlags = 1;
        result.jdoStateManager = sm;
        return result;
    }

    public PersistenceCapable jdoNewInstance(StateManager sm, Object obj) {
        Burner result = new Burner();
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
                this.contactInfo = (ContactInfo)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 1: {
                this.demographics = (Demographics)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
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
        }
        throw new IllegalArgumentException(new StringBuffer("out of field index :").append(index).toString());
    }

    public void jdoProvideField(int index) {
        if (this.jdoStateManager == null) {
            throw new IllegalStateException("state manager is null");
        }
        switch (index) {
            case 0: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.contactInfo);
                return;
            }
            case 1: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.demographics);
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
        }
        throw new IllegalArgumentException(new StringBuffer("out of field index :").append(index).toString());
    }

    protected final void jdoCopyField(Burner obj, int index) {
        switch (index) {
            case 0: {
                this.contactInfo = obj.contactInfo;
                return;
            }
            case 1: {
                this.demographics = obj.demographics;
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
        if (!(obj instanceof Burner)) {
            throw new IllegalArgumentException("object is not an object of type org.hbgb.webcamp.shared.Burner");
        }
        Burner other = (Burner)obj;
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
        return new String[]{"contactInfo", "demographics", "email", "encodedKey"};
    }

    private static final Class[] __jdoFieldTypesInit() {
        return new Class[]{Burner.___jdo$loadClass("org.hbgb.webcamp.shared.ContactInfo"), Burner.___jdo$loadClass("org.hbgb.webcamp.shared.Demographics"), Burner.___jdo$loadClass("java.lang.String"), Burner.___jdo$loadClass("java.lang.String")};
    }

    private static final byte[] __jdoFieldFlagsInit() {
        return new byte[]{26, 26, 21, 24};
    }

    protected static int __jdoGetInheritedFieldCount() {
        return 0;
    }

    protected static int jdoGetManagedFieldCount() {
        return 4;
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
        Burner o = (Burner)super.clone();
        o.jdoFlags = 0;
        o.jdoStateManager = null;
        return o;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        this.jdoPreSerialize();
        out.defaultWriteObject();
    }

    private static ContactInfo jdoGetcontactInfo(Burner objPC) {
        if (objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 0)) {
            return (ContactInfo)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 0, (Object)objPC.contactInfo);
        }
        if (!objPC.jdoIsDetached()) return objPC.contactInfo;
        if (((BitSet)objPC.jdoDetachedState[2]).get(0)) return objPC.contactInfo;
        if (((BitSet)objPC.jdoDetachedState[3]).get(0)) return objPC.contactInfo;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"contactInfo\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetcontactInfo(Burner objPC, ContactInfo val) {
        if (objPC.jdoStateManager == null) {
            objPC.contactInfo = val;
        } else {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 0, (Object)objPC.contactInfo, (Object)val);
        }
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(0);
    }

    private static Demographics jdoGetdemographics(Burner objPC) {
        if (objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 1)) {
            return (Demographics)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 1, (Object)objPC.demographics);
        }
        if (!objPC.jdoIsDetached()) return objPC.demographics;
        if (((BitSet)objPC.jdoDetachedState[2]).get(1)) return objPC.demographics;
        if (((BitSet)objPC.jdoDetachedState[3]).get(1)) return objPC.demographics;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"demographics\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetdemographics(Burner objPC, Demographics val) {
        if (objPC.jdoStateManager == null) {
            objPC.demographics = val;
        } else {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 1, (Object)objPC.demographics, (Object)val);
        }
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(1);
    }

    private static String jdoGetemail(Burner objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 2)) {
            return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 2, objPC.email);
        }
        if (!objPC.jdoIsDetached()) return objPC.email;
        if (((BitSet)objPC.jdoDetachedState[2]).get(2)) return objPC.email;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"email\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetemail(Burner objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 2, objPC.email, val);
            return;
        }
        objPC.email = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(2);
    }

    private static String jdoGetencodedKey(Burner objPC) {
        return objPC.encodedKey;
    }

    private static void jdoSetencodedKey(Burner objPC, String val) {
        if (objPC.jdoStateManager == null) {
            objPC.encodedKey = val;
        } else {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 3, objPC.encodedKey, val);
        }
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(3);
    }
}

