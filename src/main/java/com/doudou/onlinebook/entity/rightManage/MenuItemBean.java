package com.doudou.onlinebook.entity.rightManage;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@ToString
@Setter
@Getter
@ApiModel(value = "菜单")
@TableName("menu_item")
public class MenuItemBean {

    @TableId(value = "menu_id",type = IdType.AUTO)
    private Integer menuId;//菜单ID
    @NotEmpty(message = "权限名不能为空！")
    private String menuName;//菜单名称
    private Integer upMenuId;//上级菜单ID

    private String menuUrl;//菜单名称
    @TableField("createTime")
    private Data createTime;
    @TableField("updateTime")
    private Data updateTime;

    private String remark;

}
