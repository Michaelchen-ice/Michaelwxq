package com.example.demo.domain.controller;



import com.example.demo.domain.entities.Users;
import com.example.demo.domain.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import java.util.Map;

@Controller
public class LoginController {
@Autowired
private LoginService loginService;



//    SELECT `password` FROM Users WHERE email = 'admin';

//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        boolean flag,
                        Map<String,Object> map, HttpSession session){

        flag = loginService.Find(email,password);


        if (flag){
            session.setAttribute("loginEmail",email);

            return "redirect:/main.html";
        }else {
            map.put("msg","用户名密码错误");

            return "login";
        }

//        try {
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://47.100.248.118:3306/farming?user=root&password=&useUnicode=true&characterEncoding=utf-8");
//            Statement st = conn.createStatement();
//            ResultSet resultSet = st.executeQuery("SELECT * FROM Users;");
//
//                while (resultSet.next()) {
//                    String Email = resultSet.getString("email");
//                    String PassWord = resultSet.getString("password");
//                    if(Email.equals(email) && PassWord.equals(password))
//                    {
//                        flag = 1;
//                        break;
//                    }
//                }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (flag == 1){
//            session.setAttribute("loginEmail",email);
//            flag = 0;
//            return "redirect:/main.html";
//        }else {
//            map.put("msg","用户名密码错误");
//            flag = 0;
//            return "login";
//        }
    }
}
