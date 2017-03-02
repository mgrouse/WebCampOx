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
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.identity.StringIdentity;
import javax.jdo.spi.Detachable;
import javax.jdo.spi.JDOImplHelper;
import javax.jdo.spi.PersistenceCapable;
import javax.jdo.spi.StateManager;
import org.hbgb.webcamp.shared.Address;
import org.hbgb.webcamp.shared.enums.CallTime;
import org.hbgb.webcamp.shared.enums.ContactMethod;

@javax.jdo.annotations.PersistenceCapable(detachable="true", identityType=IdentityType.APPLICATION)
public class ContactInfo
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
    private Address address;
    @Persistent
    private String phone = "";
    @Persistent
    private String skypeName = "";
    @Persistent
    private Boolean isReturningHeeBee;
    @Persistent
    private String pastYearsText;
    @Persistent
    private ContactMethod contactMethod;
    @Persistent
    private CallTime callTime;
    protected transient StateManager jdoStateManager;
    protected transient byte jdoFlags;
    protected Object[] jdoDetachedState;
    private static final byte[] jdoFieldFlags;
    private static final Class jdoPersistenceCapableSuperclass;
    private static final Class[] jdoFieldTypes;
    private static final String[] jdoFieldNames;
    private static final int jdoInheritedFieldCount;
    private static final long serialVersionUID = 2410204817703049574L;

    public ContactInfo() {
    }

    public ContactInfo(String emailText) {
        this.email = emailText;
    }

    public ContactInfo(String email, ContactInfo source) {
        if (source != null) {
            this.setEmail(source.getEmail());
            this.setAddress(new Address(source.getAddress()));
            this.setPhone(source.getPhone());
            this.setSkypeName(source.getSkypeName());
            this.setContactMethod(source.getContactMethod());
            this.setCallTime(source.getCallTime());
            return;
        }
        this.setEmail(email);
        this.setAddress(new Address());
    }

    public String getEncodedKey() {
        return ContactInfo.jdoGetencodedKey(this);
    }

    public void setEncodedKey(String encodedKey) {
        ContactInfo.jdoSetencodedKey(this, encodedKey);
    }

    public String getEmail() {
        return ContactInfo.jdoGetemail(this);
    }

    public void setEmail(String email) {
        ContactInfo.jdoSetemail(this, email);
    }

    public Address getAddress() {
        return ContactInfo.jdoGetaddress(this);
    }

    public void setAddress(Address address) {
        ContactInfo.jdoSetaddress(this, address);
    }

    public String getPhone() {
        return ContactInfo.jdoGetphone(this);
    }

    public void setPhone(String phone) {
        ContactInfo.jdoSetphone(this, phone);
    }

    public String getSkypeName() {
        return ContactInfo.jdoGetskypeName(this);
    }

    public void setSkypeName(String skypeName) {
        ContactInfo.jdoSetskypeName(this, skypeName);
    }

    public ContactMethod getContactMethod() {
        return ContactInfo.jdoGetcontactMethod(this);
    }

    public void setContactMethod(ContactMethod contactMethod) {
        ContactInfo.jdoSetcontactMethod(this, contactMethod);
    }

    public CallTime getCallTime() {
        return ContactInfo.jdoGetcallTime(this);
    }

    public void setCallTime(CallTime callTime) {
        ContactInfo.jdoSetcallTime(this, callTime);
    }

    static {
        jdoFieldNames = ContactInfo.__jdoFieldNamesInit();
        jdoFieldTypes = ContactInfo.__jdoFieldTypesInit();
        jdoFieldFlags = ContactInfo.__jdoFieldFlagsInit();
        jdoInheritedFieldCount = ContactInfo.__jdoGetInheritedFieldCount();
        jdoPersistenceCapableSuperclass = ContactInfo.__jdoPersistenceCapableSuperclassInit();
        JDOImplHelper.registerClass((Class)ContactInfo.___jdo$loadClass("org.hbgb.webcamp.shared.ContactInfo"), (String[])jdoFieldNames, (Class[])jdoFieldTypes, (byte[])jdoFieldFlags, (Class)jdoPersistenceCapableSuperclass, (PersistenceCapable)new ContactInfo());
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
        ContactInfo result = new ContactInfo();
        result.jdoFlags = 1;
        result.jdoStateManager = sm;
        return result;
    }

    public PersistenceCapable jdoNewInstance(StateManager sm, Object obj) {
        ContactInfo result = new ContactInfo();
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
                this.address = (Address)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 1: {
                this.callTime = (CallTime)((Object)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index));
                return;
            }
            case 2: {
                this.contactMethod = (ContactMethod)((Object)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index));
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
                this.isReturningHeeBee = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 6: {
                this.pastYearsText = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 7: {
                this.phone = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 8: {
                this.skypeName = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
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
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.address);
                return;
            }
            case 1: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.callTime);
                return;
            }
            case 2: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.contactMethod);
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
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.isReturningHeeBee);
                return;
            }
            case 6: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.pastYearsText);
                return;
            }
            case 7: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.phone);
                return;
            }
            case 8: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.skypeName);
                return;
            }
        }
        throw new IllegalArgumentException(new StringBuffer("out of field index :").append(index).toString());
    }

    protected final void jdoCopyField(ContactInfo obj, int index) {
        switch (index) {
            case 0: {
                this.address = obj.address;
                return;
            }
            case 1: {
                this.callTime = obj.callTime;
                return;
            }
            case 2: {
                this.contactMethod = obj.contactMethod;
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
                this.isReturningHeeBee = obj.isReturningHeeBee;
                return;
            }
            case 6: {
                this.pastYearsText = obj.pastYearsText;
                return;
            }
            case 7: {
                this.phone = obj.phone;
                return;
            }
            case 8: {
                this.skypeName = obj.skypeName;
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
        if (!(obj instanceof ContactInfo)) {
            throw new IllegalArgumentException("object is not an object of type org.hbgb.webcamp.shared.ContactInfo");
        }
        ContactInfo other = (ContactInfo)obj;
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
        return new String[]{"address", "callTime", "contactMethod", "email", "encodedKey", "isReturningHeeBee", "pastYearsText", "phone", "skypeName"};
    }

    private static final Class[] __jdoFieldTypesInit() {
        return new Class[]{ContactInfo.___jdo$loadClass("org.hbgb.webcamp.shared.Address"), ContactInfo.___jdo$loadClass("org.hbgb.webcamp.shared.enums.CallTime"), ContactInfo.___jdo$loadClass("org.hbgb.webcamp.shared.enums.ContactMethod"), ContactInfo.___jdo$loadClass("java.lang.String"), ContactInfo.___jdo$loadClass("java.lang.String"), ContactInfo.___jdo$loadClass("java.lang.Boolean"), ContactInfo.___jdo$loadClass("java.lang.String"), ContactInfo.___jdo$loadClass("java.lang.String"), ContactInfo.___jdo$loadClass("java.lang.String")};
    }

    private static final byte[] __jdoFieldFlagsInit() {
        return new byte[]{26, 21, 21, 21, 24, 21, 21, 21, 21};
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
        ContactInfo o = (ContactInfo)super.clone();
        o.jdoFlags = 0;
        o.jdoStateManager = null;
        return o;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        this.jdoPreSerialize();
        out.defaultWriteObject();
    }

    private static Address jdoGetaddress(ContactInfo objPC) {
        if (objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 0)) {
            return (Address)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 0, (Object)objPC.address);
        }
        if (!objPC.jdoIsDetached()) return objPC.address;
        if (((BitSet)objPC.jdoDetachedState[2]).get(0)) return objPC.address;
        if (((BitSet)objPC.jdoDetachedState[3]).get(0)) return objPC.address;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"address\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetaddress(ContactInfo objPC, Address val) {
        if (objPC.jdoStateManager == null) {
            objPC.address = val;
        } else {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 0, (Object)objPC.address, (Object)val);
        }
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(0);
    }

    private static CallTime jdoGetcallTime(ContactInfo objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 1)) {
            return (CallTime)((Object)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 1, (Object)objPC.callTime));
        }
        if (!objPC.jdoIsDetached()) return objPC.callTime;
        if (((BitSet)objPC.jdoDetachedState[2]).get(1)) return objPC.callTime;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"callTime\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetcallTime(ContactInfo objPC, CallTime val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 1, (Object)objPC.callTime, (Object)val);
            return;
        }
        objPC.callTime = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(1);
    }

    private static ContactMethod jdoGetcontactMethod(ContactInfo objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 2)) {
            return (ContactMethod)((Object)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 2, (Object)objPC.contactMethod));
        }
        if (!objPC.jdoIsDetached()) return objPC.contactMethod;
        if (((BitSet)objPC.jdoDetachedState[2]).get(2)) return objPC.contactMethod;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"contactMethod\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetcontactMethod(ContactInfo objPC, ContactMethod val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 2, (Object)objPC.contactMethod, (Object)val);
            return;
        }
        objPC.contactMethod = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(2);
    }

    private static String jdoGetemail(ContactInfo objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 3)) {
            return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 3, objPC.email);
        }
        if (!objPC.jdoIsDetached()) return objPC.email;
        if (((BitSet)objPC.jdoDetachedState[2]).get(3)) return objPC.email;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"email\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetemail(ContactInfo objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 3, objPC.email, val);
            return;
        }
        objPC.email = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(3);
    }

    private static String jdoGetencodedKey(ContactInfo objPC) {
        return objPC.encodedKey;
    }

    private static void jdoSetencodedKey(ContactInfo objPC, String val) {
        if (objPC.jdoStateManager == null) {
            objPC.encodedKey = val;
        } else {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 4, objPC.encodedKey, val);
        }
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(4);
    }

    private static Boolean jdoGetisReturningHeeBee(ContactInfo objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 5)) {
            return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 5, (Object)objPC.isReturningHeeBee);
        }
        if (!objPC.jdoIsDetached()) return objPC.isReturningHeeBee;
        if (((BitSet)objPC.jdoDetachedState[2]).get(5)) return objPC.isReturningHeeBee;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"isReturningHeeBee\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetisReturningHeeBee(ContactInfo objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 5, (Object)objPC.isReturningHeeBee, (Object)val);
            return;
        }
        objPC.isReturningHeeBee = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(5);
    }

    private static String jdoGetpastYearsText(ContactInfo objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 6)) {
            return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 6, objPC.pastYearsText);
        }
        if (!objPC.jdoIsDetached()) return objPC.pastYearsText;
        if (((BitSet)objPC.jdoDetachedState[2]).get(6)) return objPC.pastYearsText;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"pastYearsText\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetpastYearsText(ContactInfo objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 6, objPC.pastYearsText, val);
            return;
        }
        objPC.pastYearsText = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(6);
    }

    private static String jdoGetphone(ContactInfo objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 7)) {
            return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 7, objPC.phone);
        }
        if (!objPC.jdoIsDetached()) return objPC.phone;
        if (((BitSet)objPC.jdoDetachedState[2]).get(7)) return objPC.phone;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"phone\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetphone(ContactInfo objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 7, objPC.phone, val);
            return;
        }
        objPC.phone = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(7);
    }

    private static String jdoGetskypeName(ContactInfo objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 8)) {
            return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 8, objPC.skypeName);
        }
        if (!objPC.jdoIsDetached()) return objPC.skypeName;
        if (((BitSet)objPC.jdoDetachedState[2]).get(8)) return objPC.skypeName;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"skypeName\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetskypeName(ContactInfo objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 8, objPC.skypeName, val);
            return;
        }
        objPC.skypeName = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(8);
    }
}

