package com.cykj.hospitalsystem.bean;

import java.util.List;

public class DailyReport {
    private String weight;
    private String enterweight;
    private String outweight;
    private int tid;
    private String tname;
    private String quantity;
    private String hname;

    private List<DailyReport> list;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getEnterweight() {
        return enterweight;
    }

    public void setEnterweight(String enterweight) {
        this.enterweight = enterweight;
    }

    public String getOutweight() {
        return outweight;
    }

    public void setOutweight(String outweight) {
        this.outweight = outweight;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public List<DailyReport> getList() {
        return list;
    }

    public void setList(List<DailyReport> list) {
        this.list = list;
    }
}
