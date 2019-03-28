package com.example.demo.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwichController {

    @GetMapping("/view")
     public String view(){
        return "view";
    }

    @GetMapping("/monitor")
    public String monitor(){
        return "monitor";
    }

    @GetMapping("/data")
    public String data(){
        return "echarts_tempout";
    }

    @GetMapping("/infos")
    public String expert(){
        return "infos";
    }

    @GetMapping("/out_humi")
    public String out_humi(){
        return "echarts_humiout";
    }

    @GetMapping("/out_temp")
    public String out_temp(){
        return "echarts_tempout";
    }

    @GetMapping("/in_temp")
    public String in_temp(){
        return "echarts_tempin";
    }

    @GetMapping("/in_humi")
    public String in_humi(){
        return "echarts_humiin";
    }
}
