package com.example.demo.domain.controller;


import com.example.demo.domain.entities.Information;
import com.example.demo.domain.service.InfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.Line;
import java.util.List;

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


    @GetMapping("/info")
    public String comeToInfoAdd(){
        return "infosAdd";
    }


    @PostMapping("/info")
    public String addInfos(HttpServletRequest request, HttpServletResponse response){

        String sort = request.getParameter("sort");
        int judge = Integer.parseInt(request.getParameter("judge"));
        String infos = request.getParameter("infos");
        infosService.AddInfos(sort,judge,infos);
        return "redirect:/infos";
    }

    @DeleteMapping("/info/{sort}")
    public String deleteEmployee(@PathVariable("sort") String sort){
        infosService.DeleteInfo(sort);
        return "redirect:/infos";
    }

    @GetMapping("/info/{sort}")
    public ModelAndView toUpdatePage(@PathVariable String sort){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("infosUpdate");
        modelAndView.addObject("infosUpdate",infosService.SelectBySort(sort));
        return modelAndView;
    }


    @PutMapping("/info")
    public String updateInfos(Information information){
        System.out.println(information);
        String sort = information.getSort();
        int judge = information.getJudge();
        String infos = information.getInfos();
        infosService.UpdateInfo(sort,judge,infos);
        return "redirect:/infos";
    }
}
