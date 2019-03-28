package com.example.demo.domain.mapper;


import com.example.demo.domain.entities.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    @Select("select * from Users where email = #{email}")
    public List<Users> selectByEmail(@Param("email") String email);
}
