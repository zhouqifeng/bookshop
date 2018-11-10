package com.qf.adminmanagement.web;

import com.qf.common.pojo.po.TbUser;
import com.qf.adminmanagement.pojo.vo.UserPageInfo;
import com.qf.adminmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserAction {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/listuser")
    public Map<String,Object> listUser(@RequestBody UserPageInfo pageinfo){

        Map<String, Object> map = userService.searchUserByPage(pageinfo);

        return map;
    }

    @ResponseBody
    @PostMapping("/adduser")
    public Map<String,Object> addUser(@RequestBody TbUser user){

        Map<String, Object> map = userService.addUser(user);

        return map;
    }

    @ResponseBody
    @PostMapping("/edituser")
    public Map<String,Object> editUser(@RequestBody TbUser user){

        Map<String, Object> map = userService.editUser(user);

        return map;
    }
}
