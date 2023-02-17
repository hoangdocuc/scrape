package com.viettelpost.scrape.ultils;

import java.util.List;

public class TextUtils {
    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static boolean isNullOrEmpty(Object input) {
        if (input instanceof String) {
            return input == null || ((String) input).isEmpty();
        }

        if (input instanceof List) {
            return input == null || ((List) input).isEmpty();
        }
        return input == null;
    }

    public static String checkNull(String input){
        if (!TextUtils.isNullOrEmpty(input)){
            return input;
        } else {
            return "";
        }
    }
    public static String checkNull(String input, String output){
        if (!TextUtils.isNullOrEmpty(input)){
            return input;
        } else {
            if(!TextUtils.isNullOrEmpty(output)) return output;
            else return "";
        }
    }
}
