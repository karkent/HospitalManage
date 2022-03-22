package com.cykj.hospitalsystem.service;

import com.cykj.hospitalsystem.bean.StockIn;
import com.cykj.hospitalsystem.bean.Tblhospitalinfo;


import java.util.List;
import java.util.Map;

public interface StockInService {

    //查询医废入库信息
    List<StockIn> queryStockInInfo(Map<String,Object> map);

    // 查询医废入库信息总条数
    int queryStockInInfoCount(Map<String,Object> map);

    // 查询所有医院名称
    List<Tblhospitalinfo> getHospitalName();

    // 批量出库
    Map<String,Object> batchOutLibrary(Map<String,Object> map);

    // 批量全部出库
    Map<String,Object> batchOutLibraryAll(Map<String, Object> map);

    // 查询医废入库信息(无分页)
    List<StockIn> queryStockInInfoAll(String hname, String state, String beginTime, String endTime);

}
