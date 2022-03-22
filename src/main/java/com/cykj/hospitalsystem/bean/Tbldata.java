package com.cykj.hospitalsystem.bean;


import java.util.List;

public class Tbldata {

  private long dataid;
  private String pid;
  private String dataname;
  private String dremarks;
  //新增字段
  private long dstate;

  //新增属性
  private int value;
  private String label;

  /*新增字段*/
  private List<Tbldata> children;


  public List<Tbldata> getChildren() {
    return children;
  }

  public void setChildren(List<Tbldata> children) {
    this.children = children;
  }

  public long getDstate() {
    return dstate;
  }

  public void setDstate(long dstate) {
    this.dstate = dstate;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public long getDataid() {
    return dataid;
  }

  public void setDataid(long dataid) {
    this.dataid = dataid;
  }


  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }


  public String getDataname() {
    return dataname;
  }

  public void setDataname(String dataname) {
    this.dataname = dataname;
  }


  public String getDremarks() {
    return dremarks;
  }

  public void setDremarks(String dremarks) {
    this.dremarks = dremarks;
  }

}
