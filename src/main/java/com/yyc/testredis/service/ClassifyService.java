package com.yyc.testredis.service;

import com.yyc.testredis.pojo.Classify;
import com.yyc.testredis.utils.Page;

import java.util.List;

public interface ClassifyService {
    List<Classify> selectPageList(Page page);

    int selectPageCount(Page page);
}
