package com.yyc.testredis.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Classify {
    private String id;

    private String cName;

    private String cParentId;

    private Integer cLevelFlag;

    private Date createTime;

    private Date updateTime;
    @JsonIgnore
    private List<Classify> children = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcParentId() {
        return cParentId;
    }

    public void setcParentId(String cParentId) {
        this.cParentId = cParentId == null ? null : cParentId.trim();
    }

    public Integer getcLevelFlag() {
        return cLevelFlag;
    }

    public void setcLevelFlag(Integer cLevelFlag) {
        this.cLevelFlag = cLevelFlag;
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