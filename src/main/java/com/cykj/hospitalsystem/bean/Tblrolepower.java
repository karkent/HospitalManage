package com.cykj.hospitalsystem.bean;


public class Tblrolepower {

  private long id;
  private long menuid;
  private long pdAmenuid;
  private long roleid;
  private long powerid;
  private long state;
  private Tblrole tblrole;


  public Tblrole getTblrole() {
    return tblrole;
  }

  public void setTblrole(Tblrole tblrole) {
    this.tblrole = tblrole;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getMenuid() {
    return menuid;
  }

  public void setMenuid(long menuid) {
    this.menuid = menuid;
  }


  public long getPdAmenuid() {
    return pdAmenuid;
  }

  public void setPdAmenuid(long pdAmenuid) {
    this.pdAmenuid = pdAmenuid;
  }


  public long getRoleid() {
    return roleid;
  }

  public void setRoleid(long roleid) {
    this.roleid = roleid;
  }


  public long getPowerid() {
    return powerid;
  }

  public void setPowerid(long powerid) {
    this.powerid = powerid;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }

}
