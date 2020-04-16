package com.yyc.testredis.controller;

import com.yyc.testredis.pojo.Goods;
import com.yyc.testredis.service.ClassifyService;
import com.yyc.testredis.service.GoodsService;
import com.yyc.testredis.utils.CreateIDUtils;
import com.yyc.testredis.utils.JsonResult;
import com.yyc.testredis.utils.Page;
import com.yyc.testredis.utils.ResultMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RequestMapping("/goods")
@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;
    @Autowired
    ClassifyService classifyService;


    /**
     * 商品信息-数据表格接口
     *
     * @return
     */
    @RequestMapping("/dataGrid")
    @ResponseBody
    public ResultMap<List<Goods>> backContent(Page page, @RequestParam("limit") int limit) {
        log.info("limit{}", limit);
        log.info("page{}", page.toString());
        page.setRows(limit);
        List<Goods> contentList = goodsService.selectPageList(page);
        int totals = goodsService.selectPageCount(page);
        page.setTotalRecord(totals);
        return new ResultMap("成功", contentList, 0, totals);
    }

    /**
     * 添加页面
     */
    @RequestMapping("/addGoods")
    public String addGoods() {
        log.info("商品添加页面");
        return "addPage/goodsAdd";
    }


    /**
     * @param
     * @return
     * @Description: 添加商品
     * @author Anakin Yang
     * @date 2020/4/15 12:06
     */
    @RequestMapping("/saveAddGoods")
    @ResponseBody
    public JsonResult saveAddGoods(@RequestParam("gImgPath") String gImgPath,@RequestParam("gName")String gName,
                                   @RequestParam("gStock")Integer gStock,@RequestParam("goodLocation")String goodLocation,
                                   @RequestParam("levelOne")String levelOne,@RequestParam("levelTwo")String levelTwo,
                                   @RequestParam("levelThree")String levelThree) {
        log.info("添加商品,参数:gImgPath,gName,gStock,goodLocation,levelOne,levelTwo,levelThree{}",gImgPath,gName,gStock,goodLocation,levelOne,levelTwo,levelThree);
        /**
         *  封装参数
         **/
        Goods goods = new Goods();
        goods.setId(CreateIDUtils.genGoodsId());
        goods.setgName(gName);
        goods.setgName(gName);
        goods.setgImgPath(gImgPath);
        goods.setgLocationId(goodLocation);
        goods.setgSalesVolume(0);
        goods.setgStock(gStock);
        goods.setgClassfyId(levelThree);
        goods.setCreateTime(new Date());
        goods.setUpdateTime(new Date());
        Integer rows = 0;
        rows = goodsService.insert(goods);
        if(rows <1){
            return new JsonResult(1,"失败");
        }else {
            return new JsonResult(0, "成功");
        }
    }

    /**
     * @Description: 删除商品
     *
     * @author Anakin Yang
     * @date 2020/4/16 9:47
     * @param id
     * @return JsonResult
     */
    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam("id") String id){
        log.info("删除商品，id{}",id);
        Integer rows=goodsService.deleteById(id);
        if(rows<1 ){
            return new JsonResult(1,"删除失败");
        }else {
            return new JsonResult(0,"删除成功");
        }
    }


    /**
     * @Description: 商品修改页面
     *
     * @author Anakin Yang
     * @date 2020/4/16 11:53
     * @param
     * @return
     */
    @RequestMapping("/editGoods")
    public String editGoodsPage(Model model, @RequestParam("id") String id) {
        log.info("商品修改页面,参数{}:",id);
        /**
        *  根据id查询商品信息
        **/
        Goods goods = goodsService.selectById(id);
        model.addAttribute("id",id);
        model.addAttribute("gImgPath",goods.getgImgPath());
        model.addAttribute("gName",goods.getgName());
        model.addAttribute("gStock",goods.getgStock());
        model.addAttribute("gLocationId",goods.getgLocationId());
        model.addAttribute("levelThree",goods.getgClassfyId());
        //查询上上级id
        String levelTwo= classifyService.selectParentIdById(goods.getgClassfyId());
        String levelOne= classifyService.selectParentIdById(levelTwo);
        model.addAttribute("levelOne",levelOne);
        model.addAttribute("levelTwo",levelTwo);
        return "editPage/goodsEdit";
    }


    /**
     * @Description: 商品保存修改
     *
     * @author Anakin Yang
     * @date 2020/4/16 10:59
     * @param id,gImgPath,gName,gStock,goodLocation,levelOne,levelTwo,levelThree
     * @return JsonResult
     */
    @RequestMapping("/saveEditGoods")
    @ResponseBody
    public JsonResult saveEditGoods(@RequestParam("id") String id,@RequestParam("gImgPath") String gImgPath,@RequestParam("gName")String gName,
                                     @RequestParam("gStock")Integer gStock,@RequestParam("goodLocation")String goodLocation,
                                     @RequestParam("levelOne")String levelOne,@RequestParam("levelTwo")String levelTwo,
                                     @RequestParam("levelThree")String levelThree) {
        log.info("修改商品,参数:id,gImgPath,gName,gStock,goodLocation,levelOne,levelTwo,levelThree{}",id,gImgPath,gName,gStock,goodLocation,levelOne,levelTwo,levelThree);

        Goods goods = new Goods();
        goods.setId(id);
        goods.setgName(gName);
        goods.setgImgPath(gImgPath);
        goods.setgLocationId(goodLocation);
        goods.setgStock(gStock);
        goods.setgClassfyId(levelThree);
        goods.setUpdateTime(new Date());
        Integer rows = goodsService.update(goods);
        if(rows<1 ){
            return new JsonResult(1,"删除失败");
        }else {
            return new JsonResult(0,"删除成功");
        }
    }
}
