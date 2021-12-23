package com.doudou.onlinebook.entity;

import lombok.ToString;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/15 22:09
 * @modified By：代购详情
 * @version: $
 */
@ToString
public class HotMailBean {
    public Long seqId;
    public String companyId;
    public String bookingTime;
    public String bookingEmail;
    public String businessNumber;
    public String bookingName;
    public String ren;
    public String createTime;
    public String updateTime;
    public String remark;
    public List<BookingServicesBean> formList;

    public Long getSeqId() {
        return seqId;
    }

    public void setSeqId(Long seqId) {
        this.seqId = seqId;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
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

    public String getRen() {
        return ren;
    }

    public void setRen(String ren) {
        this.ren = ren;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getBookingEmail() {
        return bookingEmail;
    }

    public void setBookingEmail(String bookingEmail) {
        this.bookingEmail = bookingEmail;
    }

    public List<BookingServicesBean> getFormList() {
        return formList;
    }

    public void setFormList(List<BookingServicesBean> formList) {
        this.formList = formList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HotMailBean{");
        sb.append("companyId='").append(companyId).append('\'');
        sb.append(", bookingTime='").append(bookingTime).append('\'');
        sb.append(", bookingEmail='").append(bookingEmail).append('\'');
        sb.append(", formList=").append(formList);
        sb.append('}');
        return sb.toString();
    }
}
