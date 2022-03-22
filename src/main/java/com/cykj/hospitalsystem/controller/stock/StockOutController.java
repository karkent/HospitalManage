package com.cykj.hospitalsystem.controller.stock;

import com.alibaba.fastjson.JSON;
import com.cykj.hospitalsystem.bean.StockIn;
import com.cykj.hospitalsystem.bean.StockOut;
import com.cykj.hospitalsystem.bean.Tblhospitalinfo;
import com.cykj.hospitalsystem.bean.Tbltypeprint;
import com.cykj.hospitalsystem.service.StockOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.MapUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/StockOut")
public class StockOutController {

    @Autowired
    private StockOutService stockOutServiceImpl;

    //查询医废入库信息
    @RequestMapping("/queryStockInInfo")
    @ResponseBody
    public Map queryStockInInfo(@RequestBody Map map){
        // 查询医废入库信息
        List<StockOut> list = stockOutServiceImpl.queryStockInInfo(map);
        // 查询医废入库信息总条数
        int count = stockOutServiceImpl.queryStockInInfoCount(map);
        Map map1 = new HashMap();
        map1.put("StockInInfoList",list);
        map1.put("count",count);
        map1.put("code",1);
        return map1;
    }

    // 查询所有医院名称
    @RequestMapping("/getHospitalName")
    @ResponseBody
    public Map getHospitalName(){
        List<Tblhospitalinfo> list = stockOutServiceImpl.getHospitalName();
        Map map = new HashMap();
        map.put("HospitalNameList",list);
        map.put("code",1);
        return map;
    }

    // 查询所有医废类型
    @RequestMapping("/getMedicalWasteType")
    @ResponseBody
    public Map getMedicalWasteType(){
        List<Tbltypeprint> list = stockOutServiceImpl.getMedicalWasteType();
        Map map = new HashMap();
        map.put("code",1);
        map.put("MedicalWasteTypeList",list);
        return map;
    }

    // 查询医废入库信息(无分页)
    @RequestMapping("/queryStockInInfoAll")
    @ResponseBody
    public Map queryStockInInfoAll(@RequestBody Map map){
        // 查询医废入库信息
        List<StockOut> list = stockOutServiceImpl.queryStockInInfoAll(map);
        map.put("StockInInfoAllList",list);
        map.put("code",1);
        return map;
    }

}
