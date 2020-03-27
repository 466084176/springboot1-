package com.mkmk.student.bean;

/**
 * 用户实体类
 */
public class UserLogIn {

    private int Id;
    private String UserName;
    private String PassWord;
    private String NickName;

    public UserLogIn() {
    }

    public UserLogIn(int id, String userName, String passWord, String nickName) {
        Id = id;
        UserName = userName;
        PassWord = passWord;
        NickName = nickName;
    }

    public UserLogIn(int id, String userName, String passWord) {
        Id = id;
        UserName = userName;
        PassWord = passWord;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    @Override
    public String toString() {
        return "UserLogIn{" +
                "Id=" + Id +
                ", UserName='" + UserName + '\'' +
                ", PassWord='" + PassWord + '\'' +
                ", NickName='" + NickName + '\'' +
                '}';
    }
}
