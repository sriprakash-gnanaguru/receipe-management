package com.food.receipe.manage.common;

import java.util.Random;

import static com.food.receipe.manage.common.Constants.SYSTEM_ID;

public class CommonUtil {

    public static String getUniqueId(){
        return SYSTEM_ID+getRandomNumberString();
    }

    public static String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
}
