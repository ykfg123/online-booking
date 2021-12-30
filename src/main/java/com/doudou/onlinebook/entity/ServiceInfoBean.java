package com.doudou.onlinebook.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/16 15:57
 * @modified By：
 * @version: $
 */
@ToString
@Setter
@Getter
public class ServiceInfoBean {
    private String serviceId;
    private String serviceName;
    private String sts;
    private String createTime;
    private String updateTime;
    private String remark;


}
