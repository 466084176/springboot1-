package com.mkmk.student.bean;

/**
 * 课程实体类
 */
public class Course {

    private int Cno;
    private String Cname;
    private int Cpno;
    private int Ccredit;

    public Course() {
    }

    public Course(int cno, String cname, int cpno, int ccredit) {
        Cno = cno;
        Cname = cname;
        Cpno = cpno;
        Ccredit = ccredit;
    }

    public int getCno() {
        return Cno;
    }

    public void setCno(int cno) {
        Cno = cno;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public int getCpno() {
        return Cpno;
    }

    public void setCpno(int cpno) {
        Cpno = cpno;
    }

    public int getCcredit() {
        return Ccredit;
    }

    public void setCcredit(int ccredit) {
        Ccredit = ccredit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Cno=" + Cno +
                ", Cname='" + Cname + '\'' +
                ", Cpno=" + Cpno +
                ", Ccredit=" + Ccredit +
                '}';
    }
}
