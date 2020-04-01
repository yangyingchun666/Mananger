package com.yyc.testredis.serviceImpl;

import com.yyc.testredis.mapper.Test1Mapper;
import com.yyc.testredis.pojo.Test1;
import com.yyc.testredis.service.Test1Service;
import com.yyc.testredis.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Test1ServiceImpl implements Test1Service {

    @Autowired
    Test1Mapper test1Mapper;

    @Override
    public List<Test1> selectPageList(Page page) {
        List<Test1> list=test1Mapper.selectPageList(page);
        return list;
    }

    @Override
    public int selectPageCount(Page page) {
        return test1Mapper.selectPageCount(page);
    }

    @Override
    public List<Test1> selectAll() {
        return test1Mapper.selectAll();
    }

    @Override
    public Integer selectCount() {
        return  test1Mapper.selectCount();
    }

    @Override
    public Test1 selectTest1ById(String id) {
        return test1Mapper.selectByPrimaryKey(id);
    }

    @Override
    public String selectPwdByUsername(String username) {
        return test1Mapper.selectPwdByUsername(username);
    }
}
