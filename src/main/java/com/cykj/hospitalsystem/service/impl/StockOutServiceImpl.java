package com.cykj.hospitalsystem.service.impl;
import com.cykj.hospitalsystem.bean.StockIn;
import com.cykj.hospitalsystem.bean.StockOut;
import com.cykj.hospitalsystem.bean.Tblhospitalinfo;
import com.cykj.hospitalsystem.bean.Tbltypeprint;
import com.cykj.hospitalsystem.mapper.StockOutMapper;
import com.cykj.hospitalsystem.service.StockOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StockOutServiceImpl implements StockOutService {

    @Autowired
    private StockOutMapper stockOutMapper;

    // 查询医废入库信息
    @Override
    public List<StockOut> queryStockInInfo(Map map) {
        return stockOutMapper.queryStockInInfo(map);
    }
    // 查询医废入库信息总条数
    @Override
    public int queryStockInInfoCount(Map map) {
        return stockOutMapper.queryStockInInfoCount(map);
    }

    // 查询所有医院名称
    @Override
    public List<Tblhospitalinfo> getHospitalName() {
        return stockOutMapper.getHospitalName();
    }

    // 查询所有医废类型
    @Override
    public List<Tbltypeprint> getMedicalWasteType() {
        return stockOutMapper.getMedicalWasteType();
    }

    // 查询医废入库信息(无分页)
    @Override
    public List<StockOut> queryStockInInfoAll(Map map) {
        return stockOutMapper.queryStockInInfoAll(map);
    }

}
