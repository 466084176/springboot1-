package com.mkmk.student.bean;

/**
 * 选修表
 */
public class SC {
    private int Sno;
    private int Cno;
    private float Score;

    public SC() {
    }

    public SC(int sno, int cno, float grade) {
        Sno = sno;
        Cno = cno;
        Score = grade;
    }

    public int getSno() {
        return Sno;
    }

    public void setSno(int sno) {
        Sno = sno;
    }

    public int getCno() {
        return Cno;
    }

    public void setCno(int cno) {
        Cno = cno;
    }

    public float getGrade() {
        return Score;
    }

    public void setGrade(float grade) {
        Score = grade;
    }

    @Override
    public String toString() {
        return "SC{" +
                "Sno=" + Sno +
                ", Cno=" + Cno +
                ", Grade=" + Score +
                '}';
    }
}
