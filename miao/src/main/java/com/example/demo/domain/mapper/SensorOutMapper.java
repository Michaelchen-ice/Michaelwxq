package com.example.demo.domain.mapper;


import com.example.demo.domain.entities.Sensor;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
    public interface SensorOutMapper {
        @Select("SELECT * FROM Sensor ORDER BY id DESC LIMIT 10;")
        public List<Sensor> getall();
}
