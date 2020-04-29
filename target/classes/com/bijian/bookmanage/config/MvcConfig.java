package com.bijian.bookmanage.config;

import com.bijian.bookmanage.config.intercepter.CommonIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/20
 * @Content:
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private CommonIntercepter commonIntercepter;

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonIntercepter).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有${ctx!}/** 访问都映射到classpath:${ctx!}/ 目录下
        registry.addResourceHandler("${ctx!}/**").addResourceLocations("classpath:${ctx!}/");
    }
}
