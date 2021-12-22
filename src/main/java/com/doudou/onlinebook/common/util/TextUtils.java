package com.doudou.onlinebook.common.util;

import java.util.regex.Pattern;

public class TextUtils {

    /**
     * 只包含字母
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkLetter(String cardNum) {
        String regex = "^[A-Za-z]+$";
        return Pattern.matches(regex, cardNum);
    }

    /**
     * 验证中文
     * @param chinese 中文字符
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkChinese(String chinese) {
        String regex = "^[\u4E00-\u9FA5]+$";
        return Pattern.matches(regex,chinese);
    }
}
