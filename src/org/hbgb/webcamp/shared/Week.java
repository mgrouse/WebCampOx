/*
 * Decompiled with CFR 0_115.
 */
package org.hbgb.webcamp.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hbgb.webcamp.shared.Day;
import org.hbgb.webcamp.shared.MealsInfo;
import org.hbgb.webcamp.shared.enums.DayOfEvent;

public class Week
implements Serializable {
    private List<Day> days;
    private String name;

    public Week() {
        this.days = new ArrayList<Day>();
        this.name = "";
    }

    public Week(String name, DayOfEvent begin, DayOfEvent end) {
        this.name = name;
        this.days = new ArrayList<Day>();
        int i = begin.ordinal();
        while (i <= end.ordinal()) {
            DayOfEvent dayOE = DayOfEvent.atIndex(i);
            Day day = new Day(dayOE);
            this.days.add(day);
            ++i;
        }
    }

    public void setDays(List<Day> list) {
        this.days.addAll(list);
    }

    public List<Day> getDays() {
        return this.days;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMealsInfo(MealsInfo mealsInfo) {
        for (Day day : this.days) {
            day.addMealInfo(mealsInfo);
        }
    }
}

