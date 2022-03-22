package com.cykj.hospitalsystem.service;

import com.cykj.hospitalsystem.bean.Tbldepartrment;
import com.cykj.hospitalsystem.bean.Tblmedicaltype;
import com.cykj.hospitalsystem.bean.Viewmedicaltype;

import java.util.List;
import java.util.Map;


public interface TblmedicaltypeService {

    Map<String,Object> selTbldpartment(Map<String, Object> map);
    Map<String,Object> selTbltypeprin(Map<String, Object> map);
    Map<String,Object> selTblhospitalinfo(Map<String, Object> map);
    Map<String,Object> selTbldata(Map<String, Object> map);
    Map<String,Object> selTblstaff(Map<String, Object> map);
    Map<String,Object> selTblsave(Map<String, Object> map);
    Map<String,Object> selTblboxcode(Map<String, Object> map);
    Map<String,Object> selTblboxcodes(Map<String, Object> map);
    Map<String,Object> findAll(Map<String, Object> map);
    Map<String,Object> find(Map<String, Object> map);
    Map<String,Object> upTrashType(Map<String, Object> map);
    Map<String,Object> upTrashState(Map<String, Object> map);
    Map<String,Object> upSaveid(Map<String, Object> map);
    Map<String,Object> upBoxcode(Map<String, Object> map);
    Map<String,Object> HandaddDate(Map<String, Object> map);
    Map<String,Object> DpartPonser(Map<String, Object> map);

    Map<String,Object> collectList(Map<String, Object> map);
    // 预警的
    List<Tblmedicaltype> outtimein(String nowtime);
    int warningstatus(int infoid);

    // 首页的 医费分析
    Map getNumByType(Map<String, Object> map);
    Map<String,Object> table(Map<String, Object> map);


    // 危险废物转移联单（医疗废物专用）
    Map<String,Object> hazardousWasteTable(Map<String,Object> map);
    //打印交接单
    Map<String,Object> findjiao(Map<String, Object> map);

    Map<String,Object> kstable(Map<String, Object> map);

}
