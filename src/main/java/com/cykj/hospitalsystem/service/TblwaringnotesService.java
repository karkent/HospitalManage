package com.cykj.hospitalsystem.service;

import com.cykj.hospitalsystem.bean.Tblwaringnotes;

import java.util.List;
import java.util.Map;

public interface TblwaringnotesService {

    int addnote(List<Tblwaringnotes> list);

    Map<String,Object> findAll(Map<String,Object> map);

    List<Tblwaringnotes> findParam(Map<String,Object> map);
    int findParamCount(Map<String,Object> map);
    int updateHandle(Map<String,Object> map);

    Map<String,Object> allShowMsg(Map<String,Object> map);
}
