package com.yyc.testredis.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.yyc.testredis.service.UserInfoService;
import com.yyc.testredis.utils.DESUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    public LoginInterceptor(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
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
        // 检查每个到来的请求对应的session域中是否有登录标识
        if (request.getSession().getAttribute("username") != null) {
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
                pwd = userInfoService.selectPwdByUsername(requsername);
            }catch (Exception e){
                response.sendRedirect("/index/login");
                return false;
            }
            //DES解密
            DESUtil des = new DESUtil();
            String password = des.decryptStr(pwd);
            log.info("解密后：", password);
            if (pwd == null) {
                response.sendRedirect("/index/login");
                return false;
            }
            if (reqpassword.equals(password)) {
                // 校验通过时，在session里放入一个标识
                // 后续通过session里是否存在该标识来判断用户是否登录
                HttpSession session = request.getSession();
                session.setAttribute("username", requsername);
                session.setAttribute("password", password);
                session.setMaxInactiveInterval(1800);
                log.info("当前用户已登录，登录的用户名为： " + requsername);
                return true;
            } else {
                log.info("密码错误");
                return true;
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
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

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
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}