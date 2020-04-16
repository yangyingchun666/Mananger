package com.yyc.testredis.controller;

import com.yyc.testredis.pojo.UserInfo;
import com.yyc.testredis.service.Test1Service;
import com.yyc.testredis.service.UserInfoService;
import com.yyc.testredis.utils.CreateIDUtils;
import com.yyc.testredis.utils.DESUtil;
import com.yyc.testredis.utils.JsonResult;
import com.yyc.testredis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Date;

@Controller
@Slf4j
public class LoginController {

    @Autowired
    Test1Service test1Service;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    RedisUtil redisUtil;

    /**
     * 登录进主页
     * @return
     */
    @PostMapping("/loginInto")
    @ResponseBody
    public JsonResult login(){
        log.info("用户登录");
        String username= (String) redisUtil.get("username");
        String password= (String) redisUtil.get("password");
        log.info("username{}：",username);
        log.info("password{}：",password);
        if("用户未注册".equals(username)){
            redisUtil.del("username","password");
            return new JsonResult(1,"用户未注册");
        }else if("密码错误".equals(password)){
            redisUtil.del("password","username");
            return new JsonResult(1,"密码错误");
        }
        String pwd=userInfoService.selectPwdByUsername(username);
        UserInfo userInfo = userInfoService.selectByUsername(username);
        //DES解密
        DESUtil des=new DESUtil();
        String despassword = des.decryptStr(pwd);
        log.info("解密后：",despassword);
        if(pwd==null || "".equals(pwd)){
            return new JsonResult(1,"用户未注册");
        }
        if(password.equals(despassword)){

          redisUtil.set("username",username,7200);
          redisUtil.set("password",password,7200);
          redisUtil.set("roleId",userInfo.getRoleId(),7200);
            return new JsonResult(0,"登录成功");
        }else {
            return new JsonResult(1,"登录失败");
        }

    }

    /**
     * 商品图片信息上传
     *
     * @param file
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/uploadFile")
    @ResponseBody
    public JsonResult uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        log.info("商品图片信息上传");
        return test1Service.uploadHeaderImg(file);
    }


    /**
     * 本地图片回显
     * @param imgUrl
     * @param request
     * @param response
     */
    @RequestMapping("/showImage")
    public void picToJSP(@RequestParam("imgUrl") String imgUrl, HttpServletRequest request, HttpServletResponse response){
        FileInputStream in;
        response.setContentType("application/octet-stream;charset=UTF-8");
        try {
            //图片读取路径
            in=new FileInputStream(imgUrl);
            int i=in.available();
            byte[]data=new byte[i];
            in.read(data);
            in.close();
            //写图片
            OutputStream outputStream=new BufferedOutputStream(response.getOutputStream());
            outputStream.write(data);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 用户注册
     * @param userInfo
     * @return
     */
    @PostMapping("/registerInto")
    @ResponseBody
    public JsonResult registerInto(@RequestBody UserInfo userInfo){

        log.info("用户注册");
        log.info("userInfo{}=",userInfo.toString());
        //DES加密
        DESUtil des=new DESUtil();
        String password = des.encryptStr(userInfo.getPassword());
        log.info("加密后password{}",password);
        userInfo.setId(CreateIDUtils.genUserId());
        userInfo.setPassword(password);
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(new Date());
        Integer result=0;
        try {
            result=userInfoService.insert(userInfo);
        }catch (Exception e){
            log.info("用户信息插入异常",e);
            return new JsonResult(1,"注册失败");
        }
        if(result<1){
            return new JsonResult(1,"注册失败");
        }else {
            return new JsonResult(0,"注册成功");
        }
    }

    /**
     * 手机号唯一性验证
     * @param verifyPhone
     * @return
     */
    @GetMapping("/verifyPhone")
    @ResponseBody
    public JsonResult verifyPhone(@RequestParam("verifyPhone") String verifyPhone){
        log.info("验证手机号");
        log.info("verifyPhone{}=",verifyPhone);
        Integer result=0;
        try {
            result=userInfoService.selectCountByParam(verifyPhone,null);
        }catch (Exception e){
            log.info("验证手机号查询异常",e);
            return new JsonResult(1);
        }
        if(result<1){
            return new JsonResult(0);
        }else {
            return new JsonResult(1);
        }
    }

    /**
     * 用户名唯一性验证
     * @param verifyUsername
     * @return
     */
    @GetMapping("/verifyUsername")
    @ResponseBody
    public JsonResult verifyUsername(@RequestParam("verifyUsername") String verifyUsername){
        log.info("用户名唯一性验证");
        log.info("verifyUsername{}=",verifyUsername);
        Integer result=0;
        try {
            result=userInfoService.selectCountByParam(null,verifyUsername);
        }catch (Exception e){
            log.info("验证用户名查询异常",e);
            return new JsonResult(1);
        }
        if(result<1){
            return new JsonResult(0);
        }else {
            return new JsonResult(1);
        }
    }

    /**
     * 退出登录
     * @return
     */
    @GetMapping("/logOut")
    public String logOut(){
        log.info("用户退出登录");
        String username= (String) redisUtil.get("username");
        String password= (String) redisUtil.get("password");
        log.info("username{}：",username);
        log.info("password{}：",password);
        redisUtil.del("username","password");
        //重定向
        return "redirect:/index/login";
    }

}

