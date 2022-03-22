package com.cykj.hospitalsystem.bean;


public class Tbladmininfo {

  private long adminid;
  private String aname;
  private String ajobnum;
  private long astate;
  private String acardnum;
  private String apwd;
  private String aphone;
  private String acornet;
  private long roleid;
  private long hid;
  private java.sql.Timestamp insterdate;
  private java.sql.Timestamp updatadate;
  private String spare1;
  private String spare2;
  private Tblhospitalinfo tblhospitalinfo;
  private Tblrole tblrole;

  public Tblrole getTblrole() {
    return tblrole;
  }

  public void setTblrole(Tblrole tblrole) {
    this.tblrole = tblrole;
  }

  public Tblhospitalinfo getTblhospitalinfo() {
    return tblhospitalinfo;
  }

  public void setTblhospitalinfo(Tblhospitalinfo tblhospitalinfo) {
    this.tblhospitalinfo = tblhospitalinfo;
  }

  public long getAdminid() {
    return adminid;
  }

  public void setAdminid(long adminid) {
    this.adminid = adminid;
  }


  public String getAname() {
    return aname;
  }

  public void setAname(String aname) {
    this.aname = aname;
  }


  public String getAjobnum() {
    return ajobnum;
  }

  public void setAjobnum(String ajobnum) {
    this.ajobnum = ajobnum;
  }


  public long getAstate() {
    return astate;
  }

  public void setAstate(long astate) {
    this.astate = astate;
  }


  public String getAcardnum() {
    return acardnum;
  }

  public void setAcardnum(String acardnum) {
    this.acardnum = acardnum;
  }


  public String getApwd() {
    return apwd;
  }

  public void setApwd(String apwd) {
    this.apwd = apwd;
  }


  public String getAphone() {
    return aphone;
  }

  public void setAphone(String aphone) {
    this.aphone = aphone;
  }


  public String getAcornet() {
    return acornet;
  }

  public void setAcornet(String acornet) {
    this.acornet = acornet;
  }


  public long getRoleid() {
    return roleid;
  }

  public void setRoleid(long roleid) {
    this.roleid = roleid;
  }


  public long getHid() {
    return hid;
  }

  public void setHid(long hid) {
    this.hid = hid;
  }


  public java.sql.Timestamp getInsterdate() {
    return insterdate;
  }

  public void setInsterdate(java.sql.Timestamp insterdate) {
    this.insterdate = insterdate;
  }


  public java.sql.Timestamp getUpdatadate() {
    return updatadate;
  }

  public void setUpdatadate(java.sql.Timestamp updatadate) {
    this.updatadate = updatadate;
  }


  public String getSpare1() {
    return spare1;
  }

  public void setSpare1(String spare1) {
    this.spare1 = spare1;
  }


  public String getSpare2() {
    return spare2;
  }

  public void setSpare2(String spare2) {
    this.spare2 = spare2;
  }

}
