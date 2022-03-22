package com.cykj.hospitalsystem.service.impl;


import com.alibaba.fastjson.JSON;
import com.cykj.hospitalsystem.bean.Tblbox;
import com.cykj.hospitalsystem.bean.Tbldata;
import com.cykj.hospitalsystem.mapper.TblboxMapper;
import com.cykj.hospitalsystem.service.TblboxService;;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class TblboxServerImpl implements TblboxService {
    @Autowired
    private TblboxMapper tblboxMapper;

    @Override
    public Map<String, Object> showTable(Map<String, Object> map) {
        String boxStateValueStr=map.get("bstate").toString().trim();
        if (boxStateValueStr != null){
            map.put("boxStateValueStr",boxStateValueStr);
        }
        String str=map.get("searchStr").toString().trim();
        if(KTool.checkNameChese(str)){
            map.put("bstate",str);
        }else {
            map.put("boxcode",str);
        }
        List<Tblbox> tblboxList=tblboxMapper.showTable(map);
        map.put("list",tblboxList);
        map.put("totalCum",tblboxMapper.countRows(map));
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> selTbldata(Map<String, Object> map) {
        List<Tbldata> list=tblboxMapper.selTbldata();
        map.put("list",list);
        return KTool.codeToclient(map);
    }

    @Override
    public Map<String, Object> addbox(Map<String, Object> map) {
        //自增周转箱编码
        Date date = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

        String nowDayStr = sdf.format(date).substring(2,8);
//        System.out.println(nowDayStr.substring(2,8)); 分割成21年11月22日

        String startTime = KTool.getDataToStr(sdf2.format(date),0);
        String endTime = KTool.getDataToStr(sdf2.format(date),1);

        String boxMaxcode = tblboxMapper.MaxboxCode(startTime,endTime);
        System.out.println("打印得到的数据"+boxMaxcode);
        if (boxMaxcode != null) {
            //假设找到最大编码为 211123 1234 5678
            //分割编码
            boxMaxcode = boxMaxcode.substring(6, 14); //得到1234 5678
        } else {
            boxMaxcode = "0";
        }
        int num=Integer.valueOf(map.get("num").toString().trim());

        List<Tblbox> boxList = new ArrayList<>();
        for (int i=1;i<=num;i++){
            Tblbox box = new Tblbox();
            // 日期为6位，
            String codeStr = nowDayStr + get8code(boxMaxcode,i);
            box.setBoxcode(codeStr);
            box.setBstate(24);
            int boxhid= Integer.parseInt(map.get("hid").toString().trim());
            box.setHid(boxhid);
            box.setFullName(map.get("fullName").toString());
            boxList.add(box);
        }
        int i=tblboxMapper.addbox(boxList);
        if (i >= 1) {
            map.put("sign", "1");
            map.put("msg", "新增成功");
        } else {
            map.put("sign", "2");
            map.put("msg", "新增异常，请重试！");
        }
        return KTool.codeToclient(map);
    }

    @Override
    public Map setBoxState(Map<String, Object> map) {
        tblboxMapper.setstate(map);
        String msg = "";
        switch (map.get("bstate").toString()){
            case "24":
                msg = "未使用";
                break;
            case "25":
                msg = "已打印";
                break;
            case "26":
                msg = "已入库";
                break;
            case "27":
                msg = "已出库";
                break;
            case "44":
                msg = "已作废";
                break;
        }
        map.put("msg","批量"+msg+"成功!");
        return KTool.codeToclient(map);
    }




    /*新增医废箱编码*/
    public String get8code(String str,int index){
        int code8 = Integer.valueOf(str)+index;
        String code8Str = "";
        if(code8<10){
            code8Str = "0000000"+code8;
        }else if (code8<100){
            code8Str = "000000"+code8;
        }else if(code8<1000){
            code8Str = "00000"+code8;
        }else if(code8<10000){
            code8Str = "0000"+code8;
        }else if(code8<100000){
            code8Str = "000"+code8;
        }else if(code8<1000000){
            code8Str = "00"+code8;
        }else if(code8<10000000){
            code8Str = "0"+code8;
        }else{
            code8Str = str;
        }
        return code8Str;
    }
}
