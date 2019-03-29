package com.example.demo.domain.mapper;


import com.example.demo.domain.entities.Information;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InfosMapper {

    @Select("SELECT * FROM Information;")
    public List<Information>selectAll();

    @Insert("INSERT into Information(sort,judge,infos,time) value(#{sort},#{judge},#{infos},now());")
    public void insertInfos(@Param("sort")String sort,@Param("judge")int judge,@Param("infos")String infos);

    @Delete("delete from Information where sort = #{sort}")
    public void deleteInfos(@Param("sort") String sort);
}
