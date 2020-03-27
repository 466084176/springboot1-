package com.mkmk.student.service;

import com.mkmk.student.bean.UserLogIn;
import com.mkmk.student.mapper.UserMapper;
import com.mkmk.student.utils.getMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录功能的service层
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //登录检查
    public int CheckLog(String username,String password){
        UserLogIn logIn = userMapper.getUserByUserName(username);
        if (logIn!=null){
            if (logIn.getPassWord().equals(getMD5.getMD5Str(password))){
                return 1;
            }
        }
        return 0;
    }

    //获取id
    public int getUserId(String username){
        UserLogIn userLogIn = userMapper.getIdByUsername(username);
        return userLogIn.getId();
    }

    //获取昵称
    public String getNickName(String username){
        UserLogIn userLogIn = userMapper.getIdByUsername(username);
        return userLogIn.getNickName();
    }

}
