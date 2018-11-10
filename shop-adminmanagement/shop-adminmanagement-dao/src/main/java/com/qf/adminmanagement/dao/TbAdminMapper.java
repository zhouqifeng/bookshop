package com.qf.adminmanagement.dao;

import com.qf.common.pojo.po.TbAdmin;
import com.qf.adminmanagement.pojo.vo.AdminPageInfo;

import java.util.List;

public interface TbAdminMapper {

    //查询数量
    Integer countByExample(AdminPageInfo pageInfo);
    //分页查询
    List<TbAdmin> selectAdmins(AdminPageInfo pageInfo);
    //添加管理员
    Integer insertAdmin(TbAdmin tbAdmin);
    //删除管理员
    Integer deleteAdmin(TbAdmin tbAdmin);
    //修改管理员账户密码
    Integer editAdmin(TbAdmin tbAdmin);
    //批量删除管理员
    Integer deleteAdmins(List<Long> listL);
}