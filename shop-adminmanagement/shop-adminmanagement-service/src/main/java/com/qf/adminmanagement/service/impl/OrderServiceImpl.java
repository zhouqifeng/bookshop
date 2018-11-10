package com.qf.adminmanagement.service.impl;

import com.qf.adminmanagement.dao.TbOrderMapper;
import com.qf.adminmanagement.pojo.dto.OrderInfo;
import com.qf.adminmanagement.pojo.po.ViewOrder;
import com.qf.adminmanagement.service.OrderService;
import com.qf.common.pojo.po.TbOrder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TbOrderMapper mapper;

    @Override
    public ViewOrder findOrders(OrderInfo orderInfo) {

        ViewOrder viewOrder = new ViewOrder();

        try {
            int count = mapper.selectCount(orderInfo);
            viewOrder.setCount(count);
            List<TbOrder> list = mapper.selectOrders(orderInfo);
            viewOrder.setList(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return viewOrder;
    }


}
