package com.doudou.onlinebook.entity.system;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/23 23:47
 * @description：系统设置
 * @modified By：
 * @version: 1.0.0$
 */
@ToString
@Getter
@Setter
public class SystemBean {
    public Integer seqId;
    public String paramCode;
    public String ownerDesc;
    public String paramName;
    public String paramValue;
    public Integer isUsedFlag;
    public Integer isForCompany;
    public String createTime;
    public String updateTime;
    public String remark;
    public String companyId;

}
