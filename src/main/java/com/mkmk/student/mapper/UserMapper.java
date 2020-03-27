package com.mkmk.student.mapper;

import com.mkmk.student.bean.UserLogIn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * mybatis应用
 */
@Mapper
public interface UserMapper {
    UserLogIn getUserByUserName(@Param("username")String username);
    UserLogIn getIdByUsername(@Param("username") String username);
}
