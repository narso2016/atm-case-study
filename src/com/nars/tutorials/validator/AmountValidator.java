package com.nars.tutorials.validator;

import java.math.BigDecimal;

public class AmountValidator {

    public static boolean isMaxAmount(BigDecimal amount, BigDecimal threshold){
        return (amount.compareTo(threshold) > 0);
    }
    public static boolean isMinAmount(BigDecimal amount, BigDecimal threshold){
        return (amount.compareTo(threshold) < 0);
    }

    public static boolean isMultipleBy(int amount, int threshold){
        return (amount % threshold == 0);
    }

    public static boolean insufficientBalance(BigDecimal prevBal, BigDecimal balance){
        return (prevBal.subtract(balance).compareTo(BigDecimal.ZERO) < 0);
    }
}
