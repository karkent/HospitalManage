package com.cykj.hospitalsystem.bean;


import java.util.List;

public class Tbldepartrment {

  private long did;
  private long kid;
  private String dname;
  private String dcode;
  private String dspell;
  private String depidemic;
  private long dprintnum;
  private String dplacenta;
  private long pwarning;
  private String collecmode;
  private long ordernum;
  private String dfloornum;
  private String dfloor;
  private String droomNum;
  private String dproduce;
  private java.sql.Timestamp insterdate;
  private java.sql.Timestamp updatadate;
  private String spare1;
  private String spare2;
  private String dincode;

  private Tbldata tbldata;
  private Tblkname tblkname;

  private String dstate;   //改变属性 类型 之前是int 改成String
  //新增两个字段   并且新增一个toString的方法
  private String kname; //对应tblkname表的字段
  private String knum; //对应tblkname表的字段

  // 欧阳
  private String label;
  private List<Tblstaff> children;

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public List<Tblstaff> getChildren() {
    return children;
  }

  public void setChildren(List<Tblstaff> children) {
    this.children = children;
  }

  @Override
  public String toString() {
    return "Tbldepartrment{" +
            "did=" + did +
            ", kid=" + kid +
            ", dname='" + dname + '\'' +
            ", dcode='" + dcode + '\'' +
            ", dspell='" + dspell + '\'' +
            ", depidemic='" + depidemic + '\'' +
            ", dprintnum=" + dprintnum +
            ", dplacenta='" + dplacenta + '\'' +
            ", pwarning=" + pwarning +
            ", collecmode='" + collecmode + '\'' +
            ", ordernum=" + ordernum +
            ", dfloornum='" + dfloornum + '\'' +
            ", dfloor='" + dfloor + '\'' +
            ", droomNum='" + droomNum + '\'' +
            ", dproduce='" + dproduce + '\'' +
            ", dincode='" + dincode + '\'' +
            ", insterdate=" + insterdate +
            ", updatadate=" + updatadate +
            ", spare1='" + spare1 + '\'' +
            ", spare2='" + spare2 + '\'' +
            ", dstate='" + dstate + '\'' +
            ", kname='" + kname + '\'' +
            ", knum='" + knum + '\'' +
            ", tbldata=" + tbldata +
            ", tblkname=" + tblkname +
            '}';
  }

  public String getDincode() {
    return dincode;
  }

  public void setDincode(String dincode) {
    this.dincode = dincode;
  }

  public void setDstate(String dstate) {
    this.dstate = dstate;
  }

  public String getKname() {
    return kname;
  }

  public void setKname(String kname) {
    this.kname = kname;
  }

  public String getKnum() {
    return knum;
  }

  public void setKnum(String knum) {
    this.knum = knum;
  }

  public Tblkname getTblkname() {
    return tblkname;
  }

  public void setTblkname(Tblkname tblkname) {
    this.tblkname = tblkname;
  }

  public Tbldata getTbldata() {
    return tbldata;
  }

  public void setTbldata(Tbldata tbldata) {
    this.tbldata = tbldata;
  }

  public long getDid() {
    return did;
  }

  public void setDid(long did) {
    this.did = did;
  }


  public long getKid() {
    return kid;
  }

  public void setKid(long kid) {
    this.kid = kid;
  }


  public String getDname() {
    return dname;
  }

  public void setDname(String dname) {
    this.dname = dname;
  }


  public String getDcode() {
    return dcode;
  }

  public void setDcode(String dcode) {
    this.dcode = dcode;
  }


  public String getDspell() {
    return dspell;
  }

  public void setDspell(String dspell) {
    this.dspell = dspell;
  }


  public String getDepidemic() {
    return depidemic;
  }

  public void setDepidemic(String depidemic) {
    this.depidemic = depidemic;
  }


  public long getDprintnum() {
    return dprintnum;
  }

  public void setDprintnum(long dprintnum) {
    this.dprintnum = dprintnum;
  }


  public String getDplacenta() {
    return dplacenta;
  }

  public void setDplacenta(String dplacenta) {
    this.dplacenta = dplacenta;
  }


  public long getPwarning() {
    return pwarning;
  }

  public void setPwarning(long pwarning) {
    this.pwarning = pwarning;
  }


  public String getCollecmode() {
    return collecmode;
  }

  public void setCollecmode(String collecmode) {
    this.collecmode = collecmode;
  }


  public long getOrdernum() {
    return ordernum;
  }

  public void setOrdernum(long ordernum) {
    this.ordernum = ordernum;
  }


  public String getDfloornum() {
    return dfloornum;
  }

  public void setDfloornum(String dfloornum) {
    this.dfloornum = dfloornum;
  }


  public String getDfloor() {
    return dfloor;
  }

  public void setDfloor(String dfloor) {
    this.dfloor = dfloor;
  }


  public String getDroomNum() {
    return droomNum;
  }

  public void setDroomNum(String droomNum) {
    this.droomNum = droomNum;
  }


  public String getDproduce() {
    return dproduce;
  }

  public void setDproduce(String dproduce) {
    this.dproduce = dproduce;
  }

  public String getDstate() {
    return dstate;
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
