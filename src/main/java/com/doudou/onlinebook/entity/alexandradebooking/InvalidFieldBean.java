package com.doudou.onlinebook.entity.alexandradebooking;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ：zhuyk
 * @date ：Created in 2022-10-12 15:42
 * @modified By：
 * @version: $
 */
@ToString
@Setter
@Getter
public class InvalidFieldBean {
    public String field;
    public String message;
    public String idref;
    public String error_id;
}
