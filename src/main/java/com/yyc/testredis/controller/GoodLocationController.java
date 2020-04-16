package com.yyc.testredis.controller;

import com.yyc.testredis.pojo.GoodsLocation;
import com.yyc.testredis.service.GoodLocationService;
import com.yyc.testredis.utils.JsonResult;
import com.yyc.testredis.utils.Page;
import com.yyc.testredis.utils.ResultMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@RequestMapping("/goodLocation")
@Controller
public class GoodLocationController {
    @Autowired
    GoodLocationService goodLocationService;

    /**
     * 商品位置信息-数据表格接口
     *
     * @return
     */
    @RequestMapping("/dataGrid")
    @ResponseBody
    public ResultMap<List<GoodsLocation>> backContent(Page page, @RequestParam("limit") int limit) {
        log.info("limit{}", limit);
        log.info("page{}", page.toString());
        page.setRows(limit);
        List<GoodsLocation> contentList = goodLocationService.selectPageList(page);
        int totals = goodLocationService.selectPageCount(page);
        page.setTotalRecord(totals);
        return new ResultMap("成功", contentList, 0, totals);
    }

    /**
     * 商品位置信息-数据表格接口
     *
     * @return
     */
    @RequestMapping("/selectGoodLocation")
    @ResponseBody
    public JsonResult selectGoodLocation() {
        log.info("查询货架列表");
        List<GoodsLocation> contentList = goodLocationService.selectAll();
        return new JsonResult(0,"成功",contentList);
    }



}
