package com.yyc.testredis.controller;

import com.alibaba.fastjson.JSON;
import com.yyc.testredis.pojo.Banner;
import com.yyc.testredis.pojo.UserInfo;
import com.yyc.testredis.service.BannerService;
import com.yyc.testredis.service.Test1Service;
import com.yyc.testredis.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/index")
@Controller
@Slf4j
public class PageController {
    @Autowired
    Test1Service test1Service;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    BannerService bannerService;

    /**
     * 主页面
     *
     * @return
     */
    @GetMapping("/indexPage")
    public String index(Model model, String username) {
        log.info("登录到主页面");
        log.info("username:[]", username);
        UserInfo userInfo = userInfoService.selectByUsername(username);
        model.addAttribute("headerImgPath", userInfo.getHeaderImgPath());
        model.addAttribute("sign", userInfo.getSign());
        /**
         * 查询轮播图
         */
        List<Banner> bannerList = bannerService.selectAll();
//        String json = JSON.toJSONString(bannerList);
        model.addAttribute("bannerList",bannerList);
        return "indexPage";
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 注册
     *
     * @return
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 用户信息列表页面
     *
     * @return
     */
    @RequestMapping("/userInfoPage")
    public String userInfoPage() {
        return "userInfoList";
    }

    /**
     * 角色管理页面
     *
     * @return
     */
    @RequestMapping("/userRoleInfoPage")
    public String userRoleInfoPage() {
        return "roleInfoList";
    }

}
