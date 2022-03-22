package com.cykj.hospitalsystem.bean;


public class Tblbox {

  private long boxid;
  private long bstate;
  private String boxcode;
  private String fullName;
  private java.sql.Timestamp insterdate;
  private java.sql.Timestamp updatadate;
  private String usedate;
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

  public long getBoxid() {
    return boxid;
  }

  public void setBoxid(long boxid) {
    this.boxid = boxid;
  }


  public long getBstate() {
    return bstate;
  }

  public void setBstate(long bstate) {
    this.bstate = bstate;
  }


  public String getBoxcode() {
    return boxcode;
  }

  public void setBoxcode(String boxcode) {
    this.boxcode = boxcode;
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


  public java.sql.Timestamp getUpdatadate() {
    return updatadate;
  }

  public void setUpdatadate(java.sql.Timestamp updatadate) {
    this.updatadate = updatadate;
  }


  public String getUsedate() {
    return usedate;
  }

  public void setUsedate(String usedate) {
    this.usedate = usedate;
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
