package com.qf.adminmanagement.dao;

import com.qf.adminmanagement.pojo.dto.OrderInfo;
import com.qf.common.pojo.po.TbOrder;
import com.qf.common.pojo.po.TbOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbOrderMapper {
    int countByExample(TbOrderExample example);

    int deleteByExample(TbOrderExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(TbOrder record);

    int insertSelective(TbOrder record);

    List<TbOrder> selectByExampleWithBLOBs(TbOrderExample example);

    List<TbOrder> selectByExample(TbOrderExample example);

    TbOrder selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("record") TbOrder record, @Param("example") TbOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") TbOrder record, @Param("example") TbOrderExample example);

    int updateByExample(@Param("record") TbOrder record, @Param("example") TbOrderExample example);

    int updateByPrimaryKeySelective(TbOrder record);

    int updateByPrimaryKeyWithBLOBs(TbOrder record);

    int updateByPrimaryKey(TbOrder record);

    int selectCount(OrderInfo orderInfo);

    List<TbOrder> selectOrders(OrderInfo orderInfo);
}