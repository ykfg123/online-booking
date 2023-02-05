package com.doudou.onlinebook.common.util;

/**
 * @author ：zhuyk
 * @date ：Created in 2023-1-29 17:03
 * @modified By：
 * @version: $
 */

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 验证手机号码的注解类
 * @author 程就人生
 * @Date
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=MobileValidator.class)  //对应的验证实现类
public @interface Mobile {

    //默认提示
    String message() default "手机号码格式错误！";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
