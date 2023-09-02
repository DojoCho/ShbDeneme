package com.sahibinden.app.Utils;

import java.util.regex.Pattern;

public class Utils {
    public static boolean emailValidate(String emailAddress) {
        String regexPattern = "^(.+)@(\\S+)$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
}
