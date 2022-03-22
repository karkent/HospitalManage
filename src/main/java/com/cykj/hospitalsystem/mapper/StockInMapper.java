package com.cykj.hospitalsystem.mapper;

import com.cykj.hospitalsystem.bean.StockIn;
import com.cykj.hospitalsystem.bean.Tblhospitalinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * 李久明
 * 用于医废入库
 */

@Repository
public interface StockInMapper {
    //查询医废入库信息
    List<StockIn> queryStockInInfo(Map<String,Object> map);

    // 查询医废入库信息总条数
    int queryStockInInfoCount(Map<String,Object> map);

    // 查询所有医院名称
    List<Tblhospitalinfo> getHospitalName();

    // 批量出库
    int batchOutLibrary(@Param(value = "map") Map<String,Object> map);

    // 批量全部出库
    int batchOutLibraryAll();

    // 查询医废入库信息(无分页)
    List<StockIn> queryStockInInfoAll(@Param(value = "hname") String hname,
                                      @Param(value = "state") String state,
                                      @Param(value = "beginTime") String beginTime,
                                      @Param(value = "endTime") String endTime);

    int addMedicalIn(Map<String, Object> map);

    int AddTWO(@Param(value = "map") Map<String,Object> map);

    //查询所有已入库状态的 收集表
    List<StockIn> findTblByState();
}
