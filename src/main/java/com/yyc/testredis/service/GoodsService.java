package com.yyc.testredis.service;

import com.yyc.testredis.pojo.Goods;
import com.yyc.testredis.utils.Page;
import com.yyc.testredis.vo.GoodsVO;

import java.util.List;

public interface GoodsService {
    List<Goods> selectPageList(Page page);

    int selectPageCount(Page page);
}
