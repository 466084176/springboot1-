package com.mkmk.student.controller;

import com.mkmk.student.bean.Grade;
import com.mkmk.student.bean.SC;
import com.mkmk.student.bean.Student;
import com.mkmk.student.service.CourseService;
import com.mkmk.student.service.GradeService;
import com.mkmk.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用于学生成绩的增删改查
 */
@Controller
@RequestMapping("/gra")
public class GradeController {

    @Autowired
    GradeService gradeService;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;

    //获取需要查询成绩的学生学号
    @RequestMapping("/data/{sno}")
    public String getGrade(@PathVariable("sno")Integer sno,
                           Model model){
        //获取同学的姓名
        String studentName = studentService.QueryStudentBySno(sno).getSname();
        //获取成绩信息
        List<Grade> studentGrade = gradeService.getStudentGrade(sno);
        //发送信息
        model.addAttribute("studentGrade",studentGrade);
        model.addAttribute("studentName",studentName);
        return  "forward:/grade.html";
    }

    //获取需要添加成绩的学生姓名
    @RequestMapping("/add/{sname}")
    public String InsertScore(HttpServletRequest request,
                              @PathVariable("sname")String sname){
        //查询学生
        Student student = studentService.QueryStudentBySname(sname);
        //将学生信息放入request域
        request.setAttribute("courseName",courseService.QueryCourseName());
        request.setAttribute("student",student);
        return "forward:/score.html";
    }
    //获取插入成绩的信息
    @RequestMapping("/insert")
    public String AddScore(@RequestParam("Sno")Integer sno,
                           @RequestParam("Cname")String cname,
                           @RequestParam("Grade")Float grade){
        //获取课程号
        int cno = courseService.QueryNoByCname(cname);
        //插入成绩
        SC sc = new SC(sno,cno,grade);
        gradeService.InserScore(sc);
        //页面跳回该学生的成绩显示界面
        return  "redirect:/gra/data/"+sno;
    }

    //删除操作
    @RequestMapping(value = "/del")
    public String DelScore(@RequestParam("cname")String cname,
                           @RequestParam("sname")String sname){
        int cno = courseService.QueryNoByCname(cname);
        Student student = studentService.QueryStudentBySname(sname);
        gradeService.DeleteScoreBySnoAndeCno(student.getSno(),cno);
        return "redirect:/gra/data/"+student.getSno();
    }
    //回显将要更新成绩
    @RequestMapping("/up")
    public String Up(@RequestParam("cname")String cname,
                     @RequestParam("sname")String sname,Model model){
        //查询学生
        Student student = studentService.QueryStudentBySname(sname);
        model.addAttribute("student",student);
        //查询课程
        int cno = courseService.QueryNoByCname(cname);
        SC sc = gradeService.getStudentSC(student.getSno(),cno);
        System.out.println("SC--------------------->"+sc);
        //回显选者框的值
        model.addAttribute("courseName",courseService.QueryCourseName());
        model.addAttribute("CourseN",courseService.QueryCourseNameByCno(sc.getCno()));
        System.out.println("-------------------------here"+sc.getGrade());
        model.addAttribute("Score",sc.getGrade());
        return "forward:/score.html";
    }
    //将更新的成绩放入数据库中
    @RequestMapping("/update")
    public String UpdateStudentSc(@RequestParam("Sno")Integer sno,
                                  @RequestParam("Cname")String cname,
                                  @RequestParam("Grade")Integer grade){
        int cno = courseService.QueryNoByCname(cname);
        System.out.println("-------------------------"+grade);
        gradeService.UpdateStudentScore(new SC(sno,cno,grade));
        return "redirect:/gra/data/"+sno;
    }
}
