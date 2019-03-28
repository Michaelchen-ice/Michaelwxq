package com.example.demo.domain.mapper;


import com.example.demo.domain.entities.SensorIn;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface SensorInMapper {
    @Select("SELECT * FROM Sensor_in ORDER BY id DESC LIMIT 5;")
    public List<SensorIn> GetInAll();
}
