package com.ex;

import org.apache.commons.lang.RandomStringUtils;

public class Main {


    public static String genRandomEmail() {
        String randomText = "abcdefghijklmnopqrstuvwxyz";
        int length = 11;
        String temp = RandomStringUtils.random(length, randomText) + "7H@mailforspam.com";
        return temp;
    }
}
