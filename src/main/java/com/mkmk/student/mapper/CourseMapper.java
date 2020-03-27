package com.mkmk.student.mapper;

import com.mkmk.student.bean.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper {
    //查找所有课程
    List<Course> QueryCourse();
    //查询单个课程
    Course QueryCourseByCno(@Param("cno")int cno);
    //通过课程名查课程号
    Course QueryCnoByCname(@Param("cname")String cname);
    //修改课程
    int UpdateCourse(Course course);
    //增加课程
    int InsertCourse(Course course);
    //删除课程
    int DeleteCourse(@Param("cno") int cno);
}
