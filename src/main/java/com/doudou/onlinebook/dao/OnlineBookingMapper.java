package com.doudou.onlinebook.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doudou.onlinebook.entity.BookingServicesBean;
import com.doudou.onlinebook.entity.HotMailBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OnlineBookingMapper extends BaseMapper<BookingServicesBean> {

    int sendBooking(HotMailBean hotMailBean);
    int sendBookingServices(BookingServicesBean bookingServicesBean);
}
