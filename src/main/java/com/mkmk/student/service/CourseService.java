package com.mkmk.student.service;

import com.mkmk.student.bean.Course;
import com.mkmk.student.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程操作
 */
@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;
    //判断课程是否存在
    public boolean IsExist(int cno){
        if(courseMapper.QueryCourseByCno(cno)!=null){
            return true;
        }
        return false;
    }
    //增加课程
    public boolean InsertCourse(Course course){
        if(!IsExist(course.getCno())){
            courseMapper.InsertCourse(course);
            return true;
        }else{
            return false;
        }
    }
    //删除课程
    public boolean DeleteCourse(int cno){
        if (IsExist(cno)){
            courseMapper.DeleteCourse(cno);
            return true;
        }else{
            return  false;
        }

    }
    //修改课程
    public boolean UpdateCourse(Course course){
        if (IsExist(course.getCno())){
            courseMapper.UpdateCourse(course);
            return true;
        }else{
            return  false;
        }

    }
    //查询课程
    public List<Course> QueryCourse(){
        return courseMapper.QueryCourse();
    }
    //查询课程号
    public int QueryNoByCname(String cname){
        System.out.println(courseMapper.QueryCnoByCname(cname).getCno());
        return courseMapper.QueryCnoByCname(cname).getCno();
    }
    //查找课程名
    public String[] QueryCourseName(){
        List<Course> courses = courseMapper.QueryCourse();
        String[] courseName = new String[courses.size()+1];
        courseName[0]="0";
        int i=1;
        for (Course course: courses) {
            courseName[i]=course.getCname();
            i++;
        }
        for (String s: courseName
             ) {
            System.out.println(s);
        }
        return  courseName;
    }
    //通过课程号查询课程信息
    public Course QueryCourseByCno(int cno){
        if (IsExist(cno)){
            return courseMapper.QueryCourseByCno(cno);
        }
        return  null;
    }
    //更具课程号查询课程名
    public String QueryCourseNameByCno(int cno){
        if (IsExist(cno)){
            return courseMapper.QueryCourseByCno(cno).getCname();
        }
        return null;
    }

}
