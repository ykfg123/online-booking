package com.doudou.onlinebook.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doudou.onlinebook.entity.CompanyBean;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/16 16:07
 * @modified By：
 * @version: $
 */
@Mapper
public interface CompanyMapper extends BaseMapper<CompanyBean> {
    public int addCompany(CompanyBean companyBean);
    public CompanyBean getCompanyInfo(String companyId);
}
