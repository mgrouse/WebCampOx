/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hbgb.webcamp.shared.Meal;
import org.hbgb.webcamp.shared.MealsInfo;
import org.hbgb.webcamp.shared.enums.DayOfEvent;
import org.hbgb.webcamp.shared.enums.DietType;
import org.hbgb.webcamp.shared.enums.PlayaTime;

public class Day
implements Serializable {
    private DayOfEvent today;
    private Meal breakfast;
    private Meal lunch;
    private Meal dinner;
    private String restrictions;
    private static /* synthetic */ int[] $SWITCH_TABLE$org$hbgb$webcamp$shared$enums$PlayaTime;

    public Day() {
    }

    public Day(DayOfEvent date) {
        this.today = date;
        this.breakfast = new Meal("breakfast");
        this.lunch = new Meal("lunch");
        this.dinner = new Meal("dinner");
        this.restrictions = "[";
    }

    public void addMealInfo(MealsInfo mealsInfo) {
        if (this.today == mealsInfo.getArrivalDate()) {
            this.addAsBeginning(mealsInfo);
            return;
        }
        if (this.today == mealsInfo.getDepartureDate()) {
            this.addAsEnd(mealsInfo);
            return;
        }
        if (this.dateIsInTheMiddle(this.today, mealsInfo.getArrivalDate(), mealsInfo.getDepartureDate()) == false) return;
        this.addAsMiddle(mealsInfo);
    }

    public void addDietaryRestriction(String value) {
        if (value.isEmpty()) return;
        this.restrictions = String.valueOf(this.restrictions) + value + "]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[";
    }

    public String getRestrictions() {
        return this.restrictions;
    }

    public void setRestrictions(String value) {
        this.restrictions = value;
    }

    public void setBreakfast(Meal b) {
        this.breakfast = b;
    }

    public Meal getBreakfast() {
        return this.breakfast;
    }

    public DayOfEvent getToday() {
        return this.today;
    }

    public void setToday(DayOfEvent today) {
        this.today = today;
    }

    public Meal getLunch() {
        return this.lunch;
    }

    public void setLunch(Meal lunch) {
        this.lunch = lunch;
    }

    public Meal getDinner() {
        return this.dinner;
    }

    public void setDinner(Meal dinner) {
        this.dinner = dinner;
    }

    public List<Meal> getMeals() {
        ArrayList<Meal> list = new ArrayList<Meal>();
        list.add(this.breakfast);
        list.add(this.lunch);
        list.add(this.dinner);
        return list;
    }

    private void addAsBeginning(MealsInfo mealsInfo) {
        switch (Day.$SWITCH_TABLE$org$hbgb$webcamp$shared$enums$PlayaTime()[mealsInfo.getArrivalTime().ordinal()]) {
            case 1: {
                this.breakfast.incrementValueForDietType(mealsInfo.getDietType(), mealsInfo.getIsGlutenFree());
            }
            case 2: {
                this.lunch.incrementValueForDietType(mealsInfo.getDietType(), mealsInfo.getIsGlutenFree());
            }
            case 3: {
                this.dinner.incrementValueForDietType(mealsInfo.getDietType(), mealsInfo.getIsGlutenFree());
                this.addDietaryRestriction(mealsInfo.getDietaryRestrictions());
            }
            case 4: {
                break;
            }
        }
    }

    private void addAsEnd(MealsInfo mealsInfo) {
        switch (Day.$SWITCH_TABLE$org$hbgb$webcamp$shared$enums$PlayaTime()[mealsInfo.getDepartureTime().ordinal()]) {
            case 4: {
                this.dinner.incrementValueForDietType(mealsInfo.getDietType(), mealsInfo.getIsGlutenFree());
            }
            case 3: {
                this.lunch.incrementValueForDietType(mealsInfo.getDietType(), mealsInfo.getIsGlutenFree());
            }
            case 2: {
                this.breakfast.incrementValueForDietType(mealsInfo.getDietType(), mealsInfo.getIsGlutenFree());
                this.addDietaryRestriction(mealsInfo.getDietaryRestrictions());
            }
            case 1: {
                break;
            }
        }
    }

    private void addAsMiddle(MealsInfo mealsInfo) {
        Boolean gFree = false;
        if (mealsInfo.getIsGlutenFree() != null) {
            gFree = mealsInfo.getIsGlutenFree();
        }
        this.breakfast.incrementValueForDietType(mealsInfo.getDietType(), gFree);
        this.lunch.incrementValueForDietType(mealsInfo.getDietType(), gFree);
        this.dinner.incrementValueForDietType(mealsInfo.getDietType(), gFree);
        this.addDietaryRestriction(mealsInfo.getDietaryRestrictions());
    }

    private Boolean dateIsInTheMiddle(DayOfEvent date, DayOfEvent begin, DayOfEvent end) {
        if (begin.ordinal() >= date.ordinal()) return false;
        if (end.ordinal() <= date.ordinal()) return false;
        return true;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$hbgb$webcamp$shared$enums$PlayaTime() {
        int[] arrn;
        int[] arrn2 = $SWITCH_TABLE$org$hbgb$webcamp$shared$enums$PlayaTime;
        if (arrn2 != null) {
            return arrn2;
        }
        arrn = new int[PlayaTime.values().length];
        try {
            arrn[PlayaTime.after_dinner.ordinal()] = 4;
        }
        catch (NoSuchFieldError v1) {}
        try {
            arrn[PlayaTime.before_breakfast.ordinal()] = 1;
        }
        catch (NoSuchFieldError v2) {}
        try {
            arrn[PlayaTime.before_dinner.ordinal()] = 3;
        }
        catch (NoSuchFieldError v3) {}
        try {
            arrn[PlayaTime.before_lunch.ordinal()] = 2;
        }
        catch (NoSuchFieldError v4) {}
        $SWITCH_TABLE$org$hbgb$webcamp$shared$enums$PlayaTime = arrn;
        return $SWITCH_TABLE$org$hbgb$webcamp$shared$enums$PlayaTime;
    }
}

