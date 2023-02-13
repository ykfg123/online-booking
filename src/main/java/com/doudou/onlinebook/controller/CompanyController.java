package com.doudou.onlinebook.controller;

import com.doudou.onlinebook.common.util.Result;
import com.doudou.onlinebook.entity.company.CompanyBean;
import com.doudou.onlinebook.entity.company.CompanyInfoBean;
import com.doudou.onlinebook.entity.company.CompanyVo;
import com.doudou.onlinebook.service.company.CompanyManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/12/4 15:50
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/company")
@Log4j2
@Api(tags = "公司管理", description = "companyController")
public class CompanyController {

    @Autowired
    private CompanyManageService companyManageService;

    @ApiOperation(value = "新增", notes = "公司信息", httpMethod = "POST")
    @PostMapping("/create")
    public Result createCompany(@Validated CompanyBean companyBean) {
        //对表单进行验证
        try {

            int result = companyManageService.createCompany(companyBean);

        } catch (Exception e) {
            log.error("创建公司失败，请联系管理员！",e);
            return Result.error("创建公司失败，请联系管理员！");
        }
        return Result.success("创建公司成功！");
    }
    @ApiOperation(value = "查询列表", notes = "公司信息列表", httpMethod = "GET")
    @GetMapping("/list")
    public Result getCompanyLst(CompanyVo companyVo) {
        List<CompanyBean> companyLst = null;
        Integer count = null;
        try {
            companyLst = companyManageService.getCompanyLst(companyVo);
            count = companyManageService.getCount(companyVo);
        } catch (Exception e) {
            log.error("查询公司列表系统错误！",e);
           return Result.error("查询公司列表系统错误！");
        }
        return Result.successList(companyLst,count);
    }

    @ApiOperation(value = "公司详情", notes = "公司信息详情", httpMethod = "GET")
    @GetMapping("/detail/{companyId}")
    public Result getCompanyLst(@PathVariable Integer companyId) {
        CompanyInfoBean companyBean = null;
        try {
            companyBean = companyManageService.getCompany(companyId);
        } catch (Exception e) {
            log.error("查询公司详情系统错误！",e);
            return Result.error("查询公司详情系统错误！");
        }
        return Result.success(companyBean);
    }

    @ApiOperation(value = "修改", notes = "公司信息", httpMethod = "POST")
    @PostMapping("/edit")
    public Result editCompany(@Validated CompanyInfoBean companyInfoBean) {
        //对表单进行验证
        try {
            int result = companyManageService.editCompany(companyInfoBean);

        } catch (Exception e) {
            log.error("修改公司失败，请联系管理员！",e);
            return Result.error("修改公司失败，请联系管理员！");
        }
        return Result.success("修改公司成功！");
    }
    @ApiOperation(value = "禁用公司", notes = "禁用公司", httpMethod = "GET")
    @GetMapping("/delete/{companyId}")
    public Result deleteCompany(@PathVariable Integer companyId) {
        try {
            int result = companyManageService.deleteCompany(companyId);
        } catch (Exception e) {
            log.error("禁用公司系统错误！",e);
            return Result.error("禁用公司系统错误！");
        }
        return Result.success("禁用公司成功!");
    }
}
