package com.doudou.onlinebook.entity.menuManage;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@ApiModel(value = "权限查询条件")
public class MenuItemVo {

    private String menuName;//菜单名称
    private Integer pageIndex;
    private Integer pageSize;


}
