package com.example.demo.domain.service;


import com.example.demo.domain.entities.SensorIn;
import com.example.demo.domain.mapper.SensorInMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TempinService {

    @Autowired
    private SensorInMapper sensorInMapper;

    public List<SensorIn> getMyTempSensorin(){
        return sensorInMapper.GetInAll();
    }
}
