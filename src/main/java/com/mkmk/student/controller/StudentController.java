package com.mkmk.student.controller;

import com.mkmk.student.bean.Student;
import com.mkmk.student.service.StudentService;
import com.mkmk.student.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    UserService userService ;

    //接受添加学生请求，然后让页面跳转到添加页面
    @GetMapping("")
    public String StudentController(){
        return "redirect:/add.html";
    }

    //接受添加学生的数据
    @RequestMapping("/add")
    public String StudentAdd(HttpSession session,
                             @RequestParam("Sno") Integer Sno,
                             @RequestParam("Sname") String Sname,
                             @RequestParam("Ssex") String Ssex,
                             @RequestParam("Sage") Integer Sage,
                             @RequestParam("Sdept")String Sdept,
                             Map<String,Object> map){
        String username = (String)session.getAttribute("username");
        int userid= userService.getUserId(username);
        Student student = new Student(userid,Sno,Sname,Ssex,Sage,Sdept);
        int i = studentService.InsertStudent(student);
        return "redirect:/Log/show";
    }

    //接受删除学生的学号，然后跳转到全部学生信息的页面
    @GetMapping("/del/{sno}")
    public String DeleteStudent(@PathVariable("sno") Integer sno){
        int i = studentService.DeleteStudentBySno(sno);
        return "forward:/stu/show";
    }

    //接受更新学生的学号
    @GetMapping("/upd/{sno}")
    public String UpdateStudent(@PathVariable("sno") Integer sno,Model model){
        //查询数据用于回显
        Student student = studentService.QueryStudentBySno(sno);
        model .addAttribute("student",student);
        //页面的复用
        return "forward:/add.html";
    }

    //用于接受更新好了的学生数据
    @RequestMapping("/Up")
    public String StudentUp(HttpSession session,
                             @RequestParam("Sno") Integer Sno,
                             @RequestParam("Sname") String Sname,
                             @RequestParam("Ssex") String Ssex,
                             @RequestParam("Sage") Integer Sage,
                             @RequestParam("Sdept")String Sdept,
                             Map<String,Object> map){
        //获取用户名
        String username = (String)session.getAttribute("username");
        //获取用户的id
        int userid= userService.getUserId(username);
        //添加学生
        Student student = new Student(userid,Sno,Sname,Ssex,Sage,Sdept);
        int i = studentService.UpdateStudentBySno(student);
        return "redirect:/stu/show";
    }
    //查询男生
    @RequestMapping("/boy")
    public String getBoyStudent(Model model){
        List<Student> students = studentService.QueryStudentBySex("男");
        model.addAttribute("students",students);
        return "forward:/data.html";
    }
    //查询女生
    @RequestMapping("/girl")
    public String getGirlStudent(Model model){
        List<Student> students = studentService.QueryStudentBySex("女");
        model.addAttribute("students",students);
        return "forward:/data.html";
    }
    //显示全部学生信息
    @GetMapping("/show")
    public String getStudentDate(HttpSession session,Model model){
        //获取用户名以获取用户id
        String username = (String) session.getAttribute("username");
        int userId = userService.getUserId(username);
        //根据用户id查询学生情况
        List<Student> students = studentService.QueryStudentById(userId);
        model.addAttribute("students",students);
        System.out.println(students.size());
        return "forward:/data.html";
    }
}
