package com.example.demo.domain.config;


import com.example.demo.domain.component.LoginHandleInterceptor;
import com.example.demo.domain.component.MylocaleResolver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hziee").setViewName("success");
    }

    @Bean
    //所有的WebMvcConfigurerAdapter会一起起作用
   public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("login.html").setViewName("login");
                registry.addViewController("index").setViewName("login");
                registry.addViewController("index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("view");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //静态资源：css，js不会被拦截
                registry.addInterceptor(new LoginHandleInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login","login.html","index","/static/**","/asserts/**","/webjars/**","/sensor_out_temp","/water");
            }
        };
        return adapter;
   }

   @Bean
   public LocaleResolver localeResolver(){
        return new MylocaleResolver();
   }
}
