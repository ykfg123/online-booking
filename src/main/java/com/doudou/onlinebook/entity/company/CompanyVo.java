package com.doudou.onlinebook.entity.company;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@ApiModel(value = "公司信息查询")
public class CompanyVo {

    private String companyName;
    private String companyType;
    private Integer pageIndex;
    private Integer pageSize;

}
