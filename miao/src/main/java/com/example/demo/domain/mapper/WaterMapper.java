package com.example.demo.domain.mapper;


import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface WaterMapper {

    @Select("SELECT volume FROM Water ORDER BY id DESC LIMIT 1;")
    public String selectLastestData();
}
