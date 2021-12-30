package com.doudou.onlinebook.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/16 15:39
 * @modified By： 员工详情
 * @version: $
 */
@ToString
@Setter
@Getter
public class StaffManageBean {
    private String staffId;
    private String staffName;
    private String staffPws;
    private String staffNo;
    private String Age;
    private String Tel;
    private String Addr;
    private String City;
    private String Email;
    private String sts;
    private String companyId;
    private String createTime;
    private String updateTime;
    private String remark;

}
