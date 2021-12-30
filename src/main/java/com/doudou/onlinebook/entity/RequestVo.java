package com.doudou.onlinebook.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/22 20:26
 * @modified By：
 * @version: $
 */
@ToString
@Setter
@Getter
public class RequestVo {

    public String startTime;
    public String companyId;
    public String endTime;
    public String searchType;
    public String username;
    public String staffPws;
    public String staffNo;
    public String keyWord;
    public Integer pageNum;
    public Integer pageSize;
    public String timestamp;
    public String seqId;

}
