package cn.sims.model;

import java.util.Date;

import cn.sims.util.ModelUtil;

public class Student {
    private String sno;

    private String sname;

    private String ssex;

	private Date sbirthday;

    private String clno;

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

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex == null ? null : ssex.trim();
    }

    public Date getSbirthday() {
        return sbirthday;
    }
    
    public String getSbirthdayString()
    {
    	return ModelUtil.dateToString(sbirthday);
    }

    public void setSbirthday(Date sbirthday) {
        this.sbirthday = sbirthday;
    }

    public String getClno() {
        return clno;
    }

    public void setClno(String clno) {
        this.clno = clno == null ? null : clno.trim();
    }
    
    @Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", ssex=" + ssex + ", sbirthday=" + ModelUtil.dateToString(sbirthday) + ", clno="
				+ clno + "]";
	}
}