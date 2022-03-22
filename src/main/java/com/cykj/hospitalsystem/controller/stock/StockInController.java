package com.cykj.hospitalsystem.controller.stock;

import com.alibaba.fastjson.JSON;
import com.cykj.hospitalsystem.bean.StockIn;
import com.cykj.hospitalsystem.bean.Tblhospitalinfo;
import com.cykj.hospitalsystem.service.StockInService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.krb5.internal.tools.Ktab;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/StockIn")
public class StockInController {

    @Autowired
    private StockInService stockInServiceImpl;

    //查询医废入库信息
    @RequestMapping("/queryStockInInfo")
    @ResponseBody
    public Map queryStockInInfo(@RequestBody Map<String,Object> map){
        // 查询医废入库信息
        List<StockIn> list = stockInServiceImpl.queryStockInInfo(map);
        // 查询医废入库信息总条数
        int count = stockInServiceImpl.queryStockInInfoCount(map);
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
        List<Tblhospitalinfo> list = stockInServiceImpl.getHospitalName();
        Map map = new HashMap();
        map.put("hospitalList",list);
        map.put("code",1);
        return map;
    }

    // 批量勾选出库
    @RequestMapping("/batchOutLibrary")
    @ResponseBody
    public Map batchOutLibrary(@RequestBody Map<String,Object> map){
        return stockInServiceImpl.batchOutLibrary(map);
    }

    // 批量全部出库
    @RequestMapping("/batchOutLibraryAll")
    @ResponseBody
    public Map batchOutLibraryAll(@RequestBody Map<String,Object> map){
        return stockInServiceImpl.batchOutLibraryAll(map);
    }

    // 查询医废入库信息(无分页)
    @RequestMapping("/queryStockInInfoAll")
    @ResponseBody
    public Map queryStockInInfoAll(String hname, String state, String beginTime, String endTime){
        System.out.println(hname+","+state+","+beginTime+","+endTime);
        // 查询医废入库信息
        List<StockIn> list = stockInServiceImpl.queryStockInInfoAll(hname, state, beginTime, endTime);
        Map map = new HashMap();
        map.put("data",list);
        return KTool.codeToclient(map);
    }

}
