package com.mkmk.student.service;

import com.mkmk.student.bean.Student;
import com.mkmk.student.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生service层
 */
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    //判断学生是否存在
    public boolean IsExist(int sno){
        Student student =studentMapper.QueryStudentBySno(sno);
        if(student==null){
            return  false;      //不存在
        }else{
            return true;        //存在
        }
    }

    //通过用户ID查询学生
    public List<Student> QueryStudentById(int id){
        return studentMapper.QueryStudentById(id);
    }
    //通过学号查询学生
    public Student QueryStudentBySno(int sno){
        return studentMapper.QueryStudentBySno(sno);
    }
    //通过学号删除学生
    public int DeleteStudentBySno(int sno){
        if(IsExist(sno)){
            return studentMapper.DeleteStudentBySno(sno);
        }else {
            return 0;  //删除失败
        }
    }
    //通过姓名查询学生
    public Student QueryStudentBySname(String sname){
        return studentMapper.QueryStudentBySname(sname);
    }
    //更新学生信息
    public int UpdateStudentBySno(Student student){
        if(IsExist(student.getSno())){
            return studentMapper.UpdateStudent(student);
        }else {
            return 0;  //更新失败
        }
    }
    //填加学生
    public int InsertStudent(Student student){
        if(!IsExist(student.getSno())){
            return studentMapper.InsertStudent(student);
        }else {
            return 0;  //添加失败
        }
    }
    //通过性别查询同学
    public List<Student> QueryStudentBySex(String sex){
        return studentMapper.QueryStudentBySex(sex);
    }
}
