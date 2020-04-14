package com.yyc.testredis.pojo;

import java.util.Date;

public class GoodsLocation {
    private String id;

    private String lName;

    private String lOld;

    private String lNew;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName == null ? null : lName.trim();
    }

    public String getlOld() {
        return lOld;
    }

    public void setlOld(String lOld) {
        this.lOld = lOld == null ? null : lOld.trim();
    }

    public String getlNew() {
        return lNew;
    }

    public void setlNew(String lNew) {
        this.lNew = lNew == null ? null : lNew.trim();
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