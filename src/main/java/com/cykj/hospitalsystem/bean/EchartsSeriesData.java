package com.cykj.hospitalsystem.bean;

public class EchartsSeriesData {
    private String name;
    private String type;
    private int yAxisIndex;
    private String[] data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getyAxisIndex() {
        return yAxisIndex;
    }

    public void setyAxisIndex(int yAxisIndex) {
        this.yAxisIndex = yAxisIndex;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
