package com.mkmk.student.controller;

import com.mkmk.student.bean.Course;
import com.mkmk.student.service.CourseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 课程的增删改查
 */
@Controller
@RequestMapping("/cou")
public class CourseController {
    @Autowired
    CourseService courseService;

    //显示所有的课程信息
    @RequestMapping("")
    public String CourseController(Model model){
        List<Course> courses = courseService.QueryCourse();
        model.addAttribute("courses",courses);
        return "forward:/cour.html";
    }
    //页面跳转到添加课程页面
    @RequestMapping("/add")
    public String Course(Model model){
        //搜索出所有的课程名
        model.addAttribute("courseName",courseService.QueryCourseName());
        return "forward:/addcou.html";
    }
    //获取即将添加的课程信息
    @RequestMapping("/insert")
    public String InsertCourse(@RequestParam("Cno") Integer cno,
                               @RequestParam("Cname") String cname,
                               @RequestParam("Cpno") String cpno,
                               @RequestParam("Ccredit") Integer ccredit){
        boolean b=false;
        Course course;
        if(cpno.equals('0')){   //表示没有先修课程
            int Cno = courseService.QueryNoByCname(cpno);
            course = new Course(cno,cname,Cno,ccredit);
            b = courseService.InsertCourse(course);
        }else{
            course = new Course(cno,cname,0,ccredit);
            b = courseService.InsertCourse(course);
        }

        System.out.println(b);
        return "redirect:/cou";
    }

    //获取需要删除的课程号
    @RequestMapping("/del/{cno}")
    public String DeleteCourse(@PathVariable("cno")Integer cno){
        System.out.println(cno);
        courseService.DeleteCourse(cno);
        return "redirect:/cou";
    }

    //获取需要更新的课程号，
    @RequestMapping("/up/{cno}")
    public String Update(@PathVariable("cno") Integer cno,Model model){
        model.addAttribute("courseName",courseService.QueryCourseName());
        //课程信息的回显
        Course course = courseService.QueryCourseByCno(cno);
        model.addAttribute("CpnoName",course.getCname());
        model.addAttribute("course",course);
        return "forward:/addcou.html";
    }
    //获取更新的信息完成更新
    @RequestMapping("/Update")
    public String UpdateCourse(@RequestParam("Cno") Integer cno,
                               @RequestParam("Cname") String cname,
                               @RequestParam("Cpno") String cpno,
                               @RequestParam("Ccredit") Integer ccredit){

            boolean b=false;
            Course course;
            if(!cpno.equals('0')){
                int Cno = courseService.QueryNoByCname(cpno);
                course = new Course(cno,cname,Cno,ccredit);
                b = courseService.UpdateCourse(course);
            }else{
                course = new Course(cno,cname,0,ccredit);
                b = courseService.UpdateCourse(course);
            }

            System.out.println(b);
            return "redirect:/cou";
    }

}
