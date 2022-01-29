package com.doudou.onlinebook.service.impl.website;

import com.doudou.onlinebook.dao.website.WebsiteTemplateMapper;
import com.doudou.onlinebook.entity.website.WebsiteTemplateBean;
import com.doudou.onlinebook.service.website.WebsiteTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2022/1/20 21:58
 * @modified By：
 * @version: 1.0.0$
 */
@Service
public class WebsiteTemplateServiceImpl implements WebsiteTemplateService {

    @Autowired
    private WebsiteTemplateMapper websiteTemplateMapper;

    @Override
    public List<WebsiteTemplateBean> show(String typeId) throws Exception {
        if("0".equals(typeId)){
            typeId=null;
        }
        return websiteTemplateMapper.show(typeId);
    }
}
