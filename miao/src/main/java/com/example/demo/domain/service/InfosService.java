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

                for(int i=0;i<infosMapper.selectAll().size();i++){
          if(infosMapper.selectAll().get(i).getJudge().equals("0")){
                  infosMapper.selectAll().get(i).setJudge("否");
              }else {
                  infosMapper.selectAll().get(i).setJudge("是");
              }
        }
        return infosMapper.selectAll();
    }
}
