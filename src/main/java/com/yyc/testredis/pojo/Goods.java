package com.yyc.testredis.pojo;

import java.util.Date;

public class Goods {
    private String id;

    private String gName;

    private Integer gStock;

    private Integer gSalesVolume;

    private String gLocationId;

    private String gClassfyId;

    private String gImgPath;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }

    public Integer getgStock() {
        return gStock;
    }

    public void setgStock(Integer gStock) {
        this.gStock = gStock;
    }

    public Integer getgSalesVolume() {
        return gSalesVolume;
    }

    public void setgSalesVolume(Integer gSalesVolume) {
        this.gSalesVolume = gSalesVolume;
    }

    public String getgLocationId() {
        return gLocationId;
    }

    public void setgLocationId(String gLocationId) {
        this.gLocationId = gLocationId == null ? null : gLocationId.trim();
    }

    public String getgClassfyId() {
        return gClassfyId;
    }

    public void setgClassfyId(String gClassfyId) {
        this.gClassfyId = gClassfyId == null ? null : gClassfyId.trim();
    }

    public String getgImgPath() {
        return gImgPath;
    }

    public void setgImgPath(String gImgPath) {
        this.gImgPath = gImgPath;
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

    private String gLocationName;

    private String gClassfyName;

    public String getgLocationName() {
        return gLocationName;
    }

    public void setgLocationName(String gLocationName) {
        this.gLocationName = gLocationName;
    }

    /**
     * 返回数据封装时添加不属于当前表字段
     * @return
     */
    public String getgClassfyName() {
        return gClassfyName;
    }

    public void setgClassfyName(String gClassfyName) {
        this.gClassfyName = gClassfyName;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", gName='" + gName + '\'' +
                ", gStock=" + gStock +
                ", gSalesVolume=" + gSalesVolume +
                ", gLocationId='" + gLocationId + '\'' +
                ", gClassfyId='" + gClassfyId + '\'' +
                ", gImgPath='" + gImgPath + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", gLocationName='" + gLocationName + '\'' +
                ", gClassfyName='" + gClassfyName + '\'' +
                '}';
    }
}