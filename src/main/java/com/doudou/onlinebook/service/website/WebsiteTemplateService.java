package com.doudou.onlinebook.service.website;

import com.doudou.onlinebook.entity.website.WebsiteTemplateBean;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2022/1/20 21:57
 * @modified By：网站模板模块
 * @version: 1.0.0$
 */
public interface WebsiteTemplateService {
   public List<WebsiteTemplateBean> show(String typeId)throws Exception;
}
