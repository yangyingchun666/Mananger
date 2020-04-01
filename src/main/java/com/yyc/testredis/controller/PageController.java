package com.yyc.testredis.controller;

import com.yyc.testredis.pojo.Test1;
import com.yyc.testredis.service.Test1Service;
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

    /**
     * 主页面
     * @return
     */
    @GetMapping("/indexPage")
    public String index(Model model, String username){
        log.info("登录到主页面");
        log.info("username:[]",username);
        Test1 test1=test1Service.selectByUsernameAndPwd(username);
        model.addAttribute("sign",test1.getSign());
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
