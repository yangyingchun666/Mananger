package com.yyc.testredis.vo;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsVO {
    private String id;

    private String gName;

    private Integer gStock;

    private Integer gSalesVolume;

    private String gLocationId;

    private String gLocationName;

    private String gClassfyId;

    private String gClassfyName;

    private Date createTime;

    private Date updateTime;
}
