package com.nars.tutorials.service;

import com.nars.tutorials.menu.TransactionMenu;

public class TransactionServiceImpl implements AtmService {

    @Override
    public boolean checkValidMenu(int opsi) {
        for (TransactionMenu menu : TransactionMenu.values()) {
            if (menu.getStatusValue() == opsi)return true;
        }
        return false;
    }
}
