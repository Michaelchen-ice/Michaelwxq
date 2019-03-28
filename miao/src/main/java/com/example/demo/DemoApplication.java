package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@MapperScan("com.example.demo.domain.mapper")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public ViewResolver MyViewResolver(){
            return new MyViewResolver();
    }

    private static class MyViewResolver implements ViewResolver{


        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}

