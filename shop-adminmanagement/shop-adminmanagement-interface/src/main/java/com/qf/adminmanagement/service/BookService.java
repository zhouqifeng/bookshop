package com.qf.adminmanagement.service;

import com.alibaba.fastjson.JSONObject;
import com.qf.management.pojo.dto.BookList;
import com.qf.management.pojo.po.Book;
import com.qf.management.pojo.vo.PageInfo;

import java.util.List;
import java.util.Map;

public interface BookService {
    BookList searchBooksByPage(PageInfo pageInfo) throws Exception;
    int changeStatusUnder(Book book) throws Exception;
    List<JSONObject> getBigTypes() throws Exception;
    List<Map<String, Object>> getSmallTypes() throws Exception;
    int modifyById(Book book) throws  Exception;
    int addBook(Book book) throws Exception;
}
