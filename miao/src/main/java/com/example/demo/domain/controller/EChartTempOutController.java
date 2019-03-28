package com.example.demo.domain.controller;


import com.example.demo.domain.entities.Sensor;
import com.example.demo.domain.service.TempOutService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EchartTempOutController {
    @Autowired
    public TempOutService tempOutService;

    @RequestMapping("/sensor_out_temp")
    @ResponseBody
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public List<Sensor> mytempoutSensor() {
        return tempOutService.mytempSensor();

    }
}
