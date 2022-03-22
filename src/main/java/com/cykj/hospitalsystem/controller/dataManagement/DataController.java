package com.cykj.hospitalsystem.controller.dataManagement;

import com.cykj.hospitalsystem.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/*参数管理*/
@Controller
@RequestMapping("/data")
public class DataController {
    @Autowired
    private DataService dataService;

    @RequestMapping("/addData")
    @ResponseBody
    public Map addData(@RequestBody Map<String, Object> map) {
        return dataService.addData(map);
    }

    @RequestMapping("/updateData")
    @ResponseBody
    public Map updateData(@RequestBody Map<String, Object> map){
        return dataService.updateData(map);
    }

    @RequestMapping("/selpnames")
    @ResponseBody
    public Map selpname(@RequestBody Map<String, Object> map){
        return dataService.selpname(map);
    }

    @RequestMapping("/disableState")
    @ResponseBody
    public Map disableState(@RequestBody Map<String, Object> map){
        return dataService.disable(map);
    }
    //批量操作
    @RequestMapping("/setDataState")
    @ResponseBody
    public Map setDatasState(@RequestBody Map<String, Object> map){
        return dataService.setstate(map);
    }

    // 开航 通过父级id获得下拉列表
    @RequestMapping("/findAllByPid")
    @ResponseBody
    public Map findAllByPid(@RequestBody Map<String,Object> map){
        return dataService.findAllByPid(map);
    }


    @RequestMapping("/selectAllData")
    @ResponseBody
    public Map selectAllData(@RequestBody Map<String,Object> map){
        return dataService.selectAllData(map);
    }
}
