package com.cykj.hospitalsystem.bean;

public class HazardousWasteTable {
    int bags;
    int boxs;
    double totalweight;
    String startdate;
    String enddate;

    int otherBags;
    int otherBoxs;
    double otherTotalweight;

    String collectName;
    String enterName;
    String inDate;


    public String getCollectName() {
        return collectName;
    }

    public void setCollectName(String collectName) {
        this.collectName = collectName;
    }

    public String getEnterName() {
        return enterName;
    }

    public void setEnterName(String enterName) {
        this.enterName = enterName;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    @Override
    public String toString() {
        return "HazardousWasteTable{" +
                "bags=" + bags +
                ", boxs=" + boxs +
                ", totalweight=" + totalweight +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", otherBags=" + otherBags +
                ", otherBoxs=" + otherBoxs +
                ", otherTotalweight=" + otherTotalweight +
                '}';
    }

    public int getOtherBags() {
        return otherBags;
    }

    public void setOtherBags(int otherBags) {
        this.otherBags = otherBags;
    }

    public int getOtherBoxs() {
        return otherBoxs;
    }

    public void setOtherBoxs(int otherBoxs) {
        this.otherBoxs = otherBoxs;
    }

    public double getOtherTotalweight() {
        return otherTotalweight;
    }

    public void setOtherTotalweight(double otherTotalweight) {
        this.otherTotalweight = otherTotalweight;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public int getBags() {
        return bags;
    }

    public void setBags(int bags) {
        this.bags = bags;
    }

    public int getBoxs() {
        return boxs;
    }

    public void setBoxs(int boxs) {
        this.boxs = boxs;
    }

    public double getTotalweight() {
        return totalweight;
    }

    public void setTotalweight(double totalweight) {
        this.totalweight = totalweight;
    }
}
