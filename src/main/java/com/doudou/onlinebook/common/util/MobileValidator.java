package com.doudou.onlinebook.common.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 验证手机号码的实现类
 * @author 程就人生
 * @Date
 */
public class MobileValidator implements ConstraintValidator<Mobile, String> {

    //验证手机的正则表达式
    private String mobileReg = "^1(3|4|5|7|8|9)\\d{9}$";

    private Pattern mobilePattern = Pattern.compile(mobileReg);

    public void initialize(Mobile mobile) {

    }

    public boolean isValid(String value, ConstraintValidatorContext arg1) {
        //为空时，不进行验证
        if (StringUtils.isEmpty(value))
            return true;

        //返回匹配结果
        return mobilePattern.matcher(value).matches();

    }

}
