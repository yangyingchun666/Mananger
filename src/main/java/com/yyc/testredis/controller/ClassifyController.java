package com.yyc.testredis.controller;

import com.yyc.testredis.pojo.Classify;
import com.yyc.testredis.service.ClassifyService;
import com.yyc.testredis.utils.CreateIDUtils;
import com.yyc.testredis.utils.JsonResult;
import com.yyc.testredis.utils.Page;
import com.yyc.testredis.utils.ResultMap;
import com.yyc.testredis.vo.ClassifyVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
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
     * 商品分类列表-数据表格接口
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

    /**
     * 添加商品页面查询分类
     *
     * @param level
     * @return
     */
    @RequestMapping("/selectClassifyLevel")
    @ResponseBody
    public JsonResult selectClassifyLevel(@RequestParam("level") Integer level) {
        log.info("根据分类级别查询分类列表,参数level=[]", level);
        List<Classify> classifyList = classifyService.selectClassifyByLevel(level);
        return new JsonResult(0, "成功", classifyList);

    }

    /**
     * @param
     * @return string
     * @Description: 分类添加页面
     * @author Anakin Yang
     * @date 2020/4/16 16:35
     */
    @RequestMapping("/addClassify")
    public String addClassify() {
        log.info("————————————分类添加页面————————————");
        return "/addPage/classifyAdd";
    }

    /**
     * @Description: 保存添加分类
     *
     * @author Anakin Yang
     * @date 2020/4/21 16:46
     * @param cName,cParentId
     * @return JsonResult
     */
    @RequestMapping("/saveAddClassify")
    @ResponseBody
    public JsonResult saveAddClassify(@RequestParam("cName") String cName, @RequestParam("cParentId") String cParentId) {
        log.info("————————————分类添加保存————————————");
        log.info("参数cName:{}", cName);
        log.info("参数cParentId:{}", cParentId);
        /**
        * 封装参数
        **/
        Classify classify = new Classify();
        classify.setId(CreateIDUtils.genStringId());
        classify.setcName(cName);
        classify.setcParentId(cParentId);
        Integer parentLevel =classifyService.selectParentLevel(cParentId);
        if(parentLevel==null){
            parentLevel=0;
        }
        classify.setcLevelFlag(parentLevel+1);
        classify.setCreateTime(new Date());
        classify.setUpdateTime(new Date());
        int rows=0;
        try {
            rows=classifyService.insert(classify);
        }catch (Exception e){
            log.info("分类添加异常");
            return new JsonResult(1,"分类添加失败");
        }
        if(rows<1){
            return new JsonResult(1,"分类添加失败");
        }
        return new JsonResult(0, "分类添加成功");
    }

    /**
     * @param 
     * @return list
     * @Description: zTree树
     * @author Anakin Yang
     * @date 2020/4/17 10:32
     */
    @RequestMapping("/getClassify")
    @ResponseBody
    public List<ClassifyVO> getMenuTestList() {
        log.info("————————————分类ZTree————————————");
        List<ClassifyVO> classifyList = classifyService.getClassify();
        return classifyList;
    }

    /**
     * @Description: 查询子节点
     * 
     * @author Anakin Yang
     * @date 2020/4/21 16:47
     * @param id
     * @return JsonResult
     */
    @RequestMapping("/getChildrenByParentId")
    @ResponseBody
    public JsonResult getChildrenByParentId(@RequestParam("id") String id){
        log.info("————————————查询子节点————————————");
        List<ClassifyVO> classifyChildren = classifyService.getClassifyChildren(id);
        if(classifyChildren ==null || classifyChildren.size()==0){
            return new JsonResult(1,"无子节点",classifyChildren);
        }else {
            return new JsonResult(0,"有子节点",classifyChildren);
        }
    }

    /**
     * @Description: 查询所有分类节点
     *
     * @author Anakin Yang
     * @date 2020/4/22 14:17
     * @param
     * @return
     */
    @RequestMapping("/getClassifyAll")
    @ResponseBody
    public JsonResult getClassifyAll(){
        log.info("————————————查询子节点————————————");
        List<Classify> classifyList=classifyService.getClassifyAll();
        return new JsonResult(0, "成功", classifyList);
    }

    /**
     * @Description: 分类编辑页面
     * 
     * @author Anakin Yang
     * @date 2020/4/22 15:26
     * @param  id
     * @return String
     */
    @RequestMapping("/editClassifyPage")
    public String editClassifyPage(@RequestParam("id")String id, Model model){
        log.info("————————————分类编辑页面————————————");
        log.info("参数id:{}",id);
        Classify classify = classifyService.selectClasssifyById(id);
        model.addAttribute("id",classify.getId());
        model.addAttribute("cName",classify.getcName());
        model.addAttribute("classifyParentId",classify.getcParentId());
        return "/editPage/classifyEdit";
    }


    /**
     * @Description: 分类编辑页面保存
     *
     * @author Anakin Yang
     * @date 2020/4/22 15:26
     * @param cName,cParentId,id
     * @return JsonResult
     */
    @RequestMapping("/saveEditClassify")
    @ResponseBody
    public JsonResult saveEditClassify(@RequestParam("cName") String cName, @RequestParam("cParentId") String cParentId,@RequestParam("id") String id) {
        log.info("————————————分类编辑保存————————————");
        log.info("参数cName:{}", cName);
        log.info("参数cParentId:{}", cParentId);
        log.info("参数id:{}", id);
        /**
         * 封装参数
         **/
        Classify classify=classifyService.selectClasssifyById(id);
        classify.setcName(cName);
        classify.setcParentId(cParentId);
        Integer parentLevel =classifyService.selectParentLevel(cParentId);
        classify.setcLevelFlag(parentLevel+1);
        classify.setUpdateTime(new Date());
        int rows=0;
        try {
            rows=classifyService.update(classify);
        }catch (Exception e){
            log.info("分类修改异常");
            return new JsonResult(1,"分类修改失败");
        }
        if(rows<1){
            return new JsonResult(1,"分类修改失败");
        }
        return new JsonResult(0, "分类修改成功");
    }

}
