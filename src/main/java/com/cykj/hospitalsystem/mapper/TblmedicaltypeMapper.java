package com.cykj.hospitalsystem.mapper;

import com.cykj.hospitalsystem.bean.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TblmedicaltypeMapper {

    int countRows(Map<String, Object> map);

    List<Tbldepartrment> selTbldpartment();
    List<Tbltypeprint> selTbltypeprin();
    List<Tblhospitalinfo> selTblhospitalinfo();
    List<Tbldata> selTbldata();
    List<Tblstaff> selTblstaff();
    List<Tblsave> selTblsave();
    List<Tblbox> selTblboxcode();
    List<Tblbox> selTblboxcodes();
    List<Viewmedicaltype> findAll(Map<String, Object> map);

    List<Viewmedicaltype> find(Map<String, Object> map);

    int upTrashType(@Param(value = "map") Map<String, Object> map);
    int upTrashState(@Param(value = "map") Map<String, Object> map);
    int upSaveid(@Param(value = "map") Map<String, Object> map);

    int upBoxcode(Map<String, Object> map);
    int HandaddDate(Map<String, Object> map);

    List<ViewDepstaff> DpartPonser(Map<String, Object> map);

    List<ViewDepstaff> collectList(Map<String, Object> map);

    // 预警的
    List<Tblmedicaltype> outtimein(@Param(value = "nowtime") String nowtime);
    int warningstatus(@Param(value = "infoid") int infoid);

    // 首页的 医费分析
    int getNumByType(Map<String, Object> map);

    // 收集列表的重量
    String collectWeightSUM(Map<String, Object> map);
    // 出库列表的重量
    String outWeightSUM(Map<String, Object> map);

    String findSumtable(Map<String, Object> map);

    // 科室医疗废物记录表
    List<Viewmedicaltype> table(Map<String, Object> map);
    List<TrashTable> findbox(Map<String, Object> map);
    List<TrashTable> findbox2(Map<String, Object> map);
    List<TrashTable> findbag(Map<String, Object> map);
    List<TrashTable> findplacenta(Map<String, Object> map);

    // 本科室医疗废物记录表 按钮 科室医疗废物记录表
    HazardousWasteTable hazardousWasteTable(Map<String,Object> map);

    //打印交接单
    List<TrashJiaoTable> findjiao(Map<String, Object> map);

    List<tbldemo> kstable(Map<String, Object> map);
}
