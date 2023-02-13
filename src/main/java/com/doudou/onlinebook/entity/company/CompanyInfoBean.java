package com.doudou.onlinebook.entity.company;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@ToString
@Setter
@Getter
@ApiModel(value = "公司信息")
@TableName("companyInfo")
public class CompanyInfoBean {
    @TableId(value = "companyId",type = IdType.AUTO)
    private String companyId;//公司ID
    @NotBlank(message = "公司名不能为空")
    @Size(min=2, max=20,message="公司名必须在 2 ~ 20 字符之间！")
    @TableField("companyName")
    private String companyName;//公司名称
    @Min(value=1,message="最小必须是1")
    @Max(value=3,message="最大不能超过3")
    @TableField("companyType")
    private String companyType;//1.理发店；2.指甲店；3.按摩店；。。
    @TableField("companyAddr")
    @NotEmpty(message = "公司地址不能为空！")
    private String companyAddr;
    @TableField("companyEmail")
    @Email(message = "邮箱格式错误！")
    @Length(min=5, max=100,message="邮箱必须在 5 ~ 100 字符之间！")
    private String companyEmail;
    @TableField("companyTel")
    @NotEmpty(message = "公司电话不能为空！")
    private String companyTel;
}
