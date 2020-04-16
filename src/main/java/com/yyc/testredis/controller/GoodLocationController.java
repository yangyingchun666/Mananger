package com.yyc.testredis.controller;

import com.yyc.testredis.pojo.GoodsLocation;
import com.yyc.testredis.service.GoodLocationService;
import com.yyc.testredis.utils.CreateIDUtils;
import com.yyc.testredis.utils.JsonResult;
import com.yyc.testredis.utils.Page;
import com.yyc.testredis.utils.ResultMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
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


    /**
     * @Description: 添加货架（位置）页面
     *
     * @author Anakin Yang
     * @date 2020/4/16 13:49
     * @param
     * @return
     */
    @RequestMapping("/addGoodLocationPage")
    public String addGoodLocationPage(){
        return "/addPage/goodLocationAdd";
    }

    /**
     * @Description: 删除货架
     *
     * @author Anakin Yang
     * @date 2020/4/16 14:47
     * @param
     * @return
     */
    @RequestMapping("/saveAddGoodLocation")
    @ResponseBody
    public JsonResult saveAddGoodLocation(@RequestParam("lName") String lName,@RequestParam("lOld") String lOld) {
        log.info("——————————————————新增货架————————————————");
        log.info("参数lName{}:",lName);
        log.info("参数lOld{}:",lOld);
        if(lName==null ||"".equals(lName)){
            return new JsonResult(1,"失败:货架名称为未填写");
        }
        /**
        * 分装参数
        **/
        GoodsLocation goodsLocation = new GoodsLocation();
        goodsLocation.setId(CreateIDUtils.genGoodLocationId());
        goodsLocation.setlName(lName);
        goodsLocation.setlOld(lOld);
        goodsLocation.setlNew(lName);
        goodsLocation.setCreateTime(new Date());
        goodsLocation.setUpdateTime(new Date());
        Integer rows= goodLocationService.insert(goodsLocation);
        if(rows<1){
            log.info("数据插入失败");
            return new JsonResult(1,"失败:插入失败");
        }else {
            return new JsonResult(0,"成功");
        }
    }


    /**
     * @Description: 删除货架
     *
     * @author Anakin Yang
     * @date 2020/4/16 15:12
     * @param
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam("id") String id) {
        log.info("——————————————————删除货架————————————————");
        log.info("id{}:",id);
        if(id==null ||"".equals(id)){
            return new JsonResult(1,"失败:货架名称为未填写");
        }
        int rows= goodLocationService.delete(id);
        if(rows<1){
            log.info("数据插入失败");
            return new JsonResult(1,"失败:删除失败");
        }else {
            return new JsonResult(0,"删除成功");
        }
    }


    /**
     * @Description: 货架修改页面
     *
     * @author Anakin Yang
     * @date 2020/4/16 15:22
     * @param
     * @return
     */
    @RequestMapping("/editGoodLocationPage")
    public String editGoodLocationPage(@RequestParam("id") String id, Model model){
        log.info("——————————————————修改货架页面————————————————");
        log.info("参数id{}:",id);
        /**
        *   查询选中的数据
        **/
        GoodsLocation goodsLocation =goodLocationService.selectById(id);
        model.addAttribute("goodLocation",goodsLocation);
        return "/editPage/editGoodLocation";
    }

    /**
     * @Description: 修改货架信息
     * @author Anakin Yang
     * @date 2020/4/16 15:20
     * @param id lName lNew
     * @return JsonResult
     */
    @RequestMapping("/saveEditGoodLocation")
    @ResponseBody
    public JsonResult saveEditGoodLocation(@RequestParam("id") String id,@RequestParam("lName") String lName,@RequestParam("lNew") String lNew) {
        log.info("——————————————————修改货架信息————————————————");
        log.info("参数id:{}",id);
        log.info("参数lName:{}",lName);
        log.info("参数lNew:{}",lNew);
        if(lName==null ||"".equals(lName) ||id==null ||"".equals(id) ||lNew==null ||"".equals(lNew)){
            return new JsonResult(1,"失败:参数异常");
        }
        /**
         * 分装参数
         **/
        GoodsLocation goodsLocation = new GoodsLocation();
        /**
        *   被修改货架名称改为旧货架，新货架名称加入
        **/
        goodsLocation.setId(id);
        goodsLocation.setlName(lNew);
        goodsLocation.setlOld(lName);
        goodsLocation.setlNew(lNew);
        goodsLocation.setUpdateTime(new Date());
        int rows=0;
        try {
            rows= goodLocationService.update(goodsLocation);
        }catch (Exception e){
            log.info("跟新异常",e);
            return new JsonResult(1,"失败:数据更新失败");
        }
        return new JsonResult(0,"修改成功");
    }
}
