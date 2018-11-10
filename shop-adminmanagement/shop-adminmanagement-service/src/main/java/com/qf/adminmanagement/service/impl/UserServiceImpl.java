package com.qf.adminmanagement.service.impl;

import com.qf.adminmanagement.dao.TbUserMapper;
import com.qf.adminmanagement.dao.UserMapper;
import com.qf.common.pojo.po.TbUser;
import com.qf.adminmanagement.pojo.vo.UserPageInfo;
import com.qf.adminmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userdao;

    @Autowired
    private TbUserMapper usermapper;

    @Override
    public Map<String,Object> searchUserByPage(UserPageInfo pageinfo) {

        Integer count = userdao.countUser(pageinfo);

        List<TbUser> list = userdao.searchUserByPage(pageinfo);

        HashMap<String, Object> map = new HashMap<>();

        map.put("count",count);

        map.put("list",list);

        return map;
    }

    @Override
    public Map<String, Object> addUser(TbUser user) {

        Integer count = userdao.saveUser(user);

        HashMap<String, Object> map = new HashMap<>();

        map.put("count",count);

        return map;
    }

    @Override
    public Map<String, Object> editUser(TbUser user) {

        Integer count = userdao.modifyUser(user);

        HashMap<String, Object> map = new HashMap<>();

        map.put("count",count);

        return map;
    }
}
