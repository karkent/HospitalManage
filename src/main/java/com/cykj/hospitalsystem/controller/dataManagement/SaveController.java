package com.cykj.hospitalsystem.controller.dataManagement;

import com.cykj.hospitalsystem.bean.Tblsave;
import com.cykj.hospitalsystem.service.SaveService;
import com.cykj.hospitalsystem.until.KTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/save")
public class SaveController {
    @Autowired
    public SaveService saveService;
//添加暂存点
    @RequestMapping("/addSave")
    @ResponseBody
    public Map addData(@RequestBody Map<String, Object> map) {
        return saveService.addSave(map);
    }
//修改暂存点信息
    @RequestMapping("/updateSave")
    @ResponseBody
    public Map updateData(@RequestBody Map<String, Object> map){
        return saveService.updateSave(map);
    }

    //批量操作
    @RequestMapping("/setSaveState")
    @ResponseBody
    public Map setSaveState(@RequestBody Map<String, Object> map){
        return saveService.setSaveState(map);
    }

    //查状态
    @RequestMapping("/selsavestate")
    @ResponseBody
    public Map selsavestate(@RequestBody Map<String, Object> map){
        return saveService.selsavestate(map);
    }

    /*查已存在*/
    @RequestMapping("/findsavenameExsit")
    @ResponseBody
    public Map<String, Object> findsavenameExsit(@RequestBody Map<String, Object> map){
        Tblsave tblsave=saveService.findExist(String.valueOf(map.get("savename")),null);
        if (tblsave != null){
            map.put("sign",0);
        }else {
            map.put("sign",1);
        }
        return KTool.codeToclient(map);
    }

    @RequestMapping("/findsavecodeExsit")
    @ResponseBody
    public Map<String, Object> findsavecodeExsit(@RequestBody Map<String, Object> map){
        Tblsave tblsave=saveService.findExist(null,String.valueOf(map.get("savecode")));
        if (tblsave != null){
            map.put("sign",0);
        }else {
            map.put("sign",1);
        }
        return KTool.codeToclient(map);
    }
}
