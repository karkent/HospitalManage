package com.cykj.hospitalsystem.controller.dashboard;

import com.alibaba.fastjson.JSONObject;
import com.cykj.hospitalsystem.bean.StockIn;
import com.cykj.hospitalsystem.bean.Tblwaringnotes;
import com.cykj.hospitalsystem.mapper.TblwaringnotesMapper;
import com.cykj.hospitalsystem.service.DataService;
import com.cykj.hospitalsystem.service.TblmedicaltypeService;
import com.cykj.hospitalsystem.service.TblwaringnotesService;
import com.cykj.hospitalsystem.until.KTool;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    private TblmedicaltypeService tblmedicaltypeServiceImpl;
    @Autowired
    private TblwaringnotesService tblwaringnotesServiceImpl;

    // 首页 获得统计表
    @RequestMapping("/getStatistics")
    @ResponseBody
    public Map getStatistics(@RequestBody Map<String,Object> map){
        return tblmedicaltypeServiceImpl.getNumByType(map);
    }

    // 首页 轮循请求
    @RequestMapping("/realTime")
    @ResponseBody
    public Map<String,Object> realTime(@RequestBody Map<String,Object> map){
        System.out.println("{}{}{}{");
        return tblwaringnotesServiceImpl.allShowMsg(map);
    }

    @RequestMapping("/totalWeight")
    @ResponseBody // 预警弹窗表格 下一页功能，直接调用map层，没什么业务逻辑。
    public Map totalWeight(@RequestBody Map<String,Object> map){
        System.out.println(123);
        return tblwaringnotesServiceImpl.allShowMsg(map);
    }

    @RequestMapping("/initWaring")
    @ResponseBody // 预警弹窗表格 下一页功能，直接调用map层，没什么业务逻辑。
    public Map<String,Object> initWaring(@RequestBody Map<String,Object> map){
        return tblwaringnotesServiceImpl.findAll(map);
    }

    @RequestMapping("/listWarning")
    @ResponseBody // 预警列表：预警弹窗表格 下一页功能，直接调用map层，没什么业务逻辑。
    public Map<String,Object> listWaring(@RequestBody Map<String,Object> map){
        System.out.println(JSONObject.toJSONString(map)+"@!");
        List<Tblwaringnotes> list = tblwaringnotesServiceImpl.findParam(map);
        int count = tblwaringnotesServiceImpl.findParamCount(map);
        Map map1 = new HashMap();
        map1.put("WarningList",list);
        map1.put("count",count);
        map1.put("code",1);
        return map1;
    }

    @RequestMapping("/updateHandle")
    @ResponseBody // 预警处理
    public Map<String,Object> updateHandle(@RequestBody Map<String,Object> map){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        map.put("handletime",dateString);
        int count = tblwaringnotesServiceImpl.updateHandle(map);
        Map map1 = new HashMap();
        map1.put("count",count);
        map1.put("code",1);
        return map1;
    }
}
