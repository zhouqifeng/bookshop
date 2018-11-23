package com.qf.adminmanagement.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qf.adminmanagement.dao.BookMapper;
import com.qf.adminmanagement.service.BookService;
import com.qf.management.pojo.dto.BookList;
import com.qf.management.pojo.po.Book;
import com.qf.management.pojo.po.BookType;
import com.qf.management.pojo.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper dao;

    @Override
    public BookList searchBooksByPage(PageInfo pageInfo) throws Exception {
        BookList list = new BookList();
        list.setCount(dao.selectCount(pageInfo));
        List<Book> bookList = dao.selectBooksByPage(pageInfo);
        for (Book book:bookList) {
            if(0==book.getStatus()){
                book.setBool(true);
            }else{
                book.setBool(false);
            }
        }
        list.setList(bookList);
        return list;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int changeStatusUnder(Book book) throws Exception {
        int i = 0;
        if(book.getBool()) {
            i = dao.updateStatusUp(book);
        }else {
            i = dao.updateStatusUnder(book);
        }
        return i;
    }

    @Override
    public List<JSONObject> getBigTypes() throws Exception {
        List<JSONObject> list = new ArrayList<>();
        JSONObject jsonObject = null;
        List<BookType> list1 = dao.selectBigTypes();
        for (BookType bookType : list1) {
            jsonObject = new JSONObject();
            jsonObject.put("label",bookType.getTypename());
            jsonObject.put("value",bookType.getId());
            list.add(jsonObject);
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> getSmallTypes() throws Exception {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = null;
        List<BookType> list1 = dao.selectSmallTypes();
        for (BookType bookType : list1) {
            map = new HashMap<>();
            map.put("bigtype",bookType.getParentid());
            map.put("label",bookType.getTypename());
            map.put("value",bookType.getId());
            list.add(map);
        }
        return list;
    }

    @Override
    public int modifyById(Book book) throws Exception {
        int i = dao.updateBookInventoryById(book);
        int j = dao.updateBookById(book);
        return i+j;
    }

    @Override
    public int addBook(Book book) throws Exception {
        dao.insertBookinventory(book);
        int a = dao.selectPublishername(book);
        if(a==0){
            dao.insertPublisher(book);
        }
        int i = dao.selectPublisherid(book);
        book.setPublisherid(i);
        dao.insertBookinfo(book);
        int index = dao.selectBookidByIsbn(book);
        return index;
    }


}
