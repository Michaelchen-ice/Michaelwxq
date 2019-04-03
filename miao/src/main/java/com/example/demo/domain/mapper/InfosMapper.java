package com.example.demo.domain.mapper;


import com.example.demo.domain.entities.Information;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public interface InfosMapper {

    @Select("SELECT * FROM Information;")
    public List<Information>selectAll();

    @Select("SELECT * FROM Information where sort = #{sort};")
    public List<Information>selectBySort(@Param("sort")String sort);

    @Insert("INSERT into Information(sort,judge,infos,time) value(#{sort},#{judge},#{infos},now());")
    public void insertInfos(@Param("sort")String sort,@Param("judge")int judge,@Param("infos")String infos);

    @Delete("DELETE from Information where sort = #{sort}")
    public void deleteInfos(@Param("sort") String sort);

    @Update("UPDATE Information set judge = #{judge},infos = #{infos},time=now() ,sort = #{sort} where id = #{id}")
    public void updateInfos(@Param("sort")String sort,@Param("judge")int judge,@Param("infos")String infos,@Param("id")int id);
}
