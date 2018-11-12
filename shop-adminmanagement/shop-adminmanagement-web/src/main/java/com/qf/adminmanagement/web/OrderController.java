package com.qf.adminmanagement.web;

import com.qf.adminmanagement.pojo.dto.OrderInfo;
import com.qf.adminmanagement.pojo.po.ViewOrder;
import com.qf.adminmanagement.service.OrderService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @Autowired
    private OrderService service;

    @ResponseBody
    @PostMapping(value = "orderLists", produces = "application/json;charset=UTF-8")
    public ViewOrder userLists(@RequestBody OrderInfo orderInfo){
        int page = orderInfo.getPage();
        int pagesize = orderInfo.getPagesize();
        String select_word = orderInfo.getSelect_word();
        OrderInfo pageInfo = new OrderInfo();
        pageInfo.setPagesize(pagesize);
        pageInfo.setPage(page);
        pageInfo.setSelect_word(select_word);

        return service.findOrders(pageInfo);
    }

}
