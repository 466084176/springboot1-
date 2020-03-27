package com.mkmk.student.service;

import com.mkmk.student.bean.Grade;
import com.mkmk.student.bean.SC;
import com.mkmk.student.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用于获取学生的成绩
 */
@Service
public class GradeService {
    @Autowired
    StudentService studentService;
    @Autowired
    GradeMapper gradeMapper;

    //判断单条数据是否存在
    public boolean IsExist(int sno,int cno){
        SC sc = gradeMapper.QueryBySnoAndCno(sno, cno);
        if ((sc!=null)){
            return true;
        }else {
            return  false;
        }
    }

    //查询单个学生的成绩情况
    public List<Grade> getStudentGrade(int sno){
        if(studentService.IsExist(sno)){
            return gradeMapper.getStudentGrade(sno);
        }
        return  null;
    }
    //根据学号和课程号删除成绩
    public boolean DeleteScoreBySnoAndeCno(int sno,int cno){
        if (IsExist(sno,cno)){
            gradeMapper.DeleteStudentScore(sno,cno);
            return true;//表示删除成功
        }else{
            return  false;
        }
    }

    //根据学号和课程号修改成绩
    public boolean UpdateStudentScore(SC sc){
        if (IsExist(sc.getSno(),sc.getCno())){
            gradeMapper.UpdateStudentScore(sc);
            return true;
        }else {
            return false;
        }
    }
    //增加学生
    public boolean InserScore(SC sc){
       if (!IsExist(sc.getSno(),sc.getCno())){
           gradeMapper.InsertStudentScore(sc);
           return true;//表示插入成功
       }else{
           return  false;
       }
    }
    //查找单个学生成绩记录
    public SC getStudentSC(int sno,int cno){
        return gradeMapper.QueryBySnoAndCno(sno,cno);
    }
}
