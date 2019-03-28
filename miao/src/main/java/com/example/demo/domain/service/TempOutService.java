package com.example.demo.domain.service;


import com.example.demo.domain.entities.Sensor;
import com.example.demo.domain.mapper.EchartsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TempOutService {

    @Autowired
    public EchartsMapper echartsMapper;
    public List<Sensor> mytempSensor() {


//        for(int i=0;i<echartsMapper.getall().size();i++){
//            String tm=new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date(Long.parseLong(echartsMapper.getall().get(i).getTime())));
//            echartsMapper.getall().get(i).setTime(tm);
//            //System.out.println(echartsMapper.getall().get(i).getTime());
//
//    }


        return echartsMapper.getall();
    }
}
