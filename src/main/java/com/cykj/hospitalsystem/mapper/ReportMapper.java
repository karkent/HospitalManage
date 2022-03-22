package com.cykj.hospitalsystem.mapper;

import com.cykj.hospitalsystem.bean.DailyReport;
import com.cykj.hospitalsystem.bean.MouthData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ReportMapper {
    // 获取日报表的 产生 转运 入库 出库的重量
    public DailyReport getDailyReportWeight(Map map);

    // 获取日报表的 产生和转运的箱数
    public int getDailyReportNum(Map map);

    // 获取日报表的入库箱数
    public int getDailyReportstockInNum(Map map);

    // 获取日报表的出库箱数
    public int getDailyReportstockOutNum(Map map);

    // 获取日报表的入库重量
    public String getDailyReportstockInWeight(Map map);

    // 获取日报表的出库重量
    public String getDailyReportstockOutWeight(Map map);

    // 获取日报表的各种类型的重量箱数
    public List<DailyReport> getDailyReportTypeInfo(Map map);

    // 获取日报表的报表重量数据
    public DailyReport getEchartsInfo(Map map);

    // 获取月报表的报表重量数据
    public List<MouthData> getEchartsMouthInfo(Map map);

    // 获取年报表的报表重量数据
    public List<MouthData> getEchartsYearInfo(Map map);
}
