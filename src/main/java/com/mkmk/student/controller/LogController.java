package com.mkmk.student.controller;

import com.mkmk.student.bean.Student;
import com.mkmk.student.service.StudentService;
import com.mkmk.student.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/Log")
public class LogController {

    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;

    //登录检查功能
    @PostMapping("/check")
    public String CheckLogin(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             Map<String,Object> map, HttpSession session){
        if(userService.CheckLog(username,password)>0){
            //登录成功，防止表单数据重新提交，可以重定向到主页面
            session.setAttribute("nickname",userService.getNickName(username));
            session.setAttribute("username",username);
            return "redirect:/stu/show";
        }else{
            map.put("msg","用户名密码错误");
            return "login";
        }
    }



}
