package com.yyc.testredis.config;

import com.yyc.testredis.interceptor.LoginInterceptor;
import com.yyc.testredis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfiguration implements WebMvcConfigurer {

    @Autowired
    private UserInfoService userInfoService;
    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截的请求，并排除几个不拦截的请求
        registry.addInterceptor(new LoginInterceptor(userInfoService)).addPathPatterns("/**")
                .excludePathPatterns("/index/register", "/", "/index/login","/static/**","/favicon.ico","/error");
    }

}
