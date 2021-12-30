package com.doudou.onlinebook.entity.monitor;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/30 8:48
 * @modified By：今日员工预定数量
 * @version: 1.0.0$
 */
@ToString
@Setter
@Getter
public class StaffDataBean {

    public String staffName;
    public String count;
    public String dayStr;
}
