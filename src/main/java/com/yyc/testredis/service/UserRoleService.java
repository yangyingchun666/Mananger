package com.yyc.testredis.service;

import com.yyc.testredis.pojo.UserRole;
import com.yyc.testredis.utils.Page;

import java.util.List;

public interface UserRoleService {
    List<UserRole> selectPageList(Page page);

    int selectPageCount(Page page);
}
