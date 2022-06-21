package com.cykj.hospitalsystem.mapper;

import com.cykj.hospitalsystem.bean.Tblmedicaltype;
import com.cykj.hospitalsystem.bean.Tblwaringnotes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TblwaringnotesMapper {

      int addnote(List<Tblwaringnotes> list);

      List<Tblwaringnotes> findAll();

      int countRows();
      // 添加入库重量异常的信息
      int addnoteByMap(@Param(value = "map") Map<String,Object> map);

      //设置收集表，重量异常 是否已经预警
      int setWeightWaringState(@Param(value = "map") Map<String,Object> map);

//    删除预警表中的所有重量预警的信息
      int delInStockWeightWaring(Map<String,Object> map);

//    查找交接超时的数据
      List<Tblmedicaltype> OutOvertime(Map<String,Object> map);

      //删除预警表中的交接超时的预警信息
      int delOutStockOvertimeWaring();

      //设置入库表，出库（交接）超时的 状态，是否已经预警 spare1 =1
      int setOutStockOvertimeWaringState(@Param(value = "map") Map<String,Object> map);

      List<Tblwaringnotes> findParam(Map<String,Object> map);
      int findParamCount(Map<String,Object> map);

      int updateHandle(Map<String,Object> map);

      List<Tblmedicaltype> years(String yearTime);

      List<Tblmedicaltype> weightSort(String yearTime);

      List<Tblmedicaltype> sevenDay();

      List<Tblmedicaltype> disease();

      List<Tblmedicaltype> realTimeCollecting();

      List<Tblmedicaltype> officeRealTimeCollecting();

      List<Tblmedicaltype> dayWeekProportion(String dayWeek);
}
