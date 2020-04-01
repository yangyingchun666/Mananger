package com.yyc.testredis.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yyc.testredis.pojo.Test1;
import com.yyc.testredis.service.Test1Service;
import com.yyc.testredis.utils.Page;
import com.yyc.testredis.utils.RedisUtil;
import com.yyc.testredis.utils.ResultMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestRedisController {
    @Autowired
    Test1Service test1Service;
    private static int ExpireTime = 3600;   // redis中存储的过期时间60s
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/redis")
    public String testRedis() {
        return "TestRedis";
    }

    /**
     * layui-content后台代码
     *
     * @return
     */
    @RequestMapping("/dataGrid")
    @ResponseBody
    public ResultMap<List<Test1>> backContent(Page page, @RequestParam("limit") int limit) {
        log.info("limit{}", limit);
        log.info("page{}", page.toString());
        Integer count = test1Service.selectCount();
        /**
         * 使用redis
         */
        if (count == 5 && redisUtil.get("data") != null) {
            log.info("data{}", redisUtil.get("data"));
            JSONArray jsonlist = JSONObject.parseArray((String) redisUtil.get("data"));
            List<Test1> list1 = (List<Test1>) JSON.toJSON(jsonlist);
            Integer total = Integer.valueOf((String) redisUtil.get("pageCount"));
            return new ResultMap("成功", list1, 0, total);
        } else {
            page.setRows(limit);
            List<Test1> contentList = test1Service.selectPageList(page);
            int totals = test1Service.selectPageCount(page);
            page.setTotalRecord(totals);
            redisUtil.set("data", JSON.toJSONString(contentList));
            redisUtil.set("pageCount", "" + totals);
            redisUtil.expire("data", ExpireTime);
            return new ResultMap("成功", contentList, 0, totals);
        }
        /**
         *不使用redis
         */
        /*page.setRows(limit);
        List<Test1> contentList = test1Service.selectPageList(page);
        int totals = test1Service.selectPageCount(page);
        page.setTotalRecord(totals);
        return new ResultMap("成功", contentList, 0, totals);*/
    }

    /**
     * 编辑页面
     */
    @RequestMapping("/editData")
    public String editDataPage(Model model, @RequestParam("id") String id) {
        log.info("编辑页面");
        Test1 test1 = test1Service.selectTest1ById(id);
        model.addAttribute("test1", test1);
        return "helloPage";
    }

}
