package com.dgut.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class LoginConfig extends WebMvcConfigurerAdapter {

    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login/dgut")
                .excludePathPatterns("/tc")
                .excludePathPatterns("/sfzz")
                .excludePathPatterns("/sfzf")
                .excludePathPatterns("/yhkz")
                .excludePathPatterns("/yhkf")
                .excludePathPatterns("/headimg")
                .excludePathPatterns("/htfile")
                .excludePathPatterns("/loginstate");
        super.addInterceptors(registry);
    }
}
