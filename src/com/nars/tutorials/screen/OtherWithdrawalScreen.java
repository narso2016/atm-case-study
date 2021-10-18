package com.nars.tutorials.screen;

import com.nars.tutorials.model.Account;
import com.nars.tutorials.validator.AccountValidator;
import com.nars.tutorials.validator.AmountValidator;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;

public class OtherWithdrawalScreen {
    public static void showScreen(int keyVal, Map<Integer, Account> data){
        DecimalFormat ft = new DecimalFormat("$###,###.##");
        System.out.println("Other withdrawal");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter amount to withdraw:");
        int amount = in.nextInt();
        BigDecimal prevBal = data.get(keyVal).getBalance();
        if(AmountValidator.isMaxAmount(new BigDecimal(amount), new BigDecimal(1000))){
            System.out.println("Maximum amount to withdraw is $1000");
            OtherWithdrawalScreen.showScreen(keyVal, data);
        }else if(!AccountValidator.isDigitOnly(String.valueOf(amount))){
            System.out.println("Invalid Amount");
            OtherWithdrawalScreen.showScreen(keyVal, data);
        }else if(! AmountValidator.isMultipleBy(amount, 10)){
            System.out.println("Amount should be multiply $10");
            OtherWithdrawalScreen.showScreen(keyVal, data);
        }else if(AmountValidator.insufficientBalance(prevBal, new BigDecimal(amount))){
            System.out.println("Insufficient balance "+ ft.format(prevBal));
            OtherWithdrawalScreen.showScreen(keyVal, data);
        }else{
            BigDecimal currBal = WithdrawalScreen.deductAmount(keyVal, data, new BigDecimal(amount));
            data.get(keyVal).setBalance(currBal);
            SummaryScreen.show(new BigDecimal(amount), currBal, keyVal,data);
        }

    }
}
