package com.cykj.hospitalsystem.service.impl;

import com.cykj.hospitalsystem.bean.Tblhospitalinfo;
import com.cykj.hospitalsystem.mapper.TblhospitalinfoMapper;
import com.cykj.hospitalsystem.service.TblhospitalinfoService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TblhospitalinfoServiceImpl implements TblhospitalinfoService {

    @Autowired
    private TblhospitalinfoMapper tblhospitalinfoMapper;

    @Override
    public Tblhospitalinfo check(String hname, String huscc) {
        return tblhospitalinfoMapper.check(hname,huscc);
    }

    @Override
    public Tblhospitalinfo selectid(String hname,String huscc) {
        return tblhospitalinfoMapper.selectid(hname,huscc);
    }


    @Override
    public Map updatehospital(Map<String, Object> map) {
        int i = tblhospitalinfoMapper.updatehospital(map);
        if(i>=1){
            map.put("code","1");
            map.put("msg","成功");
        }else {
            map.put("code","0");
            map.put("msg","异常");
        }
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String,Object> addhospital(Map<String,Object> map) {
        int i = tblhospitalinfoMapper.addhospital(map);
        if(i>=1){
            map.put("code","1");
            map.put("msg","新增成功");
        }else{
            map.put("code","0");
            map.put("msg","新增异常，请重试");
        }
        return map;
    }

    @Override
    public Map<String,Object> upstate(Map<String, Object> map) {
        int i = tblhospitalinfoMapper.upstate(map);
        String msg = "";
        switch (map.get("hstate").toString()){
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
        if(i>=1){
            map.put("code",1);
            map.put("msg","批量"+msg+"成功!");
        }else{
            map.put("code",0);
            map.put("msg","批量"+msg+"异常，请重试");
        }
        return map;
    }

    @Override
    public Map<String, Object> find(Map<String,Object> map) {
        String hstateStr = KTool.dataid18tonull(map.get("StateValue"));
        map.put("hstateStr",hstateStr);

        // 进行数据的处理
        String str = map.get("searchStr").toString().trim();
        if (KTool.isNumeric(str)){ // 是纯数字
            map.put("hmobilephone",str);
        }else{ // 不是纯数字
            if (KTool.checkNameChese(str)){ // 判断是不是纯中文
                map.put("hname",str);
                map.put("hlegal",str);
            } else {
                map.put("huscc",str);
            }
        }
        System.out.println(tblhospitalinfoMapper.find(map).toString()+"@#@#@##@#@##@");
        map.put("tableData",tblhospitalinfoMapper.find(map));
        map.put("totalCum",tblhospitalinfoMapper.countRows(map));
        return KTool.codeToclient(map);
    }
}
