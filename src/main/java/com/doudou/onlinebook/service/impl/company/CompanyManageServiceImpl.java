package com.doudou.onlinebook.service.impl.company;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.doudou.onlinebook.common.util.MD5;
import com.doudou.onlinebook.dao.company.CompanyMapper;
import com.doudou.onlinebook.entity.company.CompanyBean;
import com.doudou.onlinebook.entity.company.CompanyInfoBean;
import com.doudou.onlinebook.entity.company.CompanyVo;
import com.doudou.onlinebook.entity.system.LoginBean;
import com.doudou.onlinebook.service.company.CompanyManageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Log4j2
public class CompanyManageServiceImpl implements CompanyManageService {
    @Autowired
    private CompanyMapper companyMapper;
    /**
     * @param companyBean
     * @return
     * @throws Exception
     */
    @Override
    public int createCompany(CompanyBean companyBean) throws Exception {
        companyBean.setCompanyPws(MD5.encode(companyBean.getCompanyPws()).toLowerCase());
        return companyMapper.addCompany(companyBean);
    }

    /**
     * @param companyVo
     * @return
     */
    @Override
    public List<CompanyBean> getCompanyLst(CompanyVo companyVo) throws Exception {
        QueryWrapper<CompanyBean> queryWrapper = new QueryWrapper<>();
        Page<CompanyBean> page = new Page<>(1,10);
        if (!"".equals(companyVo.getPageIndex())&&companyVo.getPageIndex()>0){
            page.setCurrent(companyVo.getPageIndex());
            page.setSize(companyVo.getPageSize());
        }
        queryWrapper.like(StringUtils.hasText(companyVo.getCompanyName()),"companyName",companyVo.getCompanyName());

        queryWrapper.eq(StringUtils.hasText(companyVo.getCompanyType()),"companyType",companyVo.getCompanyType());

        return companyMapper.selectPage(page,queryWrapper).getRecords();
    }

    /**
     * @param companyVo
     * @return
     */
    @Override
    public Integer getCount(CompanyVo companyVo) throws Exception {
        QueryWrapper<CompanyBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(companyVo.getCompanyName()),"companyName",companyVo.getCompanyName());
        queryWrapper.eq(StringUtils.hasText(companyVo.getCompanyType()),"companyType",companyVo.getCompanyType());
        return companyMapper.selectCount(queryWrapper);
    }

    /**
     * @param companyId
     * @return
     * @throws Exception
     */
    @Override
    public CompanyBean getCompanyInfo(Integer companyId) throws Exception {
        return null;
    }

    /**
     * @param companyId
     * @return
     * @throws Exception
     */
    @Override
    public CompanyInfoBean getCompany(Integer companyId) throws Exception {

        return companyMapper.getCompany(companyId);
    }

    /**
     * @param companyInfoBean
     * @return
     */
    @Override
    public int editCompany(CompanyInfoBean companyInfoBean)  throws Exception{
        CompanyBean companyBean = new CompanyBean();
        companyBean.setCompanyId(companyInfoBean.getCompanyId());
        companyBean.setCompanyName(companyInfoBean.getCompanyName());
        companyBean.setCompanyAddr(companyInfoBean.getCompanyAddr());
        companyBean.setCompanyEmail(companyInfoBean.getCompanyEmail());
        companyBean.setCompanyTel(companyInfoBean.getCompanyTel());
        companyBean.setCompanyType(companyInfoBean.getCompanyType());
        return companyMapper.updateById(companyBean);
    }

    /**
     * @param companyId
     * @return
     */
    @Override
    public int deleteCompany(Integer companyId) {

        return companyMapper.changeCompanySts(companyId);
    }

    /**
     * @param loginBean
     * @return
     */
    @Override
    public CompanyBean loginCompany(LoginBean loginBean) {
        QueryWrapper<CompanyBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.hasText(loginBean.getUserNo()),"companyName",loginBean.getUserNo());
        queryWrapper.eq(StringUtils.hasText(loginBean.getUserPwd()),"companyPws",MD5.encode(loginBean.getUserPwd()).toLowerCase());
        return companyMapper.selectOne(queryWrapper);
    }
}
