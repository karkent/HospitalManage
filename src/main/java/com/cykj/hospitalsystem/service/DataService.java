package com.cykj.hospitalsystem.service;

import java.util.Map;

public interface DataService {

//新增
    Map addData(Map<String, Object> map);
    //修改
    Map updateData(Map<String, Object> map);

    Map<String,Object> selpname(Map<String, Object> map);

    Map disable(Map<String, Object> map);

    Map setstate(Map<String, Object> map);

    Map findAllByPid(Map<String, Object> map);
    //显示表格
    Map selectAllData(Map<String, Object> map);
}
