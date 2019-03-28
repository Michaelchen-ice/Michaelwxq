package com.example.demo.domain.controller;


import com.example.demo.domain.entities.Sensor;
import com.example.demo.domain.service.HumiOutService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EchartHumiOutController {

    @Autowired
    public HumiOutService humiOutService;

    @RequestMapping("/sensor_out_humi")
    @ResponseBody
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public List<Sensor> myhumioutSensor() {
        return humiOutService.mySensor();

    }

//        Sensor sensor1 = new Sensor();
//        sensor1.setTime("1552487374504");
//        sensor1.setHumi(49.0000);
//        Sensor sensor2 = new Sensor();
//        sensor2.setTime("1552487375562");
//        sensor2.setHumi(49.0000);
//        Sensor sensor3 = new Sensor();
//        sensor3.setTime("1552487376644");
//        sensor3.setHumi(49.0000);
//        Sensor sensor4 = new Sensor();
//        sensor4.setTime("1552487377671");
//        sensor4.setHumi(49.0000);

//        sensorArrayList.add(sensor1);
//        sensorArrayList.add(sensor2);
//        sensorArrayList.add(sensor3);
//        sensorArrayList.add(sensor4);
//        sensorArrayList.add(sensor5);





    @RequestMapping("/text")
    public String mytext(){
        return "echarts_humiout";
    }
}
