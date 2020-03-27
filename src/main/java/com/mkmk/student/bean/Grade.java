package com.mkmk.student.bean;

/**
 * 用于接受查询出来的成绩
 */
public class Grade {

    private String Cname;
    private float Score;

    public Grade() {
    }

    public Grade( String cname, float score) {
        Cname = cname;
        Score = score;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public float getScore() {
        return Score;
    }

    public void setScore(float score) {
        Score = score;
    }

    @Override
    public String toString() {
        return "Grade{" +
                ", Cname='" + Cname + '\'' +
                ", Score=" + Score +
                '}';
    }
}
