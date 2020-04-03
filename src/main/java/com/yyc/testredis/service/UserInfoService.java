package com.yyc.testredis.service;

import com.yyc.testredis.pojo.Test1;
import com.yyc.testredis.pojo.UserInfo;
import com.yyc.testredis.utils.Page;
import com.yyc.testredis.vo.UserInfoVO;

import java.util.List;

public interface UserInfoService {

    Integer insert(UserInfo userInfo);

    Integer selectCountByParam(String verifyPhone,String verifyUsername);

    String selectPwdByUsername(String username);

    UserInfo selectByUsername(String username);

    List<UserInfoVO> selectPageList(Page page);

    int selectPageCount(Page page);

    UserInfoVO selectUserInfoById(String id);

    Integer update(UserInfo userInfo);
}
