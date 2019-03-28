package com.example.demo.domain.mapper;


import com.example.demo.domain.entities.Information;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InfosMapper {

    @Select("SELECT * FROM Information;")
    public List<Information>selectAll();
}
