package com.cykj.hospitalsystem.bean;

public class TrashTable {
    private String dname; // 科室名
    private String type1; // 医费类型所对应的重量
    private String type2;
    private String type3;
    private String type4;
    private String type5;
    private String type6;
    private String type7;
    private String totalweight;
    private String sname;
    private String sname2;
    private long did;
    private long typeid;
    private String boxnum;
    private String bagnum;
    private String placentanum;

    public long getDid() {
        return did;
    }

    public void setDid(long did) {
        this.did = did;
    }

    public String getBagnum() {
        return bagnum;
    }

    public String getPlacentanum() {
        return placentanum;
    }

    public void setPlacentanum(String placentanum) {
        this.placentanum = placentanum;
    }

    public void setBagnum(String bagnum) {
        this.bagnum = bagnum;
    }

    public long getTypeid() {
        return typeid;
    }

    public void setTypeid(long typeid) {
        this.typeid = typeid;
    }

    public String getBoxnum() {
        return boxnum;
    }

    public void setBoxnum(String boxnum) {
        this.boxnum = boxnum;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }

    public String getType4() {
        return type4;
    }

    public void setType4(String type4) {
        this.type4 = type4;
    }

    public String getType5() {
        return type5;
    }

    public void setType5(String type5) {
        this.type5 = type5;
    }

    public String getType6() {
        return type6;
    }

    public void setType6(String type6) {
        this.type6 = type6;
    }

    public String getType7() {
        return type7;
    }

    public void setType7(String type7) {
        this.type7 = type7;
    }

    public String getTotalweight() {
        return totalweight;
    }

    public void setTotalweight(String totalweight) {
        this.totalweight = totalweight;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSname2() {
        return sname2;
    }

    public void setSname2(String sname2) {
        this.sname2 = sname2;
    }
}
