package com.example.demo.domain.service;


import com.example.demo.domain.entities.Users;
import com.example.demo.domain.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    public boolean Find(String email,String password){
        List<Users> All = userMapper.selectByEmail(email);
        boolean flag = true;
        for(int i =0;i<= All.size();i++){
            Users users = All.get(i);
            if(email.equals(users.getEmail()) && password.equals(users.getPassword())){
                flag = true;
                break;
            }else{
                flag = false;
            }
        }
        return flag;
    }
}
