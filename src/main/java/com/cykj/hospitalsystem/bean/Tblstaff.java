package com.cykj.hospitalsystem.bean;

import lombok.Data;

@Data
public class Tblstaff {

  private long staffid;
  private String sname;
  private String sjobnum;
  private String sidentitycard;
  private String spwd;
  private long sstate;
  private String sphone;
  private long hid;
  private String scornet;
  private String sort;
  private String wechatnum;
  private long did;
  private String svaliddate;
  private String signurl;
  private String spinyin;
  private java.sql.Timestamp insterdate;
  private java.sql.Timestamp updatadate;
  private String spare1;
  private String spare2;
  private Tbldepartrment tbldepartrment;
  private Tblrole tblrole;

  // 映射的属性
  private String label;


  public Tbldepartrment getTbldepartrment() {
    return tbldepartrment;
  }

  public void setTbldepartrment(Tbldepartrment tbldepartrment) {
    this.tbldepartrment = tbldepartrment;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public long getStaffid() {
    return staffid;
  }

  public void setStaffid(long staffid) {
    this.staffid = staffid;
  }


  public String getSname() {
    return sname;
  }

  public void setSname(String sname) {
    this.sname = sname;
  }


  public String getSjobnum() {
    return sjobnum;
  }

  public void setSjobnum(String sjobnum) {
    this.sjobnum = sjobnum;
  }


  public String getSidentitycard() {
    return sidentitycard;
  }

  public void setSidentitycard(String sidentitycard) {
    this.sidentitycard = sidentitycard;
  }


  public String getSpwd() {
    return spwd;
  }

  public void setSpwd(String spwd) {
    this.spwd = spwd;
  }


  public long getSstate() {
    return sstate;
  }

  public void setSstate(long sstate) {
    this.sstate = sstate;
  }


  public String getSphone() {
    return sphone;
  }

  public void setSphone(String sphone) {
    this.sphone = sphone;
  }


  public long getHid() {
    return hid;
  }

  public void setHid(long hid) {
    this.hid = hid;
  }


  public String getScornet() {
    return scornet;
  }

  public void setScornet(String scornet) {
    this.scornet = scornet;
  }


  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }


  public String getWechatnum() {
    return wechatnum;
  }

  public void setWechatnum(String wechatnum) {
    this.wechatnum = wechatnum;
  }


  public long getDid() {
    return did;
  }

  public void setDid(long did) {
    this.did = did;
  }


  public String getSvaliddate() {
    return svaliddate;
  }

  public void setSvaliddate(String svaliddate) {
    this.svaliddate = svaliddate;
  }


  public String getSignurl() {
    return signurl;
  }

  public void setSignurl(String signurl) {
    this.signurl = signurl;
  }


  public String getSpinyin() {
    return spinyin;
  }

  public void setSpinyin(String spinyin) {
    this.spinyin = spinyin;
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

  public Tblrole getTblrole() {
    return tblrole;
  }

  public void setTblrole(Tblrole tblrole) {
    this.tblrole = tblrole;
  }

  @Override
  public String toString() {
    return "Tblstaff{" +
            "staffid=" + staffid +
            ", sname='" + sname + '\'' +
            ", sjobnum='" + sjobnum + '\'' +
            ", sidentitycard='" + sidentitycard + '\'' +
            ", spwd='" + spwd + '\'' +
            ", sstate=" + sstate +
            ", sphone='" + sphone + '\'' +
            ", hid=" + hid +
            ", scornet='" + scornet + '\'' +
            ", sort='" + sort + '\'' +
            ", wechatnum='" + wechatnum + '\'' +
            ", did=" + did +
            ", svaliddate='" + svaliddate + '\'' +
            ", signurl='" + signurl + '\'' +
            ", spinyin='" + spinyin + '\'' +
            ", insterdate=" + insterdate +
            ", updatadate=" + updatadate +
            ", spare1='" + spare1 + '\'' +
            ", spare2='" + spare2 + '\'' +
            ", tblrole=" + tblrole +
            '}';
  }
}
