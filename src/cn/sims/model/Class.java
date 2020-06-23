package cn.sims.model;

public class Class {
    private String clno;

    private String clname;

    private String htname;

    private String htno;
    
    public String getClno() {
        return clno;
    }

    public void setClno(String clno) {
        this.clno = clno == null ? null : clno.trim();
    }

    public String getClname() {
        return clname;
    }

    public void setClname(String clname) {
        this.clname = clname == null ? null : clname.trim();
    }

    public String getHtname() {
        return htname;
    }

    public void setHtname(String htname) {
        this.htname = htname == null ? null : htname.trim();
    }

    public String getHtno() {
        return htno;
    }

    public void setHtno(String htno) {
        this.htno = htno == null ? null : htno.trim();
    }
}