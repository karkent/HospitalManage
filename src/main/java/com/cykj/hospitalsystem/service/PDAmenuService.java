package com.cykj.hospitalsystem.service;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.Map;

public interface PDAmenuService {
    // 获得所有菜单
    Map<String,Object> authorityMenuPDA(Map<String,Object> map);
    // 选择权限并分配
    Map<String,Object> SelectAuthorityPDA(Map<String,Object> map);

    Map<String,Object> getPDAId(Map<String,Object> map);
    /*批量修改状态*/
    Map setPDAmenuState(Map<String,Object> map);
    /*修改菜单内容*/
    Map setPDAmenuData(Map<String,Object> map);
    /*新增菜单*/
    Map<String,Object> addPDAmenu(Map<String, Object> map);
}
