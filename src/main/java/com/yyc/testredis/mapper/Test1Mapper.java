package com.yyc.testredis.mapper;

import com.yyc.testredis.pojo.Test1;
import com.yyc.testredis.utils.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Test1Mapper {
    int deleteByPrimaryKey(String id);

    int insert(Test1 record);

    Test1 selectByPrimaryKey(String id);

    List<Test1> selectAll();

    int updateByPrimaryKey(Test1 record);

    List<Test1> selectPageList(Page page);

    int selectPageCount(Page page);

    Integer selectCount();

    String selectPwdByUsername(@Param("username") String username);
}