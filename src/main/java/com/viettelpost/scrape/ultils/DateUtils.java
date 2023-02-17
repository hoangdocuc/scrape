package com.viettelpost.scrape.ultils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String DateTimeFormat_1 = "dd-MM-yyyy HH:mm:ss";

    public static String convertLongtoDate(Long input){
//        DateFormat dateFormatter = new SimpleDateFormat(DateTimeFormat_1);
//        String output = dateFormatter.format(new Date(input));
        Timestamp ts=new Timestamp(input);
        Date output=new Date(ts.getTime());
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertLongtoDate(1675045022L ));
    }
}
