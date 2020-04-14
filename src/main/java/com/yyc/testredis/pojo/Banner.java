package com.yyc.testredis.pojo;

import java.util.Date;

public class Banner {
    private String id;

    private String bName;

    private Integer bSort;

    private String bPath;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public Integer getbSort() {
        return bSort;
    }

    public void setbSort(Integer bSort) {
        this.bSort = bSort;
    }

    public String getbPath() {
        return bPath;
    }

    public void setbPath(String bPath) {
        this.bPath = bPath == null ? null : bPath.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}