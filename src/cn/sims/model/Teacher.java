package cn.sims.model;

import java.util.Date;

public class Teacher {
    private String tno;

    private String tname;

    private String tsex;

    private Date tbirthday;

    private String tprofessor;

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno == null ? null : tno.trim();
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex == null ? null : tsex.trim();
    }

    public Date getTbirthday() {
        return tbirthday;
    }

    public void setTbirthday(Date tbirthday) {
        this.tbirthday = tbirthday;
    }

    public String getTprofessor() {
        return tprofessor;
    }

    public void setTprofessor(String tprofessor) {
        this.tprofessor = tprofessor == null ? null : tprofessor.trim();
    }
}