package com.yyc.testredis.controller;

import com.yyc.testredis.dto.User;
import com.yyc.testredis.pojo.UserInfo;
import com.yyc.testredis.service.Test1Service;
import com.yyc.testredis.service.UserInfoService;
import com.yyc.testredis.utils.CreateIDUtils;
import com.yyc.testredis.utils.JsonResult;
import com.yyc.testredis.utils.MD5Util;
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

    /**
     * 登录进主页
     * @param user
     * @return
     */
    @PostMapping("/loginInto")
    @ResponseBody
    public JsonResult login(@RequestBody User user){
        log.info("用户登录");
        log.info("username{}",user.getUsername());
        log.info("password{}",user.getPassword());
        String md5 = MD5Util.getMD5(user.getPassword());
        String pwd=test1Service.selectPwdByUsername(user.getUsername());
        if(pwd==null || "".equals(pwd)){
            return new JsonResult(1,"用户未注册");
        }
        String pwdMd5 = MD5Util.getMD5(pwd);
        if(md5.equals(pwdMd5)){
            return new JsonResult(0);
        }else {
            return new JsonResult(1);
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
        String password = MD5Util.getMD5(userInfo.getPassword());
        userInfo.setId(CreateIDUtils.genUsualId());
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
}
