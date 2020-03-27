package com.mkmk.student;

import com.mkmk.student.mapper.GradeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentApplicationTests {

    @Autowired
    GradeMapper gradeMapper;
    @Test
    void contextLoads() {
        System.out.println(gradeMapper.getStudentGrade( 95001));
    }

}
