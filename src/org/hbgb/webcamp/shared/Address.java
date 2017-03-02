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

@javax.jdo.annotations.PersistenceCapable(detachable="true", identityType=IdentityType.APPLICATION)
public class Address
implements Serializable,
IsSerializable,
Detachable,
PersistenceCapable {
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
    @Persistent
    private String street1 = "";
    @Persistent
    private String street2 = "";
    @Persistent
    private String city = "";
    @Persistent
    private String state = "";
    @Persistent
    private String country = "";
    @Persistent
    private String postalCode = "";
    protected transient StateManager jdoStateManager;
    protected transient byte jdoFlags;
    protected Object[] jdoDetachedState;
    private static final byte[] jdoFieldFlags;
    private static final Class jdoPersistenceCapableSuperclass;
    private static final Class[] jdoFieldTypes;
    private static final String[] jdoFieldNames;
    private static final int jdoInheritedFieldCount;
    private static final long serialVersionUID = 799551532279117929L;

    public Address() {
    }

    public Address(Address source) {
        this.setStreet1(source.getStreet1());
        this.setStreet2(source.getStreet2());
        this.setCity(source.getCity());
        this.setState(source.getState());
        this.setCountry(source.getCountry());
        this.setPostalCode(source.getPostalCode());
    }

    public String getEncodedKey() {
        return Address.jdoGetencodedKey(this);
    }

    public void setEncodedKey(String encodedKey) {
        Address.jdoSetencodedKey(this, encodedKey);
    }

    public String getStreet1() {
        return Address.jdoGetstreet1(this);
    }

    public void setStreet1(String street1) {
        Address.jdoSetstreet1(this, street1);
    }

    public String getStreet2() {
        return Address.jdoGetstreet2(this);
    }

    public void setStreet2(String street2) {
        Address.jdoSetstreet2(this, street2);
    }

    public String getCity() {
        return Address.jdoGetcity(this);
    }

    public void setCity(String city) {
        Address.jdoSetcity(this, city);
    }

    public String getState() {
        return Address.jdoGetstate(this);
    }

    public void setState(String state) {
        Address.jdoSetstate(this, state);
    }

    public String getCountry() {
        return Address.jdoGetcountry(this);
    }

    public void setCountry(String country) {
        Address.jdoSetcountry(this, country);
    }

    public String getPostalCode() {
        return Address.jdoGetpostalCode(this);
    }

    public void setPostalCode(String postalCode) {
        Address.jdoSetpostalCode(this, postalCode);
    }

    static {
        jdoFieldNames = Address.__jdoFieldNamesInit();
        jdoFieldTypes = Address.__jdoFieldTypesInit();
        jdoFieldFlags = Address.__jdoFieldFlagsInit();
        jdoInheritedFieldCount = Address.__jdoGetInheritedFieldCount();
        jdoPersistenceCapableSuperclass = Address.__jdoPersistenceCapableSuperclassInit();
        JDOImplHelper.registerClass((Class)Address.___jdo$loadClass("org.hbgb.webcamp.shared.Address"), (String[])jdoFieldNames, (Class[])jdoFieldTypes, (byte[])jdoFieldFlags, (Class)jdoPersistenceCapableSuperclass, (PersistenceCapable)new Address());
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
        Address result = new Address();
        result.jdoFlags = 1;
        result.jdoStateManager = sm;
        return result;
    }

    public PersistenceCapable jdoNewInstance(StateManager sm, Object obj) {
        Address result = new Address();
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
                this.city = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 1: {
                this.country = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 2: {
                this.encodedKey = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 3: {
                this.postalCode = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 4: {
                this.state = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 5: {
                this.street1 = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 6: {
                this.street2 = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
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
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.city);
                return;
            }
            case 1: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.country);
                return;
            }
            case 2: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.encodedKey);
                return;
            }
            case 3: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.postalCode);
                return;
            }
            case 4: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.state);
                return;
            }
            case 5: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.street1);
                return;
            }
            case 6: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.street2);
                return;
            }
        }
        throw new IllegalArgumentException(new StringBuffer("out of field index :").append(index).toString());
    }

    protected final void jdoCopyField(Address obj, int index) {
        switch (index) {
            case 0: {
                this.city = obj.city;
                return;
            }
            case 1: {
                this.country = obj.country;
                return;
            }
            case 2: {
                this.encodedKey = obj.encodedKey;
                return;
            }
            case 3: {
                this.postalCode = obj.postalCode;
                return;
            }
            case 4: {
                this.state = obj.state;
                return;
            }
            case 5: {
                this.street1 = obj.street1;
                return;
            }
            case 6: {
                this.street2 = obj.street2;
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
        if (!(obj instanceof Address)) {
            throw new IllegalArgumentException("object is not an object of type org.hbgb.webcamp.shared.Address");
        }
        Address other = (Address)obj;
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
        return new String[]{"city", "country", "encodedKey", "postalCode", "state", "street1", "street2"};
    }

    private static final Class[] __jdoFieldTypesInit() {
        return new Class[]{Address.___jdo$loadClass("java.lang.String"), Address.___jdo$loadClass("java.lang.String"), Address.___jdo$loadClass("java.lang.String"), Address.___jdo$loadClass("java.lang.String"), Address.___jdo$loadClass("java.lang.String"), Address.___jdo$loadClass("java.lang.String"), Address.___jdo$loadClass("java.lang.String")};
    }

    private static final byte[] __jdoFieldFlagsInit() {
        return new byte[]{21, 21, 24, 21, 21, 21, 21};
    }

    protected static int __jdoGetInheritedFieldCount() {
        return 0;
    }

    protected static int jdoGetManagedFieldCount() {
        return 7;
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
        Address o = (Address)super.clone();
        o.jdoFlags = 0;
        o.jdoStateManager = null;
        return o;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        this.jdoPreSerialize();
        out.defaultWriteObject();
    }

    private static String jdoGetcity(Address objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 0)) {
            return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 0, objPC.city);
        }
        if (!objPC.jdoIsDetached()) return objPC.city;
        if (((BitSet)objPC.jdoDetachedState[2]).get(0)) return objPC.city;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"city\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetcity(Address objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 0, objPC.city, val);
            return;
        }
        objPC.city = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(0);
    }

    private static String jdoGetcountry(Address objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 1)) {
            return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 1, objPC.country);
        }
        if (!objPC.jdoIsDetached()) return objPC.country;
        if (((BitSet)objPC.jdoDetachedState[2]).get(1)) return objPC.country;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"country\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetcountry(Address objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 1, objPC.country, val);
            return;
        }
        objPC.country = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(1);
    }

    private static String jdoGetencodedKey(Address objPC) {
        return objPC.encodedKey;
    }

    private static void jdoSetencodedKey(Address objPC, String val) {
        if (objPC.jdoStateManager == null) {
            objPC.encodedKey = val;
        } else {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 2, objPC.encodedKey, val);
        }
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(2);
    }

    private static String jdoGetpostalCode(Address objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 3)) {
            return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 3, objPC.postalCode);
        }
        if (!objPC.jdoIsDetached()) return objPC.postalCode;
        if (((BitSet)objPC.jdoDetachedState[2]).get(3)) return objPC.postalCode;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"postalCode\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetpostalCode(Address objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 3, objPC.postalCode, val);
            return;
        }
        objPC.postalCode = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(3);
    }

    private static String jdoGetstate(Address objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 4)) {
            return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 4, objPC.state);
        }
        if (!objPC.jdoIsDetached()) return objPC.state;
        if (((BitSet)objPC.jdoDetachedState[2]).get(4)) return objPC.state;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"state\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetstate(Address objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 4, objPC.state, val);
            return;
        }
        objPC.state = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(4);
    }

    private static String jdoGetstreet1(Address objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 5)) {
            return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 5, objPC.street1);
        }
        if (!objPC.jdoIsDetached()) return objPC.street1;
        if (((BitSet)objPC.jdoDetachedState[2]).get(5)) return objPC.street1;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"street1\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetstreet1(Address objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 5, objPC.street1, val);
            return;
        }
        objPC.street1 = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(5);
    }

    private static String jdoGetstreet2(Address objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 6)) {
            return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 6, objPC.street2);
        }
        if (!objPC.jdoIsDetached()) return objPC.street2;
        if (((BitSet)objPC.jdoDetachedState[2]).get(6)) return objPC.street2;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"street2\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetstreet2(Address objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 6, objPC.street2, val);
            return;
        }
        objPC.street2 = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(6);
    }
}

