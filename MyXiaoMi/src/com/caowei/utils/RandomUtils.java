package com.caowei.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;


public class RandomUtils {
    public static String createActive(){
        return getTime()+Integer.toHexString(new Random().nextInt(900)+100);
    }
    public static String getTime(){
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
    }
    public static String createOrderId(){
        return getTime();
    }
}
