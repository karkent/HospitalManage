package com.cykj.hospitalsystem.bean;


import java.util.List;

public class Routes {

  private int rid;
  private int pid;
  private String path;
  private String component;
  private String label;
  private String icon;
  private String redirect;
  private String rname;
  private List<Routes> children;
  private Tbldata tbldata; // 参数表
  private int rstate; // 状态

  public Tbldata getTbldata() {
    return tbldata;
  }

  public void setTbldata(Tbldata tbldata) {
    this.tbldata = tbldata;
  }

  public int getRstate() {
    return rstate;
  }

  public void setRstate(int rstate) {
    this.rstate = rstate;
  }

  @Override
  public String toString() {
    return "Routes{" +
            "rid=" + rid +
            ", pid=" + pid +
            ", path='" + path + '\'' +
            ", component='" + component + '\'' +
            ", label='" + label + '\'' +
            ", icon='" + icon + '\'' +
            ", redirect='" + redirect + '\'' +
            ", rname='" + rname + '\'' +
            ", children=" + children +
            '}';
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public List<Routes> getChildren() {
    return children;
  }

  public void setChildren(List<Routes> children) {
    this.children = children;
  }

  public int getRid() {
    return rid;
  }

  public void setRid(int rid) {
    this.rid = rid;
  }


  public int getPid() {
    return pid;
  }

  public void setPid(int pid) {
    this.pid = pid;
  }


  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }


  public String getComponent() {
    return component;
  }

  public void setComponent(String component) {
    this.component = component;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }


  public String getRedirect() {
    return redirect;
  }

  public void setRedirect(String redirect) {
    this.redirect = redirect;
  }


  public String getRname() {
    return rname;
  }

  public void setRname(String rname) {
    this.rname = rname;
  }

}
