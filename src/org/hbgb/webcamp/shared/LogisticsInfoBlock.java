/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
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

import com.google.gwt.user.client.rpc.IsSerializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
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
import org.hbgb.webcamp.shared.enums.DayOfEvent;
import org.hbgb.webcamp.shared.enums.PlayaTime;
import org.hbgb.webcamp.shared.enums.Transportation;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.APPLICATION)
public class LogisticsInfoBlock
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
    private Boolean wantsEarlyTeam = false;
    @Persistent
    private Boolean isAssignedEarlyTeam = false;
    @Persistent
    private Boolean wantsStrikeTeam = false;
    @Persistent
    private Transportation transType;
    @Persistent
    private Date arrivalDate;
    @Persistent
    private DayOfEvent arrivalDoE;
    @Persistent
    private PlayaTime arrivalTime;
    @Persistent
    private Date departureDate;
    @Persistent
    private DayOfEvent departureDoE;
    @Persistent
    private PlayaTime departureTime;
    protected transient StateManager jdoStateManager;
    protected transient byte jdoFlags;
    private static final byte[] jdoFieldFlags;
    private static final Class jdoPersistenceCapableSuperclass;
    private static final Class[] jdoFieldTypes;
    private static final String[] jdoFieldNames;
    private static final int jdoInheritedFieldCount;
    private static final long serialVersionUID = -2829708682191285958L;

    public LogisticsInfoBlock() {
    }

    public LogisticsInfoBlock(String emailText) {
        this.setEmail(emailText);
    }

    public String getEncodedKey() {
        return LogisticsInfoBlock.jdoGetencodedKey(this);
    }

    public void setEncodedKey(String encodedKey) {
        LogisticsInfoBlock.jdoSetencodedKey(this, encodedKey);
    }

    public String getEmail() {
        return LogisticsInfoBlock.jdoGetemail(this);
    }

    public void setEmail(String email) {
        LogisticsInfoBlock.jdoSetemail(this, email);
    }

    public Boolean getIsProfile() {
        return LogisticsInfoBlock.jdoGetisProfile(this);
    }

    public void setIsProfile(Boolean isProfile) {
        LogisticsInfoBlock.jdoSetisProfile(this, isProfile);
    }

    public Boolean getWantsEarlyTeam() {
        return LogisticsInfoBlock.jdoGetwantsEarlyTeam(this);
    }

    public void setWantsEarlyTeam(Boolean wantsEarlyTeam) {
        LogisticsInfoBlock.jdoSetwantsEarlyTeam(this, wantsEarlyTeam);
    }

    public Boolean getIsAssignedEarlyTeam() {
        return LogisticsInfoBlock.jdoGetisAssignedEarlyTeam(this);
    }

    public void setIsAssignedEarlyTeam(Boolean isAssignedEarlyTeam) {
        LogisticsInfoBlock.jdoSetisAssignedEarlyTeam(this, isAssignedEarlyTeam);
    }

    public Boolean getWantsStrikeTeam() {
        return LogisticsInfoBlock.jdoGetwantsStrikeTeam(this);
    }

    public void setWantsStrikeTeam(Boolean wantsStrikeTeam) {
        LogisticsInfoBlock.jdoSetwantsStrikeTeam(this, wantsStrikeTeam);
    }

    public Transportation getTransType() {
        return LogisticsInfoBlock.jdoGettransType(this);
    }

    public void setTransType(Transportation transType) {
        LogisticsInfoBlock.jdoSettransType(this, transType);
    }

    @Deprecated
    public Date getArrivalDate() {
        return LogisticsInfoBlock.jdoGetarrivalDate(this);
    }

    @Deprecated
    public void setArrivalDate(Date arrivalDate) {
        LogisticsInfoBlock.jdoSetarrivalDate(this, arrivalDate);
    }

    public PlayaTime getArrivalTime() {
        return LogisticsInfoBlock.jdoGetarrivalTime(this);
    }

    public void setArrivalTime(PlayaTime arrivalTime) {
        LogisticsInfoBlock.jdoSetarrivalTime(this, arrivalTime);
    }

    @Deprecated
    public Date getDepartureDate() {
        return LogisticsInfoBlock.jdoGetdepartureDate(this);
    }

    @Deprecated
    public void setDepartureDate(Date departureDate) {
        LogisticsInfoBlock.jdoSetdepartureDate(this, departureDate);
    }

    public PlayaTime getDepartureTime() {
        return LogisticsInfoBlock.jdoGetdepartureTime(this);
    }

    public void setDepartureTime(PlayaTime departureTime) {
        LogisticsInfoBlock.jdoSetdepartureTime(this, departureTime);
    }

    public DayOfEvent getArrivalDoE() {
        return LogisticsInfoBlock.jdoGetarrivalDoE(this);
    }

    public void setArrivalDoE(DayOfEvent arrivalDoE) {
        LogisticsInfoBlock.jdoSetarrivalDoE(this, arrivalDoE);
    }

    public DayOfEvent getDepartureDoE() {
        return LogisticsInfoBlock.jdoGetdepartureDoE(this);
    }

    public void setDepartureDoE(DayOfEvent departureDoE) {
        LogisticsInfoBlock.jdoSetdepartureDoE(this, departureDoE);
    }

    static {
        jdoFieldNames = LogisticsInfoBlock.__jdoFieldNamesInit();
        jdoFieldTypes = LogisticsInfoBlock.__jdoFieldTypesInit();
        jdoFieldFlags = LogisticsInfoBlock.__jdoFieldFlagsInit();
        jdoInheritedFieldCount = LogisticsInfoBlock.__jdoGetInheritedFieldCount();
        jdoPersistenceCapableSuperclass = LogisticsInfoBlock.__jdoPersistenceCapableSuperclassInit();
        JDOImplHelper.registerClass((Class)LogisticsInfoBlock.___jdo$loadClass("org.hbgb.webcamp.shared.LogisticsInfoBlock"), (String[])jdoFieldNames, (Class[])jdoFieldTypes, (byte[])jdoFieldFlags, (Class)jdoPersistenceCapableSuperclass, (PersistenceCapable)new LogisticsInfoBlock());
    }

    public void jdoCopyKeyFieldsFromObjectId(PersistenceCapable.ObjectIdFieldConsumer fc, Object oid) {
        if (fc == null) {
            throw new IllegalArgumentException("ObjectIdFieldConsumer is null");
        }
        if (!(oid instanceof StringIdentity)) {
            throw new ClassCastException("oid is not instanceof javax.jdo.identity.StringIdentity");
        }
        StringIdentity o = (StringIdentity)oid;
        fc.storeStringField(7, o.getKey());
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
        LogisticsInfoBlock result = new LogisticsInfoBlock();
        result.jdoFlags = 1;
        result.jdoStateManager = sm;
        return result;
    }

    public PersistenceCapable jdoNewInstance(StateManager sm, Object obj) {
        LogisticsInfoBlock result = new LogisticsInfoBlock();
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
                this.arrivalDate = (Date)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 1: {
                this.arrivalDoE = (DayOfEvent)((Object)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index));
                return;
            }
            case 2: {
                this.arrivalTime = (PlayaTime)((Object)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index));
                return;
            }
            case 3: {
                this.departureDate = (Date)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 4: {
                this.departureDoE = (DayOfEvent)((Object)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index));
                return;
            }
            case 5: {
                this.departureTime = (PlayaTime)((Object)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index));
                return;
            }
            case 6: {
                this.email = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 7: {
                this.encodedKey = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 8: {
                this.isAssignedEarlyTeam = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 9: {
                this.isProfile = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 10: {
                this.transType = (Transportation)((Object)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index));
                return;
            }
            case 11: {
                this.wantsEarlyTeam = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 12: {
                this.wantsStrikeTeam = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
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
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.arrivalDate);
                return;
            }
            case 1: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.arrivalDoE);
                return;
            }
            case 2: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.arrivalTime);
                return;
            }
            case 3: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.departureDate);
                return;
            }
            case 4: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.departureDoE);
                return;
            }
            case 5: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.departureTime);
                return;
            }
            case 6: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.email);
                return;
            }
            case 7: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.encodedKey);
                return;
            }
            case 8: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.isAssignedEarlyTeam);
                return;
            }
            case 9: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.isProfile);
                return;
            }
            case 10: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.transType);
                return;
            }
            case 11: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.wantsEarlyTeam);
                return;
            }
            case 12: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.wantsStrikeTeam);
                return;
            }
        }
        throw new IllegalArgumentException(new StringBuffer("out of field index :").append(index).toString());
    }

    protected final void jdoCopyField(LogisticsInfoBlock obj, int index) {
        switch (index) {
            case 0: {
                this.arrivalDate = obj.arrivalDate;
                return;
            }
            case 1: {
                this.arrivalDoE = obj.arrivalDoE;
                return;
            }
            case 2: {
                this.arrivalTime = obj.arrivalTime;
                return;
            }
            case 3: {
                this.departureDate = obj.departureDate;
                return;
            }
            case 4: {
                this.departureDoE = obj.departureDoE;
                return;
            }
            case 5: {
                this.departureTime = obj.departureTime;
                return;
            }
            case 6: {
                this.email = obj.email;
                return;
            }
            case 7: {
                this.encodedKey = obj.encodedKey;
                return;
            }
            case 8: {
                this.isAssignedEarlyTeam = obj.isAssignedEarlyTeam;
                return;
            }
            case 9: {
                this.isProfile = obj.isProfile;
                return;
            }
            case 10: {
                this.transType = obj.transType;
                return;
            }
            case 11: {
                this.wantsEarlyTeam = obj.wantsEarlyTeam;
                return;
            }
            case 12: {
                this.wantsStrikeTeam = obj.wantsStrikeTeam;
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
        if (!(obj instanceof LogisticsInfoBlock)) {
            throw new IllegalArgumentException("object is not an object of type org.hbgb.webcamp.shared.LogisticsInfoBlock");
        }
        LogisticsInfoBlock other = (LogisticsInfoBlock)obj;
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
        return new String[]{"arrivalDate", "arrivalDoE", "arrivalTime", "departureDate", "departureDoE", "departureTime", "email", "encodedKey", "isAssignedEarlyTeam", "isProfile", "transType", "wantsEarlyTeam", "wantsStrikeTeam"};
    }

    private static final Class[] __jdoFieldTypesInit() {
        return new Class[]{LogisticsInfoBlock.___jdo$loadClass("java.util.Date"), LogisticsInfoBlock.___jdo$loadClass("org.hbgb.webcamp.shared.enums.DayOfEvent"), LogisticsInfoBlock.___jdo$loadClass("org.hbgb.webcamp.shared.enums.PlayaTime"), LogisticsInfoBlock.___jdo$loadClass("java.util.Date"), LogisticsInfoBlock.___jdo$loadClass("org.hbgb.webcamp.shared.enums.DayOfEvent"), LogisticsInfoBlock.___jdo$loadClass("org.hbgb.webcamp.shared.enums.PlayaTime"), LogisticsInfoBlock.___jdo$loadClass("java.lang.String"), LogisticsInfoBlock.___jdo$loadClass("java.lang.String"), LogisticsInfoBlock.___jdo$loadClass("java.lang.Boolean"), LogisticsInfoBlock.___jdo$loadClass("java.lang.Boolean"), LogisticsInfoBlock.___jdo$loadClass("org.hbgb.webcamp.shared.enums.Transportation"), LogisticsInfoBlock.___jdo$loadClass("java.lang.Boolean"), LogisticsInfoBlock.___jdo$loadClass("java.lang.Boolean")};
    }

    private static final byte[] __jdoFieldFlagsInit() {
        return new byte[]{21, 21, 21, 21, 21, 21, 21, 24, 21, 21, 21, 21, 21};
    }

    protected static int __jdoGetInheritedFieldCount() {
        return 0;
    }

    protected static int jdoGetManagedFieldCount() {
        return 13;
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
        LogisticsInfoBlock o = (LogisticsInfoBlock)super.clone();
        o.jdoFlags = 0;
        o.jdoStateManager = null;
        return o;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        this.jdoPreSerialize();
        out.defaultWriteObject();
    }

    private static Date jdoGetarrivalDate(LogisticsInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.arrivalDate;
        if (objPC.jdoStateManager == null) return objPC.arrivalDate;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 0)) return objPC.arrivalDate;
        return (Date)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 0, (Object)objPC.arrivalDate);
    }

    private static void jdoSetarrivalDate(LogisticsInfoBlock objPC, Date val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 0, (Object)objPC.arrivalDate, (Object)val);
            return;
        }
        objPC.arrivalDate = val;
    }

    private static DayOfEvent jdoGetarrivalDoE(LogisticsInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.arrivalDoE;
        if (objPC.jdoStateManager == null) return objPC.arrivalDoE;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 1)) return objPC.arrivalDoE;
        return (DayOfEvent)((Object)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 1, (Object)objPC.arrivalDoE));
    }

    private static void jdoSetarrivalDoE(LogisticsInfoBlock objPC, DayOfEvent val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 1, (Object)objPC.arrivalDoE, (Object)val);
            return;
        }
        objPC.arrivalDoE = val;
    }

    private static PlayaTime jdoGetarrivalTime(LogisticsInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.arrivalTime;
        if (objPC.jdoStateManager == null) return objPC.arrivalTime;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 2)) return objPC.arrivalTime;
        return (PlayaTime)((Object)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 2, (Object)objPC.arrivalTime));
    }

    private static void jdoSetarrivalTime(LogisticsInfoBlock objPC, PlayaTime val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 2, (Object)objPC.arrivalTime, (Object)val);
            return;
        }
        objPC.arrivalTime = val;
    }

    private static Date jdoGetdepartureDate(LogisticsInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.departureDate;
        if (objPC.jdoStateManager == null) return objPC.departureDate;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 3)) return objPC.departureDate;
        return (Date)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 3, (Object)objPC.departureDate);
    }

    private static void jdoSetdepartureDate(LogisticsInfoBlock objPC, Date val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 3, (Object)objPC.departureDate, (Object)val);
            return;
        }
        objPC.departureDate = val;
    }

    private static DayOfEvent jdoGetdepartureDoE(LogisticsInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.departureDoE;
        if (objPC.jdoStateManager == null) return objPC.departureDoE;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 4)) return objPC.departureDoE;
        return (DayOfEvent)((Object)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 4, (Object)objPC.departureDoE));
    }

    private static void jdoSetdepartureDoE(LogisticsInfoBlock objPC, DayOfEvent val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 4, (Object)objPC.departureDoE, (Object)val);
            return;
        }
        objPC.departureDoE = val;
    }

    private static PlayaTime jdoGetdepartureTime(LogisticsInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.departureTime;
        if (objPC.jdoStateManager == null) return objPC.departureTime;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 5)) return objPC.departureTime;
        return (PlayaTime)((Object)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 5, (Object)objPC.departureTime));
    }

    private static void jdoSetdepartureTime(LogisticsInfoBlock objPC, PlayaTime val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 5, (Object)objPC.departureTime, (Object)val);
            return;
        }
        objPC.departureTime = val;
    }

    private static String jdoGetemail(LogisticsInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.email;
        if (objPC.jdoStateManager == null) return objPC.email;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 6)) return objPC.email;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 6, objPC.email);
    }

    private static void jdoSetemail(LogisticsInfoBlock objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 6, objPC.email, val);
            return;
        }
        objPC.email = val;
    }

    private static String jdoGetencodedKey(LogisticsInfoBlock objPC) {
        return objPC.encodedKey;
    }

    private static void jdoSetencodedKey(LogisticsInfoBlock objPC, String val) {
        if (objPC.jdoStateManager == null) {
            objPC.encodedKey = val;
            return;
        }
        objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 7, objPC.encodedKey, val);
    }

    private static Boolean jdoGetisAssignedEarlyTeam(LogisticsInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.isAssignedEarlyTeam;
        if (objPC.jdoStateManager == null) return objPC.isAssignedEarlyTeam;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 8)) return objPC.isAssignedEarlyTeam;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 8, (Object)objPC.isAssignedEarlyTeam);
    }

    private static void jdoSetisAssignedEarlyTeam(LogisticsInfoBlock objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 8, (Object)objPC.isAssignedEarlyTeam, (Object)val);
            return;
        }
        objPC.isAssignedEarlyTeam = val;
    }

    private static Boolean jdoGetisProfile(LogisticsInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.isProfile;
        if (objPC.jdoStateManager == null) return objPC.isProfile;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 9)) return objPC.isProfile;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 9, (Object)objPC.isProfile);
    }

    private static void jdoSetisProfile(LogisticsInfoBlock objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 9, (Object)objPC.isProfile, (Object)val);
            return;
        }
        objPC.isProfile = val;
    }

    private static Transportation jdoGettransType(LogisticsInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.transType;
        if (objPC.jdoStateManager == null) return objPC.transType;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 10)) return objPC.transType;
        return (Transportation)((Object)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 10, (Object)objPC.transType));
    }

    private static void jdoSettransType(LogisticsInfoBlock objPC, Transportation val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 10, (Object)objPC.transType, (Object)val);
            return;
        }
        objPC.transType = val;
    }

    private static Boolean jdoGetwantsEarlyTeam(LogisticsInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.wantsEarlyTeam;
        if (objPC.jdoStateManager == null) return objPC.wantsEarlyTeam;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 11)) return objPC.wantsEarlyTeam;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 11, (Object)objPC.wantsEarlyTeam);
    }

    private static void jdoSetwantsEarlyTeam(LogisticsInfoBlock objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 11, (Object)objPC.wantsEarlyTeam, (Object)val);
            return;
        }
        objPC.wantsEarlyTeam = val;
    }

    private static Boolean jdoGetwantsStrikeTeam(LogisticsInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.wantsStrikeTeam;
        if (objPC.jdoStateManager == null) return objPC.wantsStrikeTeam;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 12)) return objPC.wantsStrikeTeam;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 12, (Object)objPC.wantsStrikeTeam);
    }

    private static void jdoSetwantsStrikeTeam(LogisticsInfoBlock objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 12, (Object)objPC.wantsStrikeTeam, (Object)val);
            return;
        }
        objPC.wantsStrikeTeam = val;
    }
}

