package com.doudou.onlinebook.entity;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/16 14:51
 * @modified By：公司详情
 * @version: $
 */
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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getCompanyPws() {
        return companyPws;
    }

    public void setCompanyPws(String companyPws) {
        this.companyPws = companyPws;
    }

    public String getCompanyCity() {
        return companyCity;
    }

    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    public String getOperatHours() {
        return operatHours;
    }

    public void setOperatHours(String operatHours) {
        this.operatHours = operatHours;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
