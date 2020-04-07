package com.yyc.testredis.serviceImpl;

import com.yyc.testredis.mapper.UserRoleMapper;
import com.yyc.testredis.pojo.UserRole;
import com.yyc.testredis.service.UserRoleService;
import com.yyc.testredis.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;


    @Override
    public List<UserRole> selectPageList(Page page) {
        return userRoleMapper.selectPageList(page);
    }

    @Override
    public int selectPageCount(Page page) {
        return  userRoleMapper.selectPageCount(page);
    }
}
