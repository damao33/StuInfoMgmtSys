package cn.sims.model;

import java.math.BigDecimal;

public class Score {
    private String sno;

    private String sname;

    private String cno;

    private String cname;

    private BigDecimal degrees;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno == null ? null : cno.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public BigDecimal getDegrees() {
        return degrees;
    }

    public void setDegrees(BigDecimal degrees) {
        this.degrees = degrees;
    }
}