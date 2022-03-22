package com.cykj.hospitalsystem.service.impl;

import com.cykj.hospitalsystem.bean.Tbldata;
import com.cykj.hospitalsystem.bean.ViewD;
import com.cykj.hospitalsystem.mapper.DataMapper;
import com.cykj.hospitalsystem.service.DataService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private DataMapper dataMapper;

    //新增
    @Override
    public Map addData(Map<String, Object> map) {
        System.out.println("dataOptionValue=" + map.get("dataOptionValue"));
        if (map.get("dataOptionValue").toString().trim().equals("") || map.get("dataOptionValue") == null) {
            map.put("dataOptionValue", 0);
        }else {
            map.put("dataOptionValue",map.get("dataOptionValue"));
        }
        System.out.println("改变后dataOptionValue=" + map.get("dataOptionValue"));
        map.put("dstate", 2);
        int i = dataMapper.addData(map);
        if (i >= 1) {
            map.put("sign", "1");
            map.put("msg", "新增成功");
        } else {
            map.put("sign", "2");
            map.put("msg", "新增异常，请重试！");
        }
        return KTool.codeToclient(map);
    }

    //修改
    @Override
    public Map updateData(Map<String, Object> map) {
        int i = dataMapper.updateData(map);
        if (i >= 1) {
            map.put("sign", "1");
            map.put("msg", "修改成功");
        } else {
            map.put("sign", "2");
            map.put("msg", "修改异常，请重试！");
        }
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> selpname(Map<String, Object> map) {
        List<Tbldata> pnames = dataMapper.selpname(map);
        map.put("list", pnames);
        return KTool.codeToclient(map);
    }

    @Override
    public Map disable(Map<String, Object> map) {
        map.put("dstate", 4);
        int i = dataMapper.setstate(map);
        if (i >= 1) {
            map.put("sign", "1");
            map.put("msg", "作废成功");
        } else {
            map.put("sign", "2");
            map.put("msg", "作废异常，请重试！");
        }
        return KTool.codeToclient(map);
    }

    @Override
    public Map setstate(Map<String, Object> map) {
        dataMapper.setstate(map);
        String msg = "";
        switch (map.get("dstate").toString()) {
            case "2":
                msg = "启用";
                break;
            case "3":
                msg = "禁用";
                break;
            case "4":
                msg = "废除";
                break;
        }
        map.put("msg", "批量" + msg + "成功!");
        return KTool.codeToclient(map);
    }

    @Override
    public Map findAllByPid(Map<String, Object> map) {
        map.put("dataList", dataMapper.findAllByPid(map));
        return KTool.codeToclient(map);
    }

    @Override
    public Map selectAllData(Map<String, Object> map) {
        String StateValueStr = KTool.dataid18tonull(map.get("StateValue"));
        map.put("StateValueStr", StateValueStr); //状态
        map.put("dremarks", map.get("searchStr"));
        map.put("dataname", map.get("searchStr"));

        List<Tbldata> datalist = dataMapper.findAll(map);
        List<Tbldata> newList = new ArrayList<>(); //顶级
        Map<String, Object> mapDataId = new HashMap<>();
        mapDataId.put("dataid", 1);
        List<Tbldata> dataState = dataMapper.findAllByPid(mapDataId);
        int totalCum = 0;
        for (Tbldata dlist1 : datalist) {
            if (dlist1.getPid().equals("0")) {
                for (int i = 0; i < dataState.size(); i++) {
                    if (dlist1.getDstate() == dataState.get(i).getDataid()) {
                        dlist1.setLabel(dataState.get(i).getLabel());
                    }
                }
                newList.add(dlist1);// 顶级元素加进去
                List<Tbldata> children = new ArrayList<>(); // 创建一个子级的list
                for (Tbldata dlist2 : datalist) {
                    for (int i = 0; i < dataState.size(); i++) {
                        if (dlist2.getDstate() == dataState.get(i).getDataid()) {
                            dlist2.setLabel(dataState.get(i).getLabel());
                        }
                    }
                    String dataid = dlist1.getDataid() + "";
                    String pid = dlist2.getPid();
                    if (dataid.equals(pid)) {
                        children.add(dlist2);
                    }
                }
                dlist1.setChildren(children);
                totalCum++; // 行数加1
            }
        }
        int nowPage = Integer.valueOf(map.get("nowPage").toString());
        int pageSize = Integer.valueOf(map.get("pageSize").toString());
        List<Tbldata> list = new ArrayList<>();
        for (int i = nowPage; i < newList.size() && i < pageSize; i++) {
            list.add(newList.get(i));
        }
        map.put("dataList", list);
        map.put("totalCum", totalCum);
        return KTool.codeToclient(map);
    }
}
