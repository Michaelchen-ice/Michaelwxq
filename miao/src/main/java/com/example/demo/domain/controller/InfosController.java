package com.example.demo.domain.controller;


import com.example.demo.domain.service.InfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InfosController {

    @Autowired
    private InfosService infosService;

    @RequestMapping("/infos")
        public ModelAndView infos(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("infos");
        modelAndView.addObject("infos",infosService.getAllInfos());

        return modelAndView;
    }
}
