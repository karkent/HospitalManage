package com.cykj.hospitalsystem.bean;


import java.util.List;

public class Tblrole {

  private int roleid;
  private String rolename;
  private String rolecode;
  private int rolestate;
  private String rremarks;
  private Tbldata tbldata;

  // 关联映射 新增的字段
  private String label;
  private List<Tblstaff> children;


  @Override
  public String toString() {
    return "Tblrole{" +
            "roleid=" + roleid +
            ", rolename='" + rolename + '\'' +
            ", rolecode='" + rolecode + '\'' +
            ", rolestate=" + rolestate +
            ", rremarks='" + rremarks + '\'' +
            ", tbldata=" + tbldata +
            ", label='" + label + '\'' +
            ", children=" + children +
            '}';
  }

  public List<Tblstaff> getChildren() {
    return children;
  }

  public void setChildren(List<Tblstaff> children) {
    this.children = children;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public Tbldata getTbldata() {
    return tbldata;
  }

  public void setTbldata(Tbldata tbldata) {
    this.tbldata = tbldata;
  }

  public int getRoleid() {
    return roleid;
  }

  public void setRoleid(int roleid) {
    this.roleid = roleid;
  }


  public String getRolename() {
    return rolename;
  }

  public void setRolename(String rolename) {
    this.rolename = rolename;
  }


  public String getRolecode() {
    return rolecode;
  }

  public void setRolecode(String rolecode) {
    this.rolecode = rolecode;
  }


  public int getRolestate() {
    return rolestate;
  }

  public void setRolestate(int rolestate) {
    this.rolestate = rolestate;
  }


  public String getRremarks() {
    return rremarks;
  }

  public void setRremarks(String rremarks) {
    this.rremarks = rremarks;
  }

}
