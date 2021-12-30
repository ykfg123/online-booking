package com.doudou.onlinebook.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/16 14:51
 * @modified By：公司详情
 * @version: $
 */
@ToString
@Setter
@Getter
public class CompanyBean {
    private String companyId;//公司ID
    private String companyName;//公司名称
    private String companyType;//1.理发店；2.指甲店；3.按摩店；。。
    private String sts;//公司状态 0启用；-1停用；
    private String companyPws;//公司密码
    private String companyCity;
    private String companyLogo;
    private String companyAddr;
    private String companyEmail;
    private String companyTel;
    private String operatHours;
    private String createTime;
    private String updateTime;
    private String remark;

}
