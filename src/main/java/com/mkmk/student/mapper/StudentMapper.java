package com.mkmk.student.mapper;

import com.mkmk.student.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学生的数据库操作
 */
@Mapper
public interface StudentMapper {
    //通过用户ID查询学生
    List<Student> QueryStudentById(@Param("id") int id);
    //根据性别查询学生
    List<Student> QueryStudentBySex(@Param("sex")String sex);
    //通过学号查询学生
    Student QueryStudentBySno(@Param("sno") int sno);
    //通过姓名查询学生
    Student QueryStudentBySname(@Param("sname")String sname);
    //通过学号删除学生
    int DeleteStudentBySno(@Param("sno")int sno);
    //更新学生信息
    int UpdateStudent(Student student);
    //填加学生
    int InsertStudent(Student student);
}
