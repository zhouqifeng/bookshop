package com.qf.adminmanagement.service;

import com.qf.adminmanagement.pojo.dto.OrderInfo;
import com.qf.adminmanagement.pojo.po.ViewOrder;


public interface OrderService {

    ViewOrder findOrders(OrderInfo orderInfo);
}
