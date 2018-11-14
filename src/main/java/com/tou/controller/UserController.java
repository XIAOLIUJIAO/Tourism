package com.tou.controller;

import com.tou.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.tou.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,HttpSession session,
                          HttpServletRequest request){
        System.out.println(username+"---"+password);
        System.out.println("123");
        //
        User user=userService.login(username, password);
        //int i=1/0;
        if(user!=null){
            session.setAttribute("user", user);
            return "frame";
        }else{
            request.setAttribute("error", "用户名与密码错误");
            return "login";
        }
    }


}
