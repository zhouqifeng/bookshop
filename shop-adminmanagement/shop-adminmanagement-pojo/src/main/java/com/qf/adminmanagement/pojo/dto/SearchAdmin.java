package com.qf.adminmanagement.pojo.dto;



import com.qf.common.pojo.po.TbAdmin;

import java.util.List;

public class SearchAdmin {
    private Integer count;
    private List<TbAdmin> list;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<TbAdmin> getList() {
        return list;
    }

    public void setList(List<TbAdmin> list) {
        this.list = list;
    }
}
