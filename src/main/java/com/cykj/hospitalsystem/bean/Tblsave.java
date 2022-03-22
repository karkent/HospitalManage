package com.cykj.hospitalsystem.bean;


public class Tblsave {

  private long saveid;
  private String savename;
  private String savecode;
  private long savestate;
  private String fullName;
  private java.sql.Timestamp insterdate;
  private java.sql.Timestamp updatedate;
  private String spare1;
  private String spare2;
  private Tbldata tbldata;
  private Tblhospitalinfo tblhospitalinfo;
  private long hid;

  public long getHid() {
    return hid;
  }

  public void setHid(long hid) {
    this.hid = hid;
  }

  public Tblhospitalinfo getTblhospitalinfo() {
    return tblhospitalinfo;
  }

  public void setTblhospitalinfo(Tblhospitalinfo tblhospitalinfo) {
    this.tblhospitalinfo = tblhospitalinfo;
  }
  public Tbldata getTbldata() {
    return tbldata;
  }

  public void setTbldata(Tbldata tbldata) {
    this.tbldata = tbldata;
  }

  public long getSaveid() {
    return saveid;
  }

  public void setSaveid(long saveid) {
    this.saveid = saveid;
  }


  public String getSavename() {
    return savename;
  }

  public void setSavename(String savename) {
    this.savename = savename;
  }


  public String getSavecode() {
    return savecode;
  }

  public void setSavecode(String savecode) {
    this.savecode = savecode;
  }


  public long getSavestate() {
    return savestate;
  }

  public void setSavestate(long savestate) {
    this.savestate = savestate;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public java.sql.Timestamp getInsterdate() {
    return insterdate;
  }

  public void setInsterdate(java.sql.Timestamp insterdate) {
    this.insterdate = insterdate;
  }


  public java.sql.Timestamp getUpdatedate() {
    return updatedate;
  }

  public void setUpdatedate(java.sql.Timestamp updatedate) {
    this.updatedate = updatedate;
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
