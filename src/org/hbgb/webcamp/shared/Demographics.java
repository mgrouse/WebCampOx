/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.google.appengine.api.datastore.Text
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

import com.google.appengine.api.datastore.Text;
import com.google.gwt.user.client.rpc.IsSerializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Date;
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
import org.hbgb.webcamp.shared.enums.Gender;

@javax.jdo.annotations.PersistenceCapable(detachable="true", identityType=IdentityType.APPLICATION)
public class Demographics
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
    private String firstName = "";
    @Persistent
    private String lastName = "";
    @Persistent
    private String playaName = "";
    @Persistent
    private Gender gender;
    @Persistent
    private Date birthDate;
    @Persistent
    private String defaultWorldJob = "";
    @Persistent
    private Text bio = new Text("");
    protected transient StateManager jdoStateManager;
    protected transient byte jdoFlags;
    protected Object[] jdoDetachedState;
    private static final byte[] jdoFieldFlags;
    private static final Class jdoPersistenceCapableSuperclass;
    private static final Class[] jdoFieldTypes;
    private static final String[] jdoFieldNames;
    private static final int jdoInheritedFieldCount;
    private static final long serialVersionUID = 675226840139596860L;

    public Demographics() {
    }

    public Demographics(String emailText) {
        this.email = emailText;
    }

    public Demographics(String email, Demographics source) {
        if (source != null) {
            this.setEmail(source.getEmail());
            this.setFirstName(source.getFirstName());
            this.setLastName(source.getLastName());
            this.setPlayaName(source.getPlayaName());
            this.setGender(source.getGender());
            this.setBirthDate(source.getBirthDate());
            this.setDefaultWorldJob(source.getDefaultWorldJob());
            this.setBio(new Text(source.getBio().getValue()));
            return;
        }
        this.setEmail(email);
    }

    public String getEncodedKey() {
        return Demographics.jdoGetencodedKey(this);
    }

    public void setEncodedKey(String encodedKey) {
        Demographics.jdoSetencodedKey(this, encodedKey);
    }

    public String getEmail() {
        return Demographics.jdoGetemail(this);
    }

    public void setEmail(String email) {
        Demographics.jdoSetemail(this, email);
    }

    public String getFirstName() {
        return Demographics.jdoGetfirstName(this);
    }

    public void setFirstName(String fName) {
        Demographics.jdoSetfirstName(this, fName);
    }

    public String getLastName() {
        return Demographics.jdoGetlastName(this);
    }

    public void setLastName(String lName) {
        Demographics.jdoSetlastName(this, lName);
    }

    public String getPlayaName() {
        return Demographics.jdoGetplayaName(this);
    }

    public void setPlayaName(String playaName) {
        Demographics.jdoSetplayaName(this, playaName);
    }

    public String getFullName() {
        return String.valueOf(this.getFirstName()) + " " + this.getLastName();
    }

    public Gender getGender() {
        return Demographics.jdoGetgender(this);
    }

    public void setGender(Gender gender) {
        Demographics.jdoSetgender(this, gender);
    }

    public Date getBirthDate() {
        return Demographics.jdoGetbirthDate(this);
    }

    public void setBirthDate(Date birthDate) {
        Demographics.jdoSetbirthDate(this, birthDate);
    }

    public String getDefaultWorldJob() {
        return Demographics.jdoGetdefaultWorldJob(this);
    }

    public void setDefaultWorldJob(String defaultWorldJob) {
        Demographics.jdoSetdefaultWorldJob(this, defaultWorldJob);
    }

    public Text getBio() {
        return Demographics.jdoGetbio(this);
    }

    public void setBio(Text bio) {
        Demographics.jdoSetbio(this, bio);
    }

    static {
        jdoFieldNames = Demographics.__jdoFieldNamesInit();
        jdoFieldTypes = Demographics.__jdoFieldTypesInit();
        jdoFieldFlags = Demographics.__jdoFieldFlagsInit();
        jdoInheritedFieldCount = Demographics.__jdoGetInheritedFieldCount();
        jdoPersistenceCapableSuperclass = Demographics.__jdoPersistenceCapableSuperclassInit();
        JDOImplHelper.registerClass((Class)Demographics.___jdo$loadClass("org.hbgb.webcamp.shared.Demographics"), (String[])jdoFieldNames, (Class[])jdoFieldTypes, (byte[])jdoFieldFlags, (Class)jdoPersistenceCapableSuperclass, (PersistenceCapable)new Demographics());
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
        Demographics result = new Demographics();
        result.jdoFlags = 1;
        result.jdoStateManager = sm;
        return result;
    }

    public PersistenceCapable jdoNewInstance(StateManager sm, Object obj) {
        Demographics result = new Demographics();
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
                this.birthDate = (Date)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 2: {
                this.defaultWorldJob = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
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
                this.firstName = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 6: {
                this.gender = (Gender)((Object)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index));
                return;
            }
            case 7: {
                this.lastName = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 8: {
                this.playaName = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
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
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.birthDate);
                return;
            }
            case 2: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.defaultWorldJob);
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
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.firstName);
                return;
            }
            case 6: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.gender);
                return;
            }
            case 7: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.lastName);
                return;
            }
            case 8: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.playaName);
                return;
            }
        }
        throw new IllegalArgumentException(new StringBuffer("out of field index :").append(index).toString());
    }

    protected final void jdoCopyField(Demographics obj, int index) {
        switch (index) {
            case 0: {
                this.bio = obj.bio;
                return;
            }
            case 1: {
                this.birthDate = obj.birthDate;
                return;
            }
            case 2: {
                this.defaultWorldJob = obj.defaultWorldJob;
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
                this.firstName = obj.firstName;
                return;
            }
            case 6: {
                this.gender = obj.gender;
                return;
            }
            case 7: {
                this.lastName = obj.lastName;
                return;
            }
            case 8: {
                this.playaName = obj.playaName;
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
        if (!(obj instanceof Demographics)) {
            throw new IllegalArgumentException("object is not an object of type org.hbgb.webcamp.shared.Demographics");
        }
        Demographics other = (Demographics)obj;
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
        return new String[]{"bio", "birthDate", "defaultWorldJob", "email", "encodedKey", "firstName", "gender", "lastName", "playaName"};
    }

    private static final Class[] __jdoFieldTypesInit() {
        return new Class[]{Demographics.___jdo$loadClass("com.google.appengine.api.datastore.Text"), Demographics.___jdo$loadClass("java.util.Date"), Demographics.___jdo$loadClass("java.lang.String"), Demographics.___jdo$loadClass("java.lang.String"), Demographics.___jdo$loadClass("java.lang.String"), Demographics.___jdo$loadClass("java.lang.String"), Demographics.___jdo$loadClass("org.hbgb.webcamp.shared.enums.Gender"), Demographics.___jdo$loadClass("java.lang.String"), Demographics.___jdo$loadClass("java.lang.String")};
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
        Demographics o = (Demographics)super.clone();
        o.jdoFlags = 0;
        o.jdoStateManager = null;
        return o;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        this.jdoPreSerialize();
        out.defaultWriteObject();
    }

    private static Text jdoGetbio(Demographics objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 0)) {
            return (Text)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 0, (Object)objPC.bio);
        }
        if (!objPC.jdoIsDetached()) return objPC.bio;
        if (((BitSet)objPC.jdoDetachedState[2]).get(0)) return objPC.bio;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"bio\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetbio(Demographics objPC, Text val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 0, (Object)objPC.bio, (Object)val);
            return;
        }
        objPC.bio = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(0);
    }

    private static Date jdoGetbirthDate(Demographics objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 1)) {
            return (Date)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 1, (Object)objPC.birthDate);
        }
        if (!objPC.jdoIsDetached()) return objPC.birthDate;
        if (((BitSet)objPC.jdoDetachedState[2]).get(1)) return objPC.birthDate;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"birthDate\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetbirthDate(Demographics objPC, Date val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 1, (Object)objPC.birthDate, (Object)val);
            return;
        }
        objPC.birthDate = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(1);
    }

    private static String jdoGetdefaultWorldJob(Demographics objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 2)) {
            return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 2, objPC.defaultWorldJob);
        }
        if (!objPC.jdoIsDetached()) return objPC.defaultWorldJob;
        if (((BitSet)objPC.jdoDetachedState[2]).get(2)) return objPC.defaultWorldJob;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"defaultWorldJob\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetdefaultWorldJob(Demographics objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 2, objPC.defaultWorldJob, val);
            return;
        }
        objPC.defaultWorldJob = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(2);
    }

    private static String jdoGetemail(Demographics objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 3)) {
            return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 3, objPC.email);
        }
        if (!objPC.jdoIsDetached()) return objPC.email;
        if (((BitSet)objPC.jdoDetachedState[2]).get(3)) return objPC.email;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"email\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetemail(Demographics objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 3, objPC.email, val);
            return;
        }
        objPC.email = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(3);
    }

    private static String jdoGetencodedKey(Demographics objPC) {
        return objPC.encodedKey;
    }

    private static void jdoSetencodedKey(Demographics objPC, String val) {
        if (objPC.jdoStateManager == null) {
            objPC.encodedKey = val;
        } else {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 4, objPC.encodedKey, val);
        }
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(4);
    }

    private static String jdoGetfirstName(Demographics objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 5)) {
            return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 5, objPC.firstName);
        }
        if (!objPC.jdoIsDetached()) return objPC.firstName;
        if (((BitSet)objPC.jdoDetachedState[2]).get(5)) return objPC.firstName;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"firstName\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetfirstName(Demographics objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 5, objPC.firstName, val);
            return;
        }
        objPC.firstName = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(5);
    }

    private static Gender jdoGetgender(Demographics objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 6)) {
            return (Gender)((Object)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 6, (Object)objPC.gender));
        }
        if (!objPC.jdoIsDetached()) return objPC.gender;
        if (((BitSet)objPC.jdoDetachedState[2]).get(6)) return objPC.gender;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"gender\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetgender(Demographics objPC, Gender val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 6, (Object)objPC.gender, (Object)val);
            return;
        }
        objPC.gender = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(6);
    }

    private static String jdoGetlastName(Demographics objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 7)) {
            return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 7, objPC.lastName);
        }
        if (!objPC.jdoIsDetached()) return objPC.lastName;
        if (((BitSet)objPC.jdoDetachedState[2]).get(7)) return objPC.lastName;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"lastName\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetlastName(Demographics objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 7, objPC.lastName, val);
            return;
        }
        objPC.lastName = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(7);
    }

    private static String jdoGetplayaName(Demographics objPC) {
        if (objPC.jdoFlags > 0 && objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 8)) {
            return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 8, objPC.playaName);
        }
        if (!objPC.jdoIsDetached()) return objPC.playaName;
        if (((BitSet)objPC.jdoDetachedState[2]).get(8)) return objPC.playaName;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"playaName\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSetplayaName(Demographics objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 8, objPC.playaName, val);
            return;
        }
        objPC.playaName = val;
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(8);
    }
}

