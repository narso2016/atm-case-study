package com.nars.tutorials.validator;

public class StringsValidator {
    public static boolean isNullOrEmpty(String input){
        if (input != null && !input.trim().isEmpty()){
            return false;
        }
        return true;

    }
}
