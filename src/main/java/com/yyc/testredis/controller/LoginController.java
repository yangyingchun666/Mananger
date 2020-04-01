package com.yyc.testredis.controller;

import com.yyc.testredis.service.Test1Service;
import com.yyc.testredis.utils.MD5Util;
import com.yyc.testredis.utils.ResultMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class LoginController {

    @Autowired
    Test1Service test1Service;

    @PostMapping("/loginInto")
    @ResponseBody
    public ResultMap login(@RequestParam("username") String username, @RequestParam("password")String password ){
        log.info("用户登录");
        log.info("username{}",username);
        log.info("password{}",password);
        String md5 = MD5Util.getMD5(password);
        String pwd=test1Service.selectPwdByUsername(username);
        String pwdMd5 = MD5Util.getMD5(pwd);
        if(md5.equals(pwdMd5)){
            return new ResultMap("成功",null,0,0);
        }else {
            return new ResultMap("失败",null,1,0);
        }

    }
}
