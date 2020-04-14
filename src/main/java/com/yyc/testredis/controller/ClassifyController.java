package com.yyc.testredis.controller;

import com.yyc.testredis.pojo.Classify;
import com.yyc.testredis.service.ClassifyService;
import com.yyc.testredis.utils.Page;
import com.yyc.testredis.utils.ResultMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yyc
 * @date 2020-4-14
 * 商品分类控制器
 */
@Controller
@RequestMapping("/classify")
@Slf4j
public class ClassifyController {

    @Autowired
    ClassifyService classifyService;

    /**
     * layui-数据表格接口
     *
     * @return
     */
    @RequestMapping("/dataGrid")
    @ResponseBody
    public ResultMap<List<Classify>> backContent(Page page, @RequestParam("limit") int limit) {
        log.info("limit{}", limit);
        log.info("page{}", page.toString());
        page.setRows(limit);
        List<Classify> contentList = classifyService.selectPageList(page);
        int totals = classifyService.selectPageCount(page);
        page.setTotalRecord(totals);
        return new ResultMap("成功", contentList, 0, totals);
    }
}
