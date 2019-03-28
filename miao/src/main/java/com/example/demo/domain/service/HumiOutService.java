package com.example.demo.domain.service;


import com.example.demo.domain.entities.Sensor;
import com.example.demo.domain.mapper.SensorOutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumiOutService {

    @Autowired
    public SensorOutMapper sensorOutMapper;

    public List<Sensor> mySensor() {

//        for(int i=0;i<echartsMapper.getall().size();i++){
//            String tm=new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date(Long.parseLong(echartsMapper.getall().get(i).getTime())));
//            echartsMapper.getall().get(i).setTime(tm);
//            //System.out.println(echartsMapper.getall().get(i).getTime());
//
//        }


        return sensorOutMapper.getall();
    }

}
