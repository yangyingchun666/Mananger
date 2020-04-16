package com.yyc.testredis.service;

import com.yyc.testredis.pojo.GoodsLocation;
import com.yyc.testredis.utils.Page;

import java.util.List;

public interface GoodLocationService {
    List<GoodsLocation> selectPageList(Page page);

    int selectPageCount(Page page);

    List<GoodsLocation> selectAll();

    Integer insert(GoodsLocation goodsLocation);

    int delete(String id);

    int update(GoodsLocation goodsLocation);

    GoodsLocation selectById(String id);
}
