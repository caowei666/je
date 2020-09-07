package com.test.boot.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/*")
//                .excludePathPatterns("/login.html")
//                .excludePathPatterns("/dologin.html");
//        registry.addInterceptor(new MenuInterceptor())
//                .addPathPatterns("/sys/*");
    }
}
