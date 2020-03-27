package com.mkmk.student.mapper;

import com.mkmk.student.bean.Grade;
import com.mkmk.student.bean.SC;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GradeMapper {
    //查询单个学生的成绩情况
    List<Grade> getStudentGrade(@Param("sno")int sno);
    //删除学生成绩
    int DeleteStudentScore(@Param("sno")int sno,@Param("cno") int cno);
    //修改学生成绩
    int UpdateStudentScore(SC sc);
    //插入学生数据
    int InsertStudentScore(SC sc);
    //查询单条记录
    SC QueryBySnoAndCno(@Param("sno")int sno,@Param("cno")int cno);

}
