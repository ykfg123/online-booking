package com.doudou.onlinebook.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
    public static boolean isNumber(String str) {
        return str.matches("[0-9]+");
    }
    public static boolean isEmail(String str) {
        String regex = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}" ;

        return match( regex ,str );
    }
    private static boolean match( String regex ,String str ){

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher( str );

        return matcher.matches();

    }

}
