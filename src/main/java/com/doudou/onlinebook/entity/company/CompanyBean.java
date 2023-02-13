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

/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/16 14:51
 * @modified By：公司详情
 * @version: $
 */
@ToString
@Setter
@Getter
@ApiModel(value = "公司信息")
@TableName("company")
public class CompanyBean {
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
    @TableField("sts")
    private String sts;//公司状态 0启用；-1停用；
    @TableField("companyPws")
    @NotEmpty(message = "公司密码不能为空！")
    @Size(min=6, max=15,message="密码长度必须在 6 ~ 15 字符之间！")
    @Pattern(regexp="^[a-zA-Z0-9|_]+$",message="密码必须由字母、数字、下划线组成！")
    private String companyPws;//公司密码
    @TableField("companyCity")
    private String companyCity;
    @TableField("companyLogo")
    private String companyLogo;
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
    @TableField("operatHours")
    private String operatHours;
    @TableField("createTime")
    private String createTime;
    @TableField("updateTime")
    private String updateTime;
    @TableField("remark")
    private String remark;

}
