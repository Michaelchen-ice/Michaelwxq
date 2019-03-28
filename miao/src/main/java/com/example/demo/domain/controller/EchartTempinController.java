package com.example.demo.domain.controller;


import com.example.demo.domain.entities.SensorIn;
import com.example.demo.domain.service.TempinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EchartTempinController {

    @Autowired
    private TempinService tempinService;

    @RequestMapping("/sensor_in_temp")
    @ResponseBody
    public List<SensorIn> mytempinSensor(){
        return tempinService.getMyTempSensorin();
    }
}
