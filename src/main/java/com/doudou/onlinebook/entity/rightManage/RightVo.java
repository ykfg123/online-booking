package com.doudou.onlinebook.entity.rightManage;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@ApiModel(value = "权限查询条件")
public class RightVo {

    private String rightName;
    private Integer pageIndex;
    private Integer pageSize;


}
