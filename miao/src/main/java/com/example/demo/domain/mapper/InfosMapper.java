package com.example.demo.domain.mapper;


import com.example.demo.domain.entities.Information;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InfosMapper {

    @Select("SELECT * FROM Information;")
    public List<Information>selectAll();

    @Insert("Insert into Information(sort,judge,infos,time) value(#{sort},#{judge},#{infos},now());")
    public void insertInfos(@Param("sort")String sort,@Param("judge")int judge,@Param("infos")String infos);
}
