package com.cykj.hospitalsystem.bean;


public class Tbltypeprint {

    private long tid;
    private String tname;
    private String tcode;
    private long pid;
    private long tstate;
    private Tbldata tbldata;

    public Tbldata getTbldata() {
        return tbldata;
    }

    public void setTbldata(Tbldata tbldata) {
        this.tbldata = tbldata;
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }


    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }


    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }


    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }


    public long getTstate() {
        return tstate;
    }

    public void setTstate(long tstate) {
        this.tstate = tstate;
    }

}
