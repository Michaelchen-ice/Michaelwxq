package com.example.demo.domain.controller;


import com.example.demo.domain.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WaterController {

    @Autowired
    WaterService waterService;


    @RequestMapping("/water")
    @ResponseBody
    public String SentLastestData(){
        return waterService.GetLastestData();
    }
}
