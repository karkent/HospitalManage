package com.cykj.hospitalsystem.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSONObject;
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
        return tblwaringnotesMapper.addnote(list);
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
}
