package com.cykj.hospitalsystem.service;

import com.cykj.hospitalsystem.bean.Tblhospitalinfo;

import java.util.List;
import java.util.Map;


public interface TblhospitalinfoService {
    Tblhospitalinfo check(String hname, String huscc);

    Tblhospitalinfo selectid(String hname, String huscc);

    Map updatehospital(Map<String, Object> map);

    Map addhospital(Map<String, Object> map);

    Map upstate(Map<String, Object> map);

    Map<String,Object> find(Map<String, Object> map);
}
