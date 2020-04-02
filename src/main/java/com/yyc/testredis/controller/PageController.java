package com.yyc.testredis.controller;

import com.yyc.testredis.pojo.UserInfo;
import com.yyc.testredis.service.Test1Service;
import com.yyc.testredis.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/index")
@Controller
@Slf4j
public class PageController {
    @Autowired
    Test1Service test1Service;
    @Autowired
    UserInfoService userInfoService;

    /**
     * 主页面
     * @return
     */
    @GetMapping("/indexPage")
    public String index(Model model, String username){
        log.info("登录到主页面");
        log.info("username:[]",username);
        UserInfo userInfo=userInfoService.selectByUsername(username);
        model.addAttribute("headerImgPath",userInfo.getHeaderImgPath());
        model.addAttribute("sign",userInfo.getSign());
        return "indexPage";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 注册
     * @return
     */
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

}
