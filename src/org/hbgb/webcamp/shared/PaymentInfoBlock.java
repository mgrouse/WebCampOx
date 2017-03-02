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
import org.hbgb.webcamp.shared.enums.TicketType;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.APPLICATION)
public class PaymentInfoBlock
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
    private Boolean hasTicket = false;
    @Persistent
    private TicketType ticketType;
    @Persistent
    private Boolean hasBeenInvoiced = false;
    @Persistent
    private Boolean hasPaidDues = false;
    @Persistent
    private Date paidDate;
    @Persistent
    private Boolean wasHeeBeeSubsidized = false;
    @Persistent
    private Integer subsidyAmt = 0;
    @Persistent
    private String subsidyReason = "";
    protected transient StateManager jdoStateManager;
    protected transient byte jdoFlags;
    private static final byte[] jdoFieldFlags;
    private static final Class jdoPersistenceCapableSuperclass;
    private static final Class[] jdoFieldTypes;
    private static final String[] jdoFieldNames;
    private static final int jdoInheritedFieldCount;
    private static final long serialVersionUID = -1263245533748327311L;

    public PaymentInfoBlock() {
    }

    public PaymentInfoBlock(String emailText) {
        this.setEmail(emailText);
    }

    public PaymentInfoBlock(String email, PaymentInfoBlock source) {
        if (source != null) {
            this.setEmail(source.getEmail());
            return;
        }
        this.setEmail(email);
    }

    public String getEncodedKey() {
        return PaymentInfoBlock.jdoGetencodedKey(this);
    }

    public void setEncodedKey(String encodedKey) {
        PaymentInfoBlock.jdoSetencodedKey(this, encodedKey);
    }

    public String getEmail() {
        return PaymentInfoBlock.jdoGetemail(this);
    }

    public void setEmail(String email) {
        PaymentInfoBlock.jdoSetemail(this, email);
    }

    public Boolean getHasTicket() {
        return PaymentInfoBlock.jdoGethasTicket(this);
    }

    public void setHasTicket(Boolean hasTicket) {
        PaymentInfoBlock.jdoSethasTicket(this, hasTicket);
    }

    public TicketType getTicketType() {
        return PaymentInfoBlock.jdoGetticketType(this);
    }

    public void setTicketType(TicketType ticketType) {
        PaymentInfoBlock.jdoSetticketType(this, ticketType);
    }

    public Boolean getHasBeenInvoiced() {
        return PaymentInfoBlock.jdoGethasBeenInvoiced(this);
    }

    public void setHasBeenInvoiced(Boolean hasBeenInvoiced) {
        PaymentInfoBlock.jdoSethasBeenInvoiced(this, hasBeenInvoiced);
    }

    public Boolean getHasPaidDues() {
        return PaymentInfoBlock.jdoGethasPaidDues(this);
    }

    public void setHasPaidDues(Boolean hasPaidDues) {
        PaymentInfoBlock.jdoSethasPaidDues(this, hasPaidDues);
    }

    public Date getPaidDate() {
        return PaymentInfoBlock.jdoGetpaidDate(this);
    }

    public void setPaidDate(Date paidDate) {
        PaymentInfoBlock.jdoSetpaidDate(this, paidDate);
    }

    public Boolean getWasHeeBeeSubsidized() {
        return PaymentInfoBlock.jdoGetwasHeeBeeSubsidized(this);
    }

    public void setWasHeeBeeSubsidized(Boolean wasHeeBeeSubsidized) {
        PaymentInfoBlock.jdoSetwasHeeBeeSubsidized(this, wasHeeBeeSubsidized);
    }

    public Integer getSubsidyAmt() {
        return PaymentInfoBlock.jdoGetsubsidyAmt(this);
    }

    public void setSubsidyAmt(Integer subsidyAmt) {
        PaymentInfoBlock.jdoSetsubsidyAmt(this, subsidyAmt);
    }

    public String getSubsidyReason() {
        return PaymentInfoBlock.jdoGetsubsidyReason(this);
    }

    public void setSubsidyReason(String subsidyReason) {
        PaymentInfoBlock.jdoSetsubsidyReason(this, subsidyReason);
    }

    static {
        jdoFieldNames = PaymentInfoBlock.__jdoFieldNamesInit();
        jdoFieldTypes = PaymentInfoBlock.__jdoFieldTypesInit();
        jdoFieldFlags = PaymentInfoBlock.__jdoFieldFlagsInit();
        jdoInheritedFieldCount = PaymentInfoBlock.__jdoGetInheritedFieldCount();
        jdoPersistenceCapableSuperclass = PaymentInfoBlock.__jdoPersistenceCapableSuperclassInit();
        JDOImplHelper.registerClass((Class)PaymentInfoBlock.___jdo$loadClass("org.hbgb.webcamp.shared.PaymentInfoBlock"), (String[])jdoFieldNames, (Class[])jdoFieldTypes, (byte[])jdoFieldFlags, (Class)jdoPersistenceCapableSuperclass, (PersistenceCapable)new PaymentInfoBlock());
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
        PaymentInfoBlock result = new PaymentInfoBlock();
        result.jdoFlags = 1;
        result.jdoStateManager = sm;
        return result;
    }

    public PersistenceCapable jdoNewInstance(StateManager sm, Object obj) {
        PaymentInfoBlock result = new PaymentInfoBlock();
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
                this.hasBeenInvoiced = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 3: {
                this.hasPaidDues = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 4: {
                this.hasTicket = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 5: {
                this.paidDate = (Date)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 6: {
                this.subsidyAmt = (Integer)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
            case 7: {
                this.subsidyReason = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 8: {
                this.ticketType = (TicketType)((Object)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index));
                return;
            }
            case 9: {
                this.wasHeeBeeSubsidized = (Boolean)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
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
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.hasBeenInvoiced);
                return;
            }
            case 3: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.hasPaidDues);
                return;
            }
            case 4: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.hasTicket);
                return;
            }
            case 5: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.paidDate);
                return;
            }
            case 6: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.subsidyAmt);
                return;
            }
            case 7: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.subsidyReason);
                return;
            }
            case 8: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.ticketType);
                return;
            }
            case 9: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, (Object)this.wasHeeBeeSubsidized);
                return;
            }
        }
        throw new IllegalArgumentException(new StringBuffer("out of field index :").append(index).toString());
    }

    protected final void jdoCopyField(PaymentInfoBlock obj, int index) {
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
                this.hasBeenInvoiced = obj.hasBeenInvoiced;
                return;
            }
            case 3: {
                this.hasPaidDues = obj.hasPaidDues;
                return;
            }
            case 4: {
                this.hasTicket = obj.hasTicket;
                return;
            }
            case 5: {
                this.paidDate = obj.paidDate;
                return;
            }
            case 6: {
                this.subsidyAmt = obj.subsidyAmt;
                return;
            }
            case 7: {
                this.subsidyReason = obj.subsidyReason;
                return;
            }
            case 8: {
                this.ticketType = obj.ticketType;
                return;
            }
            case 9: {
                this.wasHeeBeeSubsidized = obj.wasHeeBeeSubsidized;
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
        if (!(obj instanceof PaymentInfoBlock)) {
            throw new IllegalArgumentException("object is not an object of type org.hbgb.webcamp.shared.PaymentInfoBlock");
        }
        PaymentInfoBlock other = (PaymentInfoBlock)obj;
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
        return new String[]{"email", "encodedKey", "hasBeenInvoiced", "hasPaidDues", "hasTicket", "paidDate", "subsidyAmt", "subsidyReason", "ticketType", "wasHeeBeeSubsidized"};
    }

    private static final Class[] __jdoFieldTypesInit() {
        return new Class[]{PaymentInfoBlock.___jdo$loadClass("java.lang.String"), PaymentInfoBlock.___jdo$loadClass("java.lang.String"), PaymentInfoBlock.___jdo$loadClass("java.lang.Boolean"), PaymentInfoBlock.___jdo$loadClass("java.lang.Boolean"), PaymentInfoBlock.___jdo$loadClass("java.lang.Boolean"), PaymentInfoBlock.___jdo$loadClass("java.util.Date"), PaymentInfoBlock.___jdo$loadClass("java.lang.Integer"), PaymentInfoBlock.___jdo$loadClass("java.lang.String"), PaymentInfoBlock.___jdo$loadClass("org.hbgb.webcamp.shared.enums.TicketType"), PaymentInfoBlock.___jdo$loadClass("java.lang.Boolean")};
    }

    private static final byte[] __jdoFieldFlagsInit() {
        return new byte[]{21, 24, 21, 21, 21, 21, 21, 21, 21, 21};
    }

    protected static int __jdoGetInheritedFieldCount() {
        return 0;
    }

    protected static int jdoGetManagedFieldCount() {
        return 10;
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
        PaymentInfoBlock o = (PaymentInfoBlock)super.clone();
        o.jdoFlags = 0;
        o.jdoStateManager = null;
        return o;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        this.jdoPreSerialize();
        out.defaultWriteObject();
    }

    private static String jdoGetemail(PaymentInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.email;
        if (objPC.jdoStateManager == null) return objPC.email;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 0)) return objPC.email;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 0, objPC.email);
    }

    private static void jdoSetemail(PaymentInfoBlock objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 0, objPC.email, val);
            return;
        }
        objPC.email = val;
    }

    private static String jdoGetencodedKey(PaymentInfoBlock objPC) {
        return objPC.encodedKey;
    }

    private static void jdoSetencodedKey(PaymentInfoBlock objPC, String val) {
        if (objPC.jdoStateManager == null) {
            objPC.encodedKey = val;
            return;
        }
        objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 1, objPC.encodedKey, val);
    }

    private static Boolean jdoGethasBeenInvoiced(PaymentInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.hasBeenInvoiced;
        if (objPC.jdoStateManager == null) return objPC.hasBeenInvoiced;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 2)) return objPC.hasBeenInvoiced;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 2, (Object)objPC.hasBeenInvoiced);
    }

    private static void jdoSethasBeenInvoiced(PaymentInfoBlock objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 2, (Object)objPC.hasBeenInvoiced, (Object)val);
            return;
        }
        objPC.hasBeenInvoiced = val;
    }

    private static Boolean jdoGethasPaidDues(PaymentInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.hasPaidDues;
        if (objPC.jdoStateManager == null) return objPC.hasPaidDues;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 3)) return objPC.hasPaidDues;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 3, (Object)objPC.hasPaidDues);
    }

    private static void jdoSethasPaidDues(PaymentInfoBlock objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 3, (Object)objPC.hasPaidDues, (Object)val);
            return;
        }
        objPC.hasPaidDues = val;
    }

    private static Boolean jdoGethasTicket(PaymentInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.hasTicket;
        if (objPC.jdoStateManager == null) return objPC.hasTicket;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 4)) return objPC.hasTicket;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 4, (Object)objPC.hasTicket);
    }

    private static void jdoSethasTicket(PaymentInfoBlock objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 4, (Object)objPC.hasTicket, (Object)val);
            return;
        }
        objPC.hasTicket = val;
    }

    private static Date jdoGetpaidDate(PaymentInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.paidDate;
        if (objPC.jdoStateManager == null) return objPC.paidDate;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 5)) return objPC.paidDate;
        return (Date)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 5, (Object)objPC.paidDate);
    }

    private static void jdoSetpaidDate(PaymentInfoBlock objPC, Date val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 5, (Object)objPC.paidDate, (Object)val);
            return;
        }
        objPC.paidDate = val;
    }

    private static Integer jdoGetsubsidyAmt(PaymentInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.subsidyAmt;
        if (objPC.jdoStateManager == null) return objPC.subsidyAmt;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 6)) return objPC.subsidyAmt;
        return (Integer)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 6, (Object)objPC.subsidyAmt);
    }

    private static void jdoSetsubsidyAmt(PaymentInfoBlock objPC, Integer val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 6, (Object)objPC.subsidyAmt, (Object)val);
            return;
        }
        objPC.subsidyAmt = val;
    }

    private static String jdoGetsubsidyReason(PaymentInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.subsidyReason;
        if (objPC.jdoStateManager == null) return objPC.subsidyReason;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 7)) return objPC.subsidyReason;
        return objPC.jdoStateManager.getStringField((PersistenceCapable)objPC, 7, objPC.subsidyReason);
    }

    private static void jdoSetsubsidyReason(PaymentInfoBlock objPC, String val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 7, objPC.subsidyReason, val);
            return;
        }
        objPC.subsidyReason = val;
    }

    private static TicketType jdoGetticketType(PaymentInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.ticketType;
        if (objPC.jdoStateManager == null) return objPC.ticketType;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 8)) return objPC.ticketType;
        return (TicketType)((Object)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 8, (Object)objPC.ticketType));
    }

    private static void jdoSetticketType(PaymentInfoBlock objPC, TicketType val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 8, (Object)objPC.ticketType, (Object)val);
            return;
        }
        objPC.ticketType = val;
    }

    private static Boolean jdoGetwasHeeBeeSubsidized(PaymentInfoBlock objPC) {
        if (objPC.jdoFlags <= 0) return objPC.wasHeeBeeSubsidized;
        if (objPC.jdoStateManager == null) return objPC.wasHeeBeeSubsidized;
        if (objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 9)) return objPC.wasHeeBeeSubsidized;
        return (Boolean)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 9, (Object)objPC.wasHeeBeeSubsidized);
    }

    private static void jdoSetwasHeeBeeSubsidized(PaymentInfoBlock objPC, Boolean val) {
        if (objPC.jdoFlags != 0 && objPC.jdoStateManager != null) {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 9, (Object)objPC.wasHeeBeeSubsidized, (Object)val);
            return;
        }
        objPC.wasHeeBeeSubsidized = val;
    }
}

