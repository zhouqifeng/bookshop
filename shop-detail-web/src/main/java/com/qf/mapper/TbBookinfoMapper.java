package com.qf.mapper;

import com.qf.common.pojo.po.TbBookinfo;
import com.qf.common.pojo.po.TbBookinfoExample;
import com.qf.pojo.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbBookinfoMapper {

    List<Item> getItemById(Long itemId);
}