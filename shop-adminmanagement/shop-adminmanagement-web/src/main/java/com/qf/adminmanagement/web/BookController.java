package com.qf.adminmanagement.web;

import com.alibaba.fastjson.JSONObject;
import com.qf.adminmanagement.service.BookService;
import com.qf.common.fdfs.FastDFSFile;
import com.qf.common.fdfs.FastDFSUtils;
import com.qf.common.utilss.PropKit;
import com.qf.common.utilss.StrKit;
import com.qf.management.pojo.dto.BookList;
import com.qf.management.pojo.po.Book;
import com.qf.management.pojo.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.jms.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    @Autowired
    BookService ser;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource
    private Destination topicDestination;

    @PostMapping("/books")
    @ResponseBody
    public BookList searchBooksByPage(@RequestBody PageInfo pageInfo){
        BookList list = null;
        try {
            list = ser.searchBooksByPage(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @ResponseBody
    @PostMapping("/undercarriage")
    public int changeStatusUnder(@RequestBody Book book){
        int i = 0;
        try {
            i = ser.changeStatusUnder(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @PostMapping("/bigtypes")
    @ResponseBody
    public List<JSONObject> getBigTypes(){
        List<JSONObject> list = null;
        try {
            list = ser.getBigTypes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @PostMapping("/smalltypes")
    @ResponseBody
    public List<Map<String,Object>> getSmallTypes(){
        List<Map<String,Object>> list = null;
        try {
            list = ser.getSmallTypes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @PostMapping("/editUser")
    @ResponseBody
    public int modifyById(@RequestBody Book book){
        int i = 0;
        try {
            i = ser.modifyById(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @PostMapping("/addUser")
    @ResponseBody
    public void addBook(@RequestBody Book book){
        try {
            int index = ser.addBook(book);
            //2. 发送消息
            jmsTemplate.send(topicDestination, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException{
                    TextMessage message = session.createTextMessage(index + "");
                    return message;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @PostMapping("/uploadImage")
    public Map<String, Object> uploadImage(@RequestParam MultipartFile file) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            //1. 形成实体类
            FastDFSFile fastDFSFile = new FastDFSFile(file.getBytes(), file.getOriginalFilename(), file.getSize());
            //2. 调用工具类进行文件上传
            // remotePath： group1/M00/00/00/xxx.jpg
            String remotePath = FastDFSUtils.uploadFile(fastDFSFile);
            //3. 形成返回的JSON
            if (StrKit.notBlank(remotePath)) {
                //不为空，成功
                String basePath = PropKit.use("fdfs_client.conf").get("fdfs_server");
                String path = basePath + "/" + remotePath;
                map.put("code", 0);
                map.put("url", path);
            } else {
                //失败
                map.put("code", 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}
