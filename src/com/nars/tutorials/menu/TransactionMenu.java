package com.nars.tutorials.menu;

import java.util.HashMap;
import java.util.Map;

public enum TransactionMenu {
    WITHDRAWAL(1, "Withdrawal"), TRANSFER (2, "Fund Transfer"), EXIT(3, "Exit");
    private final int statusValue;
    private final String statusType;

    private static final Map<Integer, TransactionMenu> lookup = new HashMap<>();
    static {
        for (TransactionMenu m : TransactionMenu.values())
            lookup.put(m.getStatusValue(), m);
    }

    private TransactionMenu get(Integer value){
        return lookup.get(value);
    }

    private TransactionMenu(int statusValue, String statusType){
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
