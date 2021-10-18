package com.nars.tutorials.datasource;

import com.nars.tutorials.model.Account;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class AccountData {
    private Map<Integer, Account> mapData;

    public void setMapData(Map<Integer, Account> mapData) {
        this.mapData = mapData;
    }

    public Map<Integer, Account> getMapData() {
        //Creating account
        Account ac1 = new Account("John Doe","012108", new BigDecimal(100), "112233" );
        Account ac2 = new Account("Jane Doe","932012", new BigDecimal(30), "112244" );
        this.mapData = new LinkedHashMap<>();
        //adding Account to map
        this.mapData.put(1, ac1);
        this.mapData.put(2, ac2);

        return mapData;
    }


    public static void printDataSource(Map<Integer, Account> datasource) {
        AccountData data = new AccountData();
        //Traversing map
        System.out.println("Details:");
        for (Map.Entry<Integer, Account> entry : datasource.entrySet()) {
            int key = entry.getKey();
            Account account = entry.getValue();
            System.out.println("No. " + key);
            String formattedName = String.format("Name: %s", account.getName());
            String formattedPIN = String.format("PIN: %s", account.getPin());
            String formattedAccountNumber = String.format("Account Number %s", account.getAccountNumber());

            // formatting money in dollars
            double bal = account.getBalance().doubleValue();

            // prints only numeric part of a floating number
            DecimalFormat ft = new DecimalFormat("####");
            ft = new DecimalFormat("$###,###.##");

            System.out.println(formattedName);
            System.out.println(formattedPIN);
            System.out.println("Balance : " + ft.format(bal));
            System.out.println(formattedAccountNumber);
        }
    }
}