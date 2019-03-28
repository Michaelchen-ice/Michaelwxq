package com.example.demo.domain.controller;


import com.example.demo.domain.entities.SensorIn;
import com.example.demo.domain.service.HumiInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EchartHumiinController {

    @Autowired
    private HumiInService humiInService;


    @RequestMapping("/sensor_in_humi")
    @ResponseBody
    public List<SensorIn> myhumiinSensor(){
        return humiInService.MyHumiSensorIn();
    }
}
