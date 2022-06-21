package com.cykj.hospitalsystem.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSONObject;
import com.cykj.hospitalsystem.bean.Tblmedicaltype;
import com.cykj.hospitalsystem.bean.Tblwaringnotes;
import com.cykj.hospitalsystem.controller.WebSocketServer;
import com.cykj.hospitalsystem.mapper.TblwaringnotesMapper;
import com.cykj.hospitalsystem.service.TblwaringnotesService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TblwaringnotesServiceImpl implements TblwaringnotesService {

    @Autowired
    TblwaringnotesMapper tblwaringnotesMapper;

    @Override
    public int addnote(List<Tblwaringnotes> list) {
        int a = tblwaringnotesMapper.addnote(list);
        return a;
    }

    @Override
    public Map<String, Object> findAll(Map<String, Object> map) {
        List<Tblwaringnotes> waringnotesList = tblwaringnotesMapper.findAll();
        Map<String, Object> testmap = new HashMap<>();
        if (waringnotesList.size() > 0) {
            testmap.put("sign", 1);
            List<Map<String,Object>> list = new ArrayList<>();
            int totalCum = 0;
            for (Tblwaringnotes wn: waringnotesList) {
                //创建一个map
                String wnHname = wn.getHospital().getHname(); // 获得医院名称
                String wnDname = wn.getDepartrment().getDname(); //获得科室名称
                String wnDataName = wn.getTbldata().getDataname(); //获得预警类型名称
                int flag = 0;
                if (list.size()>0){
                    for (Map<String, Object> mapso : list) { // 去重，如果集合中已经有则不添加。
                        String mapsoHname = mapso.get("hName").toString();
                        String mapsoDname = mapso.get("dName").toString();
                        String mapsoDataName = mapso.get("dataName").toString();
                        if (wnHname.equals(mapsoHname) && wnDname.equals(mapsoDname) && wnDataName.equals(mapsoDataName)) {
                            flag = 1;
                            break;//跳出 这一层的fou循环
                        }
                    }
                }
                if (flag == 0) {
                    Map<String, Object> waringnotes = new HashMap<>();
                    //三个类型相等则累加一行。
                    int waringNum = 0;
                    for (Tblwaringnotes wnotes : waringnotesList) {
                        //创建一个map
                        String wnotesHname = wnotes.getHospital().getHname(); // 获得医院名称
                        String wnotesDname = wnotes.getDepartrment().getDname(); //获得科室名称
                        String wnotesDataName = wnotes.getTbldata().getDataname(); //获得预警类型名称
                        //三个类型相等则累加一行。
                        if (wnHname.equals(wnotesHname) && wnDname.equals(wnotesDname) && wnDataName.equals(wnotesDataName)) {
                            waringNum++;
                        }
                    }
                    waringnotes.put("hName", wnHname);
                    waringnotes.put("dName", wnDname);
                    waringnotes.put("dataName", wnDataName);
                    waringnotes.put("waringNum", waringNum);
                    list.add(waringnotes);
                    totalCum++;
                }
            }
            int nowPage = Integer.valueOf(map.get("nowPage").toString());
            int pageSize = Integer.valueOf(map.get("pageSize").toString());
            List<Map<String,Object>> listPage = new ArrayList<>();
            for(int i = nowPage;i<list.size() && i< pageSize;i++){
                listPage.add(list.get(i));
            }
            System.out.println("开始打印list");
            for (int i=0;i<listPage.size();i++){
                System.out.println(listPage.get(i).get("hName"));
            }
            testmap.put("waringnotesList", listPage);
            testmap.put("totalCum",totalCum);
        } else {
            List<Map<String,Object>> listPage = new ArrayList<>();
            testmap.put("waringnotesList", listPage); // 传一个空
            testmap.put("sign", 0);
            testmap.put("totalCum",0);
        }
        return KTool.codeToclient(testmap);
    }

    @Override
    public List<Tblwaringnotes> findParam(Map<String, Object> map) {
        return tblwaringnotesMapper.findParam(map);
    }

    @Override
    public int findParamCount(Map<String, Object> map) {
        return tblwaringnotesMapper.findParamCount(map);
    }

    @Override
    public int updateHandle(Map<String, Object> map) {
        return tblwaringnotesMapper.updateHandle(map);

    }

    @Override
    public Map<String, Object> allShowMsg(Map<String,Object> map) {
        map = new HashMap<>();
        //获取年获取月总重量
        Double yearWeight = 0.00;
        Double monthWeight = 0.00;
        Double dayWeight = 0.00;

        List<Tblmedicaltype> tblmedicaltypes = tblwaringnotesMapper.years(KTool.getYearStartTime());
        for (Tblmedicaltype m:tblmedicaltypes) {
            //获取年
            yearWeight = KTool.add(yearWeight,Double.valueOf(m.getWeight()));
            try {
                m.setCollectdate(String.valueOf(KTool.dayToTimeInMillis(m.getCollectdate())));
            } catch (Exception e) {
                e.printStackTrace();
            }
            //获取月
            if (Long.valueOf(m.getCollectdate()) >= KTool.getMonthStartTime()){
                monthWeight = KTool.add(monthWeight,Double.valueOf(m.getWeight()));
            }
            //获取日
            if (Long.valueOf(m.getCollectdate()) >= KTool.getTodayZeroPointTimestamps()){
                dayWeight = KTool.add(dayWeight,Double.valueOf(m.getWeight()));
            }
        }
        //年医废收集排序 三个
        List<Tblmedicaltype> tblMSort = tblwaringnotesMapper.weightSort(KTool.getYearStartTime());
        int a = 0;
        for (Tblmedicaltype t : tblMSort){
            t.setInfoid(a++);
        }
        //近三天七天
        List<Tblmedicaltype> seven = null;
        List<Tblmedicaltype> disease = null;
        try {
            disease = KTool.bubbleSort(tblwaringnotesMapper.disease());
            seven = KTool.bubbleSort(tblwaringnotesMapper.sevenDay());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //三天
        List<Tblmedicaltype> three = seven.subList(4,7);
        System.out.println(three.size());

        //实时收集数据 15个人员
        List<Tblmedicaltype> peopleRealTimeCollecting = tblwaringnotesMapper.realTimeCollecting();
        for (Tblmedicaltype r:peopleRealTimeCollecting){
           r.setSpare3(KTool.protectedName(r.getSpare3()));
        }
        //科室
        List<Tblmedicaltype> officeRealTimeCollecting = tblwaringnotesMapper.officeRealTimeCollecting();
        for (Tblmedicaltype r:officeRealTimeCollecting){
            r.setSpare3(KTool.protectedName(r.getSpare3()));
        }
        //周 日 医废占比
        List<Tblmedicaltype> weekProportion = tblwaringnotesMapper.dayWeekProportion(KTool.getNextDay
                (KTool.timeInMillisToDay(KTool.getTodayZeroPointTimestamps()),-6)+" 00:00:00");
        List<Tblmedicaltype> dayProportion = tblwaringnotesMapper.dayWeekProportion(KTool.timeInMillisToDay
                (KTool.getTodayZeroPointTimestamps()));
        map.put("code",1);
        map.put("yearWeight",yearWeight);
        map.put("monthWeight",monthWeight);
        map.put("dayWeight",dayWeight);
        map.put("tblMSort",tblMSort);
        map.put("seven",seven);
        map.put("three",three);
        map.put("realTimeCollecting",peopleRealTimeCollecting);
        map.put("officeRealTimeCollecting",officeRealTimeCollecting);
        map.put("weekProportion",weekProportion);
        map.put("dayProportion",dayProportion);
        map.put("disease",disease);
        System.out.println(JSONObject.toJSONString(map.get("disease")+"/*-"));
        return map;
    }
}
