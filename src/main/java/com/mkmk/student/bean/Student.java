package com.mkmk.student.bean;

/**
 * 学生实体类
 */
public class Student {

    private int Id;
    private int Sno;
    private String Sname;
    private String Ssex;
    private int Sage;
    private String Sdept;

    public Student() {
    }

    public Student(int id, int sno, String sname, String ssex, int sage, String sdept) {
        Id = id;
        Sno = sno;
        Sname = sname;
        Ssex = ssex;
        Sage = sage;
        Sdept = sdept;
    }

    public int getSno() {
        return Sno;
    }

    public void setSno(int sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public int getSage() {
        return Sage;
    }

    public void setSage(int sage) {
        Sage = sage;
    }

    public String getSdept() {
        return Sdept;
    }

    public void setSdept(String sdept) {
        Sdept = sdept;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", Sno=" + Sno +
                ", Sname='" + Sname + '\'' +
                ", Ssex='" + Ssex + '\'' +
                ", Sage=" + Sage +
                ", Sdept='" + Sdept + '\'' +
                '}';
    }
}
