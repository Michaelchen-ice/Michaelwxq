package com.example.demo.domain.controller;


import com.example.demo.domain.entities.Sensor;
import com.example.demo.domain.service.TempOutService;
import com.example.demo.domain.service.WaterService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EchartTempOutController {
    @Autowired
    private TempOutService tempOutService;

    @Autowired
    private WaterService waterService;

    @RequestMapping("/sensor_out_temp")
    @ResponseBody
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public List<Sensor> mytempoutSensor() {

        return tempOutService.mytempSensor();

    }
}
