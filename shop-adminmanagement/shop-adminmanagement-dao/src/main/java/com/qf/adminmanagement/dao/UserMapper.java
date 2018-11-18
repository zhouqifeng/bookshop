package com.qf.adminmanagement.dao;

import com.alibaba.fastjson.JSONArray;
import com.qf.common.pojo.po.TbUser;
import com.qf.adminmanagement.pojo.dto.UserPageInfo;

import java.util.List;

public interface UserMapper {

    Integer countUser(UserPageInfo pageinfo);

    List<TbUser> searchUserByPage(UserPageInfo pageinfo);

    Integer saveUser(TbUser user);

    Integer modifyUser(TbUser user);

    Integer removeUser(Integer userid);

    Integer removeUsers(JSONArray array);
}
