package com.nars.tutorials.screen;

import com.nars.tutorials.datasource.AccountData;
import com.nars.tutorials.model.Account;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;

public class WithdrawalScreen extends AccountData {
    public static void showScreen(int keyVal, Map<Integer, Account> datasource){
        DecimalFormat ft = new DecimalFormat("$###,###.##");
        BigDecimal availableBal = datasource.get(keyVal).getBalance();
        //System.out.println("Balance " + ft.format(availableBal));
        Scanner scan = new Scanner(System.in);
        int opsi = 5;
        System.out.println("1. $10");
        System.out.println("2. $50");
        System.out.println("3. $100");
        System.out.println("4. Other");
        System.out.println("5. Back");
        System.out.print("Please choose option[5]:");
        opsi = scan.nextInt();
        BigDecimal currentBal;
        boolean checkBalance;
        switch (opsi){
            case 1:
                checkBalance = isAvailableBalance(keyVal, datasource, new BigDecimal(10));
                if(checkBalance){
                    currentBal = deductAmount(keyVal, datasource, new BigDecimal(10));
                    datasource.get(keyVal).setBalance(currentBal);
                    SummaryScreen.show(new BigDecimal(10), currentBal, keyVal,datasource);
                    break;
                } else {
                    System.out.println("Insufficient balance " + ft.format(new BigDecimal(10)));
                    System.out.println("Current balance " +  ft.format(availableBal));
                    WithdrawalScreen.showScreen(keyVal, datasource);
                }

            case 2:
                 checkBalance = isAvailableBalance(keyVal, datasource, new BigDecimal(50));
                if(checkBalance){
                    currentBal = deductAmount(keyVal, datasource, new BigDecimal(50));
                    datasource.get(keyVal).setBalance(currentBal);
                    SummaryScreen.show(new BigDecimal(50), currentBal, keyVal,datasource);
                    break;
                } else {
                    System.out.println("Insufficient balance " + ft.format(new BigDecimal(50)));
                    System.out.println("Current balance " +  ft.format(availableBal));
                    WithdrawalScreen.showScreen(keyVal, datasource);
                }
            case 3:
               checkBalance = isAvailableBalance(keyVal, datasource, new BigDecimal(100));
                if(checkBalance){
                    currentBal = deductAmount(keyVal, datasource, new BigDecimal(100));
                    datasource.get(keyVal).setBalance(currentBal);
                    SummaryScreen.show(new BigDecimal(100), currentBal, keyVal,datasource);
                    break;
                } else {
                    System.out.println("Insufficient balance " + ft.format(new BigDecimal(100)));
                    System.out.println("Current balance " +  ft.format(availableBal));
                    WithdrawalScreen.showScreen(keyVal, datasource);
                }
            case 4:
                OtherWithdrawalScreen.showScreen(keyVal, datasource);
                break;
            case 5:
                TransactionScreen.showScreen(keyVal, datasource);
        }

    }

    public static BigDecimal deductAmount(int keyVal, Map<Integer, Account> datasource, BigDecimal balance){
        return datasource.get(keyVal).getBalance().subtract(balance);
    }

    public static boolean isAvailableBalance(int keyVal, Map<Integer, Account> datasource, BigDecimal balance){
        BigDecimal prevBal = datasource.get(keyVal).getBalance();
        return (prevBal.subtract(balance).compareTo(BigDecimal.ZERO) > 0);
    }


}
