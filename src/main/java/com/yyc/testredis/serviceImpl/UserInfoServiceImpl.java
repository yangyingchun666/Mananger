package com.yyc.testredis.serviceImpl;

import com.yyc.testredis.mapper.UserInfoMapper;
import com.yyc.testredis.pojo.UserInfo;
import com.yyc.testredis.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public Integer insert(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }
}
