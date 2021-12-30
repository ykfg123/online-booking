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
@Getter
@Setter
@ToString
public class ServiceInfoBean {
    private String serviceId;//服务ID
    private String serviceName;//服务名
    private String serviceGroupId;//服务组ID
    private String priceMin;//价格小
    private String priceMax;//价格大
    private String timeSts;//生效状态 0全天  1上午 2下午
    private String sts;//状态
    private String createTime;//创建时间
    private String updateTime;//修改时间
    private String remark;//备注
    private String companyId;//公司ID

}
