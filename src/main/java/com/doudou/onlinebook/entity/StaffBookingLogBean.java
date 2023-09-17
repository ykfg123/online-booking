package com.doudou.onlinebook.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.util.List;


/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/15 22:09
 * @modified By：邮件详情
 * @version: $
 */
@ToString
@Setter
@Getter
@ApiModel(value = "Email")
@TableName("staff_booking_log")
public class StaffBookingLogBean {

    @TableId(value = "log_id",type = IdType.AUTO)
    public String logId;//记录流水ID

    @TableField("staff_id")
    public String staffId;//记录流水ID

    @TableField("company_id")
    public String companyId;//公司ID

    @NotEmpty(message = "预订日期不能为空！")
    @TableField("booking_date")
    public String bookingDate;//预订日期  yyyy-mm-dd

    @NotEmpty(message = "预订时间不能为空！")
    @TableField("time_id")
    public Integer timeId;//预订时间片  每15分钟为一个时间片 1 表示 00：00-00:15 时间段 ；2 表示 00：16-00:30 时间段.。。。。

    @NotEmpty(message = "预订邮箱不能为空！")
    @TableField("booking_email")
    public String bookingEmail;//预订邮箱

    @TableField("business_number")
    public String businessNumber;//预订人联系号码

    @TableField("booking_name")
    public String bookingName;//预订人名称

    @TableField("booking_json")
    public String bookingJson;//预约项目

    public String createTime;
    public String updateTime;
    public String remark;
}
