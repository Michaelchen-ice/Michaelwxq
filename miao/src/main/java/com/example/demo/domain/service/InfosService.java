package com.example.demo.domain.service;


import com.example.demo.domain.entities.Information;
import com.example.demo.domain.mapper.InfosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfosService {

    @Autowired
    private InfosMapper infosMapper;

    public List<Information>getAllInfos(){

//                for(int i=0;i<infosMapper.selectAll().size();i++){
//          if(infosMapper.selectAll().get(i).getJudge().equals("0")){
//                  infosMapper.selectAll().get(i).setJudge("否");
//              }else {
//                  infosMapper.selectAll().get(i).setJudge("是");
//              }
//        }
        return infosMapper.selectAll();
    }

    public Information SelectBySort(String sort){
        Information information=new Information();
        infosMapper.selectBySort(sort).forEach(item -> {
            information.setSort(item.getSort());
            information.setJudge(item.getJudge());
            information.setInfos(item.getInfos());
        });
        return information ;
    }

    public void AddInfos(String sort,int judge,String infos){
        infosMapper.insertInfos(sort,judge,infos);
    }

    public void DeleteInfo(String sort){
        infosMapper.deleteInfos(sort);
    }

    public void UpdateInfo(String sort,int judge,String infos){
        System.out.println(sort);
        infosMapper.updateInfos(sort,judge,infos);
    }
}
