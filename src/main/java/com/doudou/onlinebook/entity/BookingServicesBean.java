package com.doudou.onlinebook.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/15 22:31
 * @modified By：代购服务
 * @version: $
 */
@ToString
@Setter
@Getter
public class BookingServicesBean {
    public long bookingId;
    public String serviceName;
    public String serviceTime;
    public String staffName;
    public String staffId;
    public String createTime;
    public String updateTime;
    public String remark;

}
