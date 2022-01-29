package com.doudou.onlinebook.dao.website;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doudou.onlinebook.entity.website.WebsiteTemplateBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2022/1/22 22:00
 * @modified By：
 * @version: $
 */
public interface WebsiteTemplateMapper extends BaseMapper<WebsiteTemplateBean> {

    public List<WebsiteTemplateBean> show(@Param("typeId")String typeId);
}
