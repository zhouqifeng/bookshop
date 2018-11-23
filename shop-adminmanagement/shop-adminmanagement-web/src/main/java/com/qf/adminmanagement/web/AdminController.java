package com.qf.adminmanagement.web;

import com.qf.adminmanagement.service.AdminService;

import com.qf.adminmanagement.pojo.dto.DeleteAdmins;
import com.qf.common.pojo.po.TbAdmin;
import com.qf.adminmanagement.pojo.vo.AdminPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @ResponseBody
    @PostMapping("/admin")
    public Map<String, Object> adminList(@RequestBody AdminPageInfo adminPageInfo){
        Integer count=adminService.selectAdminCount(adminPageInfo);
        List<TbAdmin> list=adminService.selectAdminList(adminPageInfo);
        Map<String,Object> model=new HashMap<>();
        if(list!=null){
            model.put("count",count);
            model.put("list",list);
        }
        System.out.println(count+":"+list);
        return model;
    }
    @ResponseBody
    @PostMapping("/addAdmin")
    public Integer addAdmin(@RequestBody TbAdmin tbAdmin){
        System.out.println(tbAdmin.getAdminname());
        Integer i=adminService.addingAdmin(tbAdmin);

        return i;
    }
    @ResponseBody
    @PostMapping("/deleteAdmin")
    public Integer deleteAdmin(@RequestBody TbAdmin tbAdmin){
        System.out.println("删除ID:"+tbAdmin.getAdminid());
        Integer i=adminService.removeAdmin(tbAdmin);
        return i;
    }
    @ResponseBody
    @PostMapping("/editAdmin")
    public Integer editAdmin(@RequestBody TbAdmin tbAdmin){
        System.out.println(tbAdmin.getAdminid()+";"+tbAdmin.getAdminname());
        Integer i=adminService.modifyAdmin(tbAdmin);
        return i;

    }
    @ResponseBody
    @PostMapping("/deleteAdminArray")
    public Integer deleteAdminArray(@RequestBody DeleteAdmins deleteAdmins){
        System.out.println(deleteAdmins);
        String string=deleteAdmins.getIds();
        Integer integer=adminService.deleteAdminArray(string);
        return integer;
    }
}
