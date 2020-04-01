package com.yyc.testredis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/index")
@Controller
public class PageController {

    /**
     * 主页面
     * @return
     */
    @RequestMapping("/indexPage")
    public String index(){
        return "indexPage";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
