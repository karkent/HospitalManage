package com.cykj.hospitalsystem.service;

import com.cykj.hospitalsystem.bean.Tbltypeprint;

import java.util.Map;

public interface TrashTypeService {

    Map<String,Object> seltype(Map<String, Object> map);
    //显示表格
    Map<String,Object> selTrashList(Map<String, Object> map);
    //新增
    Map addTrash(Map<String, Object> map);

    Map updateTrash(Map<String, Object> map);

    int updateState(int tstate, int tid);

    Map setTrashstate(Map<String, Object> map);

    Tbltypeprint findExist(String tname);

}
