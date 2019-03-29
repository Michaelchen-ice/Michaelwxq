package com.example.demo.domain.service;


import com.example.demo.domain.mapper.WaterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaterService {

    @Autowired
    private WaterMapper waterMapper;

    public String GetLastestData(){
        return waterMapper.selectLastestData();
    }
}
