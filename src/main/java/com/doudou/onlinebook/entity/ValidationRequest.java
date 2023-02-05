package com.doudou.onlinebook.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

/**
 * @author ：zhuyk
 * @date ：Created in 2023-1-29 15:28
 * @modified By：
 * @version: $
 */
@ToString
@Setter
@Getter
public class ValidationRequest {
    @Max(value=50,message = "count最大小于等于50")
    @Min(value=10,message = "count最小大于等于10")
    private int count;
    @NotNull(message = "age不能为空")
    private String age;
    @NotBlank(message = "name不能为空或者空格")
    private String name;
    @Size(min=10, max=20,message = "content字符长度在10-20之间")
    private String content;
    @NotEmpty(message = "remark不能为空或（允许为空格）")
    private String remark;
}
