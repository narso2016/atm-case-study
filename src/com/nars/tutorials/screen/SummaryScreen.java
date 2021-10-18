package com.nars.tutorials.screen;

import com.nars.tutorials.model.Account;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class SummaryScreen {
    public static void show(BigDecimal withdrawalAmount, BigDecimal balance, int keyVal, Map<Integer, Account> datasource){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a");
        DecimalFormat ft = new DecimalFormat("$###,###.##");
        Scanner scan = new Scanner(System.in);
        System.out.println("Summary");
        System.out.println("Date "+ df.format(new Date()));
        System.out.println("Withdrawal "+ ft.format(withdrawalAmount.doubleValue()));
        System.out.println("Balance "+ ft.format(balance.doubleValue()));
        System.out.println(System.lineSeparator());
        System.out.println("1. Transaction ");
        System.out.println("2. Exit ");
        int opsi = 2;
        System.out.println("Choose option[2]:");
        opsi = scan.nextInt();
        switch (opsi) {
            case 1:
                TransactionScreen.showScreen(keyVal,datasource);
            case 2:
                WelcomeScreen.showSubmit();
        }
    }

}
