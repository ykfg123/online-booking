package com.doudou.onlinebook.service;

import com.doudou.onlinebook.entity.BookingServicesBean;
import com.doudou.onlinebook.entity.HotMailBean;

public interface OnlineBookingService {

    int sendHotmail(HotMailBean hotMailBean) throws Exception;

}
