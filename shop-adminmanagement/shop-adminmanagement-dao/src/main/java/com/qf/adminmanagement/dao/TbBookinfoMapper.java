package com.qf.adminmanagement.dao;

import com.qf.common.pojo.po.TbBookinfo;
import com.qf.common.pojo.po.TbBookinfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbBookinfoMapper {
    int countByExample(TbBookinfoExample example);

    int deleteByExample(TbBookinfoExample example);

    int deleteByPrimaryKey(Integer bookid);

    int insert(TbBookinfo record);

    int insertSelective(TbBookinfo record);

    List<TbBookinfo> selectByExampleWithBLOBs(TbBookinfoExample example);

    List<TbBookinfo> selectByExample(TbBookinfoExample example);

    TbBookinfo selectByPrimaryKey(Integer bookid);

    int updateByExampleSelective(@Param("record") TbBookinfo record, @Param("example") TbBookinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") TbBookinfo record, @Param("example") TbBookinfoExample example);

    int updateByExample(@Param("record") TbBookinfo record, @Param("example") TbBookinfoExample example);

    int updateByPrimaryKeySelective(TbBookinfo record);

    int updateByPrimaryKeyWithBLOBs(TbBookinfo record);

    int updateByPrimaryKey(TbBookinfo record);
}