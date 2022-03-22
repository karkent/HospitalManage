package com.cykj.hospitalsystem.service;

import com.cykj.hospitalsystem.bean.StockIn;
import com.cykj.hospitalsystem.bean.StockOut;
import com.cykj.hospitalsystem.bean.Tblhospitalinfo;
import com.cykj.hospitalsystem.bean.Tbltypeprint;

import java.util.List;
import java.util.Map;

public interface StockOutService {

    //查询医废入库信息
    List<StockOut> queryStockInInfo(Map map);

    // 查询医废入库信息总条数
    int queryStockInInfoCount(Map map);

    // 查询所有医院名称
    List<Tblhospitalinfo> getHospitalName();

    // 查询所有医废类型
    List<Tbltypeprint> getMedicalWasteType();

    // 查询医废入库信息(无分页)
    List<StockOut> queryStockInInfoAll(Map map);

}
