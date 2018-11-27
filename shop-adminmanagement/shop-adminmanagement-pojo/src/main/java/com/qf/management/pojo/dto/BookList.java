package com.qf.management.pojo.dto;

import com.qf.management.pojo.po.Book;

import java.util.List;

public class BookList {
    private Integer count;
    private List<Book> list;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}
