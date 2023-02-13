package com.doudou.onlinebook.service.company;

import com.doudou.onlinebook.entity.company.CompanyBean;
import com.doudou.onlinebook.entity.company.CompanyInfoBean;
import com.doudou.onlinebook.entity.company.CompanyVo;
import com.doudou.onlinebook.entity.system.LoginBean;

import java.util.List;

public interface CompanyManageService {

    public int createCompany (CompanyBean companyBean) throws Exception;

    public List<CompanyBean> getCompanyLst(CompanyVo companyVo) throws Exception;

    public Integer getCount(CompanyVo companyVo) throws Exception;

    public CompanyBean getCompanyInfo(Integer companyId) throws Exception;
    public CompanyInfoBean getCompany(Integer companyId) throws Exception;

    public int editCompany(CompanyInfoBean companyInfoBean) throws Exception;

    public int deleteCompany(Integer companyId);

    public CompanyBean loginCompany(LoginBean loginBean);
}
