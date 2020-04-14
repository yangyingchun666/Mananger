package com.yyc.testredis.config;

import com.yyc.testredis.interceptor.LoginInterceptor;
import com.yyc.testredis.service.UserInfoService;
import com.yyc.testredis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfiguration implements WebMvcConfigurer {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    RedisUtil redisUtil;
    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截的请求，并排除几个不拦截的请求
        registry.addInterceptor(new LoginInterceptor(userInfoService,redisUtil)).addPathPatterns("/**")
                .excludePathPatterns("/logOut","/index/register", "/", "/index/login","/static/**","/favicon.ico","/error","/verifyPhone","/verifyUsername");
    }

}
