package com.mkmk.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 简单的退出功能
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {

    @RequestMapping("/")
    public String LogOut(HttpSession session){
        //session的注销
        session.removeAttribute("username");
        return "redirect:/";
    }
}
