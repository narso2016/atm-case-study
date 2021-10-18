package com.nars.tutorials.screen;

import com.nars.tutorials.menu.TransactionMenu;
import com.nars.tutorials.model.Account;
import com.nars.tutorials.service.AtmService;
import com.nars.tutorials.service.TransactionServiceImpl;

import java.util.Map;
import java.util.Scanner;

public class TransactionScreen {

    public static void showScreen(int keyVal, Map<Integer, Account> data){
        System.out.println("1. Withdrawal");
        System.out.println("2. Fund Transfer");
        System.out.println("3. Exit");
        Scanner scan = new Scanner(System.in);
        int opsi = 3;
        System.out.print("Please choose option[3]:");
        opsi = scan.nextInt();
        AtmService atmService = new TransactionServiceImpl();
        boolean checkValid = atmService.checkValidMenu(opsi);
        boolean isExit = false;
        if(checkValid){
            while(!isExit){
                switch(opsi){
                    case 1:
                        WithdrawalScreen.showScreen(keyVal, data);
                    case 2:
                        FundTransferScreen.destinationScreen(keyVal,data);
                        isExit = true;
                    case 3:
                        WelcomeScreen.showSubmit();
                }
            }

        } else {
            TransactionScreen.showScreen(keyVal, data);
        }


    }

    private static boolean isValidOpsi(int opsi){
        for (TransactionMenu menu : TransactionMenu.values()) {
            if (menu.getStatusValue() == opsi)return true;
        }
        return false;
    }
}
