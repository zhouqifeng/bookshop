package com.qf.adminmanagement.service;

import com.qf.common.pojo.po.TbUser;
import com.qf.adminmanagement.pojo.dto.UserPageInfo;

import java.util.Map;


public interface UserService {

     Map<String,Object> searchUserByPage(UserPageInfo pageinfo);

     Map<String,Object> addUser(TbUser user);

     Map<String,Object> editUser(TbUser user);
}
