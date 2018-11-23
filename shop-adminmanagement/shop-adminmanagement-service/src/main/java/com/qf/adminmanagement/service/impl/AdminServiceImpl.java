package com.qf.adminmanagement.service.impl;

import com.qf.adminmanagement.dao.TbAdminMapper;
import com.qf.adminmanagement.service.AdminService;
import com.qf.common.pojo.po.TbAdmin;
import com.qf.adminmanagement.pojo.vo.AdminPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private TbAdminMapper tbAdminMapper;


    @Override
    public Integer selectAdminCount(AdminPageInfo adminPageInfo) {
        return tbAdminMapper.countByExample(adminPageInfo);
    }

    @Override
    public List<TbAdmin> selectAdminList(AdminPageInfo adminPageInfo) {
        return tbAdminMapper.selectAdmins(adminPageInfo);
    }

    @Override
    public Integer addingAdmin(TbAdmin tbAdmin) {
        return tbAdminMapper.insertAdmin(tbAdmin);
    }

    @Override
    public Integer removeAdmin(TbAdmin tbAdmin) {
        return tbAdminMapper.deleteAdmin(tbAdmin);
    }

    @Override
    public Integer modifyAdmin(TbAdmin tbAdmin) {
        return tbAdminMapper.editAdmin(tbAdmin);
    }

    @Override
    public Integer deleteAdminArray(String ids) {
        List<String> listStr = java.util.Arrays.asList(ids.split(","));
        List<Long> listL = new ArrayList<>();
        Long l ;
        for (String s1:listStr) {
            l = Long.parseLong(s1);
            listL.add(l);
            //System.out.println(l);
        }

        return tbAdminMapper.deleteAdmins(listL);
    }


}
