package com.yyc.testredis.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.yyc.testredis.service.UserInfoService;
import com.yyc.testredis.utils.DESUtil;
import com.yyc.testredis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created with logindemo.
 * Author: dreamer-1
 * Email: zhong--lei@outllok.com
 * Date: 2018/5/13
 * Time: 下午2:58
 * Description:
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    RedisUtil redisUtil;

    public LoginInterceptor(UserInfoService userInfoService, RedisUtil redisUtil) {
        this.userInfoService = userInfoService;
        this.redisUtil = redisUtil;

    }


    /**
     * 在请求被处理之前调用
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String user = null;
        try {
            user = (String) redisUtil.get("username");
        } catch (Exception e) {

        }
        if (user != null) {
            return true;
        } else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String str = "";
            String wholeStr = "";
            //一行一行的读取body体里面的内容
            while ((str = reader.readLine()) != null) {
                wholeStr += str;
            }

            //转化成json对象
            JSONObject t = JSONObject.parseObject(wholeStr);
            //得到想要的参数
            String requsername = null;
            String reqpassword = null;
            String pwd = null;
            try {
                requsername = (String) t.get("username");
                reqpassword = (String) t.get("password");
            } catch (
                    Exception e) {
                response.sendRedirect("/index/login");
                return false;
            }

            //获取redis存储的用户名和密码
            String redisUsername = null;
            String redisPassword = null;
            try{
                redisUsername = (String) redisUtil.get("username");
                redisPassword = (String) redisUtil.get("password");
            }catch (Exception e){

            }
            String password = null;
            if (requsername.equals(redisUsername) && reqpassword.equals(redisPassword)) {
                return true;
            } else if (!requsername.equals(redisUsername)) {
                //查询密码
                pwd = userInfoService.selectPwdByUsername(requsername);
                //DES解密
                if (pwd == null) {
                    log.info("没有注册的");
                    redisUtil.set("username", "用户未注册", 7200);
                    redisUtil.set("password", "用户未注册", 7200);
                    return true;
                }
                DESUtil des = new DESUtil();
                password = des.decryptStr(pwd);
                log.info("解密后：", password);
                if (password.equals(reqpassword)) {
                    log.info("验证通过时");
                    redisUtil.set("username", requsername, 7200);
                    redisUtil.set("password", password, 7200);
                    return true;
                } else {
                    log.info("密码错误的");
                    redisUtil.set("username", requsername, 7200);
                    redisUtil.set("password", "密码错误", 7200);
                    return true;
                }
            } else {
                redisUtil.del("username", "password");
                return false;
            }
        }

    }

    /**
     * 在请求被处理后，视图渲染之前调用
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束后调用
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) throws Exception {

    }
}