package com.qf.adminmanagement.pojo.dto;

public class OrderInfo {

    private int page;
    private int pagesize;
    private int offset;
    private String select_word;

    public String getSelect_word() {
        return select_word;
    }

    public void setSelect_word(String select_word) {
        this.select_word = select_word;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getOffset(){
        return (page-1)*pagesize;
    }
}
