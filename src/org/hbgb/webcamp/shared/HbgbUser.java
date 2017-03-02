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
 *  javax.jdo.annotations.Unique
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
import javax.jdo.annotations.Unique;
import javax.jdo.identity.StringIdentity;
import javax.jdo.spi.JDOImplHelper;
import javax.jdo.spi.PersistenceCapable;
import javax.jdo.spi.StateManager;
import org.hbgb.webcamp.shared.HbgbUserDetails;
import org.hbgb.webcamp.shared.enums.SecurityRole;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.APPLICATION)
public class HbgbUser
implements Serializable,
PersistenceCapable {
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
    @Persistent
    @Unique
    private String emailAddress;
    @Persistent
    String password;
    @Persistent
    Boolean isMustResetPassword;
    @Persistent
    String firstName;
    @Persistent
    String playaName;
    @Persistent
    String lastName;
    @Persistent
    Boolean isEarlyTeam;
    @Persistent
    SecurityRole securityRole;
    protected transient StateManager jdoStateManager;
    protected transient byte jdoFlags;
    private static final byte[] jdoFieldFlags;
    private static final Class jdoPersistenceCapableSuperclass;
    private static final Class[] jdoFieldTypes;
    private static final String[] jdoFieldNames;
    private static final int jdoInheritedFieldCount;
    private static final long serialVersionUID = -1328508789389081016L;

    public HbgbUser() {
        this.isMustResetPassword = true;
        this.isEarlyTeam = false;
        this.emailAddress = "";
        this.firstName = "";
        this.playaName = "";
        this.lastName = "";
    }

    public HbgbUser(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public HbgbUserDetails getDetails() {
        return new HbgbUserDetails(this.getKey(), this.getDisplayName());
    }

    public String getKey() {
        return HbgbUser.jdoGetencodedKey(this);
    }

    public void setKey(String key) {
        HbgbUser.jdoSetencodedKey(this, key);
    }

    public String getEmailAddress() {
        return HbgbUser.jdoGetemailAddress(this);
    }

    public void setEmailAddress(String emailAddress) {
        HbgbUser.jdoSetemailAddress(this, emailAddress);
    }

    public String getDisplayName() {
        StringBuilder display = new StringBuilder(this.getFirstName());
        display.append(" \"");
        display.append(this.getPlayaName());
        display.append("\" ");
        display.append(this.getLastName());
        return display.toString();
    }

    public String getFirstName() {
        return HbgbUser.jdoGetfirstName(this);
    }

    public void setFirstName(String firstName) {
        HbgbUser.jdoSetfirstName(this, firstName);
    }

    public String getPlayaName() {
        return HbgbUser.jdoGetplayaName(this);
    }

    public void setPlayaName(String playaName) {
        HbgbUser.jdoSetplayaName(this, playaName);
    }

    public String getLastName() {
        return HbgbUser.jdoGetlastName(this);
    }

    public void setLastName(String lastName) {
        HbgbUser.jdoSetlastName(this, lastName);
    }

    public Boolean getIsMustResetPassword() {
        return HbgbUser.jdoGetisMustResetPassword(this);
    }

    public void setIsMustResetPassword(Boolean bool) {
        HbgbUser.jdoSetisMustResetPassword(this, bool);
    }

    public Boolean getIsEarlyTeam() {
        return HbgbUser.jdoGetisEarlyTeam(this);
    }

    public void setIsEarlyTeam(Boolean bool) {
        HbgbUser.jdoSetisEarlyTeam(this, bool);
    }

    public Boolean isPassword(String password) {
        return HbgbUser.jdoGetpassword(this).equals(this.encodePassword(password));
    }

    private String encodePassword(String password) {
        return password;
    }

    private String getPassword() {
        return HbgbUser.jdoGetpassword(this);
    }

    public void setPassword(String password) {
        HbgbUser.jdoSetpassword(this, this.encodePassword(password));
    }

    public SecurityRole getSecurityRole() {
        return HbgbUser.jdoGetsecurityRole(this);
    }

    public void setSecurityRole(SecurityRole securityRole) {
        HbgbUser.jdoSetsecurityRole(this, securityRole);
    }

    static {
        jdoFieldNames = HbgbUser.__jdoFieldNamesInit();
        jdoFieldTypes = HbgbUser.__jdoFieldTypesInit();
        jdoFieldFlags = HbgbUser.__jdoFieldFlagsInit();
        jdoInheritedFieldCount = HbgbUser.__jdoGetInheritedFieldCount();
        jdoPersistenceCapableSuperclass = HbgbUser.__jdoPersistenceCapableSuperclassInit();
        JDOImplHelper.registerClass((Class)HbgbUser.___jdo$loadClass("org.hbgb.webcamp.shared.HbgbUser"), (String[])jdoFieldNames, (Class[])jdoFieldTypes, (byte[])jdoFieldFlags, (Class)jdoPersistenceCapableSuperclass, (PersistenceCapable)new HbgbUser());
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
        HbgbUser result = new HbgbUser();
        result.jdoFlags = 1;
        result.jdoStateManager = sm;
        return result;
    }

    public PersistenceCapable jdoNewInstance(StateManager sm, Object obj) {
        HbgbUser result = new HbgbUser();
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
                this.emailAddress = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 1: {
                this.encodedKey = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 2: {
                this.firstName = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 3: {
                this.isEarlyTeam = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 4: {
                this.isMustResetPassword = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 5: {
                this.lastName = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 6: {
                this.password = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 7: {
                this.playaName = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 8: {
                this.securityRole = (SecurityRole)((Object)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index));
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
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.emailAddress);
                return;
            }
            case 1: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.encodedKey);
                return;
            }
            case 2: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.firstName);
                return;
            }
            case 3: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.isEarlyTeam);
                return;
            }
            case 4: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.isMustResetPassword);
                return;
            }
            case 5: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.lastName);
                return;
            }
            case 6: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.password);
                return;
            }
            case 7: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.playaName);
                return;
            }
            case 8: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.securityRole);
                return;
            }
        }
        throw new IllegalArgumentException(new StringBuffer("out of field index :").append(index).toString());
    }

    protected final void jdoCopyField(HbgbUser obj, int index) {
        switch (index) {
            case 0: {
                this.emailAddress = obj.emailAddress;
                return;
            }
            case 1: {
                this.encodedKey = obj.encodedKey;
                return;
            }
            case 2: {
                this.firstName = obj.firstName;
                return;
            }
            case 3: {
                this.isEarlyTeam = obj.isEarlyTeam;
                return;
            }
            case 4: {
                this.isMustResetPassword = obj.isMustResetPassword;
                return;
            }
            case 5: {
                this.lastName = obj.lastName;
                return;
            }
            case 6: {
                this.password = obj.password;
                return;
            }
            case 7: {
                this.playaName = obj.playaName;
                return;
            }
            case 8: {
                this.securityRole = obj.securityRole;
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
        if (!(obj instanceof HbgbUser)) {
            throw new IllegalArgumentException("object is not an object of type org.hbgb.webcamp.shared.HbgbUser");
        }
        HbgbUser other = (HbgbUser)obj;
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
        return new String[]{"emailAddress", "encodedKey", "firstName", "isEarlyTeam", "isMustResetPassword", "lastName", "password", "playaName", "securityRole"};
    }

    private static final Class[] __jdoFieldTypesInit() {
        return new Class[]{HbgbUser.___jdo$loadClass("java.lang.String"), HbgbUser.___jdo$loadClass("java.lang.String"), HbgbUser.___jdo$loadClass("java.lang.String"), HbgbUser.___jdo$loadClass("java.lang.Boolean"), HbgbUser.___jdo$loadClass("java.lang.Boolean"), HbgbUser.___jdo$loadClass("java.lang.String"), HbgbUser.___jdo$loadClass("java.lang.String"), HbgbUser.___jdo$loadClass("java.lang.String"), HbgbUser.___jdo$loadClass("org.hbgb.webcamp.shared.enums.SecurityRole")};
    }

    private static final byte[] __jdoFieldFlagsInit() {
        return new byte[]{21, 24, 21, 21, 21, 21, 21, 21, 21};
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
        HbgbUser o = (HbgbUser)super.clone();
        o.jdoFlags = 0;
        o.jdoStateManager = null;
        return o;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        this.jdoPreSerialize();
        out.defaultWriteObject();
    }

    private static String jdoGetemailAddress(HbgbUser objPC) {
        if (objPC.jdoFlags <= 0) return objPC.emailAddress;
        if (objPC.jdoStateManager == null) return objPC.emailAddress;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 0)) return objPC.emailAddress;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 0, objPC.emailAddress);
    }

    private static void jdoSetemailAddress(HbgbUser objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 0, objPC.emailAddress, val);
            return;
        }
        objPC.emailAddress = val;
    }

    private static String jdoGetencodedKey(HbgbUser objPC) {
        return objPC.encodedKey;
    }

    private static void jdoSetencodedKey(HbgbUser objPC, String val) {
        if (objPC.jdoStateManager == null) {
            objPC.encodedKey = val;
            return;
        }
        objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 1, objPC.encodedKey, val);
    }

    static String jdoGetfirstName(HbgbUser objPC) {
        if (objPC.jdoFlags <= 0) return objPC.firstName;
        if (objPC.jdoStateManager == null) return objPC.firstName;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 2)) return objPC.firstName;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 2, objPC.firstName);
    }

    static void jdoSetfirstName(HbgbUser objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 2, objPC.firstName, val);
            return;
        }
        objPC.firstName = val;
    }

    static Boolean jdoGetisEarlyTeam(HbgbUser objPC) {
        if (objPC.jdoFlags <= 0) return objPC.isEarlyTeam;
        if (objPC.jdoStateManager == null) return objPC.isEarlyTeam;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 3)) return objPC.isEarlyTeam;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 3, (Object)objPC.isEarlyTeam);
    }

    static void jdoSetisEarlyTeam(HbgbUser objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 3, (Object)objPC.isEarlyTeam, (Object)val);
            return;
        }
        objPC.isEarlyTeam = val;
    }

    static Boolean jdoGetisMustResetPassword(HbgbUser objPC) {
        if (objPC.jdoFlags <= 0) return objPC.isMustResetPassword;
        if (objPC.jdoStateManager == null) return objPC.isMustResetPassword;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 4)) return objPC.isMustResetPassword;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 4, (Object)objPC.isMustResetPassword);
    }

    static void jdoSetisMustResetPassword(HbgbUser objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 4, (Object)objPC.isMustResetPassword, (Object)val);
            return;
        }
        objPC.isMustResetPassword = val;
    }

    static String jdoGetlastName(HbgbUser objPC) {
        if (objPC.jdoFlags <= 0) return objPC.lastName;
        if (objPC.jdoStateManager == null) return objPC.lastName;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 5)) return objPC.lastName;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 5, objPC.lastName);
    }

    static void jdoSetlastName(HbgbUser objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 5, objPC.lastName, val);
            return;
        }
        objPC.lastName = val;
    }

    static String jdoGetpassword(HbgbUser objPC) {
        if (objPC.jdoFlags <= 0) return objPC.password;
        if (objPC.jdoStateManager == null) return objPC.password;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 6)) return objPC.password;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 6, objPC.password);
    }

    static void jdoSetpassword(HbgbUser objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 6, objPC.password, val);
            return;
        }
        objPC.password = val;
    }

    static String jdoGetplayaName(HbgbUser objPC) {
        if (objPC.jdoFlags <= 0) return objPC.playaName;
        if (objPC.jdoStateManager == null) return objPC.playaName;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 7)) return objPC.playaName;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 7, objPC.playaName);
    }

    static void jdoSetplayaName(HbgbUser objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 7, objPC.playaName, val);
            return;
        }
        objPC.playaName = val;
    }

    static SecurityRole jdoGetsecurityRole(HbgbUser objPC) {
        if (objPC.jdoFlags <= 0) return objPC.securityRole;
        if (objPC.jdoStateManager == null) return objPC.securityRole;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 8)) return objPC.securityRole;
        return (SecurityRole)((Object)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 8, (Object)objPC.securityRole));
    }

    static void jdoSetsecurityRole(HbgbUser objPC, SecurityRole val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 8, (Object)objPC.securityRole, (Object)val);
            return;
        }
        objPC.securityRole = val;
    }
}

