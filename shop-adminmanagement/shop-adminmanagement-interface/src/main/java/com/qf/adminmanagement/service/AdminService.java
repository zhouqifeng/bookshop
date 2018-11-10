package com.qf.adminmanagement.service;

import com.qf.common.pojo.po.TbAdmin;
import com.qf.adminmanagement.pojo.vo.AdminPageInfo;

import java.util.List;

public interface AdminService {

    //查询管理员数量
    Integer selectAdminCount(AdminPageInfo pageInfo);

    //查询管理员的集合
    List<TbAdmin> selectAdminList(AdminPageInfo adminPageInfo);
    //添加管理员
    Integer addingAdmin(TbAdmin tbAdmin);
    //删除管理员
    Integer removeAdmin(TbAdmin tbAdmin);
    //修改管理员账户密码
    Integer modifyAdmin(TbAdmin tbAdmin);
    //批量删除管理员
    Integer deleteAdminArray(String ids);
}
