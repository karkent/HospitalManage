package com.cykj.hospitalsystem.service.impl;

import com.cykj.hospitalsystem.bean.DailyReport;
import com.cykj.hospitalsystem.bean.MouthData;
import com.cykj.hospitalsystem.mapper.ReportMapper;
import com.cykj.hospitalsystem.service.ReportService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    // 获取日报表的 产生 转运 入库 出库的重量
    @Override
    public DailyReport getDailyReportWeight(Map map) {
        return reportMapper.getDailyReportWeight(map);
    }

    // 获取日报表的 产生和转运的箱数
    @Override
    public int getDailyReportNum(Map map) {
        return reportMapper.getDailyReportNum(map);
    }

    // 获取日报表的入库箱数
    @Override
    public int getDailyReportstockInNum(Map map) {
        return reportMapper.getDailyReportstockInNum(map);
    }

    // 获取日报表的出库箱数
    @Override
    public int getDailyReportstockOutNum(Map map) {
        return reportMapper.getDailyReportstockOutNum(map);
    }

    // 获取日报表的入库重量
    @Override
    public String getDailyReportstockInWeight(Map map) {
        return reportMapper.getDailyReportstockInWeight(map);
    }

    // 获取日报表的出库重量
    @Override
    public String getDailyReportstockOutWeight(Map map) {
        return reportMapper.getDailyReportstockOutWeight(map);
    }

    // 获取日报表的各种类型的重量箱数
    @Override
    public List<DailyReport> getDailyReportTypeInfo(Map map) {
        return reportMapper.getDailyReportTypeInfo(map);
    }

    // 获取日报表的报表重量数据
    @Override
    public DailyReport getEchartsInfo(Map map) {
        return reportMapper.getEchartsInfo(map);
    }

    // 获取月报表的报表重量数据
    @Override
    public List<MouthData> getEchartsMouthInfo(Map map) {
        return reportMapper.getEchartsMouthInfo(map);
    }

    // 获取年报表的报表重量数据
    @Override
    public List<MouthData> getEchartsYearInfo(Map map) {
        return reportMapper.getEchartsYearInfo(map);
    }


}
