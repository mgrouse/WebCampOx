/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.jdo.JDODetachedFieldAccessException
 *  javax.jdo.annotations.Extension
 *  javax.jdo.annotations.IdGeneratorStrategy
 *  javax.jdo.annotations.IdentityType
 *  javax.jdo.annotations.Inheritance
 *  javax.jdo.annotations.PersistenceCapable
 *  javax.jdo.annotations.Persistent
 *  javax.jdo.annotations.PrimaryKey
 *  javax.jdo.spi.Detachable
 *  javax.jdo.spi.JDOImplHelper
 *  javax.jdo.spi.PersistenceCapable
 *  javax.jdo.spi.StateManager
 */
package org.hbgb.webcamp.shared;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.List;
import javax.jdo.JDODetachedFieldAccessException;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.spi.Detachable;
import javax.jdo.spi.JDOImplHelper;
import javax.jdo.spi.PersistenceCapable;
import javax.jdo.spi.StateManager;
import org.hbgb.webcamp.shared.Burner;
import org.hbgb.webcamp.shared.HeeBeeHistoryRecord;

@javax.jdo.annotations.PersistenceCapable(detachable="true", identityType=IdentityType.APPLICATION)
@Inheritance(customStrategy="complete-table")
public class HeeBee
extends Burner
implements Serializable,
Detachable,
PersistenceCapable {
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;
    @Persistent
    private List<HeeBeeHistoryRecord> history;
    private static final byte[] jdoFieldFlags;
    private static final Class jdoPersistenceCapableSuperclass;
    private static final Class[] jdoFieldTypes;
    private static final String[] jdoFieldNames;
    private static final int jdoInheritedFieldCount;
    private static final long serialVersionUID = 2620854956006703746L;

    static {
        jdoFieldNames = HeeBee.__jdoFieldNamesInit();
        jdoFieldTypes = HeeBee.__jdoFieldTypesInit();
        jdoFieldFlags = HeeBee.__jdoFieldFlagsInit();
        jdoInheritedFieldCount = HeeBee.__jdoGetInheritedFieldCount();
        jdoPersistenceCapableSuperclass = HeeBee.__jdoPersistenceCapableSuperclassInit();
        JDOImplHelper.registerClass((Class)HeeBee.___jdo$loadClass("org.hbgb.webcamp.shared.HeeBee"), (String[])jdoFieldNames, (Class[])jdoFieldTypes, (byte[])jdoFieldFlags, (Class)jdoPersistenceCapableSuperclass, (PersistenceCapable)new HeeBee());
    }

    @Override
    public void jdoMakeDirty(String fieldName) {
        if (this.jdoStateManager != null) {
            this.jdoStateManager.makeDirty((PersistenceCapable)this, fieldName);
        }
        if (this.jdoIsDetached() && fieldName != null) {
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
        super.jdoMakeDirty(fieldName);
    }

    @Override
    public boolean jdoIsDetached() {
        if (this.jdoStateManager != null) return false;
        if (this.jdoDetachedState == null) return false;
        return true;
    }

    @Override
    public PersistenceCapable jdoNewInstance(StateManager sm) {
        HeeBee result = new HeeBee();
        result.jdoFlags = 1;
        result.jdoStateManager = sm;
        return result;
    }

    @Override
    public PersistenceCapable jdoNewInstance(StateManager sm, Object obj) {
        HeeBee result = new HeeBee();
        result.jdoFlags = 1;
        result.jdoStateManager = sm;
        result.jdoCopyKeyFieldsFromObjectId(obj);
        return result;
    }

    @Override
    public void jdoReplaceField(int index) {
        if (this.jdoStateManager == null) {
            throw new IllegalStateException("state manager is null");
        }
        switch (index - jdoInheritedFieldCount) {
            case 0: {
                this.encodedKey = this.jdoStateManager.replacingStringField((PersistenceCapable)this, index);
                return;
            }
            case 1: {
                this.history = (List)this.jdoStateManager.replacingObjectField((PersistenceCapable)this, index);
                return;
            }
        }
        super.jdoReplaceField(index);
    }

    @Override
    public void jdoProvideField(int index) {
        if (this.jdoStateManager == null) {
            throw new IllegalStateException("state manager is null");
        }
        switch (index - jdoInheritedFieldCount) {
            case 0: {
                this.jdoStateManager.providedStringField((PersistenceCapable)this, index, this.encodedKey);
                return;
            }
            case 1: {
                this.jdoStateManager.providedObjectField((PersistenceCapable)this, index, this.history);
                return;
            }
        }
        super.jdoProvideField(index);
    }

    protected final void jdoCopyField(HeeBee obj, int index) {
        switch (index - jdoInheritedFieldCount) {
            case 0: {
                this.encodedKey = obj.encodedKey;
                return;
            }
            case 1: {
                this.history = obj.history;
                return;
            }
        }
        super.jdoCopyField(obj, index);
    }

    @Override
    public void jdoCopyFields(Object obj, int[] indices) {
        if (this.jdoStateManager == null) {
            throw new IllegalStateException("state manager is null");
        }
        if (indices == null) {
            throw new IllegalStateException("fieldNumbers is null");
        }
        if (!(obj instanceof HeeBee)) {
            throw new IllegalArgumentException("object is not an object of type org.hbgb.webcamp.shared.HeeBee");
        }
        HeeBee other = (HeeBee)obj;
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
        return new String[]{"encodedKey", "history"};
    }

    private static final Class[] __jdoFieldTypesInit() {
        return new Class[]{HeeBee.___jdo$loadClass("java.lang.String"), HeeBee.___jdo$loadClass("java.util.List")};
    }

    private static final byte[] __jdoFieldFlagsInit() {
        return new byte[]{24, 10};
    }

    protected static int __jdoGetInheritedFieldCount() {
        return Burner.jdoGetManagedFieldCount();
    }

    protected static int jdoGetManagedFieldCount() {
        return 2 + Burner.jdoGetManagedFieldCount();
    }

    private static Class __jdoPersistenceCapableSuperclassInit() {
        return HeeBee.___jdo$loadClass("org.hbgb.webcamp.shared.Burner");
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
        HeeBee o = (HeeBee)super.clone();
        o.jdoFlags = 0;
        o.jdoStateManager = null;
        return o;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        this.jdoPreSerialize();
        out.defaultWriteObject();
    }

    private static String jdoGetencodedKey(HeeBee objPC) {
        return objPC.encodedKey;
    }

    private static void jdoSetencodedKey(HeeBee objPC, String val) {
        if (objPC.jdoStateManager == null) {
            objPC.encodedKey = val;
        } else {
            objPC.jdoStateManager.setStringField((PersistenceCapable)objPC, 0 + jdoInheritedFieldCount, objPC.encodedKey, val);
        }
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(0 + jdoInheritedFieldCount);
    }

    private static List jdoGethistory(HeeBee objPC) {
        if (objPC.jdoStateManager != null && !objPC.jdoStateManager.isLoaded((PersistenceCapable)objPC, 1 + jdoInheritedFieldCount)) {
            return (List)objPC.jdoStateManager.getObjectField((PersistenceCapable)objPC, 1 + jdoInheritedFieldCount, objPC.history);
        }
        if (!objPC.jdoIsDetached()) return objPC.history;
        if (((BitSet)objPC.jdoDetachedState[2]).get(1 + jdoInheritedFieldCount)) return objPC.history;
        if (((BitSet)objPC.jdoDetachedState[3]).get(1 + jdoInheritedFieldCount)) return objPC.history;
        throw new JDODetachedFieldAccessException("You have just attempted to access field \"history\" yet this field was not detached when you detached the object. Either dont access this field, or detach it when detaching the object.");
    }

    private static void jdoSethistory(HeeBee objPC, List val) {
        if (objPC.jdoStateManager == null) {
            objPC.history = val;
        } else {
            objPC.jdoStateManager.setObjectField((PersistenceCapable)objPC, 1 + jdoInheritedFieldCount, objPC.history, (Object)val);
        }
        if (!objPC.jdoIsDetached()) return;
        ((BitSet)objPC.jdoDetachedState[3]).set(1 + jdoInheritedFieldCount);
    }
}

