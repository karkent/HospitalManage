package com.cykj.hospitalsystem.bean;


public class Viewmedicaltype {

  private long infoid;
  private long state;
  private long typeid;
  private String weight;
  private long joinid;
  private long did;
  private long placentanum;
  private String collectdate;
  private long collectid;
  private String bagcode;
  private String boxcode;
  private long saveid;
  private long hid;
  private String depidemic;
  private String spare1;
  private String spare2;
  private String dataname;
  private String tname;
  private String sname;
  private String dname;
  private String sname2;
  private String savename;
  private String hname;
  private String infraction;

  // 返回给首页报表的数据，新增的两个属性
  private int value;
  private String name;

  private int row;


  @Override
  public String toString() {
    return "Viewmedicaltype{" +
            "infoid=" + infoid +
            ", state=" + state +
            ", typeid=" + typeid +
            ", weight='" + weight + '\'' +
            ", joinid=" + joinid +
            ", did=" + did +
            ", placentanum=" + placentanum +
            ", collectdate='" + collectdate + '\'' +
            ", collectid=" + collectid +
            ", bagcode='" + bagcode + '\'' +
            ", boxcode='" + boxcode + '\'' +
            ", saveid=" + saveid +
            ", hid=" + hid +
            ", depidemic='" + depidemic + '\'' +
            ", spare1='" + spare1 + '\'' +
            ", spare2='" + spare2 + '\'' +
            ", dataname='" + dataname + '\'' +
            ", tname='" + tname + '\'' +
            ", sname='" + sname + '\'' +
            ", dname='" + dname + '\'' +
            ", sname2='" + sname2 + '\'' +
            ", savename='" + savename + '\'' +
            ", hname='" + hname + '\'' +
            ", infraction='" + infraction + '\'' +
            ", value=" + value +
            ", name='" + name + '\'' +
            ", row=" + row +
            '}';
  }

  public int getRow() {
    return row;
  }
  public void setRow(int row) {
    this.row = row;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getInfraction() {
    return infraction;
  }

  public void setInfraction(String infraction) {
    this.infraction = infraction;
  }

  public long getInfoid() {
    return infoid;
  }

  public void setInfoid(long infoid) {
    this.infoid = infoid;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }


  public long getTypeid() {
    return typeid;
  }

  public void setTypeid(long typeid) {
    this.typeid = typeid;
  }


  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }


  public long getJoinid() {
    return joinid;
  }

  public void setJoinid(long joinid) {
    this.joinid = joinid;
  }


  public long getDid() {
    return did;
  }

  public void setDid(long did) {
    this.did = did;
  }


  public long getPlacentanum() {
    return placentanum;
  }

  public void setPlacentanum(long placentanum) {
    this.placentanum = placentanum;
  }


  public String getCollectdate() {
    return collectdate;
  }

  public void setCollectdate(String collectdate) {
    this.collectdate = collectdate;
  }


  public long getCollectid() {
    return collectid;
  }

  public void setCollectid(long collectid) {
    this.collectid = collectid;
  }


  public String getBagcode() {
    return bagcode;
  }

  public void setBagcode(String bagcode) {
    this.bagcode = bagcode;
  }


  public String getBoxcode() {
    return boxcode;
  }

  public void setBoxcode(String boxcode) {
    this.boxcode = boxcode;
  }


  public long getSaveid() {
    return saveid;
  }

  public void setSaveid(long saveid) {
    this.saveid = saveid;
  }


  public long getHid() {
    return hid;
  }

  public void setHid(long hid) {
    this.hid = hid;
  }


  public String getDepidemic() {
    return depidemic;
  }

  public void setDepidemic(String depidemic) {
    this.depidemic = depidemic;
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


  public String getDataname() {
    return dataname;
  }

  public void setDataname(String dataname) {
    this.dataname = dataname;
  }


  public String getTname() {
    return tname;
  }

  public void setTname(String tname) {
    this.tname = tname;
  }


  public String getSname() {
    return sname;
  }

  public void setSname(String sname) {
    this.sname = sname;
  }


  public String getDname() {
    return dname;
  }

  public void setDname(String dname) {
    this.dname = dname;
  }


  public String getSname2() {
    return sname2;
  }

  public void setSname2(String sname2) {
    this.sname2 = sname2;
  }


  public String getSavename() {
    return savename;
  }

  public void setSavename(String savename) {
    this.savename = savename;
  }


  public String getHname() {
    return hname;
  }

  public void setHname(String hname) {
    this.hname = hname;
  }

}
