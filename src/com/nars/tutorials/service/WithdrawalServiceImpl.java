package com.nars.tutorials.service;

import com.nars.tutorials.menu.WithdrawalMenu;

public class WithdrawalServiceImpl implements AtmService{
    @Override
    public boolean checkValidMenu(int opsi) {
        for (WithdrawalMenu menu : WithdrawalMenu.values()) {
            if (menu.getStatusValue() == opsi)return true;
        }
        return false;
    }
}
