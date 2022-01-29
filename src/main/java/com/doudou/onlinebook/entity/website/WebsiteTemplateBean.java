package com.doudou.onlinebook.entity.website;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ：zhuyk
 * @date ：Created in 2022/1/20 21:52
 * @modified By：网站模板
 * @version: $
 */
@ToString
@Setter
@Getter
public class WebsiteTemplateBean {

    public String templateId;
    public String templateGroupId;
    public String templateName;
    public String sts;
    public String templateUrl;
    public String templateImg;
    public String createTime;
    public String updateTime;
    public String remark;

}
