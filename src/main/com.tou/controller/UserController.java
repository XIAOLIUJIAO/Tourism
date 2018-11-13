package controller;

import entity.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("login.html")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        HttpSession session, HttpRequest request){
        System.out.println("用户名"+username+"密码："+password);
        User user=userService.login(username,password);
        if (user!=null) {
            session.setAttribute("user",user);
            return "frame";
        }else{
            return "error";
        }
    }
}
