package com.doudou.onlinebook.entity.monitor;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/30 9:08
 * @modified By：今日服务预定数量
 * @version: 1.0.0$
 */
@Getter
@Setter
@ToString
public class ServiceDataBean {

    public String serviceId;
    public String serviceName;
    public String count;
    public String dateStr;
}
