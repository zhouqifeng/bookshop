package com.qf.management.pojo.vo;

public class PageInfo {
    private Integer page;
    private Integer pageSize;
    private String searchWord;
    private Integer offSet;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public Integer getOffSet() {
        return (page-1) * pageSize;
    }

    public void setOffSet(Integer offSet) {
        this.offSet = offSet;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", searchWord='" + searchWord + '\'' +
                ", offSet=" + offSet +
                '}';
    }
}
