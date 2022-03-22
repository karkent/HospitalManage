package com.cykj.hospitalsystem.controller;

import com.cykj.hospitalsystem.bean.DailyReport;
import com.cykj.hospitalsystem.bean.DaulyReportTable;
import com.cykj.hospitalsystem.bean.EchartsSeriesData;
import com.cykj.hospitalsystem.bean.MouthData;
import com.cykj.hospitalsystem.service.ReportService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Report")
public class ReportController {

    @Autowired
    private ReportService reportServiceImpl;

    // 获取日报表的 产生 转运 入库 出库的重量
    @ResponseBody
    @RequestMapping("/getDailyReportWeight")
    public Map getDailyReportWeight(@RequestBody Map map){
        DailyReport dailyReport = reportServiceImpl.getDailyReportWeight(map);
        String stockInWeight = reportServiceImpl.getDailyReportstockInWeight(map);
        String stockOutWeight = reportServiceImpl.getDailyReportstockOutWeight(map);
        Map returnMap = new HashMap();
        returnMap.put("code",1);
        returnMap.put("list",dailyReport);
        returnMap.put("stockInWeight",stockInWeight);
        returnMap.put("stockOutWeight",stockOutWeight);
        return returnMap;
    }

    // 获取日报表的 产生和转运入库和出库的箱数
    @ResponseBody
    @RequestMapping("/getDailyReportNum")
    public Map getDailyReportNum(@RequestBody Map map){
        int count = reportServiceImpl.getDailyReportNum(map);
        int stockInNum = reportServiceImpl.getDailyReportstockInNum(map);
        int stockOutNum = reportServiceImpl.getDailyReportstockOutNum(map);
        Map returnMap = new HashMap();
        returnMap.put("code",1);
        returnMap.put("list",count);
        returnMap.put("stockInNum",stockInNum);
        returnMap.put("stockOutNum",stockOutNum);
        return returnMap;
    }

    // 获取日报表的各种类型的重量和箱数
    @ResponseBody
    @RequestMapping("/getDailyReportTypeInfo")
    public Map getDailyReportTypeInfo(@RequestBody Map map){
        List<DailyReport> list = reportServiceImpl.getDailyReportTypeInfo(map);
        double weightAll = 0;
        int quantityAll = 0;
        List<DaulyReportTable> info = new ArrayList();
        for (DailyReport dailyReport : list) {
            DaulyReportTable table = new DaulyReportTable();
            for (int i = 0; i < dailyReport.getList().size(); i++) {
                weightAll+=Double.parseDouble(dailyReport.getList().get(i).getWeight());
                quantityAll+=Integer.parseInt(dailyReport.getList().get(i).getQuantity());
                String infoStr = "箱数: "+dailyReport.getList().get(i).getQuantity()+"\n重量(KG): "+dailyReport.getList().get(i).getWeight();
                if (dailyReport.getList().get(i).getTname().equals("感染性废物")){
                    table.setValue1(infoStr);
                }else if(dailyReport.getList().get(i).getTname().equals("损伤性废物")){
                    table.setValue2(infoStr);
                }else if(dailyReport.getList().get(i).getTname().equals("病理性废物")){
                    table.setValue3(infoStr);
                }else if(dailyReport.getList().get(i).getTname().equals("化学性废物")){
                    table.setValue4(infoStr);
                }else if(dailyReport.getList().get(i).getTname().equals("药物性废物")){
                    table.setValue5(infoStr);
                }else if(dailyReport.getList().get(i).getTname().equals("输液瓶、袋")){
                    table.setValue6(infoStr);
                }

                if(table.getValue1() == null || table.getValue1().equals("")){
                    table.setValue1("箱数: 0 重量(KG): 0");
                }if(table.getValue2() == null || table.getValue2().equals("")){
                    table.setValue2("箱数: 0 重量(KG): 0");
                }if(table.getValue3() == null || table.getValue3().equals("")){
                    table.setValue3("箱数: 0 重量(KG): 0");
                }if(table.getValue4() == null || table.getValue4().equals("")){
                    table.setValue4("箱数: 0 重量(KG): 0");
                }if(table.getValue5() == null || table.getValue5().equals("")){
                    table.setValue5("箱数: 0 重量(KG): 0");
                }if(table.getValue6() == null || table.getValue6().equals("")){
                    table.setValue6("箱数: 0 重量(KG): 0");
                }

            }
            table.setHname(dailyReport.getHname());
            table.setInfoAll("箱数: "+ quantityAll +"\n重量(KG): "+ weightAll);
            info.add(table);
        }

        Map returnMap = new HashMap();
        returnMap.put("code",1);
        returnMap.put("list",info);
        return returnMap;
    }

    // 获取日报表的报表重量数据
    @ResponseBody
    @RequestMapping("/getEchartsInfo")
    public Map getEchartsInfo(@RequestBody Map map){
        DailyReport dailyReport = reportServiceImpl.getEchartsInfo(map);
        List<EchartsSeriesData> list = new ArrayList();
        Map returnMap = new HashMap();
        if(dailyReport != null){
            for (int i = 0; i < dailyReport.getList().size(); i++) {
                EchartsSeriesData data = new EchartsSeriesData();
                String[] weights = new String[1];
                weights[0] = dailyReport.getList().get(i).getWeight();
                data.setName(dailyReport.getList().get(i).getTname());
                data.setData(weights);
                data.setType("bar");
                data.setyAxisIndex(1);
                list.add(data);
            }
            returnMap.put("hospitalName", dailyReport.getHname());
            returnMap.put("list",list);
        }
        returnMap.put("code",1);
        return returnMap;
    }

    // 获取月报表的报表重量数据
    @ResponseBody
    @RequestMapping("/getEchartsMouthInfo")
    public Map getEchartsMouthInfo(@RequestBody Map map){
        String beginAndEndTime = (String) map.get("beginAndEndTime");
        String beginTime = beginAndEndTime + "-01";
        map.put("beginTime",beginTime);
        List<MouthData> mouthData = reportServiceImpl.getEchartsMouthInfo(map);
        List mouth = new ArrayList();
        List weight = new ArrayList();
        Map returnMap = new HashMap();
        if(mouthData != null){
            for (int i = 0; i < mouthData.size(); i++) {
                mouth.add(mouthData.get(i).getCday());
                weight.add(mouthData.get(i).getWeight());
            }
            returnMap.put("mouth", mouth);
            returnMap.put("weight",weight);
        }
        returnMap.put("code",1);
        return returnMap;
    }

    // 获取年报表的报表重量数据
    @ResponseBody
    @RequestMapping("/getEchartsYearInfo")
    public Map getEchartsYearInfo(@RequestBody Map map){
        String beginAndEndTime = (String) map.get("beginAndEndTime");
        String beginTime = beginAndEndTime + "-01-01";
        map.put("beginTime",beginTime);
        List<MouthData> mouthData = reportServiceImpl.getEchartsYearInfo(map);
        List year = new ArrayList();
        List weight = new ArrayList();
        Map returnMap = new HashMap();
        if(mouthData != null){
            for (int i = 0; i < mouthData.size(); i++) {
                year.add(mouthData.get(i).getCday());
                weight.add(mouthData.get(i).getWeight());
            }
            returnMap.put("year", year);
            returnMap.put("weight",weight);
        }
        returnMap.put("code",1);
        return returnMap;
    }


}
