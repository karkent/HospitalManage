package com.cykj.hospitalsystem.controller.dataManagement;

import com.cykj.hospitalsystem.service.TblboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Tblbox")
public class BoxController {
    @Autowired
    private TblboxService tblboxService;

    @RequestMapping("/boxList")
    @ResponseBody
    public Map<String, Object> getboxinfo(@RequestBody HashMap<String, Object> map){
        return tblboxService.showTable(map);
    }

    @RequestMapping("/stateList")
    @ResponseBody //查询集合
    public Map<String, Object> getstate(@RequestBody Map<String, Object> map){
        return tblboxService.selTbldata(map);
    }


    @RequestMapping("/addbox")
    @ResponseBody
    public Map<String, Object> addbox(@RequestBody Map<String, Object> map){
        return tblboxService.addbox(map);
    }

    //批量操作
    @RequestMapping("/setBoxState")
    @ResponseBody
    public Map setBoxState(@RequestBody Map<String, Object> map){
        return tblboxService.setBoxState(map);
    }

//    //二维码加密
//    @RequestMapping("/setbase64box")
//    @ResponseBody
//    public Map base64box(@RequestBody Map<String, Object> map){
//        return tblboxService.base64box(map);
//    }
}
