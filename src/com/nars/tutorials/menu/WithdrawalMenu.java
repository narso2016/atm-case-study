package com.nars.tutorials.menu;

import java.util.HashMap;
import java.util.Map;

public enum WithdrawalMenu {
    FIRST(1, "$10"),
    SECOND (2, "$50"),
    THIRD(3, "$100"),
    FOURTH(4, "Other"),
    FIFTH(5, "Back");
    private final int statusValue;
    private final String statusType;

    private static final Map<Integer, WithdrawalMenu> lookup = new HashMap<>();
    static {
        for (WithdrawalMenu m : WithdrawalMenu.values())
            lookup.put(m.getStatusValue(), m);
    }

    private WithdrawalMenu get(Integer value){
        return lookup.get(value);
    }

    private WithdrawalMenu(int statusValue, String statusType){
        this.statusValue = statusValue;
        this.statusType = statusType;
    }

    public int getStatusValue() {
        return statusValue;
    }

    public String getStatusType() {
        return statusType;
    }

}
