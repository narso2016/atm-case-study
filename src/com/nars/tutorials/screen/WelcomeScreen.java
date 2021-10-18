package com.nars.tutorials.screen;

import com.nars.tutorials.datasource.AccountData;
import com.nars.tutorials.model.Account;
import com.nars.tutorials.validator.AccountValidator;
import com.nars.tutorials.validator.StringsValidator;

import java.util.Map;
import java.util.Scanner;

public class WelcomeScreen {

    public static void showSubmit(){
        AccountData data = new AccountData();
        Map<Integer, Account> datasource = data.getMapData();
        //printDataSource(datasource);
        boolean isOn = true;
        while (isOn){
            Scanner in = new Scanner(System.in);
            System.out.print("Enter Account Number: ");
            String accNum = in.nextLine();
            if(StringsValidator.isNullOrEmpty(accNum)){
                System.out.println(" Account Number should not empty !");
            }else if( !AccountValidator.isDigitOnly(accNum)){
                System.out.println("Account Number should only contains numbers !");
            }else if( !AccountValidator.isValidLength(accNum)){
                System.out.println("Account Number should have 6 digits length !");
            }else {
                while (isOn){
                    System.out.print("Enter PIN: ");
                    String pin = in.nextLine();
                    if(StringsValidator.isNullOrEmpty(pin)){
                        System.out.println("PIN should not empty !");
                    }else if( !AccountValidator.isDigitOnly(pin)){
                        System.out.println("PIN should only contains numbers !");
                    }else if( !AccountValidator.isValidLength(pin)){
                        System.out.println("PIN should have 6 digits length !");
                    } else if(!AccountValidator.checkValidAccAndPIN(accNum, pin, datasource)){
                        System.out.println("Invalid Account Number/PIN ! ");
                        WelcomeScreen.showSubmit();
                    } else {
                        System.out.println("<<<< Transaction Screen >>>>");
                        isOn = false;
                        int key = AccountValidator.getKeyVal(accNum, pin, datasource);
                        TransactionScreen.showScreen(key, datasource);
                    }
                }
            }

        }

    }
}
