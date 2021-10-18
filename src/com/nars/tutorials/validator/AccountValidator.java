package com.nars.tutorials.validator;

import com.nars.tutorials.model.Account;

import java.util.Map;
import java.util.regex.Pattern;

public class AccountValidator {
    private final static String regex = "[0-9]+";
    private final static int len = 6;

    public static boolean isDigitOnly(String value){
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(value).matches();
    }
    public static boolean isValidLength(String value){
        return (value.trim().length() == len);
    }


    public static boolean checkValidAccAndPIN(String acc, String pin, Map<Integer, Account> datasource) {
        for (Map.Entry<Integer, Account> entry : datasource.entrySet()) {
            int key = entry.getKey();
            Account account = entry.getValue();
            if (acc.equals(account.getAccountNumber()) && pin.equals(account.getPin())) return true;
        }
        return false;
    }

    public static int getKeyVal(String acc, String pin, Map<Integer, Account> datasource) {
        int key = 0;
        for (Map.Entry<Integer, Account> entry : datasource.entrySet()) {
            key = entry.getKey();
            Account account = entry.getValue();
            if (acc.equals(account.getAccountNumber()) && pin.equals(account.getPin())) return key;
        }
        return key;
    }


}
