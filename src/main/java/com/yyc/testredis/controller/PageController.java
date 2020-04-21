package com.yyc.testredis.controller;

import com.yyc.testredis.pojo.Banner;
import com.yyc.testredis.pojo.UserInfo;
import com.yyc.testredis.service.BannerService;
import com.yyc.testredis.service.Test1Service;
import com.yyc.testredis.service.UserInfoService;
import com.yyc.testredis.utils.RedisUtil;
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
    @Autowired
    RedisUtil redisUtil;

    /**
     * 主页面
     *
     * @return
     */
    @GetMapping("/indexPage")
    public String index(Model model) {
        log.info("登录到主页面");
        String username= (String) redisUtil.get("username");
        log.info("username:[]", username);
        UserInfo userInfo = userInfoService.selectByUsername(username);
        model.addAttribute("headerImgPath", userInfo.getHeaderImgPath());
        model.addAttribute("sign", userInfo.getSign());
        /**
         * 查询轮播图
         */
        List<Banner> bannerList = bannerService.selectAll();
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
        return "listPage/userInfoList";
    }

    /**
     * 角色管理页面
     *
     * @return
     */
    @RequestMapping("/userRoleInfoPage")
    public String userRoleInfoPage() {
        return "listPage/roleInfoList";
    }

    /**
     * 分类管理页面
     *
     * @return
     */
    @RequestMapping("/classifyListPage")
    public String classifyInfoPage() {
        return "listPage/classifyList";
    }

    /**
     * 商品位置管理页面
     *
     * @return
     */
    @RequestMapping("/goodLocationPage")
    public String goodLocationInfoPage() {
        return "listPage/goodLocation";
    }

    /**
     * 商品位置管理页面
     *
     * @return
     */
    @RequestMapping("/goodsInfoPage")
    public String goodsInfoPage() {
        return "listPage/goodsList";
    }

    @RequestMapping("/zTreePage")
    public String zTreePage() {
        return "zTreeDemo";
    }

}
