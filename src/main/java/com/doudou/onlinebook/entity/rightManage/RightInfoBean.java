package com.doudou.onlinebook.entity.rightManage;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
@ToString
@Setter
@Getter
@ApiModel(value = "权限查询条件")
public class RightInfoBean {

    private String rightId;//公司ID
    @NotEmpty(message = "权限名不能为空！")
    private String rightName;

    private Integer menuId;

    private String menuName;

    private String createTime;

    private String updateTime;

    private String remark;
}
