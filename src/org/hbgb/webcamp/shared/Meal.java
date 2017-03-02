/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.shared;

import java.io.Serializable;
import org.hbgb.webcamp.shared.enums.DietType;

public class Meal
implements Serializable {
    private String name;
    private int[] dietNumbers = new int[DietType.values().length];
    private int glutenFreeNum = 0;

    public Meal() {
        new org.hbgb.webcamp.shared.Meal("");
    }

    public Meal(String name) {
        this.name = name;
    }

    public void incrementValueForDietType(DietType dt, boolean gFree) {
        int[] arrn = this.dietNumbers;
        int n = dt.ordinal();
        arrn[n] = arrn[n] + 1;
        if (!gFree) return;
        ++this.glutenFreeNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int[] getDietNumbers() {
        return this.dietNumbers;
    }

    public void setDietNumbers(int[] dietNumbers) {
        this.dietNumbers = dietNumbers;
    }

    public int getGlutenFreeNum() {
        return this.glutenFreeNum;
    }

    public void setGlutenFreeNum(int glutenFreeNum) {
        this.glutenFreeNum = glutenFreeNum;
    }
}

