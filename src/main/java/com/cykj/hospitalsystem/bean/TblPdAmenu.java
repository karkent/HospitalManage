package com.cykj.hospitalsystem.bean;


import java.util.List;

public class TblPdAmenu {

  private int menuid;
  private int mpid;
  private String label;
  private String url;
  private int mstate;
  private Tbldata tbldata;
  private List<TblPdAmenu> children;

  @Override
  public String toString() {
    return "TblPdAmenu{" +
            "menuid=" + menuid +
            ", mpid=" + mpid +
            ", label='" + label + '\'' +
            ", url='" + url + '\'' +
            ", mstate=" + mstate +
            ", tbldata=" + tbldata +
            ", children=" + children +
            '}';
  }

  public Tbldata getTbldata() {
    return tbldata;
  }

  public void setTbldata(Tbldata tbldata) {
    this.tbldata = tbldata;
  }

  public List<TblPdAmenu> getChildren() {
    return children;
  }

  public void setChildren(List<TblPdAmenu> children) {
    this.children = children;
  }

  public int getMenuid() {
    return menuid;
  }

  public void setMenuid(int menuid) {
    this.menuid = menuid;
  }


  public int getMpid() {
    return mpid;
  }

  public void setMpid(int mpid) {
    this.mpid = mpid;
  }


  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public int getMstate() {
    return mstate;
  }

  public void setMstate(int mstate) {
    this.mstate = mstate;
  }

}
