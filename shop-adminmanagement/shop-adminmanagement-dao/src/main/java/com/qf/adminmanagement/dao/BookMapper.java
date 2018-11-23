package com.qf.adminmanagement.dao;

import com.qf.management.pojo.po.Book;
import com.qf.management.pojo.po.BookType;
import com.qf.management.pojo.vo.PageInfo;

import java.util.List;

public interface BookMapper {
    int selectCount(PageInfo pageInfo) throws Exception;
    List<Book> selectBooksByPage(PageInfo pageInfo) throws Exception;
    int updateStatusUnder(Book book) throws Exception;
    int updateStatusUp(Book book) throws Exception;
    List<BookType> selectBigTypes() throws Exception;
    List<BookType> selectSmallTypes() throws Exception;
    int updateBookById(Book book) throws Exception;
    int updateBookInventoryById(Book book) throws Exception;
    int insertBookinventory(Book book) throws Exception;
    int insertPublisher(Book book) throws  Exception;
    int insertBookinfo(Book book) throws Exception;
    int selectPublisherid(Book book) throws Exception;
    int selectBookidByIsbn(Book book) throws Exception;
    int selectPublishername(Book book) throws Exception;
}
