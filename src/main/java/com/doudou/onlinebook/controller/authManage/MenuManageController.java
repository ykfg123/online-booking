package com.doudou.onlinebook.controller.authManage;

import com.doudou.onlinebook.common.util.Result;
import com.doudou.onlinebook.entity.menuManage.MenuItemBean;
import com.doudou.onlinebook.entity.menuManage.MenuItemVo;
import com.doudou.onlinebook.service.menuManage.MenuManageService;
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
@RequestMapping("/menu")
@Log4j2
@Api(tags = "菜单管理", description = "menuManageController")
public class MenuManageController {

    @Autowired
    private MenuManageService menuManageService;
    @ApiOperation(value = "新增", notes = "菜单信息", httpMethod = "POST")
    @PostMapping("/create")
    public Result createMenuItem(@Validated MenuItemBean menuItemBean) {
        //对表单进行验证
        try {

            int result = menuManageService.createMenuInfo(menuItemBean);

        } catch (Exception e) {
            log.error("创建菜单失败，请联系管理员！",e);
            return Result.error("创建菜单失败，请联系管理员！");
        }
        return Result.success("创建菜单成功！");
    }

    @ApiOperation(value = "查询", notes = "菜单信息", httpMethod = "GET")
    @GetMapping ("/list")
    public Result getMenuItemList(@Validated MenuItemVo menuItemVo) {
        List<MenuItemBean> list = null;
        Integer count =0;
        try {

           list = menuManageService.getMenuList(menuItemVo);
            count = menuManageService.getCount(menuItemVo);
        } catch (Exception e) {
            log.error("获取菜单列表失败，请联系管理员！",e);
            return Result.error("获取菜单列表失败，请联系管理员！");
        }
        return Result.successList(list,count);
    }
    @ApiOperation(value = "查询", notes = "菜单选项信息", httpMethod = "GET")
    @GetMapping ("/option")
    public Result getMenuList() {
        List<MenuItemBean> list = null;
        Integer count =0;
        try {

            list = menuManageService.getMenuOption();
        } catch (Exception e) {
            log.error("获取权限列表失败，请联系管理员！",e);
            return Result.error("获取权限列表失败，请联系管理员！");
        }
        return Result.success(list);
    }
}
