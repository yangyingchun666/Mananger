package com.yyc.testredis.service;

import com.yyc.testredis.pojo.Test1;
import com.yyc.testredis.utils.Page;

import java.util.List;

public interface Test1Service {

    List<Test1> selectPageList(Page page);

    int selectPageCount(Page page);

    List<Test1> selectAll();

    Integer selectCount();

    Test1 selectTest1ById(String id);

    String selectPwdByUsername(String username);
}
