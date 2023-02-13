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
@ApiModel(value = "权限")
@TableName("right_info")
public class RightBean {
    @TableId(value = "right_id",type = IdType.AUTO)
    private Integer rightId;//公司ID
    @NotEmpty(message = "权限名不能为空！")
    private String rightName;

    private Integer menuId;
    @TableField("createTime")
    private Data createTime;
    @TableField("updateTime")
    private Data updateTime;

    private String remark;
}
