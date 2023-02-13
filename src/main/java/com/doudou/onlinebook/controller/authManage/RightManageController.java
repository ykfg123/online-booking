package com.doudou.onlinebook.controller.authManage;

import com.doudou.onlinebook.common.util.Result;
import com.doudou.onlinebook.entity.rightManage.RightBean;
import com.doudou.onlinebook.entity.rightManage.RightInfoBean;
import com.doudou.onlinebook.entity.rightManage.RightVo;
import com.doudou.onlinebook.service.rightManage.RightManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/right")
@Log4j2
@Api(tags = "权限管理", description = "rightManageController")
public class RightManageController {

    @Autowired
    private RightManageService rightManageService;
    @ApiOperation(value = "新增", notes = "公司信息", httpMethod = "POST")
    @PostMapping("/create")
    public Result createRight(@Validated RightBean rightBean) {
        //对表单进行验证
        try {

            int result = rightManageService.createRightInfo(rightBean);

        } catch (Exception e) {
            log.error("创建公司失败，请联系管理员！",e);
            return Result.error("创建公司失败，请联系管理员！");
        }
        return Result.success("创建公司成功！");
    }

    @ApiOperation(value = "查询", notes = "公司信息", httpMethod = "GET")
    @GetMapping ("/list")
    public Result getRightList(@Validated RightVo rightVo) {
        List<RightInfoBean> list = null;
        Integer count =0;
        try {

           list = rightManageService.getRightList(rightVo);
            count = rightManageService.getCount(rightVo);
        } catch (Exception e) {
            log.error("获取权限列表失败，请联系管理员！",e);
            return Result.error("获取权限列表失败，请联系管理员！");
        }
        return Result.successList(list,count);
    }
}
