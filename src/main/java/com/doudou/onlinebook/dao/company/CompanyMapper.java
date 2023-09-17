package com.doudou.onlinebook.dao.company;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doudou.onlinebook.entity.company.CompanyBean;
import com.doudou.onlinebook.entity.company.CompanyInfoBean;
import com.doudou.onlinebook.entity.company.CompanyVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    public List<CompanyBean> getCompanyList(CompanyVo companyVo);

    public CompanyInfoBean getCompany(Integer companyId);

    public int changeCompanySts(Integer companyId);
}
