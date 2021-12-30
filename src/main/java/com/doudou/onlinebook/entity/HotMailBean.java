package com.doudou.onlinebook.entity;

import lombok.Getter;
import lombok.Setter;
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
@Setter
@Getter
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

}
